package com.company.springboot.cruddemo.dao;

import com.company.springboot.cruddemo.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    List<Employee> findAll();

}
