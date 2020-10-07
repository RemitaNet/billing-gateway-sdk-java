package ng.com.systemspecs.remitabillinggateway.servicetypes;

import java.io.Serializable;

/**
 * @author Ilesanmi Omoniyi
 * @author Eunice Olukitibi
 *
 * @since 1.0.0
 */
public class GetServiceResponseData implements Serializable {

    private String id;
    private String name;


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "GetServiceResponseData{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                '}';
    }

}
