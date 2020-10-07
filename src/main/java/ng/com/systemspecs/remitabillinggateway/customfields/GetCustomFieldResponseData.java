package ng.com.systemspecs.remitabillinggateway.customfields;

import java.io.Serializable;
import java.util.List;

/**
 * @author Ilesanmi Omoniyi
 * @author Eunice Olukitibi
 *
 * @since 1.0.0
 */
public class GetCustomFieldResponseData implements Serializable {

    private String id;

    private String columnName;

    private String columnType;

    private List<GetCustomFieldResponseDropDown> customFieldDropDown = null;

    private String columnLength;

    private Boolean required;

    private int dataLoadRuleId;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getColumnName() {
        return columnName;
    }


    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }


    public String getColumnType() {
        return columnType;
    }


    public void setColumnType(String columnType) {
        this.columnType = columnType;
    }


    public List<GetCustomFieldResponseDropDown> getCustomFieldDropDown() {
        return customFieldDropDown;
    }


    public void setCustomFieldDropDown(List<GetCustomFieldResponseDropDown> customFieldDropDown) {
        this.customFieldDropDown = customFieldDropDown;
    }


    public String getColumnLength() {
        return columnLength;
    }


    public void setColumnLength(String columnLength) {
        this.columnLength = columnLength;
    }


    public Boolean getRequired() {
        return required;
    }


    public void setRequired(Boolean required) {
        this.required = required;
    }


    public int getDataLoadRuleId() {
        return dataLoadRuleId;
    }


    public void setDataLoadRuleId(int dataLoadRuleId) {
        this.dataLoadRuleId = dataLoadRuleId;
    }

    @Override
    public String toString() {
        return "GetCustomFieldResponseData{" +
                "id='" + id + '\'' +
                ", columnName='" + columnName + '\'' +
                ", columnType='" + columnType + '\'' +
                ", customFieldDropDown=" + customFieldDropDown +
                ", columnLength='" + columnLength + '\'' +
                ", required=" + required +
                ", dataLoadRuleId=" + dataLoadRuleId +
                '}';
    }
}
