package ke.natujenge.tax.domain;

import javax.persistence.*;

@Entity
@Table(name = "tbl_bills")
public class Bill {
    @Id
    @GeneratedValue
    private Integer id;
    private Integer monthId;
    private Double netSalary;
    @Column(length = 2000)
    private String bills;
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

    public String getBills() {
        return bills;
    }

    public void setBills(String bills) {
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
        return "Bill{" +
                "id=" + id +
                ", month=" + monthId +
                ", netSalary=" + netSalary +
                ", bills='" + bills + '\'' +
                ", balance=" + balance +
                '}';
    }
}
