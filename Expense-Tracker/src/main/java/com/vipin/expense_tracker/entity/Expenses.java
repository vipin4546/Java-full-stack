package com.vipin.expense_tracker.entity;

import jakarta.persistence.*;


import java.time.LocalDate;

@Entity
public class Expenses {
    @Id
    @GeneratedValue
    private Long id;
    private String title;
    private Double amount;
    private String category;

    private LocalDate expenseDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;


    public void setId(Long id) {
        this.id = id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setExpenseDate(LocalDate expenseDate) {
        this.expenseDate = expenseDate;
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public Double getAmount() {
        return amount;
    }

    public String getCategory() {
        return category;
    }

    public LocalDate getExpenseDate() {
        return expenseDate;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public User getUser() {
        return user;
    }
}
