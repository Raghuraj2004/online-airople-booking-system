package com.airplane.controller;

import com.airplane.model.Booking;
import com.airplane.service.BookingService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/booking")
public class BookingServlet extends HttpServlet {

    private BookingService bookingService;

    @Override
    public void init() throws ServletException {
        bookingService = new BookingService();
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Booking> bookings = bookingService.getAllBookings();
        request.setAttribute("bookings", bookings);
        request.getRequestDispatcher("booking.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String flightId = request.getParameter("flightId");
        String userId = request.getParameter("userId");
        String date = request.getParameter("date");

        Booking booking = new Booking();
        booking.setFlightId(Integer.parseInt(flightId));
        booking.setUserId(Integer.parseInt(userId));
        booking.setDate(date);

        bookingService.addBooking(booking);

        response.sendRedirect("/booking");
    }
}
