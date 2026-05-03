package com.company.springboot.todos.service;

import com.company.springboot.todos.entity.Authority;
import com.company.springboot.todos.entity.User;
import com.company.springboot.todos.repository.UserRepository;
import com.company.springboot.todos.response.UserResponse;
import com.company.springboot.todos.util.FindAuthenticatedUser;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.nio.file.AccessDeniedException;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final FindAuthenticatedUser findAuthenticatedUser;

    public UserServiceImpl(UserRepository userRepository, FindAuthenticatedUser findAuthenticatedUser) {
        this.userRepository = userRepository;
        this.findAuthenticatedUser = findAuthenticatedUser;
    }

    @Override
    @Transactional(readOnly = true)
    public UserResponse getUserInfo() throws AccessDeniedException {
        User user = findAuthenticatedUser.getAuthenticatedUser();
        return new UserResponse(user.getId(), user.getFirstName() + " " + user.getLastName(), user.getEmail(), user.getAuthorities().stream().map(auth -> (Authority) auth).toList());
    }

    @Override
    public void deleteUser() throws AccessDeniedException {
        User user = findAuthenticatedUser.getAuthenticatedUser();

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
