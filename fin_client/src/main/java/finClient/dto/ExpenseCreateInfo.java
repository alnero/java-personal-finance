package finClient.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class ExpenseCreateInfo implements Serializable {

    private Long categoryId;
    private Long userId;
    private BigDecimal amount;

    public ExpenseCreateInfo() {
    }

    public ExpenseCreateInfo(Long categoryId, BigDecimal amount, Long userId) {
        this.categoryId = categoryId;
        this.amount = amount;
        this.userId = userId;
    }

    public Long getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(Long categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}