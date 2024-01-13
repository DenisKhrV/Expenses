package com.example.Expensive.repository;

import com.example.Expensive.entity.Expense;
import com.example.Expensive.entity.ExpenseByCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExpenseRepository extends JpaRepository<Expense, Integer> {
    @Query(value = "SELECT category, SUM(amount) as amount FROM expense GROUP BY category", nativeQuery = true)
    List<ExpenseByCategory> getExpensesByCategory();


}
