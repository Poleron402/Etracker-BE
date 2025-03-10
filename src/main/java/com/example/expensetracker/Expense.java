package com.example.expensetracker;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.Date;

@Entity
class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float expense;
    private Type type;
    private LocalDateTime date = LocalDateTime.now();
    private String note;
    public Expense(float expense, Type type, LocalDateTime date, String note) {
        this.expense = expense;
        this.type = type;
        this.date = date;
        this.note = note;
    }
    public Expense(float expense, Type type, String note) {
        this.expense = expense;
        this.type = type;
        this.note = note;
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

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
