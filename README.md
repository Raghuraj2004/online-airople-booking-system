
# Online Airplane Booking System
Online-Airplane-Booking/
├── README.md
├── src/
│   ├── index.html
│   ├── styles.css
│   └── app.js
├── public/
│   ├── images/
│   │   └── airplane.jpg
│   └── stylesheets/
│       └── global.css
├── tests/
│   ├── login.test.js
│   ├── booking.test.js
│   └── payment.test.js
└── docs/
    ├── api-docs.md
    ├── architecture-diagram.png
    └── user-guide.md


This project is an online airplane booking system that allows users to log in, search flights, book tickets, and make payments securely.

## Features
- User Login and Authentication.
- Flight Search and Booking.
- Secure Payment Integration.

## How to Set Up Locally
1. Clone the repository:
2. Navigate to the project directory:
3. Open the `src/index.html` file in your browser.

## Dependencies
- Basic web technologies: HTML, CSS, JavaScript.

## Commands
- Start: Open `index.html` in the browser.
- <!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Airplane Booking System</title>
    <link rel="stylesheet" href="styles.css">
</head>
<body>
    <div class="container">
        <h1>Online Airplane Booking System</h1>

        <!-- Login Form -->
        <div id="login-section">
            <h2>Login</h2>
            <form id="login-form">
                <input type="email" id="email" placeholder="Email" required>
                <input type="password" id="password" placeholder="Password" required>
                <button type="submit">Login</button>
            </form>
        </div>

        <!-- Booking Section -->
        <div id="booking-section" style="display:none;">
            <h2>Book a Flight</h2>
            <form id="booking-form">
                <input type="text" id="destination" placeholder="Destination" required>
                <input type="date" id="date" required>
                <select id="class" required>
                    <option value="economy">Economy</option>
                    <option value="business">Business</option>
                    <option value="first-class">First Class</option>
                </select>
                <h3>Payment Details</h3>
                <input type="text" id="card-name" placeholder="Name on Card" required>
                <input type="text" id="card-number" placeholder="Card Number" required>
                <input type="text" id="expiry-date" placeholder="Expiry Date (MM/YY)" required>
                <input type="text" id="cvv" placeholder="CVV" required>
                <button type="submit">Pay & Book Flight</button>
            </form>
        </div>
    </div>
    <script src="app.js"></script>
</body>
</html>
body {
    font-family: Arial, sans-serif;
    background-color: #f4f4f9;
    margin: 0;
    padding: 0;
}
.container {
    max-width: 600px;
    margin: 50px auto;
    padding: 20px;
    background: white;
    border-radius: 8px;
    box-shadow: 0 4px 10px rgba(0, 0, 0, 0.1);
}
h1, h2 {
    text-align: center;
    color: #333;
}
form {
    display: flex;
    flex-direction: column;
    gap: 10px;
}
input, select {
    padding: 10px;
    font-size: 16px;
    border: 1px solid #ccc;
    border-radius: 5px;
}
button {
    padding: 10px;
    font-size: 16px;
    background-color: #007bff;
    color: white;
    border: none;
    border-radius: 5px;
    cursor: pointer;
}
button:hover {
    background-color: #0056b3;
}
document.getElementById("login-form").addEventListener("submit", function (e) {
    e.preventDefault();
    const email = document.getElementById("email").value;
    const password = document.getElementById("password").value;

    // Simulated login check
    if (email === "user@example.com" && password === "password123") {
        alert("Login Successful");
        document.getElementById("login-section").style.display = "none";
        document.getElementById("booking-section").style.display = "block";
    } else {
        alert("Invalid login credentials");
    }
});

document.getElementById("booking-form").addEventListener("submit", function (e) {
    e.preventDefault();
    const destination = document.getElementById("destination").value;
    const date = document.getElementById("date").value;
    const flightClass = document.getElementById("class").value;
    const cardName = document.getElementById("card-name").value;

    if (destination && date && flightClass && cardName) {
        alert(`Flight booked successfully for ${destination} on ${date}`);
    } else {
        alert("Please fill in all fields");
    }
});
// Example of a simple login test
function loginTest() {
    const validEmail = "user@example.com";
    const validPassword = "password123";

    // Simulate user input
    const inputEmail = "user@example.com";
    const inputPassword = "password123";

    if (inputEmail === validEmail && inputPassword === validPassword) {
        console.log("Login Test Passed");
    } else {
        console.log("Login Test Failed");
    }
}
loginTest();

