package com.example.Expensive.controller;

import com.example.Expensive.entity.Expense;
import com.example.Expensive.service.ExpenseService;
import jdk.jshell.PersistentSnippet;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/expenses")
public class ExpensesController {

    private final ExpenseService expenseService;

    public ExpensesController(ExpenseService expenseService) {
        this.expenseService = expenseService;
    }

    @GetMapping
    public ResponseEntity<List<Expense>> getAllExpenses(@RequestParam("page") Integer pageNumber, @RequestParam("size") Integer pageSize ) {
        List<Expense> expenses = expenseService.getAllExpenses(pageNumber, pageSize);
        return ResponseEntity.ok(expenses);
    }

    @PostMapping
    public ResponseEntity<Void> createExpense(@RequestBody Expense expense) {
        expenseService.createExpense(expense);
        return ResponseEntity.ok(null);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteExpenseById(@PathVariable("id") Integer id) {
        expenseService.deleteExpense(id);
        return ResponseEntity.ok(null);
    }

}
