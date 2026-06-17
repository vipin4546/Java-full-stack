package com.vipin.employee_management_system.service;

import com.vipin.employee_management_system.entity.Department;
import com.vipin.employee_management_system.repository.DepartmentRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {
    private final DepartmentRepository repository;

    public DepartmentService(DepartmentRepository repository) {
        this.repository = repository;

    }

    public Department saveDepartment(Department department) {
        return repository.save(department);

    }

    public List<Department> getAllDepartment() {
        return repository.findAll();
    }
}
