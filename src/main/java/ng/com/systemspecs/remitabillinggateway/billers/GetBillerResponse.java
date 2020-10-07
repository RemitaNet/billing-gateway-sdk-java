package ng.com.systemspecs.remitabillinggateway.billers;

import com.google.gson.ExclusionStrategy;
import com.google.gson.GsonBuilder;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ilesanmi Omoniyi
 * @author Eunice Olukitibi
 *
 * @since 1.0.0
 */
public class GetBillerResponse implements Serializable {

    private String responseCode;

    private List<GetBillerResponseData> responseData = null;

    private String responseMsg;

    private String appVersionCode;


    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public List<GetBillerResponseData> getResponseData() {
        return responseData;
    }

    public void setResponseData(List<GetBillerResponseData> responseData) {
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
        return "GetBillerResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseData=" + responseData +
                ", responseMsg='" + responseMsg + '\'' +
                ", appVersionCode='" + appVersionCode + '\'' +
                '}';
    }
}
