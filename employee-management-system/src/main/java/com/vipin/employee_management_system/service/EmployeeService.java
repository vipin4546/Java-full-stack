package com.vipin.employee_management_system.service;

import com.vipin.employee_management_system.entity.Department;
import com.vipin.employee_management_system.entity.Employee;
import com.vipin.employee_management_system.repository.DepartmentRepository;
import com.vipin.employee_management_system.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {
    private final EmployeeRepository repository;
    private final DepartmentRepository drepository;

    public EmployeeService(EmployeeRepository repository, DepartmentRepository drepository) {
        this.drepository = drepository;
        this.repository = repository;

    }

    public Employee saveEmployees(Employee employee) {
        return repository.save(employee);
    }

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public Employee assignDepartment(Long employeeId, Long departmentId) {
        Employee employee = repository.findById(employeeId).get();
        Department department = drepository.findById(departmentId).get();
        employee.setDepartment(department);
        return repository.save(employee);
    }
}
