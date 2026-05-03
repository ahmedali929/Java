package com.company.springboot.todos.service;

import com.company.springboot.todos.entity.Authority;
import com.company.springboot.todos.entity.User;
import com.company.springboot.todos.repository.UserRepository;
import com.company.springboot.todos.response.UserResponse;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.AccessDeniedException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserInfo() throws AccessDeniedException {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
            throw new AccessDeniedException("Authentication Required");
        }


        User user = Authentication.getPrincipal();
        return new UserResponse(user.getId(), user.getFirstName() + " " + user.getLastName(), user.getEmail(), user.getAuthorities().stream().map(auth -> (Authority) auth).toList());
    }

    @Override
    public void deleteUser() throws AccessDeniedException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication == null || !authentication.isAuthenticated() || authentication.getPrincipal().equals("anonymousUser")) {
            throw new AccessDeniedException("Authentication Required");
        }

        User user = Authentication.getPrincipal();

        if (isLastAdmin(user)) {
            throw new ResponseStatusException(HttpStatus.FORBIDDEN, "Admin can't delete itself");
        }

        userRepository.delete(user);
    }

    private boolean isLastAdmin(User user) {
        boolean isAdmin = user.getAuthorities().stream()
                .anyMatch(authority -> "ROLE_ADMIN".equals(authority.getAuthority()));

        if (isAdmin) {
            long adminCount = userRepository.countAdminUsers();
            return adminCount <= 1;
        }

        return false;
    }
}
