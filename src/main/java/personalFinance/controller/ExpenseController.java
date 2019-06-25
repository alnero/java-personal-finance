package personalFinance.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personalFinance.model.Category;
import personalFinance.model.Expense;
import personalFinance.model.User;
import personalFinance.repository.CategoryRepository;
import personalFinance.repository.ExpenseRepository;
import personalFinance.repository.UserRepository;
import personalFinance.utils.ExpenseDTO;

import java.math.BigDecimal;
import java.util.List;

@RestController
@RequestMapping(value = "/expenses")
public class ExpenseController {
    private CategoryRepository categoryRepository;
    private UserRepository userRepository;
    private ExpenseRepository expenseRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ExpenseController(CategoryRepository categoryRepository, UserRepository userRepository, ExpenseRepository expenseRepository) {
        this.categoryRepository = categoryRepository;
        this.userRepository = userRepository;
        this.expenseRepository = expenseRepository;
    }

    @ResponseBody
    @GetMapping
    public List<Expense> getAllExpenses() {
        List<Expense> expenses = this.expenseRepository.findAll();
        return expenses;
    }

//    Можно урлы разделать через request mapping
//    https://www.baeldung.com/spring-requestmapping
//    Но для REST https://blog.tratif.com/2017/11/23/effective-restful-search-api-in-spring/
//    @ResponseBody
//    @GetMapping
//    public Expense getExpenseByCategoryIdAndUserId(@RequestBody ExpenseDTO expenseDTO) {
//        Category category = this.categoryRepository.findCategoriesById(expenseDTO.getCategoryId());
//        User user = this.userRepository.findUserById(expenseDTO.getUserId());
//        Expense expense = this.expenseRepository.findExpenseByCategoryAndUser(category, user);
//        return expense;
//    }

    @ResponseBody
    @PutMapping
    public Expense updateExpenseByCategoryIdAndUserId(@RequestBody ExpenseDTO expenseDTO) {
        Category category = this.categoryRepository.findCategoriesById(expenseDTO.getCategoryId());
        User user = this.userRepository.findUserById(expenseDTO.getUserId());
        Expense expense = this.expenseRepository.findExpenseByCategoryAndUser(category, user);
        this.modelMapper.map(expenseDTO, expense);
        return expense;
    }

    @ResponseBody
    @DeleteMapping
    public void deleteExpenseByCategoryIdAndUserId(@RequestBody ExpenseDTO expenseDTO) {
        Long categoryId = expenseDTO.getCategoryId();
        Long userId = expenseDTO.getUserId();
        this.expenseRepository.deleteByCategoryIdAndUserId(categoryId, userId);
    }

    @ResponseBody
    @PostMapping
    public Expense createExpense(@RequestBody ExpenseDTO expenseDTO) {
        Category category = this.categoryRepository.findCategoriesById(expenseDTO.getCategoryId());
        User user = this.userRepository.findUserById(expenseDTO.getUserId());
        BigDecimal amount = expenseDTO.getAmount();
        Expense expense = new Expense(category, user, amount);
        expense = this.expenseRepository.save(expense);
        return expense;
    }
}
