package com.vipin.expense_tracker.service;

import com.vipin.expense_tracker.entity.Expenses;
import com.vipin.expense_tracker.entity.User;
import com.vipin.expense_tracker.repository.ExpenseRepository;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExpenseService {

    private final ExpenseRepository repository;

    public ExpenseService(
            ExpenseRepository repository
    ) {

        this.repository = repository;
    }

    public Expenses saveExpense(
            Expenses expense
    ) {

        return repository.save(
                expense
        );
    }

    public List<Expenses> getAllExpense(
            User user
    ) {

        return repository.findByUser(
                user
        );
    }

    public Expenses getExpensesById(

            Long id,

            User user

    ) {

        return repository

                .findByIdAndUser(
                        id,
                        user
                )

                .orElseThrow(

                        () -> new RuntimeException(
                                "Expense not found"
                        )

                );
    }

    public Expenses updateExpense(

            Long id,

            Expenses updatedExpense,

            User user

    ) {

        Expenses expense =

                getExpensesById(
                        id,

                        user
                );

        expense.setTitle(
                updatedExpense.getTitle()
        );

        expense.setAmount(
                updatedExpense.getAmount()
        );

        expense.setCategory(
                updatedExpense.getCategory()
        );

        expense.setExpenseDate(
                updatedExpense.getExpenseDate()
        );

        return repository.save(
                expense
        );
    }

    public void deleteExpense(

            Long id,

            User user

    ) {

        Expenses expense =

                getExpensesById(
                        id,

                        user
                );

        repository.delete(
                expense
        );
    }

    public List<Expenses> getExpensesByCategory(

            String category,

            User user

    ) {

        return repository.findByCategoryAndUser(

                category,

                user

        );
    }
}