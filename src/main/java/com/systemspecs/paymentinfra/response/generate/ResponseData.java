package com.systemspecs.paymentinfra.response.generate;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;


public class ResponseData implements Serializable{

    private String amountDue;

    private String rrr;


    public String getAmountDue() {
        return amountDue;
    }


    public void setAmountDue(String amountDue) {
        this.amountDue = amountDue;
    }


    public String getRrr() {
        return rrr;
    }


    public void setRrr(String rrr) {
        this.rrr = rrr;
    }
}
