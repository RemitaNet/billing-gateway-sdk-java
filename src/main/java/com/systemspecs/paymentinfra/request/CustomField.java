package com.systemspecs.paymentinfra.request;

import java.io.Serializable;
import java.util.List;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


public class CustomField implements Serializable {

    private String id;

    private List<Value> values = null;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public List<Value> getValues() {
        return values;
    }


    public void setValues(List<Value> values) {
        this.values = values;
    }
}
