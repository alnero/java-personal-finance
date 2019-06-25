package personalFinance.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @SequenceGenerator(name = "expenses_seq", sequenceName = "expenses_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_seq")
    @ManyToOne
    @JoinColumns({
            @JoinColumn(name="user_id"),
            @JoinColumn(name="category_id")
    })
    private long expenseId;

    @NotNull(message = "category id of expense can't be empty")
    @Column(name = "category_id")
    private long categoryId;

    @NotNull(message = "user id of expense can't be empty")
    @Column(name = "user_id")
    private long userId;

    @Column(name = "amount")
    private long amount;

    public Expense() {}

    public Expense(@NotNull(message = "category id of expense can't be empty") long expenseCategoryId,
                   @NotNull(message = "user of expense can't be empty") long expenseUserId,
                   long amount) {
        this.categoryId = expenseCategoryId;
        this.userId = expenseUserId;
        this.amount = amount;
    }

    public long getExpenseId() {
        return expenseId;
    }

    public long getExpenseCategory() {
        return categoryId;
    }

    public void setExpenseCategory(long expenseCategory) {
        this.categoryId = expenseCategory;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }
}
