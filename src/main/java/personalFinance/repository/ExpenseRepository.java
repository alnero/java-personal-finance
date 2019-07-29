package personalFinance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import personalFinance.model.Category;
import personalFinance.model.Expense;
import personalFinance.model.User;

import java.util.List;

public interface ExpenseRepository extends JpaRepository<Expense, Long> {
    Expense findExpenseByCategoryAndUser(Category category, User user);

    void deleteByCategoryIdAndUserId(Long categoryId, Long userId);

    List<Expense> findAllByUserId(Long userId);
}
