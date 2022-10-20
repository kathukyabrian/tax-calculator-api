package ke.natujenge.tax.service.mapper;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import ke.natujenge.tax.domain.Bill;
import ke.natujenge.tax.dto.BillResponse;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillResponseMapper {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public BillResponse toBillResponse(Bill bill){
        if(bill == null){
            return null;
        }

        BillResponse billResponse = new BillResponse();
        billResponse.setId(bill.getId());
        billResponse.setBalance(bill.getBalance());
        billResponse.setMonthId(bill.getMonthId());
        billResponse.setNetSalary(bill.getNetSalary());

        List billList = null;
        try {
            billList = objectMapper.readValue(bill.getBills(), List.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        billResponse.setBills(billList);

        return billResponse;
    }
}
