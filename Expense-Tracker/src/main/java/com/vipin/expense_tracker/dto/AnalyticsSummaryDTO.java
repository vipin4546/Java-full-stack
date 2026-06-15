package com.vipin.expense_tracker.dto;

public class AnalyticsSummaryDTO {

    private long totalExpenses;

    private double totalAmount;

    private String topCategory;

    public AnalyticsSummaryDTO(
            long totalExpenses,

            double totalAmount,

            String topCategory
    ) {

        this.totalExpenses = totalExpenses;

        this.totalAmount = totalAmount;

        this.topCategory = topCategory;
    }

    public long getTotalExpenses() {
        return totalExpenses;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getTopCategory() {
        return topCategory;
    }
}