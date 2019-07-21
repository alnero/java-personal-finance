package personalFinance.utils;

import java.io.Serializable;
import java.math.BigDecimal;

public class ArrivalDTO implements Serializable {
    private long userId;
    private BigDecimal amount;

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
