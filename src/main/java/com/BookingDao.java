package com.airplane.dao;

import com.airplane.model.Booking;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BookingDAO {

    private static final String DB_URL = "jdbc:mysql://localhost:3306/airplane_db";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "password";

    public void addBooking(Booking booking) {
        String query = "INSERT INTO bookings (flight_id, user_id, date) VALUES (?, ?, ?)";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             PreparedStatement statement = connection.prepareStatement(query)) {

            statement.setInt(1, booking.getFlightId());
            statement.setInt(2, booking.getUserId());
            statement.setString(3, booking.getDate());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public List<Booking> getAllBookings() {
        List<Booking> bookings = new ArrayList<>();
        String query = "SELECT * FROM bookings";

        try (Connection connection = DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(query)) {

            while (resultSet.next()) {
                Booking booking = new Booking();
                booking.setBookingId(resultSet.getInt("booking_id"));
                booking.setFlightId(resultSet.getInt("flight_id"));
                booking.setUserId(resultSet.getInt("user_id"));
                booking.setDate(resultSet.getString("date"));
                bookings.add(booking);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return bookings;
    }
}
