package com.example.expensetracker;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.stereotype.Service;

@Entity
class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float expense;
    private Type type;
    public Expense(float expense, Type type) {
        this.expense = expense;
        this.type = type;
    }
    public Expense() {}

    @Override
    public String toString() {
        return "Expense{" +
                "expense=" + expense +
                ", type=" + type +
                '}';
    }
    public long getId() {
        return id;
    }
    public float getExpense() {
        return expense;
    }

    public void setExpense(float expense) {
        this.expense = expense;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
}
