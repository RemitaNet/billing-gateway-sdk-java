package ng.com.systemspecs.remitabillinggateway.validate;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ilesanmi Omoniyi
 * @author Eunice Olukitibi
 *
 * @since 1.0.0
 */
public class ValidateResponse implements Serializable{

    private String responseCode;

    private List<ResponseDatum> responseData = null;

    private String responseMsg;

    private Object appVersionCode;


    public String getResponseCode() {
        return responseCode;
    }


    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }


    public List<ResponseDatum> getResponseData() {
        return responseData;
    }


    public void setResponseData(List<ResponseDatum> responseData) {
        this.responseData = responseData;
    }


    public String getResponseMsg() {
        return responseMsg;
    }


    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }


    public Object getAppVersionCode() {
        return appVersionCode;
    }


    public void setAppVersionCode(Object appVersionCode) {
        this.appVersionCode = appVersionCode;
    }

    @Override
    public String toString() {
        return "ValidateResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseData=" + responseData +
                ", responseMsg='" + responseMsg + '\'' +
                ", appVersionCode=" + appVersionCode +
                '}';
    }
}
