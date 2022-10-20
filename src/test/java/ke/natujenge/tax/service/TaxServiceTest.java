package ke.natujenge.tax.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class TaxServiceTest {

    private TaxService taxService;

    @BeforeEach
    public void setup() {
        taxService = new TaxService();
    }

    @Test
    public void testNHIFRateGivenGrossPay() {
        assertEquals(150.00, taxService.resolveNHIFRate(4000));
        assertEquals(300.00, taxService.resolveNHIFRate(7000));
        assertEquals(400.00, taxService.resolveNHIFRate(10000));
        assertEquals(500.00, taxService.resolveNHIFRate(13000));
        assertEquals(600.00, taxService.resolveNHIFRate(16000));
        assertEquals(750.00, taxService.resolveNHIFRate(21000));
        assertEquals(850.00, taxService.resolveNHIFRate(26000));
        assertEquals(900.00, taxService.resolveNHIFRate(32000));
        assertEquals(950.00, taxService.resolveNHIFRate(36000));
        assertEquals(1000.00, taxService.resolveNHIFRate(42000));
        assertEquals(1100.00, taxService.resolveNHIFRate(46000));
        assertEquals(1200.00, taxService.resolveNHIFRate(52000));
        assertEquals(1300.00, taxService.resolveNHIFRate(62000));
        assertEquals(1400.00, taxService.resolveNHIFRate(72000));
        assertEquals(1500.00, taxService.resolveNHIFRate(84000));
        assertEquals(1600.00, taxService.resolveNHIFRate(94000));
        assertEquals(1700.00, taxService.resolveNHIFRate(104000));
    }

    @Test
    public void testPAYEGivenTaxablePay() {
        assertEquals(0.0, taxService.resolvePAYE(0));
    }

    @Test
    public void testInsuranceReliefGivenInsurancePremium() {
        assertEquals(180.0, taxService.resolveInsuranceRelief(1200));
        assertEquals(750.0, taxService.resolveInsuranceRelief(5000));
        assertEquals(1800.0, taxService.resolveInsuranceRelief(12000));
        assertEquals(5000.0, taxService.resolveInsuranceRelief(100000));
        assertEquals(5000.0, taxService.resolveInsuranceRelief(1300000));
    }

}
