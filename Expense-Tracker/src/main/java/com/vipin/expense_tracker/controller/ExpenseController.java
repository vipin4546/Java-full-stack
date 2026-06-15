package com.vipin.expense_tracker.controller;

import com.vipin.expense_tracker.entity.Expenses;
import com.vipin.expense_tracker.entity.User;

import com.vipin.expense_tracker.service.ExpenseService;
import com.vipin.expense_tracker.service.UserService;

import org.springframework.http.ResponseEntity;

import org.springframework.security.core.Authentication;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController

@RequestMapping("/expenses")

public class ExpenseController {

    private final ExpenseService service;

    private final UserService userService;

    public ExpenseController(

            ExpenseService service,

            UserService userService

    ) {

        this.service = service;

        this.userService = userService;
    }

    @PostMapping

    public ResponseEntity<Expenses> createExpense(

            @RequestBody Expenses expense,

            Authentication authentication

    ) {

        User user =

                userService.getCurrentUser(
                        authentication
                );

        expense.setUser(
                user
        );

        return ResponseEntity

                .status(201)

                .body(

                        service.saveExpense(
                                expense
                        )

                );
    }

    @GetMapping

    public ResponseEntity<List<Expenses>> getExpenses(

            Authentication authentication

    ) {

        User user =

                userService.getCurrentUser(
                        authentication
                );

        return ResponseEntity.ok(

                service.getAllExpense(
                        user
                )

        );
    }

    @GetMapping("/{id}")

    public ResponseEntity<Expenses> getExpenseById(

            @PathVariable Long id,

            Authentication authentication

    ) {

        User user =

                userService.getCurrentUser(
                        authentication
                );

        return ResponseEntity.ok(

                service.getExpensesById(
                        id,

                        user
                )

        );
    }

    @PutMapping("/{id}")

    public ResponseEntity<Expenses> updateExpense(

            @PathVariable Long id,

            @RequestBody Expenses expense,

            Authentication authentication

    ) {

        User user =

                userService.getCurrentUser(
                        authentication
                );

        return ResponseEntity.ok(

                service.updateExpense(

                        id,

                        expense,

                        user

                )

        );
    }

    @DeleteMapping("/{id}")

    public ResponseEntity<String> deleteExpense(

            @PathVariable Long id,

            Authentication authentication

    ) {

        User user =

                userService.getCurrentUser(
                        authentication
                );

        service.deleteExpense(

                id,

                user

        );

        return ResponseEntity.ok(
                "Expense deleted successfully"
        );
    }

    @GetMapping("/category/{category}")

    public ResponseEntity<List<Expenses>> getByCategory(

            @PathVariable String category,

            Authentication authentication

    ) {

        User user =

                userService.getCurrentUser(
                        authentication
                );

        return ResponseEntity.ok(

                service.getExpensesByCategory(

                        category,

                        user

                )

        );
    }
}