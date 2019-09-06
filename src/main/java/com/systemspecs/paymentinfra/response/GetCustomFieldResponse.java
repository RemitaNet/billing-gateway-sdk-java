package com.systemspecs.paymentinfra.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;


public class GetCustomFieldResponse implements Serializable {

    private String responseCode;

    private List<GetCustomFieldResponseData> responseData = null;

    private String responseMsg;

    private String appVersionCode;

    private Boolean acceptPartPayment;

    private Boolean fixedPrice;

    private Double fixedAmount;

    private String currency;


    public String getResponseCode() {
        return responseCode;
    }


    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }


    public List<GetCustomFieldResponseData> getResponseData() {
        return responseData;
    }


    public void setResponseData(List<GetCustomFieldResponseData> responseData) {
        this.responseData = responseData;
    }


    public String getResponseMsg() {
        return responseMsg;
    }


    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }


    public String getAppVersionCode() {
        return appVersionCode;
    }


    public void setAppVersionCode(String appVersionCode) {
        this.appVersionCode = appVersionCode;
    }


    public Boolean getAcceptPartPayment() {
        return acceptPartPayment;
    }


    public void setAcceptPartPayment(Boolean acceptPartPayment) {
        this.acceptPartPayment = acceptPartPayment;
    }


    public Boolean getFixedPrice() {
        return fixedPrice;
    }


    public void setFixedPrice(Boolean fixedPrice) {
        this.fixedPrice = fixedPrice;
    }


    public Double getFixedAmount() {
        return fixedAmount;
    }


    public void setFixedAmount(Double fixedAmount) {
        this.fixedAmount = fixedAmount;
    }


    public String getCurrency() {
        return currency;
    }


    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
