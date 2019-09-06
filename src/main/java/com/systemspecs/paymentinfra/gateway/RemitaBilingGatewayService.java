package com.systemspecs.paymentinfra.gateway;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.systemspecs.paymentinfra.config.Credentials;
import com.systemspecs.paymentinfra.constant.ApplicationUrl;

import com.systemspecs.paymentinfra.request.BillRequest;
import com.systemspecs.paymentinfra.request.ValidateRequest;
import com.systemspecs.paymentinfra.response.*;
import com.systemspecs.paymentinfra.response.notification.BillNotificationResponse;
import com.systemspecs.paymentinfra.response.validate.ValidateResponse;
import com.systemspecs.paymentinfra.response.generate.GenerateResponse;
import org.springframework.http.*;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;


public class RemitaBilingGatewayService {

    public static final String ENCODING_UTF_8 = "UTF-8";

    public static final String ALGORITHM_SHA_512 = "SHA-512";

    public RestTemplate restTemplate = new RestTemplate();

    private Credentials credentials;


    RemitaBilingGatewayService() {
    }


    public RemitaBilingGatewayService(Credentials credentials) {
        this.credentials = credentials;
    }


    Gson gson = new Gson();

    Random randomNumber = new Random();


    public GetBillerResponse getBillers() {
        GetBillerResponse getBillerResponse = null;
        if (credentials.getEnvironment().equalsIgnoreCase("LIVE")) {
            try {
                HttpEntity requestEntity = new HttpEntity(null, getHeaders(credentials.getPublicKey(), String.valueOf(randomNumber)));
                ResponseEntity<String> responseEntity = restTemplate.exchange(ApplicationUrl.productionUrlBase, HttpMethod.GET, requestEntity, String.class);
                // log.debug("Response Data {}", responseEntity);
                getBillerResponse = gson.fromJson(responseEntity.getBody(), GetBillerResponse.class);
            } catch (RestClientException e) {
                e.printStackTrace();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        } else {
            try {
                HttpEntity requestEntity = new HttpEntity(null, getHeaders(credentials.getPublicKey(), String.valueOf(randomNumber)));
                ResponseEntity<String> responseEntity = restTemplate.exchange(ApplicationUrl.getBillersUrl, HttpMethod.GET, requestEntity, String.class);
                // log.debug("Response Data {}", responseEntity);
                getBillerResponse = gson.fromJson(responseEntity.getBody(), GetBillerResponse.class);
            } catch (RestClientException e) {
                e.printStackTrace();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        }
        return getBillerResponse;
    }


    public GetServiceResponse getService(String billerId) {
        GetServiceResponse getServiceResponse = null;
        if (credentials.getEnvironment().equalsIgnoreCase("LIVE")) {
            try {
                HttpEntity requestEntity = new HttpEntity(null, getHeaders(credentials.getPublicKey(), String.valueOf(randomNumber)));
                ResponseEntity<String> responseEntity = restTemplate.exchange(
                        String.format("%s%s%s", ApplicationUrl.productionUrlBase, billerId, ApplicationUrl.getServiceUrl), HttpMethod.GET, requestEntity,
                        String.class);
                getServiceResponse = gson.fromJson(responseEntity.getBody(), GetServiceResponse.class);
            } catch (RestClientException e) {
                e.printStackTrace();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        } else {
            try {
                HttpEntity requestEntity = new HttpEntity(null, getHeaders(credentials.getPublicKey(), String.valueOf(randomNumber)));
                ResponseEntity<String> responseEntity = restTemplate.exchange(
                        String.format("%s%s%s", ApplicationUrl.demoUrlbase, billerId, ApplicationUrl.getServiceUrl), HttpMethod.GET, requestEntity,
                        String.class);
                getServiceResponse = gson.fromJson(responseEntity.getBody(), GetServiceResponse.class);
            } catch (RestClientException e) {
                e.printStackTrace();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        }
        return getServiceResponse;
    }


    public GetCustomFieldResponse getCustomField(String billId) {
        GetCustomFieldResponse getCustomFieldResponse = new GetCustomFieldResponse();
        if (credentials.getEnvironment().equalsIgnoreCase("LIVE")) {
            try {
                HttpEntity requestEntity = new HttpEntity(null, getHeaders(credentials.getPublicKey(), String.valueOf(randomNumber)));
                ResponseEntity<String> responseEntity = restTemplate.exchange(
                        String.format("%s%s%s",  ApplicationUrl.productionUrlBase, ApplicationUrl.getCustomFieldUrl, billId), HttpMethod.GET, requestEntity,
                        String.class);
                getCustomFieldResponse = gson.fromJson(responseEntity.getBody(), GetCustomFieldResponse.class);
            } catch (RestClientException e) {
                e.printStackTrace();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        } else {
            try {
                HttpEntity requestEntity = new HttpEntity(null, getHeaders(credentials.getPublicKey(), String.valueOf(randomNumber)));
                ResponseEntity<String> responseEntity = restTemplate.exchange(
                        String.format("%s%s%s", ApplicationUrl.demoUrlbase, ApplicationUrl.getCustomFieldUrl, billId), HttpMethod.GET, requestEntity,
                        String.class);
                getCustomFieldResponse = gson.fromJson(responseEntity.getBody(), GetCustomFieldResponse.class);
            } catch (RestClientException e) {
                e.printStackTrace();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        }
        return getCustomFieldResponse;
    }


    public GetRRRDetailsResponse getRRRDetails(String rrr) {
        GetRRRDetailsResponse getRRRDetails = new GetRRRDetailsResponse();
        if (credentials.getEnvironment().equalsIgnoreCase("LIVE")) {
            try {
                HttpEntity requestEntity = new HttpEntity(null, getHeaders(credentials.getPublicKey(), String.valueOf(randomNumber)));
                ResponseEntity<String> responseEntity = restTemplate.exchange(
                        String.format("%s%s%s",  ApplicationUrl.productionUrlBase, ApplicationUrl.getRRRDetailsUrl, rrr), HttpMethod.GET, requestEntity, String.class);
                getRRRDetails = gson.fromJson(responseEntity.getBody(), GetRRRDetailsResponse.class);
            } catch (RestClientException e) {
                e.printStackTrace();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        } else {
            try {
                HttpEntity requestEntity = new HttpEntity(null, getHeaders(credentials.getPublicKey(), String.valueOf(randomNumber)));
                ResponseEntity<String> responseEntity = restTemplate.exchange(
                        String.format("%s%s%s", ApplicationUrl.demoUrlbase, ApplicationUrl.getRRRDetailsUrl, rrr), HttpMethod.GET, requestEntity, String.class);
                getRRRDetails = gson.fromJson(responseEntity.getBody(), GetRRRDetailsResponse.class);
            } catch (RestClientException e) {
                e.printStackTrace();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        }
        return getRRRDetails;
    }


    public GetTransactionStatusResponse getTransactionStatus(String transactionId) {
        GetTransactionStatusResponse getStatus = new GetTransactionStatusResponse();
        if (credentials.getEnvironment().equalsIgnoreCase("LIVE")) {
            try {
                HttpEntity requestEntity = new HttpEntity(null, getHeaders(credentials.getPublicKey(), String.valueOf(randomNumber)));
                ResponseEntity<String> responseEntity = restTemplate.exchange(
                        String.format("%s%s%s",  ApplicationUrl.productionUrlBase, ApplicationUrl.getTransactionStatusUrl, transactionId), HttpMethod.GET,
                        requestEntity, String.class);
                getStatus = gson.fromJson(responseEntity.getBody(), GetTransactionStatusResponse.class);
            } catch (RestClientException e) {
                e.printStackTrace();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        } else {
            try {
                HttpEntity requestEntity = new HttpEntity(null, getHeaders(credentials.getPublicKey(), String.valueOf(randomNumber)));
                ResponseEntity<String> responseEntity = restTemplate.exchange(
                        String.format("%s%s%s", ApplicationUrl.demoUrlbase, ApplicationUrl.getTransactionStatusUrl, transactionId), HttpMethod.GET,
                        requestEntity, String.class);
                getStatus = gson.fromJson(responseEntity.getBody(), GetTransactionStatusResponse.class);
            } catch (RestClientException e) {
                e.printStackTrace();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        }
        return getStatus;
    }


    public ValidateResponse validate(ValidateRequest validateRequest) {
        ValidateResponse validateResponse = null;
        if (credentials.getEnvironment().equalsIgnoreCase("LIVE")) {
            try {
                validateResponse = new ValidateResponse();
                HttpEntity requestEntity = new HttpEntity(gson.toJson(validateRequest), getHeaders(credentials.getPublicKey(), String.valueOf(randomNumber)));
                String url = String.format("%s%s",  ApplicationUrl.productionUrlBase, ApplicationUrl.validateRequestUrl);
                String responsePayload = restTemplate.postForObject(url, requestEntity, String.class);
                validateResponse = gson.fromJson(responsePayload, ValidateResponse.class);
            } catch (RestClientException e) {
                e.printStackTrace();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        } else {
            try {
                validateResponse = new ValidateResponse();
                HttpEntity requestEntity = new HttpEntity(gson.toJson(validateRequest), getHeaders(credentials.getPublicKey(), String.valueOf(randomNumber)));
                String url = String.format("%s%s", ApplicationUrl.demoUrlbase, ApplicationUrl.validateRequestUrl);
                String responsePayload = restTemplate.postForObject(url, requestEntity, String.class);
                validateResponse = gson.fromJson(responsePayload, ValidateResponse.class);
            } catch (RestClientException e) {
                e.printStackTrace();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        }
        return validateResponse;
    }


    public GenerateResponse generateRRR(ValidateRequest validateRequest) {
        GenerateResponse generateResponse = new GenerateResponse();
        if (credentials.getEnvironment().equalsIgnoreCase("LIVE")) {
            try {
                HttpEntity requestEntity = new HttpEntity(gson.toJson(validateRequest), getHeaders(credentials.getPublicKey(), String.valueOf(randomNumber)));
                String url = String.format("%s%s",  ApplicationUrl.productionUrlBase, ApplicationUrl.generateUrl);
                String responsePayload = restTemplate.postForObject(url, requestEntity, String.class);
                generateResponse = gson.fromJson(responsePayload, GenerateResponse.class);
            } catch (RestClientException e) {
                e.printStackTrace();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        } else {
            try {
                HttpEntity requestEntity = new HttpEntity(gson.toJson(validateRequest), getHeaders(credentials.getPublicKey(), String.valueOf(randomNumber)));
                String url = String.format("%s%s", ApplicationUrl.demoUrlbase, ApplicationUrl.generateUrl);
                String responsePayload = restTemplate.postForObject(url, requestEntity, String.class);
                generateResponse = gson.fromJson(responsePayload, GenerateResponse.class);
            } catch (RestClientException e) {
                e.printStackTrace();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
        }
        return generateResponse;
    }


    public BillNotificationResponse billNotification(BillRequest billRequest) {
        BillNotificationResponse billNotificationResponse = new BillNotificationResponse();
        if (credentials.getEnvironment().equalsIgnoreCase("LIVE")) {
        try {
            HttpEntity requestEntity = new HttpEntity(gson.toJson(billRequest),
                    getHeaders(credentials.getPublicKey(), String.valueOf(randomNumber), billRequest.getHash(), billRequest.getTransactionId()));
            String url = String.format("%s%s",  ApplicationUrl.productionUrlBase, ApplicationUrl.notifyUrl);
            String responsePayload = restTemplate.postForObject(url, requestEntity, String.class);
            billNotificationResponse = gson.fromJson(responsePayload, BillNotificationResponse.class);
        } catch (RestClientException e) {
            e.printStackTrace();
        } catch (JsonSyntaxException e) {
            e.printStackTrace();
        }
        }else{
            try {
                HttpEntity requestEntity = new HttpEntity(gson.toJson(billRequest),
                        getHeaders(credentials.getPublicKey(), String.valueOf(randomNumber), billRequest.getHash(), billRequest.getTransactionId()));
                String url = String.format("%s%s", ApplicationUrl.demoUrlbase, ApplicationUrl.notifyUrl);
                String responsePayload = restTemplate.postForObject(url, requestEntity, String.class);
                billNotificationResponse = gson.fromJson(responsePayload, BillNotificationResponse.class);
            } catch (RestClientException e) {
                e.printStackTrace();
            } catch (JsonSyntaxException e) {
                e.printStackTrace();
            }
            
        }
        return billNotificationResponse;
    }


    public HttpHeaders getHeaders(String pubKey, String randNum) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("publicKey", pubKey);
        headers.add("requestId", randNum);
        return headers;
    }


    public HttpHeaders getHeaders(String pubKey, String randNum, String hash, String transactionId) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.add("publicKey", pubKey);
        headers.add("requestId", randNum);
        headers.add("TXN_HASH", hash);
        headers.add("transactionId", transactionId);
        return headers;
    }


    public String generateSHA512SecurePassword(String inputToHash) {
        String generatedPassword = null;
        try {
            MessageDigest md = MessageDigest.getInstance(ALGORITHM_SHA_512);
            md.update(inputToHash.getBytes(ENCODING_UTF_8));
            byte[] bytes = md.digest();
            StringBuilder sb = new StringBuilder();
            for (byte b : bytes) {
                sb.append(Integer.toString((b & 0xff) + 0x100, 16).substring(1));
            }
            generatedPassword = sb.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return generatedPassword;
    }
}
