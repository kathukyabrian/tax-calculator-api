package ke.natujenge.tax.service;

import ke.natujenge.tax.dto.TaxRequest;
import ke.natujenge.tax.dto.TaxResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Service
public class TaxService {

    private final Logger logger = LoggerFactory.getLogger(TaxService.class);

    public TaxResponse tax(TaxRequest taxRequest) {
        logger.debug("Request to calculate tax for : {}", taxRequest);

        TaxResponse taxResponse = new TaxResponse(taxRequest);

        double allowableDeductions = resolveTotalDeductions(taxRequest);

        double taxablePay = taxRequest.getGrossSalary() - allowableDeductions;
        taxResponse.setTaxPayable(taxablePay);

        double PAYE = resolvePAYE(taxablePay);
        taxResponse.setPAYE(PAYE);

        double personalRelief = 2400.0;
        taxResponse.setPersonalRelief(personalRelief);

        taxResponse.setNSSFAmount(200.0);

        double NHIFRate = 0;
        if (taxRequest.isNHIF()) {
            NHIFRate = resolveNHIFRate(taxRequest.getGrossSalary());
            taxResponse.setNHIFAmount(NHIFRate);
        }

        double insuranceRelief = resolveInsuranceRelief(NHIFRate, taxRequest.getInsuranceAmount());
        taxResponse.setInsuranceRelief(insuranceRelief);

        double NSSFRate = 200;

        double netPay = taxRequest.getGrossSalary() - PAYE - NHIFRate - NSSFRate + (insuranceRelief + personalRelief);
        taxResponse.setNetPay(netPay);

        return taxResponse;
    }


    public double resolveTotalDeductions(TaxRequest taxRequest) {
        double totalDeductions = 0;
        // check nssf, pension and morgage interest
        if (taxRequest.isNSSF()) {
            totalDeductions += 200.0;
        }

        if (taxRequest.isPension()) {
            double pensionAmount = taxRequest.getPensionAmount();
            if (pensionAmount > 20000.0) {
                pensionAmount = 20000.0;
            }
            totalDeductions += pensionAmount;
        }

        if (taxRequest.isMortgageInterest()) {
            double mortgageInterestAmount = taxRequest.getMortgageInterestAmount();
            if (mortgageInterestAmount > 300000) {
                totalDeductions += mortgageInterestAmount;
            }
        }

        return totalDeductions;
    }

    public double resolveInsuranceRelief(double NHIFRate, double insurancePremium) {
        double insuranceRelief = 0.15 * (NHIFRate + insurancePremium);
        if (insuranceRelief > 5000) {
            insuranceRelief = 5000;
        }

        return insuranceRelief;
    }

    public double resolveNHIFRate(double grossPay) {
        if (grossPay >= 0.0 && grossPay <= 5999) {
            return 150.0;
        } else if (grossPay >= 6000.0 && grossPay <= 7999.0) {
            return 300.0;
        } else if (grossPay >= 8000.0 && grossPay <= 11999.0) {
            return 400.0;
        } else if (grossPay >= 12000.0 && grossPay <= 14999.0) {
            return 500.0;
        } else if (grossPay >= 15000.0 && grossPay <= 19999.0) {
            return 600.0;
        } else if (grossPay >= 20000.0 && grossPay <= 24999.0) {
            return 750.0;
        } else if (grossPay >= 25000.0 && grossPay <= 29999.0) {
            return 850.0;
        } else if (grossPay >= 30000.0 && grossPay <= 34999.0) {
            return 900.0;
        } else if (grossPay >= 35000.0 && grossPay <= 39999.0) {
            return 950.0;
        } else if (grossPay >= 40000.0 && grossPay <= 44999.0) {
            return 1000.0;
        } else if (grossPay >= 45000.0 && grossPay <= 49999.0) {
            return 1100.0;
        } else if (grossPay >= 50000.0 && grossPay <= 59999.0) {
            return 1200.0;
        } else if (grossPay >= 60000.0 && grossPay <= 69999.0) {
            return 1300.0;
        } else if (grossPay >= 70000.0 && grossPay <= 79999.0) {
            return 1400.0;
        } else if (grossPay >= 80000.0 && grossPay <= 89999.0) {
            return 1500.0;
        } else if (grossPay >= 90000.0 && grossPay <= 99999.0) {
            return 1600.0;
        } else {
            return 1700.0;
        }
    }

    public double resolvePAYE(double taxablePay) {

        double PAYE;

        if (taxablePay <= 24000) {
            PAYE = taxablePay * 0.1;
        } else {
            if (taxablePay <= 32333) {
                PAYE = (24000 * 0.1) + ((32333 - 24000) * 0.25);
            } else {
                PAYE = (24000 * 0.1) + ((32333 - 24000) * 0.25) + ((taxablePay - 32333) * 0.3);
            }
        }

        return PAYE;
    }

    public double resolveInsuranceRelief(double insurancePremium) {
        double insuranceRelief = insurancePremium * 0.15;

        if (insuranceRelief > 5000.0) {
            insuranceRelief = 5000.0;
        }

        return insuranceRelief;
    }
}
