package com.airline.dao;

import com.airline.model.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class UserDAOTest {

    @Autowired
    private UserDAO userDAO;

    @Test
    void testSaveUser() {
        User user = new User(1, "john_doe", "password123");
        userDAO.save(user);

        assertNotNull(userDAO.findById(1).orElse(null));
    }

    @Test
    void testFindUserByUsername() {
        User user = new User(1, "john_doe", "password123");
        userDAO.save(user);

        User foundUser = userDAO.findByUsername("john_doe").orElse(null);
        assertNotNull(foundUser);
        assertEquals("john_doe", foundUser.getUsername());
    }
}

