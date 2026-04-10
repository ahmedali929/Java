package com.company.springboot.employees.service;

import com.company.springboot.employees.entity.Employee;
import com.company.springboot.employees.request.EmployeeRequest;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(long theId);
    Employee save(EmployeeRequest EmployeeRequest);
    Employee update(long id, EmployeeRequest employeeRequest);
    Employee convertToEmployee(long id, EmployeeRequest employeeRequest);
    void deleteById(long theId);
}
