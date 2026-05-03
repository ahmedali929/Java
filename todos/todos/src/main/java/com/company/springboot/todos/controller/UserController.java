package com.company.springboot.todos.controller;

import com.company.springboot.todos.request.PasswordUpdateRequest;
import com.company.springboot.todos.response.UserResponse;
import com.company.springboot.todos.service.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

import java.nio.file.AccessDeniedException;

@Tag(name="User REST API endpoints", description = "Operations related to info about current user")
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/info")
    public UserResponse getUserInfo() throws AccessDeniedException {
        return userService.getUserInfo();
    }

    @DeleteMapping
    public void deleteUser() throws AccessDeniedException {
        userService.deleteUser();
    }

    @PutMapping("/password")
    public void passwordUpdate(@Valid @RequestBody PasswordUpdateRequest passwordUpdateRequest) throws Exception{
        userService.updatePassword(passwordUpdateRequest);
    }
}
