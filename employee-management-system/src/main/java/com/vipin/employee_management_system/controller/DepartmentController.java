package com.vipin.employee_management_system.controller;

import com.vipin.employee_management_system.entity.Department;
import com.vipin.employee_management_system.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
    private final DepartmentService service;

    public DepartmentController(DepartmentService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Department> saveDepartment(@RequestBody Department department) {
        return ResponseEntity.status(201).body(service.saveDepartment(department));
    }

    @GetMapping
    public ResponseEntity<List<Department>> getDepartments() {
        return ResponseEntity.status(200).body(service.getAllDepartment());
    }

}
