package ng.com.systemspecs.remitabillinggateway.service;

import ng.com.systemspecs.remitabillinggateway.billers.GetBillerResponse;
import ng.com.systemspecs.remitabillinggateway.customfields.GetCustomFieldResponse;
import ng.com.systemspecs.remitabillinggateway.generaterrr.GenerateResponse;
import ng.com.systemspecs.remitabillinggateway.notification.BillNotificationResponse;
import ng.com.systemspecs.remitabillinggateway.notification.BillRequest;
import ng.com.systemspecs.remitabillinggateway.paymentstatus.GetTransactionStatusResponse;
import ng.com.systemspecs.remitabillinggateway.rrrdetails.GetRRRDetailsResponse;
import ng.com.systemspecs.remitabillinggateway.servicetypes.GetServiceResponse;
import ng.com.systemspecs.remitabillinggateway.validate.ValidateRequest;
import ng.com.systemspecs.remitabillinggateway.validate.ValidateResponse;


/**
 * The <tt>RemitaBillingGatewayService</tt> interface provides eight methods for integrating with Remita
 * Billing Gateway.
 *
 *
 * @author Ilesanmi Omoniyi
 *
 * @since 1.0.0
 */
public interface RemitaBillingGatewayService {

    /**
     * Returns the list of Billers on Remita platform
     *
     */
    GetBillerResponse getBillers();

    /**
     * Returns the list of Service Types based on selected billerId
     *
     * @param billerId String for which the services should be returned
     *
     */
    GetServiceResponse getService(String billerId);

    /**
     * Returns the list of Custom Fields based on selected serviceTypeId
     *
     * @param billId String for which the custom fields should be returned
     *
     */
    GetCustomFieldResponse getCustomField(String billId);

    /**
     * Returns result of Remita Retrieval Reference (RRR) Lookup
     *
     * @param rrr String for which details should looked up
     *
     */
    GetRRRDetailsResponse getRRRDetails(String rrr);

    /**
     * Validates request payload for RRR generation
     *
     *  @param validateRequest request object to be validated
     *
     */
    ValidateResponse validate(ValidateRequest validateRequest);

    /**
     * Generates a Remita Retrieval Reference (RRR) and total amount payable
     *
     * @param validateRequest request object for RRR generation
     *
     */
    GenerateResponse generateRRR(ValidateRequest validateRequest);

    /**
     * Notify Remita of successful transactions
     *
     * @param billRequest request object for Notification
     *
     */
    BillNotificationResponse billNotification(BillRequest billRequest);

    /**
     * Check Payment Status
     *
     * @param transactionId String for which the transaction status should be returned
     *
     */
    GetTransactionStatusResponse getTransactionStatus(String transactionId);
}
