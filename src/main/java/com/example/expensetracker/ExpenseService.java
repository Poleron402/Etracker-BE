package com.example.expensetracker;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;

    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository) {
        this.expenseRepository = expenseRepository;
    }

    public List<Expense> getAllExpenses() {
        return expenseRepository.findAll();
    }

    public Optional<Expense> getExpenseById(Long id) {
        return expenseRepository.findById(id);
    }
    public Expense addExpense(Expense expense) {
        return expenseRepository.save(expense);
    }
    public void deleteExpenseByID(Long id) {
        if (expenseRepository.existsById(id)){
            expenseRepository.deleteById(id);
        }else{
            throw new RuntimeException("Expense with id " + id + " does not exist");
        }
    }
    public List<Type> getExpenseTypes() {
        return Arrays.asList(Type.values());
    }

}
