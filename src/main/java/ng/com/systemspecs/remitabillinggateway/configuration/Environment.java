package ng.com.systemspecs.remitabillinggateway.configuration;


import ng.com.systemspecs.remitabillinggateway.util.ApplicationConstant;

import java.util.HashMap;
import java.util.Map;


/**
 * A configuration class
 *
 *
 * @author Ilesanmi Omoniyi
 *
 * @since 1.0.0
 */
public class Environment {

    private Credentials credentials;

    public Environment(Credentials credentials) {
        this.credentials = credentials;
    }

    public Map<String, String> getConfiguration() {
        Map<String, String> configurationgMap = new HashMap<>();
        String env = credentials.getEnvironment().name();

        switch (env) {
            case "DEMO":
                getEnvParameters(credentials, configurationgMap, ApplicationConstant.DEMO_URL);
                break;
            case "LIVE":
                getEnvParameters(credentials, configurationgMap, ApplicationConstant.LIVE_URL);
                break;
            default:
                configurationgMap.put("ERROR", "Invalid Environment");
        }
        return configurationgMap;
    }

    private void getEnvParameters(Credentials credentials, Map<String, String> configurationgMap, String envUrl) {
        configurationgMap.put("publicKey", credentials.getPublicKey().trim());
        configurationgMap.put("transactionId", credentials.getTransactionId().trim());
        configurationgMap.put("GET_BILLERS_URL", envUrl + "billers");
        configurationgMap.put("GET_SERVICETYPES_URL", envUrl + "%s/servicetypes");
        configurationgMap.put("GET_CUSTOMFIELDS_URL", envUrl + "servicetypes/%s");
        configurationgMap.put("GENERATE_RRR_URL", envUrl + "generate");
        configurationgMap.put("GET_RRRDETAILS_URL", envUrl + "lookup/%s");
        configurationgMap.put("VALIDATION_URL", envUrl + "validate");
        configurationgMap.put("BILL_NOTIFICATION_URL", envUrl + "payment/notify");
        configurationgMap.put("PAYMENT_STATUS_URL", envUrl + "payment/status/%s");
    }

}
