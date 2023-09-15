# REMITA BILLER SDK (JAVA)

---
- [Overview](#Overview)
- [Installation](#Installation)
- [Usage](#Usage)
- [Features](Features)
- [Contributing](#Contributing)
- [License](License)

---

## Overview

This SDK outlines the Biller methods available on Remita. This document describes the methods offered by the Software Development Kit (SDK) through which SystemSpecs’ partners can integrate much easier and faster to Remita for facilitating customer payments to billers on their platform.

Integrating to Remita for Biller payments SDK enables your customers make payments to billers on Remita through your platform. This provides you with the capability to offer your customers access to the vast array of billers and merchants, including schools, churches, service providers and the Federal Government ministries, departments and agencies (MDAs) available on Remita to purchase and subscribe to their various products and services.

[![Maven Central](https://img.shields.io/maven-central/v/ng.com.systemspecs/remita-billing-gateway.svg?label=Maven%20Central)](https://search.maven.org/search?q=g:%22ng.com.systemspecs%22%20AND%20a:%22remita-billing-gateway%22)

The process involves your customers selecting a biller to pay via your platform. They will supply payment details and confirm the details so you can debit their account with AmountDue to credit a designated Funds Holding Account. Your customers will be emailed Remita receipts (which are FGN MDA-recognized for TSA-bound payments) for each transaction.

### Dependencies
#### Apache Maven
    <dependency>
        <groupId>ng.com.systemspecs</groupId>
        <artifactId>remita-billing-gateway</artifactId>
        <version>1.0.0</version>
    </dependency>

#### Gradle Groovy DSL
    implementation 'ng.com.systemspecs:remita-billing-gateway:1.0.0'

#### Gradle Kotlin DSL
    implementation("ng.com.systemspecs:remita-billing-gateway:1.0.0")

#### Scala SBT
    libraryDependencies += "ng.com.systemspecs" % "remita-billing-gateway" % "1.0.0"

#### Apache Ivy
    <dependency org="ng.com.systemspecs" name="remita-billing-gateway" rev="1.0.0" />

#### Groovy Grape
    @Grapes(@Grab(group='ng.com.systemspecs', module='remita-billing-gateway', version='1.0.0'))

#### Leiningen
    [ng.com.systemspecs/remita-billing-gateway "1.0.0"]

#### Apache Buildr
    'ng.com.systemspecs:remita-billing-gateway:jar:1.0.0'

#### Jar Download
 To download Jar  [CLICK](https://search.maven.org/remotecontent?filepath=ng/com/systemspecs/remita-billing-gateway/1.0.0/remita-billing-gateway-1.0.0.jar) 

 ---
 
## Installation
- Prior to using the SDK, you need to set up a profile on www.remita.net. Each  method call will require you to pass the Public key/Secret key. The SDK uses EnvironmentType.DEMO by default.
            1. Your DEMO public and secret keys are located at the Billing page on your profile.
            2. After you login, click ‘Setup Billing’ at your dashboard 
            3. Click ‘Proceed’ on the ‘Yes’ option for the integration question that comes up to display the Public/Secret key.

- To get your Production keys:
  			1. Click on the top-right button **Request to go-live**
                        2. Send an email to solutionsdelivery@systemspecs.com.ng, for UAT and go-live request.
                        3. After successful UAT, your production keys can be assessed on the Billing page.
*  Java 8 or later
*  STS , IntelliJ , Eclipse
*  Maven 4 and later

### Using the SDK 
*  Add any of the above dependency in your build tool file. E.g For MAVEN, add the dependency in apache maven section to your pom.xml

### Configuration
Before calling any of the Biller API methods, the SDK needs to be initialized with the Credentials object, see below:
#### Credentials attributes
|Field       | Type    | Required   | Description   |   
| ---        | ------  | -----------| -------- |   
| publicKey  | String  | Yes        | Located at the Billing page of your Remita profile on www.remita.net.
| secretKey  | String  | Yes        | Located at the Billing page of your Remita profile on www.remita.net.
|environment| EnvironmentType  | Yes        | credentials.setEnvironment(EnvironmentType.DEMO) for Demo environment, While credentials.setEnvironment(EnvironmentType.LIVE) for Production environment.
|transactionId | String | Yes| The value that is specified to identify a transaction from a third-party application accessing the billPayment notification method.
| readTimeOut| Integer | No| The timeout on waiting to read data.
| connectionTimeOut | Integer | No| The timeout in making the initial connection.
 
_Note:_ Each of this environment has it respective Credentials. Ensure you set the right credential. By default Environment is DEMO.
Below is a code sample on how to Initialize and set the credentials.

 ```java
        Credentials credentials = new Credentials();
        redentials credentials = new Credentials();
		credentials.setPublicKey("dC5vbW9udWJpQGdtYWlsLmNvbXxiM2RjMDhjZDRlZTc5ZDIxZDQwMjdjOWM3MmI5ZWY0ZDA3MTk2YTRkNGRkMjY3NjNkMGZkYzA4MjM1MzI4OWFhODE5OGM4MjM0NTI2YWI2ZjZkYzNhZmQzNDNkZmIzYmUwNTkxODlmMmNkOTkxNmM5MjVhNjYwZjk0ZTk1OTkwNw==");
		credentials.setSecretKey("95ab7ab7b2dc3152e3ab776c8f4bbe0ec5fe87526ee129617f319fb9edf79263a6fd15f1efe78f38ad6f04634dff993ccf9f075bf91f37aa52b61a9bd61c881e");
		credentials.setTransactionId(String.valueOf(System.currentTimeMillis()));
		credentials.setEnvironment(EnvironmentType.DEMO);

        RemitaBillingGatewayService gatewayService = new RemitaBillingGatewayServiceImpl(credentials);
        gatewayService.getbillers();
 ```
---

## Usage
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
    public GetBillerResponse getbillers(){
    ...
        RemitaBillingGatewayService gatewayService = new RemitaBillingGatewayServiceImpl(credentials);
        GetBillerResponse response = gatewayService.getBillers();
        return response;
    }
   ```
#### GetBillersResponse attributes
| Name  | Type    | 
| ---   | ------  | 
| responseCode | String |
| responseMsg | String |  
| appVersionCode | String | 
| responseData  | List<GetBillerResponseData>  |

#### GetBillersResponseData attributes
| Name  | Type    |
| ---   | ------  | 
| id | String |
| description | String |  
| label | String | 

### 2. GetServiceTypes(string billerId)
This returns a list of the products and services associated with specified billers on Remita.
```java
  public GetServiceResponse getServices() {
    ...
        RemitaBillingGatewayService gatewayService = new RemitaBillingGatewayServiceImpl(credentials);
        GetServiceResponse response = gatewayService.getService("QATEST");
        return response;
    }
```

#### GetServiceResponse attributes
| Name  | Type    | 
| ---   | ------  | 
| responseCode | String |
| responseMsg | String |  
| appVersionCode | String | 
| responseData  | List <GetServiceResponseData> 

#### GetServiceResponseData attributes
| Name  | Type    |
| ---   | ------  | 
| id | String |
| name | String | 

### 3. GetCustomField(string billId)
Custom fields are additional information specific to a service/product offered for sale by a biller. A service/product may or may not have custom fields defined. This endpoint returns a list of the custom fields associated with a specific product/service offered by a biller on the platform.
````java
 public GetCustomFieldResponse getCustomField() {
        ...
        RemitaBillingGatewayService gatewayService = new RemitaBillingGatewayServiceImpl(credentials);
        return gatewayService.getCustomField("25083618");
    }
````

#### GetCustomFieldResponse attributes
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

#### GetCustomFieldResponseData attributes
| Name  | Type    |
| ---   | ------  | 
| id | String |
| columnName | String | 
| columnType| String  |
| columnLength| String|
| required| Boolean|
|customFieldDropDown | List<GetCustomFieldResponseDropDown> |

#### GetCustomFieldResponseDropDown attributes
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
public GetRRRDetailsResponse getRRR() {
        ...
        RemitaBillingGatewayService gatewayService = new RemitaBillingGatewayServiceImpl(credentials);
        return gatewayService.getRRRDetails("110007764993");
    }
```

#### GetRRRDetailsResponse attributes
| Name  | Type    | 
| ---   | ------  | 
| responseCode | String |
| responseMsg | String |  
| appVersionCode | String | 
| responseData  | List<GetRRRDetailsResponseData> |

#### GetRRRDetailsResponseData attributes
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
   public ValidateResponse validate(){
        ...
        RemitaBillingGatewayService gatewayService = new RemitaBillingGatewayServiceImpl(credentials);
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
        ValidateResponse validateResponse = gatewayService.validate(validateRequest);
        return  validateResponse;
    }
````

#### ValidateResponse attributes
| Name  | Type    | 
| ---   | ------  | 
| responseCode | String |
| responseMsg | String |  
| appVersionCode | String | 
| responseData  | List<ResponseDatum> |

#### ResponseDatum attributes
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

#### CustomField attributes
| Name  | Type    | 
| ---   | ------  | 
| values | List<Value> |
| id | String |  

#### Value attributes
| Name  | Type    | 
| ---   | ------  | 
| value | String |
| amount | BigDecimal |  
| quantity | Integer |  

### 6. GenerateRRR(ValidateRequest validateRequest)
In order to complete the transaction through the Remita Payment Gateway, a Remita Retrieval Reference or RRR is required. This is what uniquely identifies and embodies the payment details of a transaction on the platform ecosystem. Calling this endpoint will generate an RRR for the biller payment.
**Note:** The feedback to this request will contain amountDue which is the computed total amount of the service. This is the amount you are expected to debit the payer with regardless of the amount supplied by payer or the amount specified for the service.

````java
     public GenerateResponse generateRRR(){
        ...
        RemitaBillingGatewayService gatewayService = new RemitaBillingGatewayServiceImpl(credentials);
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
        GenerateResponse generateResponse = gatewayService.generateRRR(validateRequest);
        return  generateResponse;
    }

````

#### GenerateResponse attributes
| Name  | Type    | 
| ---   | ------  | 
| responseCode | String |
| responseMsg | String |  
| appVersionCode | String | 
| responseData  | List<ResponseData> |

#### ResponseData attributes
| Name  | Type    | 
| ---   | ------  | 
| amountDue | BigDecimal |
| rrr | String |  

### 7. BillPaymentNotification(BillRequest billRequest)
After you have debit the customer with the RRR amount (amountDue) to process the payment, you are required to notify Remita with details of the transaction. Invoking this endpoint will send a payment notification for the transaction to Remita accordingly.
````java
    public BillNotificationResponse billNotification(){
        ...
        RemitaBillingGatewayService gatewayService = new RemitaBillingGatewayServiceImpl(credentials);
        BillRequest billRequest = new BillRequest();
        billRequest.setRrr("270007870639");
        billRequest.setAmountDebitted("1000");
        billRequest.setDebittedAccount("0035509366");
        billRequest.setBranchCode("546789096");
        billRequest.setFundingSource("TOKS");
        billRequest.setIncomeAccount("0001061499");
        billRequest.setTellerName("INTERNETBANKING");
        billRequest.setPaymentChannel("INTERNETBANKING");
        billRequest.setPaymentAuthCode("5467890968");
        BillNotificationResponse billNotificationResponse = gatewayService.billNotification(billRequest);
        return  billNotificationResponse;
    }
````

#### BillNotificationResponse attributes
| Name  | Type    | 
| ---   | ------  | 
| responseCode | String |
| responseMsg | String |  
| appVersionCode | String | 
| iResponseCode | String | 
| iResponseMessage | String | 
| responseData  | List<ResponseData> |

#### ResponseData attributes
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
    public GetTransactionStatusResponse getTransactionStatus(){
        ...
        RemitaBillingGatewayService gatewayService = new RemitaBillingGatewayServiceImpl(credentials);
        return gatewayService.getTransactionStatus("1540915827487");
    }
````

#### GetTransactionStatusResponse attributes
| Name  | Type    | 
| ---   | ------  | 
| responseCode | String |
| responseMsg | String |  
| appVersionCode | String | 
| iResponseCode | String | 
| iResponseMessage | String | 
| responseData  | List<GetTransactionStatusData> |

#### GetTransactionStatusData attributes
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

#### Description of the Custom Field Attributes
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

### Useful links
Join our Slack Developer/Support channel on [slack.](http://bit.ly/RemitaDevSlack)
    
### Support
For all other support needs, support@remita.net

---

## Contributing
To contribute to this repo, follow these guidelines for creating issues, proposing new features, and submitting pull requests:

1. Fork the repository.
2. Create a new branch: `git checkout -b "feature-name"`
3. Make your changes and commit: `git commit -m "added some new features"`
4. Push your changes: `git push origin feature-name`
5. Submit a Pull Request (PR).

Thank you!

---

## License

This project is licensed under the MIT License - see the [LICENSE.md](LICENSE.md) file for details.
