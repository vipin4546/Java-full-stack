package com.vipin.expense_tracker.repository;

import com.vipin.expense_tracker.entity.Expenses;
import com.vipin.expense_tracker.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ExpenseRepository
        extends JpaRepository<Expenses, Long> {

    List<Expenses> findByCategory(
            String category
    );

    List<Expenses> findByUser(
            User user
    );

    Optional<Expenses> findByIdAndUser(

            Long id,

            User user

    );

    List<Expenses> findByCategoryAndUser(

            String category,

            User user

    );
}