package com.company.springboot.todos.service;

import com.company.springboot.todos.request.TodoRequest;
import com.company.springboot.todos.response.TodoResponse;

import java.util.List;

public interface TodoService {
    TodoResponse createTodo(TodoRequest todoRequest);
    List<TodoResponse> getAllTodos();
}
