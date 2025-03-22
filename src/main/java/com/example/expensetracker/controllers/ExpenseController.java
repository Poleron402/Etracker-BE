package com.example.expensetracker.controllers;


import com.example.expensetracker.Type;
import com.example.expensetracker.entities.Expense;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/expenses")
public class ExpenseController {
    @Autowired
    private ExpenseService expense;

    @GetMapping("/")
    public Iterable<Expense> getExpenses() {
        return expense.getAllExpenses();
    }

    @GetMapping("/{id}")
    public Expense getExpenseById(@PathVariable long id) {
        return expense.getExpenseById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Expense not found"));
    }
    @PostMapping("/")
    public Expense addExpense(@RequestBody Expense newExpense) {
        return expense.addExpense(newExpense);
    }
    @DeleteMapping("/{id}")
    public void deleteExpense(@PathVariable long id) {
        expense.deleteExpenseByID(id);
    }

    @GetMapping("/types")
    public List<Type> getTypes(){
        return expense.getExpenseTypes();
    }

}
