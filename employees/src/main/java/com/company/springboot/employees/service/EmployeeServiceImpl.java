package com.company.springboot.employees.service;

import com.company.springboot.employees.dao.EmployeeDAO;
import com.company.springboot.employees.entity.Employee;
import com.company.springboot.employees.request.EmployeeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private EmployeeDAO employeeDAO;

    @Autowired
    public EmployeeServiceImpl(EmployeeDAO theEmployeeDAO) {
        employeeDAO = theEmployeeDAO;
    }

    @Override
    public List<Employee> findAll() {
        return employeeDAO.findAll();
    }

    @Override
    public Employee findById(long theId) {
        return employeeDAO.findById(theId);
    }

    @Override
    public Employee save(EmployeeRequest EmployeeRequest) {
        return null;
    }

    @Override
    public Employee update(long id, EmployeeRequest employeeRequest) {
        return null;
    }

    @Override
    public Employee convertToEmployee(long id, EmployeeRequest employeeRequest) {
        return null;
    }

    @Override
    public Employee save(EmployeeRequest EmployeeRequest) {
        return null;
    }

    @Override
    public void deleteById(long theId) {
        employeeDAO.deleteById(theId);
    }
}
