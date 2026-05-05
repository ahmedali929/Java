package com.company.springboot.todos.service;

import com.company.springboot.todos.request.TodoRequest;
import com.company.springboot.todos.response.TodoResponse;

public interface TodoService {
    TodoResponse createTodo(TodoRequest todoRequest);
}
