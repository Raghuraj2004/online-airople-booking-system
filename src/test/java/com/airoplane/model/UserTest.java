package com.airline.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class UserTest {

    @Test
    void testUserEntity() {
        User user = new User(1, "john_doe", "password123");

        assertEquals(1, user.getUserId());
        assertEquals("john_doe", user.getUsername());
        assertEquals("password123", user.getPassword());
    }
}

