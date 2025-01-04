package com.airplane.model;

public class Booking {
    private int bookingId;
    private int flightId;
    private int userId;
    private String date;

    public Booking() {
    }

    public Booking(int bookingId, int flightId, int userId, String date) {
        this.bookingId = bookingId;
        this.flightId = flightId;
        this.userId = userId;
        this.date = date;
    }

    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingId=" + bookingId +
                ", flightId=" + flightId +
                ", userId=" + userId +
                ", date='" + date + '\'' +
                '}';
    }
}
