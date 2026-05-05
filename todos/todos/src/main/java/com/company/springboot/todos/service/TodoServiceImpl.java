package com.company.springboot.todos.service;

import com.company.springboot.todos.entity.Todo;
import com.company.springboot.todos.entity.User;
import com.company.springboot.todos.repository.TodoRepository;
import com.company.springboot.todos.request.TodoRequest;
import com.company.springboot.todos.response.TodoResponse;
import com.company.springboot.todos.util.FindAuthenticatedUser;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

        return convertToTodoResponse(savedTodo);
    }

    @Override
    @Transactional(readOnly = true)
    public List<TodoResponse> getAllTodos() {
        User currentUser = findAuthenticatedUser.getAuthenticatedUser();
        return todoRepository.findByOwner(currentUser)
                .stream()
                .map(this::convertToTodoResponse)
                .toList();
    }

    private TodoResponse convertToTodoResponse(Todo todo) {
        return new TodoResponse(
                todo.getId(), todo.getTitle(), todo.getDescription(), todo.getPriority(), todo.isComplete()
        );
    }
}
