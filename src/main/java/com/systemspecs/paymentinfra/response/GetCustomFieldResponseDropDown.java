package com.systemspecs.paymentinfra.response;

import java.io.Serializable;



public class GetCustomFieldResponseDropDown implements Serializable {

    private String fixedprice;

    private String unitprice;

    private String code;

    private String accountid;

    private String description;

    private String id;


    public String getFixedprice() {
        return fixedprice;
    }


    public void setFixedprice(String fixedprice) {
        this.fixedprice = fixedprice;
    }


    public String getUnitprice() {
        return unitprice;
    }


    public void setUnitprice(String unitprice) {
        this.unitprice = unitprice;
    }


    public String getCode() {
        return code;
    }


    public void setCode(String code) {
        this.code = code;
    }


    public String getAccountid() {
        return accountid;
    }


    public void setAccountid(String accountid) {
        this.accountid = accountid;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }
}
