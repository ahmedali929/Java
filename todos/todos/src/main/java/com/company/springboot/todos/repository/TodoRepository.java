package com.company.springboot.todos.repository;

import com.company.springboot.todos.entity.Todo;
import com.company.springboot.todos.entity.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TodoRepository extends CrudRepository<Todo, Long> {
    List<Todo> findByOwner(User owner);
}
