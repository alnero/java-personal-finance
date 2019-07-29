package personalFinance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "expense")
public class Expense extends MoneyFlow {

    @JsonIgnore
    @NotNull(message = "category can't be empty")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @NotNull(message = "amount can't be empty")
    @Column(name = "amount")
    private BigDecimal amount;

    public Expense() {
        super();
    }

    public Expense(@NotNull(message = "category can't be empty") Category category, @NotNull(message = "user can't be empty") User user, @NotNull(message = "amount can't be empty") BigDecimal amount) {
        super(user);
        this.category = category;
        this.amount = amount;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
