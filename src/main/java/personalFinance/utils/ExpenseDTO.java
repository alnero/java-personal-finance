package personalFinance.utils;

import java.io.Serializable;
import java.math.BigDecimal;

public class ExpenseDTO implements Serializable {
    private long categoryId;
    private long userId;
    private BigDecimal amount;

    public long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(long categoryId) {
        this.categoryId = categoryId;
    }

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
