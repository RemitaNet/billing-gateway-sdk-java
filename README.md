# REMITA BILLER SDK JAVA
This SDK Outlines the Biller methods available on Remita. This document describes the methods offered by the Software Development Kit (SDK) through which SystemSpecs’ partners can integrate much easier and faster to Remita for facilitating customer payments to billers on their platform.

## OVERVIEW 
Integrating to Remita for Biller payments SDK enables your customers make payments to billers on Remita through your platform. This provides you with the capability to offer your customers access to the vast array of billers and merchants, including schools, churches, service providers and the Federal Government ministries, departments and agencies (MDAs) available on Remita to purchase and subscribe to their various products and services.

The process involves your customers selecting a biller to pay via your platform. They will supply payment details and confirm the details so you can debit their account with AmountDue to credit a designated Funds Holding Account. Your customers will be emailed Remita receipts (which are FGN MDA-recognized for TSA-bound payments) for each transaction.

## PREREQUISITES
- Prior to using the SDK, you need to set up a profile on www.remita.net. Each  method call will require you to pass the Public key/Secret key. Note that these values have to be set in the header for any request. The SDK uses DEMO keys by default.
                >>Your DEMO public and secret keys are located at the Billing page at your profile.
                >>After you login, click ‘Setup Billing’ at your dashboard 
                >> click ‘Proceed’ on the ‘Yes’ option for the integration question that comes up to display the Public/Secret key.
- To get your Production keys:
                >>Click on the top-right button **Request to go-live**
                >>Send an email to solutionsdelivery@systemspecs.com.ng, for UAT and go-live request.
                >>After successful UAT, your production keys can be assessed on the Billing page.
- Java 1.8 or later
- IntelliJ, Eclipse.

## MAVEN DEPENDENCY
To install the remita-billing-sdk-java from central repository, add dependency to your application pom.xml as below.

<dependency>
			<artifactId>remita-billing-sdk-java</artifactId>
			<groupId>com.systemspecs.paymentinfra</groupId>
			<version>1.0-SNAPSHOT</version>
		</dependency>
## CREDENTIALS
Before calling any of the Biller API methods, the SDK needs to be initialized with the Credentials object, see below:
### Credentials attributes
|Field  | Type    | Required   | Description   |   
| ---   | ------  | -----------| -------- |   
| publicKey| String | Yes| Located at the Billing page of your Remita profile on www.remita.net.
| secretKey | String | Yes| Located at the Billing page of your Remita profile on www.remita.net.
| environment | String | Yes| credentials.setEnvironment("DEMO") for Demo environment, While credentials.setEnvironment("LIVE") for Production environment.
| transactionId | String | Yes| The value that is specified to identify a transaction from a third-party application accessing the billPayment notification method.
| readTimeOut | String | Yes| The timeout on waiting to read data.
| connectionTimeOut | String | Yes| The timeout in making the initial connection.

### Sample
```java
   String publicKey = "MDcwfDQwODE2OTg2fDI3MzY4NTc5MThkY2E0MDY5ZWFlN2JlOWRiNmUzNzMzMjc5NDdjYmMyZTM1NjAwM2I1N2NjMDgzMTdlYjIxMWMyNDgxYTc0Zjk4MGI4NzdhMDUwMzA1ZjgzNDlmNzU5NTRlZTVmOThiYjFmMTM4MTZjZjI2NWRhZDdmNjBjOTMz";
   String secretKey = 'cf51f77193fa9dd763cc6cf45887b874e99950053f9da0029a284a53c29ad7561423461930d0807d0d7e7ccbb305744968d8dc47b1018ee39a046b6e0a6e6f92';
    String environment = "DEMO";
    int readTimeOut = 5000;
    int connectionTimeOut = 15000;
    String transactionId = "720938000109892";
        
    Credentials credentials = new Credentials();
    credentials.publicKey = publicKey;
    credentials.secretKey = secretKey;
    credentials.setEnvironment("DEMO")
    credentials.transactionId = transactionId;
    credentials.setReadTimeOut(readTimeOut);
    credentials.setConnectionTimeOut(connectionTimeOut);
    
	remitaBilingGateway = new RemitaBilingGatewayService(credentials);
```

## METHODS
1. [GetBillers()](#getbillers)- Gets the list of billers on Remita platform.
2. [GetServiceTypes(string billerId)](#getservicetypes)- Gets the list of service  Types based on selected billerId.
3. [GetCustomField(string billId)](#getcustomfield) - Gets the list of Custom Fields based on selected serviceTypeId.
4. [GetRRRDetails(string rrr)](#getrrrdetails) - Remita Retrieval Reference (RRR) Lookup.
6. [ValidateResponse Validate(ValidateRequest validateRequest)](#validaterequest)- Validates request payload.
7. [GenerateRRR(GenerateRRRRequest generateRRRRequest)](#generateRRR) - Generates a Remita Retrieval Reference (RRR) and total amount payable.
7. [NotificationResponse BillNotification(NotificationRequest  notificationRequest)](#notificationresponse)- Notify Remita of successful transactions
8. [PaymentStatusResponse PaymentStatus(string transactionId)](#paymentstatus) - Check Payment Status.

### 1. Getbillers
This returns a list of the billers, merchants and MDAs available on Remita.

```java
Credentials credentials = new Credentials();
remitaBilingGateway = new RemitaBilingGatewayService(credentials);
GetBillerResponse getBillerResponse = remitaBilingGateway.getBillers();
```
### GetBillersResponse attributes
| Name  | Type    | 
| ---   | ------  | 
| responseCode | String |
| responseMsg | String |  
| appVersionCode | String | 
| responseData  | List<GetBillerResponseData>  |

### GetBillersResponseData attributes
| Name  | Type    |
| ---   | ------  | 
| id | String |
| description | String |  
| label | String | 


### 2. GetServiceTypes(string billerId)
This returns a list of the products and services associated with specified billers on Remita.
```java
Credentials credentials = new Credentials();
remitaBilingGateway = new RemitaBilingGatewayService(credentials);
GetServiceResponse getServiceResponse = remitaBilingGateway.getService("QATEST");
```
### GetServiceResponse attributes
| Name  | Type    | 
| ---   | ------  | 
| responseCode | String |
| responseMsg | String |  
| appVersionCode | String | 
| responseData  | List <GetServiceResponseData> 

### GetServiceResponseData attributes
| Name  | Type    |
| ---   | ------  | 
| id | String |
| name | String | 

### 3. GetCustomField(string billId)
Custom fields are additional information specific to a service/product offered for sale by a biller. A service/product may or may not have custom fields defined. This endpoint returns a list of the custom fields associated with a specific product/service offered by a biller on the platform.
````java
Credentials credentials = new Credentials();
remitaBilingGateway = new RemitaBilingGatewayService(credentials);
GetCustomFieldResponse getCustomFieldResponse = remitaBilingGateway.getCustomField("25083618");
````
### GetCustomFieldResponse attributes
| Name  | Type    | 
| ---   | ------  | 
| responseCode | String |
| responseMsg | String |  
| appVersionCode | String | 
| responseData  | List<GetCustomFieldResponseData> |
| acceptPartPayment | boolean |
| fixedPrice | boolean |
| fixedAmount | Double|
| currency | String|

## GetCustomFieldResponseData attributes
| Name  | Type    |
| ---   | ------  | 
| id | String |
| columnName | String | 
| columnType| String  |
| columnLength| String|
| required| Boolean|
|customFieldDropDown | List<GetCustomFieldResponseDropDown> |


## GetCustomFieldResponseDropDown attributes
| Name  | Type    |
| ---   | ------  | 
| id | String |
| description | String | 
| accountid| String|
| code | String|
| unitprice| String|
| fixedprice | String|

### 4. GetRRRDetails(string billId)
If your customer already has a Remita Retrieval Reference (RRR) before logging on to your online platform, he/she can also still process payment to Remita billers. They can supply the RRR, verify the RRR to display payment details associated with it and complete payment. The endpoint below makes the call to verify the RRR.

```java
Credentials credentials = new Credentials();
remitaBilingGateway = new RemitaBilingGatewayService(credentials);
GetRRRDetailsResponse getRRRDetails  = remitaBilingGateway.getRRRDetails("110007764993");
```
### GetRRRDetailsResponse attributes
| Name  | Type    | 
| ---   | ------  | 
| responseCode | String |
| responseMsg | String |  
| appVersionCode | String | 
| responseData  | List<GetRRRDetailsResponseData> |

## GetRRRDetailsResponseData attributes
| Name  | Type    | 
| ---   | ------  | 
|rrr |  String|
|amountDue |Integer|
|chargeFee|Double|
|rrrAmount |Integer |
|payerEmail | String|
|payerName | String|
|payerPhone | String|
|description |String|
|currency |String|
|type | String|
|acceptPartPayment |  Boolean 
|frequency | String|
|payerAccountNumber | String|
|maxNoOfDebits | String|
|startDate | String|
|endDate | String|
|extraData  | List<Object> |
|customFields |List<Object>|

### 5. ValidateRequest(ValidateRequest validateRequest)
You need to make a request for Remita to execute a validation operation on the details retrieved to check the validity of the data. This serves to ensure that the details being passed for payment are viable and will derive an amount payable to generate a Remita Retrieval Reference (RRR) successfully. The endpoint below enables you make this call towards generating an RRR for payment.
#Note:
The feedback from a validation call would indicate if all necessary field required for generating an RRR are available. To this end, you are expected to continue invoking the endpoint below to validate request until Remita returns status ‘REQUEST_OK’. Other statuses returnable ‘VALIDATION_FAILED’ or ‘MORE_DATA_REQUIRED’ for invalid request or if a required field that is needed is not supplied respectively.

````java
Credentials credentials = new Credentials();
remitaBilingGateway = new RemitaBilingGatewayService(credentials);
ValidateRequest validateRequest = new ValidateRequest();
      List<CustomField> customFieldList = new ArrayList<CustomField>();
        List<Value> valueList = new ArrayList<Value>();
        List<Value> valueList2 = new ArrayList<Value>();
        CustomField customField = new CustomField();
        CustomField customField1 = new CustomField();
        Value value = new Value();
        Value value1 = new Value();
        value.setAmount(BigDecimal.valueOf(1000));
        value.setQuantity(1);
        value.setValue("25083616");
        value1.setAmount(BigDecimal.valueOf(1000));
        value1.setQuantity(0);
        value1.setValue("Amount");
        valueList.add(value);
        valueList2.add(value1);
        customField.setValues(valueList);
        customField.setId("25083613");
        customField1.setValues(valueList2);
        customField1.setId("25083617");
        customFieldList.add(customField);
        customFieldList.add(customField1);
        validateRequest.setCustomFields(customFieldList);
        validateRequest.setAmount(BigDecimal.valueOf(1000));
        validateRequest.setBillId("25083618");
        validateRequest.setCurrency("NGN");
        validateRequest.setPayerEmail("euniceswit@gmail.com");
        validateRequest.setPayerName("Eunice Olukitibi");
        validateRequest.setPayerPhone("080339887160");
ValidateResponse validateResponse = remitaBilingGateway.validate(validateRequest)
````
### ValidateResponse attributes
| Name  | Type    | 
| ---   | ------  | 
| responseCode | String |
| responseMsg | String |  
| appVersionCode | String | 
| responseData  | List<ResponseDatum> |

### ResponseDatum attributes
| Name  | Type    | 
| ---   | ------  | 
| customFields | List<CustomField> |
| billId | String |  
| amount | Integer | 
| payerPhone  | String |
| currency  | String |
| payerName  | String |
| payerEmail | String |
| amountDue  | BigDecimal |
| status | String |

### CustomField attributes
| Name  | Type    | 
| ---   | ------  | 
| values | List<Value> |
| id | String |  

### Value attributes
| Name  | Type    | 
| ---   | ------  | 
| value | String |
| amount | BigDecimal |  
| quantity | Integer |  

### 6. GenerateRRR(ValidateRequest validateRequest)
In order to complete the transaction through the Remita Payment Gateway, a Remita Retrieval Reference or RRR is required. This is what uniquely identifies and embodies the payment details of a transaction on the platform ecosystem. Calling this endpoint will generate an RRR for the biller payment.
##### Note
The feedback to this request will contain amountDue which is the computed total amount of the service. This is the amount you are expected to debit the payer with regardless of the amount supplied by payer or the amount specified for the service.

````java
 Credentials credentials = new Credentials();
       remitaBilingGateway = new RemitaBilingGatewayService(credentials);
        ValidateRequest validateRequest = new ValidateRequest();
        List<CustomField> customFieldList = new ArrayList<CustomField>();
        List<Value> valueList = new ArrayList<Value>();
        List<Value> valueList2 = new ArrayList<Value>();
        CustomField customField = new CustomField();
        CustomField customField1 = new CustomField();
        Value value = new Value();
        Value value1 = new Value();
        value.setAmount(BigDecimal.valueOf(1000));
        value.setQuantity(1);
        value.setValue("25083616");
        value1.setAmount(BigDecimal.valueOf(1000));
        value1.setQuantity(0);
        value1.setValue("Amount");
        valueList.add(value);
        valueList2.add(value1);
        customField.setValues(valueList);
        customField.setId("25083613");
        customField1.setValues(valueList2);
        customField1.setId("25083617");
        customFieldList.add(customField);
        customFieldList.add(customField1);
        validateRequest.setCustomFields(customFieldList);
        validateRequest.setAmount(BigDecimal.valueOf(1000));
        validateRequest.setBillId("25083618");
        validateRequest.setCurrency("NGN");
        validateRequest.setPayerEmail("euniceswit@gmail.com");
        validateRequest.setPayerName("Eunice Olukitibi");
        validateRequest.setPayerPhone("080339887160");
        GenerateResponse generateResponse = remitaBilingGateway.generateRRR(validateRequest);
       GenerateResponse generateResponse = remitaBilingGateway.generate(validateRequest)
````
### GenerateResponse attributes
| Name  | Type    | 
| ---   | ------  | 
| responseCode | String |
| responseMsg | String |  
| appVersionCode | String | 
| responseData  | List<ResponseData> |

### ResponseData attributes
| Name  | Type    | 
| ---   | ------  | 
| amountDue | BigDecimal |
| rrr | String |  

### 7. BillPaymentNotification(BillRequest billRequest)
After you have debit the customer with the RRR amount (amountDue) to process the payment, you are required to notify Remita with details of the transaction. Invoking this endpoint will send a payment notification for the transaction to Remita accordingly.
````java
        Credentials credentials = new Credentials();
        remitaBilingGateway = new RemitaBilingGatewayService(credentials);
        remitaBilingGateway = new RemitaBilingGatewayService(credentials);
        BillRequest billRequest = new BillRequest();
        billRequest.setRrr("290007765333");
        billRequest.setAmountDebitted("1000");
        billRequest.setDebittedAccount("0035509366");
        billRequest.setBranchCode("546789096");
        billRequest.setFundingSource("TOKS");
        billRequest.setIncomeAccount("0001061499");
        billRequest.setTellerName("INTERNETBANKING");
        billRequest.setPaymentChannel("INTERNETBANKING");
        billRequest.setTransactionId("72093800010989290");
        billRequest.setPaymentAuthCode("54678908");
BillNotificationResponse notificationResponse = remitaBilingGateway.billNotification(billRequest);
````
### GenerateResponse attributes
| Name  | Type    | 
| ---   | ------  | 
| responseCode | String |
| responseMsg | String |  
| appVersionCode | String | 
| iResponseCode | String | 
| iResponseMessage | String | 
| responseData  | List<ResponseData> |

### ResponseData attributes
| Name  | Type    | 
| ---   | ------  | 
| rrr | String |
| totalAmount | BigDecimal |  
| balanceDue | BigDecimal | 
| paymentRef | String | 
| paymentDate | String | 
| debittedAccount | String | 
| amountDebitted | BigDecimal | 
| extendedData | List<Object> | 

### 8. TransactionStatus(String transactionId)
You may need to enquire that status of biller payments your customers have made via the BillPayment Notification API.
```java
     Credentials credentials = new Credentials();
        remitaBilingGateway = new RemitaBilingGatewayService(credentials);
        GetTransactionStatusResponse getStatus = remitaBilingGateway.getTransactionStatus(transactionId));
````
### GetTransactionStatusResponse attributes
| Name  | Type    | 
| ---   | ------  | 
| responseCode | String |
| responseMsg | String |  
| appVersionCode | String | 
| iResponseCode | String | 
| iResponseMessage | String | 
| responseData  | List<GetTransactionStatusData> |

### GetTransactionStatusData attributes
| Name  | Type    | 
| ---   | ------  | 
| rrr | String |
| totalAmount | BigDecimal |  
| balanceDue | BigDecimal | 
| paymentRef | String | 
| paymentDate | String | 
| debittedAccount | String | 
| amountDebitted | BigDecimal | 
| extendedData | List<Object> | 






### Description of the Custom Field Attributes
| ATTRIBUTE  | DESCRIPTION    | 
| ---   | ------  |
|columnLength |Represents the maximum length of the field. Useful for validation.|
|columnName |Represents the name or label of the field. This value is displayed in the element’s label or placeholder.|
|columnType |Represents the field character type. Useful for validation|
|           |A – accepts alphabets only|
|           |AN – accepts alphanumeric only|
|           |N – accepts number only|
|           |D – accepts date only|
|           |DD – single-select item list (no price/amount)|
|           |SL – multi-select item list (no price/amount)|
|           |SP – multi-select item list with price/amount|
|           |ALL - accepts all text types| 
|customFieldDropDown |This represents a list of values or items and is ONLY specific to columnTypes DD, SL and SP above|
|id |Represents the identifier of the field|
|required   |Y – This flag means the custom field is required/mandatory. Useful for validation|
|           |N – This flag means the custom field is optional|
|type       |py – Payment RRR|
|           | so – Standing Order / DD- Direct Debit|

For all other support needs, see www.remita.net/developers.

