package com.company.springboot.employees.dao;

import com.company.springboot.employees.entity.Employee;

import java.util.List;

public interface EmployeeDAO {
    List<Employee> findAll();
}
