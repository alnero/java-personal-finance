package personalFinance.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "expenses")
public class Expense {
    @Id
    @SequenceGenerator(name = "expenses_seq", sequenceName = "expenses_seq", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "expenses_seq")
    private long expenseId;

    @NotNull(message = "category of expense can't be empty")
    @Column(name = "category")
    private long expenseCategory;

    @NotNull(message = "user of expense can't be empty")
    @Column(name = "user_id")
    private long userId;

    public Expense(@NotNull(message = "category of expense can't be empty") long expenseCategory, @NotNull(message = "user of expense can't be empty") long userId) {
        this.expenseCategory = expenseCategory;
        this.userId = userId;
    }

    public long getExpenseId() {
        return expenseId;
    }

    public long getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(long expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }
}
