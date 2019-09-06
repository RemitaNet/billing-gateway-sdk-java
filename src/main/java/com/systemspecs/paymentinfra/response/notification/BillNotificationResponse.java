package com.systemspecs.paymentinfra.response.notification;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;


public class BillNotificationResponse implements Serializable {

    private String responseCode;

    private String responseMsg;

    private String iResponseCode;

    private String iResponseMessage;

    private String appVersionCode;

    private List<ResponseData> responseData = null;


    @JsonProperty("responseCode")
    public String getResponseCode() {
        return responseCode;
    }


    @JsonProperty("responseCode")
    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }


    @JsonProperty("responseMsg")
    public String getResponseMsg() {
        return responseMsg;
    }


    @JsonProperty("responseMsg")
    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }


    @JsonProperty("iResponseCode")
    public Object getIResponseCode() {
        return iResponseCode;
    }


    @JsonProperty("iResponseCode")
    public void setIResponseCode(String iResponseCode) {
        this.iResponseCode = iResponseCode;
    }


    @JsonProperty("iResponseMessage")
    public Object getIResponseMessage() {
        return iResponseMessage;
    }


    @JsonProperty("iResponseMessage")
    public void setIResponseMessage(String iResponseMessage) {
        this.iResponseMessage = iResponseMessage;
    }


    @JsonProperty("appVersionCode")
    public Object getAppVersionCode() {
        return appVersionCode;
    }


    @JsonProperty("appVersionCode")
    public void setAppVersionCode(String appVersionCode) {
        this.appVersionCode = appVersionCode;
    }


    @JsonProperty("responseData")
    public List<ResponseData> getResponseData() {
        return responseData;
    }


    @JsonProperty("responseData")
    public void setResponseData(List<ResponseData> responseData) {
        this.responseData = responseData;
    }
}
