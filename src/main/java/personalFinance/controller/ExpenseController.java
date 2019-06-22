package personalFinance.controller;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import personalFinance.model.Expense;
import personalFinance.repository.ExpenseRepository;
import personalFinance.utils.ExpenseDTO;

import java.util.List;

@RestController
@RequestMapping(value = "/expenses")
public class ExpenseController {
    private ExpenseRepository expenseRepository;
    private ModelMapper modelMapper = new ModelMapper();

    @Autowired
    public ExpenseController(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    @ResponseBody
    @GetMapping
    public List<Expense> getAllExpenses() {
        List<Expense> expenses = this.expenseRepository.findAll();
        return expenses;
    }

    @ResponseBody
    @GetMapping
    public Expense getExpenseByCategoryIdAndUserId(@RequestBody ExpenseDTO expenseDTO) {
        Long categoryId = expenseDTO.getCategoryId();
        Long userId = expenseDTO.getUserId();
        Expense expense = this.expenseRepository.findExpenseByCategoryIdAndAndUserId(categoryId, userId);
        return expense;
    }
}
