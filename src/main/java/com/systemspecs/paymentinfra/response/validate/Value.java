package com.systemspecs.paymentinfra.response.validate;

import java.io.Serializable;
import java.math.BigDecimal;

import com.fasterxml.jackson.annotation.JsonProperty;


public class Value implements Serializable {

    private String value;

    private BigDecimal amount;

    private Integer quantity;


    public String getValue() {
        return value;
    }


    public void setValue(String value) {
        this.value = value;
    }


    public BigDecimal getAmount() {
        return amount;
    }


    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public Integer getQuantity() {
        return quantity;
    }


    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }
}
