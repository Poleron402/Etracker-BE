package com.example.expensetracker.service;

import com.example.expensetracker.Type;
import com.example.expensetracker.entities.Expense;
import com.example.expensetracker.entities.User;
import com.example.expensetracker.repositories.ExpenseRepository;
import com.example.expensetracker.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public Iterable<Expense> getMyExpenses(String userName) {
        User user = userRepository.findByEmail(userName).orElseThrow(()-> new ResponseStatusException(HttpStatus.BAD_REQUEST, "User cannot be found"));
        return expenseRepository.findByUser(user);
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
