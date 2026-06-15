package com.vipin.expense_tracker.dto;

public class CategoryBreakdownDTO {

    private String category;

    private double amount;

    public CategoryBreakdownDTO(

            String category,

            double amount

    ) {

        this.category = category;

        this.amount = amount;
    }

    public String getCategory() {
        return category;
    }

    public double getAmount() {
        return amount;
    }
}