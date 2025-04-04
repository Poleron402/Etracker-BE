package com.example.expensetracker.controllers;


import com.example.expensetracker.Type;
import com.example.expensetracker.entities.Expense;
import com.example.expensetracker.entities.User;
import com.example.expensetracker.repositories.UserRepository;
import com.example.expensetracker.service.ExpenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/expenses")
@CrossOrigin(origins = "http://localhost:5173")
public class ExpenseController {
    @Autowired
    private ExpenseService expense;
    @Autowired
    private UserRepository uRepo;
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/")
    public Iterable<Expense> getExpenses(
            Principal principal
    ) {
        String email = principal.getName();
        return expense.getMyExpenses(email);
    }

    @PutMapping("/{id}")
    public Expense updateExpense(
            @RequestBody Expense updateExpense, @PathVariable int id
    ){
        return expense.updateExpense(updateExpense);
    }

    @PostMapping("/")
    public Expense addExpense(@RequestBody Expense newExpense, Principal principal) {

        User user = userRepository.findByEmail(principal.getName()).orElseThrow(() -> new RuntimeException("User not found"));
        System.out.println(user.getEmail());
        newExpense.setUser(user);
        System.out.println(newExpense);
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
