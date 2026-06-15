package com.vipin.expense_tracker.dto;

public class MonthlyTrendDTO {

    private String month;

    private double amount;

    public MonthlyTrendDTO(

            String month,

            double amount

    ) {

        this.month = month;

        this.amount = amount;
    }

    public String getMonth() {
        return month;
    }

    public double getAmount() {
        return amount;
    }
}