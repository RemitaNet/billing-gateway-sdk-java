package ng.com.systemspecs.remitabillinggateway.util;

/**
 * @author Ilesanmi Omoniyi
 *
 * @since 1.0.0
 */
public enum APiResponseCode {
    INVALID_PUBLICKEY("011", "Public key not provided"),
    INVALID_SECRETKEY("012", "Secret key not provided"),
    CONNECTION_ERROR("013", "Timeout connecting to Remita"),
    ERROR_WHILE_CONNECTING("251", "Error occur while connecting to RemitaBilingGateway service");

    private String code;
    private String description;

    public void setDescription(String description) { this.description = description; }

    APiResponseCode(String code, String description) {
        setCode(code);
        setDescription(description);
    }

    public void setCode(String code) { this.code = code; }
    public String getCode() { return code; }
    public String getDescription() { return description; }
}

