package ng.com.systemspecs.remitabillinggateway.customfields;

import java.io.Serializable;

/**
 * @author Ilesanmi Omoniyi
 * @author Eunice Olukitibi
 *
 * @since 1.0.0
 */
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

    @Override
    public String toString() {
        return "GetCustomFieldResponseDropDown{" +
                "fixedprice='" + fixedprice + '\'' +
                ", unitprice='" + unitprice + '\'' +
                ", code='" + code + '\'' +
                ", accountid='" + accountid + '\'' +
                ", description='" + description + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
