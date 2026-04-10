package com.company.springboot.employees.service;

import com.company.springboot.employees.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(long theId);
    Employee save(Employee theEmployee);
    void deleteById(long theId);
}
