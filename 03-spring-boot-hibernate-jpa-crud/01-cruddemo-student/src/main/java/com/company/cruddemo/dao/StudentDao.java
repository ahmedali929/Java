package com.company.cruddemo.dao;

import com.company.cruddemo.entity.Student;

import java.util.List;

public interface StudentDao {

    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);

    void delete(Integer id);

    int deleteAll();

}
