package com.company.springboot.todos.service;

import com.company.springboot.todos.response.UserResponse;

import java.nio.file.AccessDeniedException;

public interface UserService{

    UserResponse getUserInfo() throws AccessDeniedException;

}
