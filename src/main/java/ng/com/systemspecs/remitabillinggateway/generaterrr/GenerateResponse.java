package ng.com.systemspecs.remitabillinggateway.generaterrr;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ilesanmi Omoniyi
 * @author Eunice Olukitibi
 *
 * @since 1.0.0
 */
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

    @Override
    public String toString() {
        return "GenerateResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseData=" + responseData +
                ", responseMsg='" + responseMsg + '\'' +
                ", appVersionCode='" + appVersionCode + '\'' +
                '}';
    }
}
