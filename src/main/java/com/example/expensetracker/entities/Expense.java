package com.example.expensetracker.entities;


import com.example.expensetracker.Type;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class Expense {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private float expense;
    private Type type;
    private LocalDateTime date = LocalDateTime.now();
    private String note;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name="userId")
    private User user;


    public Expense(float expense, Type type, String note, LocalDateTime date, User user) {
        this.expense = expense;
        this.type = type;
        this.note = note;
        this.date = date;
        this.user = user;
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
    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
}
