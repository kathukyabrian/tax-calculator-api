package ke.natujenge.tax.web.rest;

import ke.natujenge.tax.dto.TaxRequest;
import ke.natujenge.tax.dto.TaxResponse;
import ke.natujenge.tax.service.TaxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class TaxResource {
    private final TaxService taxService;
    private final Logger logger = LoggerFactory.getLogger(TaxResource.class);

    public TaxResource(TaxService taxService) {
        this.taxService = taxService;
    }

    @PostMapping("/tax/resolve")
    public TaxResponse resolveTax(@RequestBody TaxRequest taxRequest) {
        logger.debug("Resolving tax for : {}", taxRequest);

        return taxService.tax(taxRequest);
    }
}
