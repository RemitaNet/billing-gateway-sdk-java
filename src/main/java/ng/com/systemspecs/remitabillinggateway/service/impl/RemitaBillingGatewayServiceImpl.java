package ng.com.systemspecs.remitabillinggateway.service.impl;

import com.google.gson.Gson;
import ng.com.systemspecs.remitabillinggateway.configuration.Credentials;
import ng.com.systemspecs.remitabillinggateway.configuration.Environment;
import ng.com.systemspecs.remitabillinggateway.billers.GetBillerResponse;
import ng.com.systemspecs.remitabillinggateway.customfields.GetCustomFieldResponse;
import ng.com.systemspecs.remitabillinggateway.generaterrr.GenerateResponse;
import ng.com.systemspecs.remitabillinggateway.notification.BillNotificationResponse;
import ng.com.systemspecs.remitabillinggateway.notification.BillRequest;
import ng.com.systemspecs.remitabillinggateway.paymentstatus.GetTransactionStatusResponse;
import ng.com.systemspecs.remitabillinggateway.rrrdetails.GetRRRDetailsResponse;
import ng.com.systemspecs.remitabillinggateway.servicetypes.GetServiceResponse;
import ng.com.systemspecs.remitabillinggateway.service.RemitaBillingGatewayService;
import ng.com.systemspecs.remitabillinggateway.util.APiResponseCode;
import ng.com.systemspecs.remitabillinggateway.util.Connection;
import ng.com.systemspecs.remitabillinggateway.util.ConnectionImpl;
import ng.com.systemspecs.remitabillinggateway.util.SimpleSHAHashGenerator;
import ng.com.systemspecs.remitabillinggateway.validate.ValidateRequest;
import ng.com.systemspecs.remitabillinggateway.validate.ValidateResponse;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * The <tt>RemitaBillingGatewayServiceImpl</tt> class implements the eight methods in <tt>RemitaBillingGatewayService</tt>  for integrating with Remita
 * Billing Gateway.
 *
 *
 * For example:
 *
 * <pre class="code">
 * RemitaBillingGatewayService remitaBillingGatewayService = new RemitaBillingGatewayServiceImpl(Credentials.class);
 * remitaBillingGatewayService.getBillers();
 * </pre>
 *
 * @author Ilesanmi Omoniyi
 *
 * @since 1.0.0
 */
public class RemitaBillingGatewayServiceImpl implements RemitaBillingGatewayService {

    /**
     * Credentials set the billers keys, like publicKey, SecretKey etc.
     *
     * @see Credentials
     */
    private Credentials credentials;

    /**
     * @see Connection
     */
    private Connection connection;

    /**
     * @see Environment
     */
    private Environment environment;

    /**
     * An instance of RemitaBillingGatewayServiceImpl is used to invoke any of the
     * eight methods provided in RemitaBillingGatewayService
     *
     * @param credentials billers credentials for Remita Billing Gateway Service
     *
     * @see Credentials
     */
    public RemitaBillingGatewayServiceImpl(Credentials credentials) {
        this.credentials = credentials;
        this.connection = new ConnectionImpl();
        this.environment = new Environment(credentials);
    }

    /**
     * This returns a list of the billers, merchants and MDAs available on Remita.
     *
     */
    @Override
    public GetBillerResponse getBillers() {
        GetBillerResponse response = new GetBillerResponse();
        APiResponseCode rCode = null;
        try {
            if (credentials.getPublicKey() == null || StringUtils.isEmpty(credentials.getPublicKey())) {
                rCode = APiResponseCode.INVALID_PUBLICKEY;
                response.setResponseCode(rCode.getCode());
                response.setResponseMsg(rCode.getDescription());
            }
            Map<String, String> configuration = environment.getConfiguration();
            String url = configuration.get("GET_BILLERS_URL");
            String getResponse = connection.sendGET(url, credentials);
            return new Gson().fromJson(getResponse, GetBillerResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            rCode = APiResponseCode.ERROR_WHILE_CONNECTING;
            response.setResponseCode(rCode.getCode());
            response.setResponseMsg(rCode.getDescription());
            return response;
        }
    }

    /**
     * This returns a list of products and services associated with specified billers on Remita.
     *
     * @param billerId String for which the services should be returned
     *
     */
    @Override
    public GetServiceResponse getService(String billerId) {
        GetServiceResponse response = new GetServiceResponse();
        APiResponseCode rCode = null;
        try {
            if (credentials.getPublicKey() == null || StringUtils.isEmpty(credentials.getPublicKey())) {
                rCode = APiResponseCode.INVALID_PUBLICKEY;
                response.setResponseCode(rCode.getCode());
                response.setResponseMsg(rCode.getDescription());
            }
            Map<String, String> configuration = environment.getConfiguration();
            String url = String.format(configuration.get("GET_SERVICETYPES_URL"), billerId);
            String getResponse = connection.sendGET(url, credentials);
            return new Gson().fromJson(getResponse, GetServiceResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            rCode = APiResponseCode.ERROR_WHILE_CONNECTING;
            response.setResponseCode(rCode.getCode());
            response.setResponseMsg(rCode.getDescription());
            return response;
        }
    }

    /**
     * Custom fields are additional information specific to a service/product
     * offered for sale by a biller. A service/product may or may not have
     * custom fields defined. This method returns a list of the custom fields
     * associated with a specific product/service offered by a biller on the platform.
     *
     * @param billId String for which the custom fields should be returned
     *
     */
    @Override
    public GetCustomFieldResponse getCustomField(String billId) {
        GetCustomFieldResponse response = new GetCustomFieldResponse();
        APiResponseCode rCode = null;
        try {
            if (credentials.getPublicKey() == null || StringUtils.isEmpty(credentials.getPublicKey())) {
                rCode = APiResponseCode.INVALID_PUBLICKEY;
                response.setResponseCode(rCode.getCode());
                response.setResponseMsg(rCode.getDescription());
            }
            Map<String, String> configuration = environment.getConfiguration();
            String url = String.format(configuration.get("GET_CUSTOMFIELDS_URL"), billId);
            String getResponse = connection.sendGET(url, credentials);
            return new Gson().fromJson(getResponse, GetCustomFieldResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            rCode = APiResponseCode.ERROR_WHILE_CONNECTING;
            response.setResponseCode(rCode.getCode());
            response.setResponseMsg(rCode.getDescription());
            return response;
        }
    }

    /**
     * If your customer already has a Remita Retrieval Reference (RRR)
     * before logging on to your online platform, he/she can also still
     * process payment to Remita billers. They can supply the RRR, verify
     * the RRR to display payment details associated with it before
     * completing the payment. This method makes the call to verify the RRR.
     *
     * @param rrr String for which details should looked up
     *
     */
    @Override
    public GetRRRDetailsResponse getRRRDetails(String rrr) {
        GetRRRDetailsResponse response = new GetRRRDetailsResponse();
        APiResponseCode rCode = null;
        try {
            if (credentials.getPublicKey() == null || StringUtils.isEmpty(credentials.getPublicKey())) {
                rCode = APiResponseCode.INVALID_PUBLICKEY;
                response.setResponseCode(rCode.getCode());
                response.setResponseMsg(rCode.getDescription());
            }
            Map<String, String> configuration = environment.getConfiguration();
            String url = String.format(configuration.get("GET_RRRDETAILS_URL"), rrr);
            String getResponse = connection.sendGET(url, credentials);
            return new Gson().fromJson(getResponse, GetRRRDetailsResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            rCode = APiResponseCode.ERROR_WHILE_CONNECTING;
            response.setResponseCode(rCode.getCode());
            response.setResponseMsg(rCode.getDescription());
            return response;
        }
    }

    /**
     * You need to make a request for Remita to execute a validation operation on
     * the details retrieved to check the validity of the data. This serves to ensure
     * that the details being passed for payment are viable and will derive an amount
     * payable to generate a Remita Retrieval Reference (RRR) successfully.
     * This method enables you make this call towards generating an RRR for payment.
     *
     *  @param validateRequest request object to be validated
     *
     */
    @Override
    public ValidateResponse validate(ValidateRequest validateRequest) {
        ValidateResponse response = new ValidateResponse();
        APiResponseCode rCode = null;
        try {
            if (credentials.getPublicKey() == null || StringUtils.isEmpty(credentials.getPublicKey())) {
                rCode = APiResponseCode.INVALID_PUBLICKEY;
                response.setResponseCode(rCode.getCode());
                response.setResponseMsg(rCode.getDescription());
            }
            Map<String, String> configuration = environment.getConfiguration();
            String url = configuration.get("VALIDATION_URL");
            String getResponse = connection.sendPOST(url, credentials, validateRequest);
            return new Gson().fromJson(getResponse, ValidateResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            rCode = APiResponseCode.ERROR_WHILE_CONNECTING;
            response.setResponseCode(rCode.getCode());
            response.setResponseMsg(rCode.getDescription());
            return response;
        }
    }

    /**
     * In order to complete the transaction through the Remita Payment Gateway,
     * a Remita Retrieval Reference or RRR is required. This is what uniquely
     * identifies and embodies the payment details of a transaction on the platform ecosystem.
     * Calling this method will generate an RRR for the biller payment.
     *
     *
     * @param validateRequest request object for RRR generation
     *
     */
    @Override
    public GenerateResponse generateRRR(ValidateRequest validateRequest) {
        GenerateResponse response = new GenerateResponse();
        APiResponseCode rCode = null;
        try {
            if (credentials.getPublicKey() == null || StringUtils.isEmpty(credentials.getPublicKey())) {
                rCode = APiResponseCode.INVALID_PUBLICKEY;
                response.setResponseCode(rCode.getCode());
                response.setResponseMsg(rCode.getDescription());
            }
            Map<String, String> configuration = environment.getConfiguration();
            String url = configuration.get("GENERATE_RRR_URL");
            String getResponse = connection.sendPOST(url, credentials, validateRequest);
            return new Gson().fromJson(getResponse, GenerateResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            rCode = APiResponseCode.ERROR_WHILE_CONNECTING;
            response.setResponseCode(rCode.getCode());
            response.setResponseMsg(rCode.getDescription());
            return response;
        }
    }

    /**
     * After you have debit the customer with the RRR amount (amountDue) to process the payment,
     * you are required to notify Remita with details of the transaction. Calling this method
     * will send a payment notification for the transaction to Remita accordingly.
     *
     * @param billRequest request object for Notification
     *
     */
    @Override
    public BillNotificationResponse billNotification(BillRequest billRequest) {
        BillNotificationResponse response = new BillNotificationResponse();
        APiResponseCode rCode = null;
        try {
            if (credentials.getPublicKey() == null || StringUtils.isEmpty(credentials.getPublicKey())) {
                rCode = APiResponseCode.INVALID_PUBLICKEY;
                response.setResponseCode(rCode.getCode());
                response.setResponseMsg(rCode.getDescription());
            }
            Map<String, String> configuration = environment.getConfiguration();
            String url = configuration.get("BILL_NOTIFICATION_URL");
            String stringForHash = billRequest.getRrr()+ billRequest.getAmountDebitted()+
                    billRequest.getFundingSource() + billRequest.getDebittedAccount()+ billRequest.getPaymentAuthCode() +
                    credentials.getSecretKey();
            String transHash = SimpleSHAHashGenerator.generateSHA512SecurePassword(stringForHash);
            String getResponse = connection.sendPOSTWithHash(url, credentials, billRequest, transHash);
            return new Gson().fromJson(getResponse, BillNotificationResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            rCode = APiResponseCode.ERROR_WHILE_CONNECTING;
            response.setResponseCode(rCode.getCode());
            response.setResponseMsg(rCode.getDescription());
            return response;
        }
    }

    /**
     * You may need to enquire that status of biller payments your customers have made via the Bill Payment Notification.
     *
     * @param transactionId String for which the transaction status should be returned
     *
     */
    @Override
    public GetTransactionStatusResponse getTransactionStatus(String transactionId) {
        GetTransactionStatusResponse response = new GetTransactionStatusResponse();
        APiResponseCode rCode = null;
        try {
            if (credentials.getPublicKey() == null || StringUtils.isEmpty(credentials.getPublicKey())) {
                rCode = APiResponseCode.INVALID_PUBLICKEY;
                response.setResponseCode(rCode.getCode());
                response.setResponseMsg(rCode.getDescription());
            }
            Map<String, String> configuration = environment.getConfiguration();
            String url = String.format(configuration.get("PAYMENT_STATUS_URL"), transactionId);
            String getResponse = connection.sendGET(url, credentials);
            return new Gson().fromJson(getResponse, GetTransactionStatusResponse.class);
        } catch (Exception e) {
            e.printStackTrace();
            rCode = APiResponseCode.ERROR_WHILE_CONNECTING;
            response.setResponseCode(rCode.getCode());
            response.setResponseMsg(rCode.getDescription());
            return response;
        }
    }
}
