package ng.com.systemspecs.remitabillinggateway.paymentstatus;

import java.util.List;

/**
 * @author Ilesanmi Omoniyi
 * @author Eunice Olukitibi
 *
 * @since 1.0.0
 */
public class GetTransactionStatusData {

    private String rrr;

    private Integer totalAmount;

    private Integer balanceDue;

    private String paymentRef;

    private String paymentDate;

    private String debittedAccount;

    private Integer amountDebitted;

    private List<Object> extendedData = null;


    public String getRrr() {
        return rrr;
    }


    public void setRrr(String rrr) {
        this.rrr = rrr;
    }


    public Integer getTotalAmount() {
        return totalAmount;
    }


    public void setTotalAmount(Integer totalAmount) {
        this.totalAmount = totalAmount;
    }


    public Integer getBalanceDue() {
        return balanceDue;
    }


    public void setBalanceDue(Integer balanceDue) {
        this.balanceDue = balanceDue;
    }


    public String getPaymentRef() {
        return paymentRef;
    }


    public void setPaymentRef(String paymentRef) {
        this.paymentRef = paymentRef;
    }


    public String getPaymentDate() {
        return paymentDate;
    }


    public void setPaymentDate(String paymentDate) {
        this.paymentDate = paymentDate;
    }


    public String getDebittedAccount() {
        return debittedAccount;
    }


    public void setDebittedAccount(String debittedAccount) {
        this.debittedAccount = debittedAccount;
    }


    public Integer getAmountDebitted() {
        return amountDebitted;
    }


    public void setAmountDebitted(Integer amountDebitted) {
        this.amountDebitted = amountDebitted;
    }


    public List<Object> getExtendedData() {
        return extendedData;
    }


    public void setExtendedData(List<Object> extendedData) {
        this.extendedData = extendedData;
    }

    @Override
    public String toString() {
        return "GetTransactionStatusData{" +
                "rrr='" + rrr + '\'' +
                ", totalAmount=" + totalAmount +
                ", balanceDue=" + balanceDue +
                ", paymentRef='" + paymentRef + '\'' +
                ", paymentDate='" + paymentDate + '\'' +
                ", debittedAccount='" + debittedAccount + '\'' +
                ", amountDebitted=" + amountDebitted +
                ", extendedData=" + extendedData +
                '}';
    }
}
