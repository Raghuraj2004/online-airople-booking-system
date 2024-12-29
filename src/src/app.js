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
