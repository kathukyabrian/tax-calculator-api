package ke.natujenge.tax.web.rest;

import ke.natujenge.tax.dto.BillRequest;
import ke.natujenge.tax.dto.BillResponse;
import ke.natujenge.tax.service.BillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class BillResource {
    private final Logger logger = LoggerFactory.getLogger(BillResource.class);
    private final BillService billService;

    public BillResource(BillService billService) {
        this.billService = billService;
    }

    @PostMapping("/bill")
    public BillResponse save(@RequestBody BillRequest billRequest) {
        logger.debug("REST request to save bill : {}", billRequest);
        return billService.save(billRequest);
    }

    @GetMapping("/bill/{month}")
    public ResponseEntity findOne(@PathVariable Integer month) {
        logger.debug("REST request to retrieve bill for month : {}", month);

        BillResponse billResponse;
        try {
            billResponse = billService.findOneByMonth(month);
        } catch (Exception e) {
            return ResponseEntity.status(404).body(e.getMessage());
        }

        return ResponseEntity.ok(billResponse);
    }

    @GetMapping("/bill")
    public List<BillResponse> findAll() {
        logger.debug("REST request to retrieve all bills");

        return billService.findAll();
    }
}
