package com.company.hibernate.demo.entity;

import javax.persistence.Entity;

@Entity
public class Instructor extends User {

    private double Salary;

    public Instructor(String firstName, String lastName, String email, double Salary) {
        super(firstName, lastName, email);
        this.Salary = Salary;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }
}
