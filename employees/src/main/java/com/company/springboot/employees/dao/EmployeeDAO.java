package com.company.springboot.employees.dao;

import com.company.springboot.employees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
    Employee findById(long theId);
    Employee save(Employee theEmployee);
    void deleteById(long theId);
}
