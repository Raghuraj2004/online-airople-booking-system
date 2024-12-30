// Form Validation Script
document.addEventListener('DOMContentLoaded', () => {
    const forms = document.querySelectorAll('form');

    forms.forEach(form => {
        form.addEventListener('submit', event => {
            let isValid = true;
            const inputs = form.querySelectorAll('.form-control');

            inputs.forEach(input => {
                if (!input.value.trim()) {
                    showError(input, 'This field is required');
                    isValid = false;
                } else if (input.type === 'email' && !validateEmail(input.value)) {
                    showError(input, 'Please enter a valid email address');
                    isValid = false;
                } else if (input.type === 'password' && input.value.length < 6) {
                    showError(input, 'Password must be at least 6 characters');
                    isValid = false;
                } else {
                    clearError(input);
                }
            });

            if (!isValid) {
                event.preventDefault();
            }
        });
    });
});

function showError(input, message) {
    let error = input.nextElementSibling;
    if (!error || !error.classList.contains('error-message')) {
        error = document.createElement('div');
        error.className = 'error-message text-danger mt-1';
        input.parentElement.appendChild(error);
    }
    error.textContent = message;
    input.classList.add('is-invalid');
}

function clearError(input) {
    const error = input.nextElementSibling;
    if (error && error.classList.contains('error-message')) {
        error.remove();
    }
    input.classList.remove('is-invalid');
}

function validateEmail(email) {
    const re = /^[^\s@]+@[^\s@]+\.[^\s@]+$/;
    return re.test(email);
}

// Dynamic Button Interactivity
document.querySelectorAll('.btn-primary').forEach(button => {
    button.addEventListener('click', () => {
        alert('Booking action initiated!');
    });
});