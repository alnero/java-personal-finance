package personalFinance.massageQueue;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import personalFinance.model.Category;
import personalFinance.model.Expense;
import personalFinance.model.User;
import personalFinance.repository.CategoryRepository;
import personalFinance.repository.ExpenseRepository;
import personalFinance.repository.UserRepository;
import personalFinance.utils.ExpenseDTO;

import java.io.IOException;

@Component
public class ExpenseReceiver {

    private final ExpenseRepository expenseRepository;
    private final CategoryRepository categoryRepository;
    private final UserRepository usersRepository;

    @Autowired
    public ExpenseReceiver(ExpenseRepository expenseRepository, CategoryRepository categoryRepository, UserRepository usersRepository) {
        this.expenseRepository = expenseRepository;
        this.categoryRepository = categoryRepository;
        this.usersRepository = usersRepository;
    }

    public void receiveMessage(String message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        ExpenseDTO expenseCreateInfo = mapper.readValue(message, ExpenseDTO.class);
        Category category = this.categoryRepository.findCategoriesById(expenseCreateInfo.getCategoryId());
        User user = this.usersRepository.findUserById(expenseCreateInfo.getUserId());
        Expense expense = new Expense(category, user, expenseCreateInfo.getAmount());
        this.expenseRepository.save(expense);
    }
}