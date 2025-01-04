package com.airline.service;

import com.airline.dao.UserDAO;
import com.airline.model.User;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class UserServiceTest {

    @Mock
    private UserDAO userDAO;

    @InjectMocks
    private UserService userService;

    @Test
    void testValidateUser() {
        User mockUser = new User(1, "john_doe", "password123");
        when(userDAO.findByUsernameAndPassword("john_doe", "password123")).thenReturn(mockUser);

        User validatedUser = userService.validateUser("john_doe", "password123");

        assertNotNull(validatedUser);
        assertEquals("john_doe", validatedUser.getUsername());
    }

    @Test
    void testCreateUser() {
        User user = new User(0, "jane_doe", "password321");
        when(userDAO.save(user)).thenReturn(new User(2, "jane_doe", "password321"));

        User savedUser = userService.createUser(user);

        assertNotNull(savedUser);
        assertEquals("jane_doe", savedUser.getUsername());
    }
}

