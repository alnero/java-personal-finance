package personalFinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import personalFinance.model.Expense;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    Expense findExpenseByCategoryIdAndAndUserId(Long categoryId, Long userId);
}
