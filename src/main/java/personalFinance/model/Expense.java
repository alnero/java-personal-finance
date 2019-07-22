package personalFinance.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;

@Entity
@Table(name = "expense")
public class Expense {
    @Id
    @SequenceGenerator(name = "expense_seq", sequenceName = "expense_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expense_seq")
    private long id;

    @JsonIgnore
    @NotNull(message = "category can't be empty")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private Category category;

    @JsonIgnore
    //  @NotNull(message = "user can't be empty")
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;

    @NotNull(message = "amount can't be empty")
    @Column(name = "amount")
    private BigDecimal amount;

    public Expense() {
    }

    public Expense(@NotNull(message = "category can't be empty") Category category, @NotNull(message = "user can't be empty") User user, @NotNull(message = "amount can't be empty") BigDecimal amount) {
        this.category = category;
        this.user = user;
        this.amount = amount;
    }

    public long getId() {
        return id;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public User getUser() {
        return this.user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }
}
