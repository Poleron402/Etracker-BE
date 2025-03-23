package com.example.expensetracker.service;

import com.example.expensetracker.Type;
import com.example.expensetracker.entities.Expense;
import com.example.expensetracker.entities.User;
import com.example.expensetracker.repositories.ExpenseRepository;
import com.example.expensetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ExpenseService {
    private final ExpenseRepository expenseRepository;
    private final UserRepository userRepository;
    @Autowired
    public ExpenseService(ExpenseRepository expenseRepository, UserRepository userRepository) {
        this.expenseRepository = expenseRepository;
        this.userRepository = userRepository;
    }

    public Iterable<Expense> getMyExpenses(Integer userId) {
        User user = userRepository.findById(userId).orElseThrow("There is a problem on our end");
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
