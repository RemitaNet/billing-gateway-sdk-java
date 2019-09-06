package com.systemspecs.paymentinfra.response;

import java.io.Serializable;


public class GetBillerResponseData implements Serializable {

    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getDescription() {
        return description;
    }


    public void setDescription(String description) {
        this.description = description;
    }


    public String getLabel() {
        return label;
    }


    public void setLabel(String label) {
        this.label = label;
    }


    private String id;

    private String description;

    private String label;
}
