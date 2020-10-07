package ng.com.systemspecs.remitabillinggateway.notification;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ilesanmi Omoniyi
 * @author Eunice Olukitibi
 *
 * @since 1.0.0
 */
public class BillNotificationResponse implements Serializable {

    private String responseCode;

    private String responseMsg;

    private String iResponseCode;

    private String iResponseMessage;

    private String appVersionCode;

    private List<ResponseData> responseData = null;


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

    public String getiResponseCode() {
        return iResponseCode;
    }

    public void setiResponseCode(String iResponseCode) {
        this.iResponseCode = iResponseCode;
    }

    public String getiResponseMessage() {
        return iResponseMessage;
    }

    public void setiResponseMessage(String iResponseMessage) {
        this.iResponseMessage = iResponseMessage;
    }

    public String getAppVersionCode() {
        return appVersionCode;
    }

    public void setAppVersionCode(String appVersionCode) {
        this.appVersionCode = appVersionCode;
    }

    public List<ResponseData> getResponseData() {
        return responseData;
    }

    public void setResponseData(List<ResponseData> responseData) {
        this.responseData = responseData;
    }

    @Override
    public String toString() {
        return "BillNotificationResponse{" +
                "responseCode='" + responseCode + '\'' +
                ", responseMsg='" + responseMsg + '\'' +
                ", iResponseCode='" + iResponseCode + '\'' +
                ", iResponseMessage='" + iResponseMessage + '\'' +
                ", appVersionCode='" + appVersionCode + '\'' +
                ", responseData=" + responseData +
                '}';
    }
}
