package com.airline.controller;

import com.airline.model.User;
import com.airline.service.UserService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class UserControllerTest {

    @Mock
    private UserService userService;

    @InjectMocks
    private UserController userController;

    private MockMvc mockMvc;

    // Setup MockMvc before each test
    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(userController).build();
    }

    // Test case for user login
    @Test
    void testUserLogin() throws Exception {
        // Mock user authentication
        User mockUser = new User(1, "john_doe", "password123");
        when(userService.validateUser("john_doe", "password123")).thenReturn(mockUser);

        // Perform POST request to login with username and password
        mockMvc.perform(post("/login")
                .param("username", "john_doe")
                .param("password", "password123"))
                .andExpect(status().is3xxRedirection())      // Should redirect on successful login
                .andExpect(redirectedUrl("/home"));           // Redirect to home page after login
    }

    // Test case for user registration
    @Test
    void testUserRegistration() throws Exception {
        // Mock the user creation response
        User newUser = new User(2, "jane_doe", "password321");
        when(userService.createUser(any(User.class))).thenReturn(newUser);

        // Perform POST request for user registration
        mockMvc.perform(post("/register")
                .param("username", "jane_doe")
                .param("password", "password321"))
                .andExpect(status().is3xxRedirection())      // Should redirect after registration
                .andExpect(redirectedUrl("/login"));          // Redirect to login page after registration
    }

    // Test case for displaying the login page
    @Test
    void testShowLoginPage() throws Exception {
        // Perform GET request to show login page
        mockMvc.perform(get("/login"))
                .andExpect(status().isOk())                 // Should return HTTP 200 OK
                .andExpect(view().name("loginPage"));        // The view name should be "loginPage"
    }

    // Test case for displaying the registration page
    @Test
    void testShowRegistrationPage() throws Exception {
        // Perform GET request to show registration page
        mockMvc.perform(get("/register"))
                .andExpect(status().isOk())                 // Should return HTTP 200 OK
                .andExpect(view().name("registerPage"));     // The view name should be "registerPage"
    }
}
