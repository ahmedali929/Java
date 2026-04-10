package com.company.springboot.employees.service;

import com.company.springboot.employees.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
}
