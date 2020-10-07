package ng.com.systemspecs.remitabillinggateway.rrrdetails;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Ilesanmi Omoniyi
 * @author Eunice Olukitibi
 *
 * @since 1.0.0
 */
public class GetRRRDetailsResponseData {
    private String rrr;
    private BigDecimal amountDue;
    private Double chargeFee;
    private BigDecimal rrrAmount;
    private String payerEmail;
    private String payerName;
    private String payerPhone;
    private String description;
    private String currency;
    private String type;
    private Boolean acceptPartPayment;
    private String frequency;
    private String payerAccountNumber;
    private String maxNoOfDebits;
    private String startDate;
    private String endDate;
    private String responseCode;

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    private List<Object> extraData = null;
    private List<Object> customFields = null;

    public String getRrr() {
        return rrr;
    }

    public void setRrr(String rrr) {
        this.rrr = rrr;
    }

    public BigDecimal getAmountDue() {
        return amountDue;
    }

    public void setAmountDue(BigDecimal amountDue) {
        this.amountDue = amountDue;
    }

    public Double getChargeFee() {
        return chargeFee;
    }

    public void setChargeFee(Double chargeFee) {
        this.chargeFee = chargeFee;
    }

    public BigDecimal getRrrAmount() {
        return rrrAmount;
    }

    public void setRrrAmount(BigDecimal rrrAmount) {
        this.rrrAmount = rrrAmount;
    }

    public String getPayerEmail() {
        return payerEmail;
    }

    public void setPayerEmail(String payerEmail) {
        this.payerEmail = payerEmail;
    }

    public String getPayerName() {
        return payerName;
    }

    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }

    public String getPayerPhone() {
        return payerPhone;
    }

    public void setPayerPhone(String payerPhone) {
        this.payerPhone = payerPhone;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
   public Boolean getAcceptPartPayment() {
        return acceptPartPayment;
    }

    public void setAcceptPartPayment(Boolean acceptPartPayment) {
        this.acceptPartPayment = acceptPartPayment;
    }

    public String getFrequency() {
        return frequency;
    }

    public void setFrequency(String frequency) {
        this.frequency = frequency;
    }

    public String getPayerAccountNumber() {
        return payerAccountNumber;
    }

    public void setPayerAccountNumber(String payerAccountNumber) {
        this.payerAccountNumber = payerAccountNumber;
    }

    public String getMaxNoOfDebits() {
        return maxNoOfDebits;
    }

    public void setMaxNoOfDebits(String maxNoOfDebits) {
        this.maxNoOfDebits = maxNoOfDebits;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public List<Object> getExtraData() {
        return extraData;
    }

    public void setExtraData(List<Object> extraData) {
        this.extraData = extraData;
    }

    public List<Object> getCustomFields() {
        return customFields;
    }

    public void setCustomFields(List<Object> customFields) {
        this.customFields = customFields;
    }

    @Override
    public String toString() {
        return "GetRRRDetailsResponseData{" +
                "rrr='" + rrr + '\'' +
                ", amountDue=" + amountDue +
                ", chargeFee=" + chargeFee +
                ", rrrAmount=" + rrrAmount +
                ", payerEmail='" + payerEmail + '\'' +
                ", payerName='" + payerName + '\'' +
                ", payerPhone='" + payerPhone + '\'' +
                ", description='" + description + '\'' +
                ", currency='" + currency + '\'' +
                ", type='" + type + '\'' +
                ", acceptPartPayment=" + acceptPartPayment +
                ", frequency='" + frequency + '\'' +
                ", payerAccountNumber='" + payerAccountNumber + '\'' +
                ", maxNoOfDebits='" + maxNoOfDebits + '\'' +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", responseCode='" + responseCode + '\'' +
                ", extraData=" + extraData +
                ", customFields=" + customFields +
                '}';
    }
}
