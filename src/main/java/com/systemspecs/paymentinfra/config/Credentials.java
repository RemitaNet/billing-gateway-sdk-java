package com.systemspecs.paymentinfra.config;

import java.io.Serializable;

import org.apache.tomcat.util.buf.StringUtils;


public class Credentials implements Serializable{

    
    public String getPublicKey() {
        return publicKey;
    }
    
    public String getSecretKey() {
        return secretKey;
    }
    
    public String getEnvironment() {
        return environment;
    }
    
    
    public void setPublicKey(String publicKey) {
        this.publicKey = publicKey;
    }
    
    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
    
    public void setEnvironment(String environment) {
        this.environment = environment;
    }
    
    private String publicKey;
    private String secretKey;
    private String environment = "DEMO";
   

  
}
