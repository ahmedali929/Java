package com.company.springboot.todos.service;

import com.company.springboot.todos.request.AuthenticationRequest;
import com.company.springboot.todos.request.RegisterRequest;
import com.company.springboot.todos.response.AuthenticationResponse;

public interface AuthenticationService {
    void register(RegisterRequest input) throws Exception;
    AuthenticationResponse login(AuthenticationRequest request);
}
