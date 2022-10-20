package ke.natujenge.tax.dto;

import java.util.List;
import java.util.Map;

public class BillResponse {
    private Integer id;
    private Integer monthId;
    private Double netSalary;
    private List<Map<String, Double>> bills;
    private Double balance;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMonthId() {
        return monthId;
    }

    public void setMonthId(Integer monthId) {
        this.monthId = monthId;
    }

    public Double getNetSalary() {
        return netSalary;
    }

    public void setNetSalary(Double netSalary) {
        this.netSalary = netSalary;
    }

    public List<Map<String, Double>> getBills() {
        return bills;
    }

    public void setBills(List<Map<String, Double>> bills) {
        this.bills = bills;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "BillResponse{" +
                "id=" + id +
                ", monthId=" + monthId +
                ", netSalary=" + netSalary +
                ", bills=" + bills +
                ", balance=" + balance +
                '}';
    }
}
