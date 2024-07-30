const csrfToken = document.getElementById('csrf-token').value;

document.getElementById('subscriptionForm').addEventListener('submit', function(event) {
    event.preventDefault();

    const email = document.getElementById('form5Example2').value;

    fetch('/api/settings/subscription/change/email', {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
        body: JSON.stringify({ email: email })
    })
        .then(response => {
            // Check if the response is JSON
            if (response.headers.get('Content-Type')?.includes('application/json')) {
                return response.json().then(data => ({ status: response.status, data: data }));
            } else {
                return response.text().then(text => ({ status: response.status, data: text }));
            }
        })
        .then(result => {
            if (result.status === 200) {
                successMessage(result.data);
            } else {
                errorMessage(result.data);
            }
        })
        .catch(() => {
            errorMessage('An error occurred while updating your subscription.');
        });
});

function successMessage(message) {
    showMessage(message, 'success');
}

function errorMessage(message) {
    showMessage(message, 'error');
}

function showMessage(message, type) {
    const messageDiv = document.querySelector('.footer-message');
    messageDiv.textContent = message;
    messageDiv.className = `footer-message ${type} show`;

    setTimeout(() => {
        messageDiv.classList.remove('show');
    }, 5000);
}
