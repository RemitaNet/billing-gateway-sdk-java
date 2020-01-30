package com.systemspecs.paymentinfra.request;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public class ValidateRequest implements Serializable {

    private List<CustomField> customFields = null;

    private String billId;

    private BigDecimal amount;

    private String payerPhone;

    private String currency;

    private String payerName;

    private String payerEmail;

    public String getDescription() { return description; }

    public void setDescription(String description) { this.description = description; }

    private String description;


    public List<CustomField> getCustomFields() {
        return customFields;
    }


    public void setCustomFields(List<CustomField> customFields) {
        this.customFields = customFields;
    }


    public String getBillId() {
        return billId;
    }


    public void setBillId(String billId) {
        this.billId = billId;
    }


    public BigDecimal getAmount() {
        return amount;
    }


    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public String getPayerPhone() {
        return payerPhone;
    }


    public void setPayerPhone(String payerPhone) {
        this.payerPhone = payerPhone;
    }


    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }


    public String getPayerName() {
        return payerName;
    }


    public void setPayerName(String payerName) {
        this.payerName = payerName;
    }


    public String getPayerEmail() {
        return payerEmail;
    }


    public void setPayerEmail(String payerEmail) {
        this.payerEmail = payerEmail;
    }
}
