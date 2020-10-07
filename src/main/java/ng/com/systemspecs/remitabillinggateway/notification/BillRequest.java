package ng.com.systemspecs.remitabillinggateway.notification;

import java.io.Serializable;

/**
 * @author Ilesanmi Omoniyi
 * @author Eunice Olukitibi
 *
 * @since 1.0.0
 */
public class BillRequest implements Serializable {

    private String rrr;

    private String incomeAccount;

    private String debittedAccount;

    private String paymentAuthCode;

    private String paymentChannel;

    private String tellerName;

    private String branchCode;

    private String amountDebitted;

    private String fundingSource;

    public String getRrr() {
        return rrr;
    }


    public void setRrr(String rrr) {
        this.rrr = rrr;
    }


    public String getIncomeAccount() {
        return incomeAccount;
    }


    public void setIncomeAccount(String incomeAccount) {
        this.incomeAccount = incomeAccount;
    }


    public String getDebittedAccount() {
        return debittedAccount;
    }


    public void setDebittedAccount(String debittedAccount) {
        this.debittedAccount = debittedAccount;
    }


    public String getPaymentAuthCode() {
        return paymentAuthCode;
    }


    public void setPaymentAuthCode(String paymentAuthCode) {
        this.paymentAuthCode = paymentAuthCode;
    }


    public String getPaymentChannel() {
        return paymentChannel;
    }


    public void setPaymentChannel(String paymentChannel) {
        this.paymentChannel = paymentChannel;
    }


    public String getTellerName() {
        return tellerName;
    }


    public void setTellerName(String tellerName) {
        this.tellerName = tellerName;
    }


    public String getBranchCode() {
        return branchCode;
    }


    public void setBranchCode(String branchCode) {
        this.branchCode = branchCode;
    }


    public String getAmountDebitted() {
        return amountDebitted;
    }


    public void setAmountDebitted(String amountDebitted) {
        this.amountDebitted = amountDebitted;
    }


    public String getFundingSource() {
        return fundingSource;
    }


    public void setFundingSource(String fundingSource) {
        this.fundingSource = fundingSource;
    }

    @Override
    public String toString() {
        return "BillRequest{" +
                "rrr='" + rrr + '\'' +
                ", incomeAccount='" + incomeAccount + '\'' +
                ", debittedAccount='" + debittedAccount + '\'' +
                ", paymentAuthCode='" + paymentAuthCode + '\'' +
                ", paymentChannel='" + paymentChannel + '\'' +
                ", tellerName='" + tellerName + '\'' +
                ", branchCode='" + branchCode + '\'' +
                ", amountDebitted='" + amountDebitted + '\'' +
                ", fundingSource='" + fundingSource + '\'' +
                '}';
    }
}
