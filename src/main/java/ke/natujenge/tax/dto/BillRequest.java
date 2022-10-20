package ke.natujenge.tax.dto;

import java.util.List;
import java.util.Map;

public class BillRequest {
    private int month;

    private double netSalary;

    private List<Map<String, Double>> bills;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(double netSalary) {
        this.netSalary = netSalary;
    }

    public List<Map<String, Double>> getBills() {
        return bills;
    }

    public void setBills(List<Map<String, Double>> bills) {
        this.bills = bills;
    }

    @Override
    public String toString() {
        return "BillRequest{" +
                "month=" + month +
                ", netSalary=" + netSalary +
                ", bills=" + bills +
                '}';
    }
}


