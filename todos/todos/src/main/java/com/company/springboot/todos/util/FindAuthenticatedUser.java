package com.company.springboot.todos.util;

import com.company.springboot.todos.entity.User;

import java.nio.file.AccessDeniedException;

public interface FindAuthenticatedUser {

    User getAuthenticatedUser() throws AccessDeniedException;

}
