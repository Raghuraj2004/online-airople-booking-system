package com.airline.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class FlightTest {

    @Test
    void testFlightEntity() {
        Flight flight = new Flight(1, "Flight 101", "New York", "London");

        assertEquals(1, flight.getFlightId());
        assertEquals("Flight 101", flight.getFlightName());
        assertEquals("New York", flight.getDepartureCity());
        assertEquals("London", flight.getArrivalCity());
    }
}

