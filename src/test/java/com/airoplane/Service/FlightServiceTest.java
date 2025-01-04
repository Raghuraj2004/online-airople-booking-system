package com.airline.service;

import com.airline.model.Flight;
import com.airline.repository.FlightRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FlightServiceTest {

    @Mock
    private FlightRepository flightRepository;

    @InjectMocks
    private FlightService flightService;

    // Mock data for flights
    private Flight flight1;
    private Flight flight2;

    @BeforeEach
    void setup() {
        flight1 = new Flight(1, "Flight 101", "New York", "London");
        flight2 = new Flight(2, "Flight 202", "Los Angeles", "Paris");
    }

    // Test for getting all flights
    @Test
    void testGetAllFlights() {
        // Mock the repository to return a list of flights
        when(flightRepository.findAll()).thenReturn(List.of(flight1, flight2));

        // Call the service method
        List<Flight> flights = flightService.getAllFlights();

        // Verify the result
        assertNotNull(flights);
        assertEquals(2, flights.size());
        assertTrue(flights.contains(flight1));
        assertTrue(flights.contains(flight2));

        // Verify that the repository's findAll method was called once
        verify(flightRepository, times(1)).findAll();
    }

    // Test for getting a flight by its ID
    @Test
    void testGetFlightById() {
        // Mock the repository to return a flight when finding by ID
        when(flightRepository.findById(1)).thenReturn(Optional.of(flight1));

        // Call the service method
        Optional<Flight> foundFlight = flightService.getFlightById(1);

        // Verify the result
        assertTrue(foundFlight.isPresent());
        assertEquals(flight1, foundFlight.get());

        // Verify that the repository's findById method was called once
        verify(flightRepository, times(1)).findById(1);
    }

    // Test for booking a flight
    @Test
    void testBookFlight() {
        // Mock the repository to return a flight when booking
        when(flightRepository.findById(1)).thenReturn(Optional.of(flight1));
        when(flightRepository.save(flight1)).thenReturn(flight1);

        // Call the service method
        Flight bookedFlight = flightService.bookFlight(1);

        // Verify the result
        assertNotNull(bookedFlight);
        assertEquals(flight1, bookedFlight);

        // Verify that the repository's save method was called once
        verify(flightRepository, times(1)).save(flight1);
    }

    // Test for searching flights by departure and destination locations
    @Test
    void testSearchFlights() {
        // Mock the repository to return flights based on the search query
        when(flightRepository.findByFromAndTo("New York", "London")).thenReturn(List.of(flight1));

        // Call the service method
        List<Flight> searchedFlights = flightService.searchFlights("New York", "London");

        // Verify the result
        assertNotNull(searchedFlights);
        assertEquals(1, searchedFlights.size());
        assertTrue(searchedFlights.contains(flight1));

        // Verify that the repository's findByFromAndTo method was called once
        verify(flightRepository, times(1)).findByFromAndTo("New York", "London");
    }
}

