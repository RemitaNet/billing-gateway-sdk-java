package com.systemspecs.paymentinfra.response.validate;

import com.systemspecs.paymentinfra.response.GetServiceResponseData;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GetServiceResponseList {
    private String responseCode;

    private List<List<GetServiceResponseData>> responseData = null;

    private String responseMsg;

    private String appVersionCode;

    private Map<String, Object> additionalProperties = new HashMap<String, Object>();


    public String getResponseCode() {
        return responseCode;
    }


    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }


    public List<List<GetServiceResponseData>> getResponseData() {
        return responseData;
    }


    public void setResponseData(List<List<GetServiceResponseData>> responseData) {
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


    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }


    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }
}
