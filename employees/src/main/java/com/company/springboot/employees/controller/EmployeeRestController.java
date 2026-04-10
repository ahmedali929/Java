package com.company.springboot.employees.controller;

import com.company.springboot.employees.entity.Employee;
import com.company.springboot.employees.request.EmployeeRequest;
import com.company.springboot.employees.service.EmployeeService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
@Tag(name="Employee REST API endpoints", description = "Operations related to employees")
public class EmployeeRestController {

    private EmployeeService employeeService;

    @Autowired
    public EmployeeRestController(EmployeeService theEmployeeService) {
        employeeService = theEmployeeService;
    }

    @Operation(summary = "Get all employees", description = "Retrieve a list of all employees")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping()
    public List<Employee> findAll() {return employeeService.findAll();}

    @Operation(summary = "Fetch single employee", description = "Get a single employee")
    @ResponseStatus(HttpStatus.OK)
    @GetMapping("/{employeeId}")
    public Employee getEmployee(@PathVariable @Min(value = 1) long employeeId) {
        return employeeService.findById(employeeId);
    }

    @Operation(summary = "Create a new employee", description = "Add a new employee")
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public Employee addEmployee(@Valid @RequestBody EmployeeRequest theEmployee) {
        return employeeService.save(theEmployee);
    }

    @Operation(summary = "Update an employee", description = "Update the details of current employee")
    @ResponseStatus(HttpStatus.OK)
    @PutMapping("/{employeeId}")
    public Employee updateEmployee(@PathVariable @Min(value = 1) long employeeId, @Valid @RequestBody EmployeeRequest employeeRequest) {
        return employeeService.update(employeeId, employeeRequest);
    }

    @Operation(summary = "Delete an employee", description = "delete an employee by id")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("/{employeeId}")
    public void deleteEmployee(@PathVariable @Min(value = 1) long employeeId) {
        employeeService.deleteById(employeeId);
    }

}
