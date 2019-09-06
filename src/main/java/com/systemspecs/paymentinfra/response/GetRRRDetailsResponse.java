package com.systemspecs.paymentinfra.response;


import java.io.Serializable;
import java.util.List;


public class GetRRRDetailsResponse implements Serializable{

    private String responseCode;

    private List<GetRRRDetailsResponseData> responseData = null;

    private String responseMsg;

    private String appVersionCode;


    public String getResponseCode() {
        return responseCode;
    }


    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }


    public List<GetRRRDetailsResponseData> getResponseData() {
        return responseData;
    }


    public void setResponseData(List<GetRRRDetailsResponseData> responseData) {
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
