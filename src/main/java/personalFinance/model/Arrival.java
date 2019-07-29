package personalFinance.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "arrival")
public class Arrival extends MoneyFlow {

    @NotNull(message = "amount can't be empty")
    @Column(name = "amount")
    private BigDecimal amount;

    public Arrival() {
        super();
    }

    public Arrival(@NotNull(message = "user can't be empty") User user, @NotNull(message = "amount can't be empty") BigDecimal amount) {
        super(user);
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
