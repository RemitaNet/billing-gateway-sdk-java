package com.systemspecs.paymentinfra.constant;


public class ApplicationUrl {
    
    //  private String pubKey = "MDcwfDQwODE2OTg2fDI3MzY4NTc5MThkY2E0MDY5ZWFlN2JlOWRiNmUzNzMzMjc5NDdjYmMyZTM1NjAwM2I1N2NjMDgzMTdlYjIxMWMyNDgxYTc0Zjk4MGI4NzdhMDUwMzA1ZjgzNDlmNzU5NTRlZTVmOThiYjFmMTM4MTZjZjI2NWRhZDdmNjBjOTMz";
    public static String getBillersUrl = "/billers";
    public static String demoUrlbase = "https://remitademo.net/remita/exapp/api/v1/send/api/bgatesvc/billing/";
    public static String  productionUrlBase = "https://login.remita.net/remita/exapp/api/v1/send/api/bgatesvc/billing/";
    public static String  getServiceUrl = "/servicetypes";
    public static String  getCustomFieldUrl = "/servicetypes/";
    public static String  getRRRDetailsUrl = "/lookup/";
    public static String  getTransactionStatusUrl = "/payment/status/";
    public static String  validateRequestUrl = "validate";
    public static String  generateUrl = "generate";
    public static String  notifyUrl = "payment/notify";
}
