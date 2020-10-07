package ng.com.systemspecs.remitabillinggateway.validate;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Ilesanmi Omoniyi
 * @author Eunice Olukitibi
 *
 * @since 1.0.0
 */
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

    @Override
    public String toString() {
        return "Value{" +
                "value='" + value + '\'' +
                ", amount=" + amount +
                ", quantity=" + quantity +
                '}';
    }
}
