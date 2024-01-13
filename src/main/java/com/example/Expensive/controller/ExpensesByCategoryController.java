package com.example.Expensive.controller;

import com.example.Expensive.entity.ExpenseByCategory;
import com.example.Expensive.service.ExpenseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ExpensesByCategoryController {

    private final ExpenseService expenseService;

    public ExpensesByCategoryController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping("expenses-by-categories")
    public List<ExpenseByCategory> getExpensesByCategories() {
        return expenseService.getExpensesByCategory();
    }

}
