package com.vipin.employee_management_system.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
public class Department {
    private String name;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "department", fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Employee> employees;

    public List<Employee> getEmployees() {

        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
