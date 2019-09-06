package com.systemspecs.paymentinfra.response.generate;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.List;


public class GenerateResponse implements Serializable {

    private String responseCode;

    private List<ResponseData> responseData = null;

    private String responseMsg;

    private String appVersionCode;


    public String getResponseCode() {
        return responseCode;
    }


    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }


    public List<ResponseData> getResponseData() {
        return responseData;
    }


    public void setResponseData(List<ResponseData> responseData) {
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
}
