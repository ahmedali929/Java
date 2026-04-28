package com.company.springboot.todos.service;

import com.company.springboot.todos.request.RegisterRequest;

public interface AuthenticationService {
    void register(RegisterRequest input) throws Exception;
}
