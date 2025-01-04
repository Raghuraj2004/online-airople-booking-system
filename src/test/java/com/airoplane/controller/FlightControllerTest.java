package com.airline.controller;

import com.airline.model.Flight;
import com.airline.service.FlightService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import java.util.List;

class FlightControllerTest {

    @Mock
    private FlightService flightService;

    @InjectMocks
    private FlightController flightController;

    private MockMvc mockMvc;

    // Setup the MockMvc instance before each test
    @BeforeEach
    void setup() {
        mockMvc = MockMvcBuilders.standaloneSetup(flightController).build();
    }

    // Test case for getting a list of flights
    @Test
    void testGetFlightList() throws Exception {
        // Mock the service layer to return a list of flights
        Flight flight = new Flight(1, "Flight 101", "New York", "London");
        when(flightService.getAllFlights()).thenReturn(List.of(flight));

        // Perform the GET request and verify the response
        mockMvc.perform(get("/flights"))
                .andExpect(status().isOk())                    // HTTP status should be OK
                .andExpect(view().name("flightList"))          // The view name should be "flightList"
                .andExpect(model().attributeExists("flights")) // The model should contain a "flights" attribute
                .andExpect(model().attribute("flights", List.of(flight))); // Verify the flights attribute value
    }

    // Test case for booking a flight
    @Test
    void testBookFlight() throws Exception {
        // Mock flight data
        Flight flight = new Flight(1, "Flight 101", "New York", "London");
        
        // Assume booking a flight will return a flight object with updated details
        when(flightService.bookFlight(1)).thenReturn(flight);

        // Perform the POST request to book a flight
        mockMvc.perform(post("/book/{id}", 1))
                .andExpect(status().is3xxRedirection())       // HTTP status should be redirect
                .andExpect(redirectedUrl("/flights"));         // Redirects to the flight list page
    }

    // Test case for searching flights
    @Test
    void testSearchFlights() throws Exception {
        // Mock search response
        Flight flight = new Flight(1, "Flight 101", "New York", "London");
        when(flightService.searchFlights("New York", "London")).thenReturn(List.of(flight));

        // Perform the search request
        mockMvc.perform(get("/search")
                .param("from", "New York")
                .param("to", "London"))
                .andExpect(status().isOk())                  // HTTP status should be OK
                .andExpect(view().name("flightList"))        // The view name should be "flightList"
                .andExpect(model().attributeExists("flights")) // The model should contain a "flights" attribute
                .andExpect(model().attribute("flights", List.of(flight))); // Verify the flight search result
    }

    // Test case for showing flight details
    @Test
    void testShowFlightDetails() throws Exception {
        // Mock flight data
        Flight flight = new Flight(1, "Flight 101", "New York", "London");
        when(flightService.getFlightById(1)).thenReturn(flight);

        // Perform the GET request to show flight details
        mockMvc.perform(get("/flight/{id}", 1))
                .andExpect(status().isOk())                 // HTTP status should be OK
                .andExpect(view().name("flightDetails"))     // The view name should be "flightDetails"
                .andExpect(model().attributeExists("flight")) // The model should contain a "flight" attribute
                .andExpect(model().attribute("flight", flight)); // Verify the flight object
    }
}

