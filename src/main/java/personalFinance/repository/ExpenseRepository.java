package personalFinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import personalFinance.model.Category;
import personalFinance.model.Expense;
import personalFinance.model.User;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {

    Expense findExpenseByCategoryAndUser(Category category, User userId);

    void deleteByCategoryIdAndUserId(Long categoryId, Long userId);
}
