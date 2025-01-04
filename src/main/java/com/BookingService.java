package com.airplane.service;

import com.airplane.dao.BookingDAO;
import com.airplane.model.Booking;

import java.util.List;

public class BookingService {

    private BookingDAO bookingDAO;

    public BookingService() {
        this.bookingDAO = new BookingDAO();
    }

    public void addBooking(Booking booking) {
        bookingDAO.addBooking(booking);
    }

    public List<Booking> getAllBookings() {
        return bookingDAO.getAllBookings();
    }
}
