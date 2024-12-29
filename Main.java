import java.util.*;
 class Flight {
    private String flightNumber;
    private String source;
    private String destination;
    private double price;
    private int availableSeats;
    

    public Flight(String flightNumber, String source, String destination, double price, int availableSeats) {
        this.flightNumber = flightNumber;
        this.source = source;
        this.destination = destination;
        this.price = price;
        this.availableSeats = availableSeats;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getSource() {
        return source;
    }

    public String getDestination() {
        return destination;
    }

    public double getPrice() {
        return price;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public boolean bookSeat() {
        if (availableSeats > 0) {
            availableSeats--;
            return true;
        } else {
            return false;
        }
    }
}

class Booking {
    private String customerName;
    private Flight flight;
    private int numberOfSeats;

    public Booking(String customerName, Flight flight, int numberOfSeats) {
        this.customerName = customerName;
        this.flight = flight;
        this.numberOfSeats = numberOfSeats;
    }

    public void displayBookingDetails() {
        System.out.println("Booking Confirmation:");
        System.out.println("Customer Name: " + customerName);
        System.out.println("Flight Number: " + flight.getFlightNumber());
        System.out.println("From: " + flight.getSource());
        System.out.println("To: " + flight.getDestination());
        System.out.println("Seats Booked: " + numberOfSeats);
        System.out.println("Total Price: " + (numberOfSeats * flight.getPrice()));
    }
}

public class Main {
    private static List<Flight> flights = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Sample Flights
        flights.add(new Flight("AI101", "New York", "London", 500.0, 50));
        flights.add(new Flight("AI102", "London", "Paris", 300.0, 60));
        flights.add(new Flight("AI103", "Paris", "Tokyo", 800.0, 40));

        while (true) {
            System.out.println("\nAirplane Booking System");
            System.out.println("1. View Available Flights");
            System.out.println("2. Book a Flight");
            System.out.println("3. Exit");
            System.out.print("Enter choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    viewAvailableFlights();
                    break;
                case 2:
                    bookAFlight();
                    break;
                case 3:
                    System.out.println("Exiting system...");
                    return;
                default:
                    System.out.println("Invalid choice, please try again.");
            }
        }
    }

    public static void viewAvailableFlights() {
        System.out.println("\nAvailable Flights:");
        for (Flight flight : flights) {
            System.out.println("Flight Number: " + flight.getFlightNumber());
            System.out.println("From: " + flight.getSource());
            System.out.println("To: " + flight.getDestination());
            System.out.println("Price: " + flight.getPrice());
            System.out.println("Available Seats: " + flight.getAvailableSeats());
            System.out.println("---------------------------");
        }
    }

    public static void bookAFlight() {
        System.out.print("Enter Customer Name: ");
        String customerName = scanner.nextLine();

        System.out.print("Enter Flight Number to book: ");
        String flightNumber = scanner.nextLine();

        Flight selectedFlight = null;
        for (Flight flight : flights) {
            if (flight.getFlightNumber().equals(flightNumber)) {
                selectedFlight = flight;
                break;
            }
        }

        if (selectedFlight != null && selectedFlight.getAvailableSeats() > 0) {
            System.out.print("Enter number of seats to book: ");
            int seatsToBook = scanner.nextInt();
            if (seatsToBook <= selectedFlight.getAvailableSeats()) {
                selectedFlight.bookSeat();
                Booking booking = new Booking(customerName, selectedFlight, seatsToBook);
                booking.displayBookingDetails();
            } else {
                System.out.println("Not enough seats available.");
            }
        } else {
            System.out.println("Flight not found or no available seats.");
        }
    }
}
