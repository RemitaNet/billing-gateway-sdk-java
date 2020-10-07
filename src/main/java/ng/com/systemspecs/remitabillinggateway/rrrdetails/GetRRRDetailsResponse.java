package ng.com.systemspecs.remitabillinggateway.rrrdetails;


import java.io.Serializable;
import java.util.List;

/**
 * @author Ilesanmi Omoniyi
 * @author Eunice Olukitibi
 *
 * @since 1.0.0
 */
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

    @Override
    public String toString() {
        return "GetRRRDetailsResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseData=" + responseData +
                ", responseMsg='" + responseMsg + '\'' +
                ", appVersionCode='" + appVersionCode + '\'' +
                '}';
    }
}
