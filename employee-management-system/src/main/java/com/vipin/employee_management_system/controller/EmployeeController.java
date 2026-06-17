package com.vipin.employee_management_system.controller;

import com.vipin.employee_management_system.entity.Employee;
import com.vipin.employee_management_system.service.EmployeeService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/employees")
public class EmployeeController {
    private final EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Employee> saveEmployees(@RequestBody Employee employee) {
        return ResponseEntity.status(201).body(service.saveEmployees(employee));
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee() {
        return ResponseEntity.status(200).body(service.getAllEmployees());
    }

    @PutMapping("/{employeeId}/department/{departmentId}")
    public ResponseEntity<Employee> setDepartment(@PathVariable Long employeeId, @PathVariable Long departmentId) {
        return ResponseEntity.status(200).body(service.assignDepartment(employeeId, departmentId));
    }
}
