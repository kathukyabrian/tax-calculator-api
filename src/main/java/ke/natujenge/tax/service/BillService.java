package ke.natujenge.tax.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ke.natujenge.tax.domain.Bill;
import ke.natujenge.tax.dto.BillRequest;
import ke.natujenge.tax.dto.BillResponse;
import ke.natujenge.tax.repository.BillRepository;
import ke.natujenge.tax.service.mapper.BillResponseMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class BillService {
    private final Logger logger = LoggerFactory.getLogger(BillService.class);
    private final BillRepository billRepository;
    private final BillResponseMapper billBillResponseMapper;
    private final ObjectMapper objectMapper = new ObjectMapper();

    public BillService(BillRepository billRepository, BillResponseMapper billBillResponseMapper) {
        this.billRepository = billRepository;
        this.billBillResponseMapper = billBillResponseMapper;
    }

    public BillResponse save(BillRequest billRequest) {
        logger.debug("Request to add bill : {}", billRequest);

        // check if bill exists
        Optional<Bill> optionalBill = billRepository.findOneByMonthId(billRequest.getMonth());

        Bill bill = new Bill();
        if (optionalBill.isPresent()) {
            bill = optionalBill.get();
            // month does not change
            bill.setNetSalary(billRequest.getNetSalary());
        } else {
            bill.setMonthId(billRequest.getMonth());
            bill.setNetSalary(billRequest.getNetSalary());
        }

        String billsStr = null;
        try {
            billsStr = objectMapper.writeValueAsString(billRequest.getBills());
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        bill.setBills(billsStr);

        // resolve balance
        double balance = resolveBalance(billRequest.getBills(), billRequest.getNetSalary());
        bill.setBalance(balance);

        bill = billRepository.save(bill);

        // map
        BillResponse billResponse = billBillResponseMapper.toBillResponse(bill);

        return billResponse;
    }

    public BillResponse findOneByMonth(Integer monthId) throws Exception {
        logger.debug("request to find bill for month : {}", monthId);
        Optional<Bill> optionalBill = billRepository.findOneByMonthId(monthId);

        if (optionalBill.isPresent()) {
            Bill bill = optionalBill.get();
            return billBillResponseMapper.toBillResponse(bill);
        } else {
            throw new Exception("Bill for month " + monthId + " does not exist");
        }
    }

    public List<BillResponse> findAll() {
        List<Bill> bills = billRepository.findAll();

        List<BillResponse> billResponses = new ArrayList<>();

        for(Bill bill : bills){
            BillResponse billResponse = billBillResponseMapper.toBillResponse(bill);
            billResponses.add(billResponse);
        }

        return billResponses;
    }

    private double resolveBalance(List<Map<String, Double>> bills, double netSalary) {
        double totalBills = 0;

        for (Map<String, Double> bill : bills) {
            for (Map.Entry<String, Double> entry : bill.entrySet()) {
                totalBills += entry.getValue();
            }
        }

        return netSalary - totalBills;
    }


}
