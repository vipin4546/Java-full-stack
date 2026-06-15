package com.vipin.expense_tracker.config;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SpaController {

    @RequestMapping(value = {
            "/",
            "/expenses",
            "/add-expense",
            "/edit-expense/**"
    })
    public String forward() {

        return "forward:/index.html";
    }
}