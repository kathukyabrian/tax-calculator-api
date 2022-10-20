package ke.natujenge.tax.dto;

public class TaxRequest {
    private double grossSalary;

    private boolean isNSSF;

    private boolean isNHIF;

    private boolean isPension;

    private double pensionAmount;

    private boolean isMortgageInterest;

    private double mortgageInterestAmount;

    private boolean isInsurance;

    private double insuranceAmount;

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

    @Override
    public String toString() {
        return "TaxRequest{" +
                "grossSalary=" + grossSalary +
                ", isNSSF=" + isNSSF +
                ", isNHIF=" + isNHIF +
                ", isPension=" + isPension +
                ", pensionAmount=" + pensionAmount +
                ", isMortgageInterest=" + isMortgageInterest +
                ", mortgageInterestAmount=" + mortgageInterestAmount +
                ", isInsurance=" + isInsurance +
                ", insuranceAmount=" + insuranceAmount +
                '}';
    }
}
