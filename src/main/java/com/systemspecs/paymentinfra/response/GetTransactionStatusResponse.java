package com.systemspecs.paymentinfra.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;


public class GetTransactionStatusResponse implements Serializable {

    private String responseCode;

    private String responseMsg;

    private String iResponseCode;

    private String iResponseMessage;

    private String appVersionCode;

    private List<GetTransactionStatusData> responseData = null;


    public String getResponseCode() {
        return responseCode;
    }


    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }


    public String getResponseMsg() {
        return responseMsg;
    }


    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }


    public Object getIResponseCode() {
        return iResponseCode;
    }


    public void setIResponseCode(String iResponseCode) {
        this.iResponseCode = iResponseCode;
    }


    public String getIResponseMessage() {
        return iResponseMessage;
    }


    public void setIResponseMessage(String iResponseMessage) {
        this.iResponseMessage = iResponseMessage;
    }


    public String getAppVersionCode() {
        return appVersionCode;
    }


    public void setAppVersionCode(String appVersionCode) {
        this.appVersionCode = appVersionCode;
    }


    public List<GetTransactionStatusData> getResponseData() {
        return responseData;
    }


    public void setResponseData(List<GetTransactionStatusData> responseData) {
        this.responseData = responseData;
    }
}
