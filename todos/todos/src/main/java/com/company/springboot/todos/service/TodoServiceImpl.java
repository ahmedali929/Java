package com.company.springboot.todos.service;

import com.company.springboot.todos.entity.Todo;
import com.company.springboot.todos.entity.User;
import com.company.springboot.todos.repository.TodoRepository;
import com.company.springboot.todos.request.TodoRequest;
import com.company.springboot.todos.response.TodoResponse;
import com.company.springboot.todos.util.FindAuthenticatedUser;
import org.springframework.transaction.annotation.Transactional;

public class TodoServiceImpl implements TodoService {

    private final TodoRepository todoRepository;
    private final FindAuthenticatedUser findAuthenticatedUser;

    public TodoServiceImpl(TodoRepository todoRepository, FindAuthenticatedUser findAuthenticatedUser) {
        this.todoRepository = todoRepository;
        this.findAuthenticatedUser = findAuthenticatedUser;
    }

    @Override
    @Transactional
    public TodoResponse createTodo(TodoRequest todoRequest) {
        User currentUser = findAuthenticatedUser.getAuthenticatedUser();

        Todo todo = new Todo(
                todoRequest.getTitle(),
                todoRequest.getDescription(),
                todoRequest.getPriority(),
                false,
                currentUser
        );

        Todo savedTodo = todoRepository.save(todo);

        TodoResponse todoResponse = new TodoResponse(
                savedTodo.getId(), savedTodo.getTitle(), savedTodo.getDescription(), , savedTodo.getPriority(), savedTodo.isComplete()
        );

        return todoResponse;
    }
}
