package com.airline.dao;

import com.airline.model.Flight;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class FlightDAOTest {

    @Autowired
    private FlightDAO flightDAO;

    @Test
    void testSaveFlight() {
        Flight flight = new Flight(1, "Flight 101", "New York", "London");
        flightDAO.save(flight);

        assertNotNull(flightDAO.findById(1).orElse(null));
    }

    @Test
    void testFindAllFlights() {
        Flight flight = new Flight(1, "Flight 101", "New York", "London");
        flightDAO.save(flight);

        assertEquals(1, flightDAO.findAll().size());
    }
}

