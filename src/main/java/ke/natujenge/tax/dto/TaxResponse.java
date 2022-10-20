package ke.natujenge.tax.dto;

public class TaxResponse {
    private double grossSalary;
    private boolean isNSSF;
    private boolean isNHIF;
    private boolean isPension;
    private double pensionAmount;
    private boolean isMortgageInterest;
    private double mortgageInterestAmount;
    private boolean isInsurance;
    private double insuranceAmount;
    private double NSSFAmount;
    private double taxablePay;
    private double PAYE;
    private double personalRelief;
    private double insuranceRelief;
    private double NHIFAmount;
    private double taxPayable;
    private double netPay;

    public TaxResponse() {
    }

    public TaxResponse(TaxRequest taxRequest) {
        this.grossSalary = taxRequest.getGrossSalary();
        this.isNSSF = taxRequest.isNSSF();
        this.isNHIF = taxRequest.isNHIF();
        this.isPension = taxRequest.isPension();
        this.pensionAmount = taxRequest.getPensionAmount();
        this.isMortgageInterest = taxRequest.isMortgageInterest();
        this.mortgageInterestAmount = taxRequest.getMortgageInterestAmount();
        this.isInsurance = taxRequest.isInsurance();
        this.insuranceAmount = taxRequest.getInsuranceAmount();
    }

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    public boolean isNSSF() {
        return isNSSF;
    }

    public void setNSSF(boolean NSSF) {
        isNSSF = NSSF;
    }

    public boolean isNHIF() {
        return isNHIF;
    }

    public void setNHIF(boolean NHIF) {
        isNHIF = NHIF;
    }

    public boolean isPension() {
        return isPension;
    }

    public void setPension(boolean pension) {
        isPension = pension;
    }

    public double getPensionAmount() {
        return pensionAmount;
    }

    public void setPensionAmount(double pensionAmount) {
        this.pensionAmount = pensionAmount;
    }

    public boolean isMortgageInterest() {
        return isMortgageInterest;
    }

    public void setMortgageInterest(boolean mortgageInterest) {
        isMortgageInterest = mortgageInterest;
    }

    public double getMortgageInterestAmount() {
        return mortgageInterestAmount;
    }

    public void setMortgageInterestAmount(double mortgageInterestAmount) {
        this.mortgageInterestAmount = mortgageInterestAmount;
    }

    public boolean isInsurance() {
        return isInsurance;
    }

    public void setInsurance(boolean insurance) {
        isInsurance = insurance;
    }

    public double getInsuranceAmount() {
        return insuranceAmount;
    }

    public void setInsuranceAmount(double insuranceAmount) {
        this.insuranceAmount = insuranceAmount;
    }

    public double getNSSFAmount() {
        return NSSFAmount;
    }

    public void setNSSFAmount(double NSSFAmount) {
        this.NSSFAmount = NSSFAmount;
    }

    public double getTaxablePay() {
        return taxablePay;
    }

    public void setTaxablePay(double taxablePay) {
        this.taxablePay = taxablePay;
    }

    public double getPAYE() {
        return PAYE;
    }

    public void setPAYE(double PAYE) {
        this.PAYE = PAYE;
    }

    public double getPersonalRelief() {
        return personalRelief;
    }

    public void setPersonalRelief(double personalRelief) {
        this.personalRelief = personalRelief;
    }

    public double getInsuranceRelief() {
        return insuranceRelief;
    }

    public void setInsuranceRelief(double insuranceRelief) {
        this.insuranceRelief = insuranceRelief;
    }

    public double getNHIFAmount() {
        return NHIFAmount;
    }

    public void setNHIFAmount(double NHIFAmount) {
        this.NHIFAmount = NHIFAmount;
    }

    public double getTaxPayable() {
        return taxPayable;
    }

    public void setTaxPayable(double taxPayable) {
        this.taxPayable = taxPayable;
    }

    public double getNetPay() {
        return netPay;
    }

    public void setNetPay(double netPay) {
        this.netPay = netPay;
    }

    @Override
    public String toString() {
        return "TaxResponse{" +
                "grossSalary=" + grossSalary +
                ", isNSSF=" + isNSSF +
                ", isNHIF=" + isNHIF +
                ", isPension=" + isPension +
                ", pensionAmount=" + pensionAmount +
                ", isMortgageInterest=" + isMortgageInterest +
                ", mortgageInterestAmount=" + mortgageInterestAmount +
                ", isInsurance=" + isInsurance +
                ", insuranceAmount=" + insuranceAmount +
                ", NSSFAmount=" + NSSFAmount +
                ", taxablePay=" + taxablePay +
                ", PAYE=" + PAYE +
                ", personalRelief=" + personalRelief +
                ", insuranceRelief=" + insuranceRelief +
                ", NHIFAmount=" + NHIFAmount +
                ", taxPayable=" + taxPayable +
                ", netPay=" + netPay +
                '}';
    }

}
