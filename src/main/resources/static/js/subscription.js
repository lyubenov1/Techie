document.addEventListener('DOMContentLoaded', function() {
    const subscriptionForm = document.getElementById('subscriptionForm');
    if (subscriptionForm) {
        subscriptionForm.addEventListener('submit', function(event) {
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
                    if (response.headers.get('Content-Type')?.includes('application/json')) {
                        return response.json().then(data => ({ status: response.status, data: data }));
                    } else {
                        return response.text().then(text => ({ status: response.status, data: text }));
                    }
                })
                .then(result => {
                    if (result.status === 200) {
                        showMessageFooter(result.data, 'footer', 'success');
                    } else {
                        showMessageFooter(result.data, 'footer', 'error');
                    }
                })
                .catch((error) => {
                    showMessageFooter(error.message, 'footer', 'error');
                });
        });
    }

    const alertDiv = document.querySelector('.alert-success');

    if (alertDiv) {
        setTimeout(() => {
            alertDiv.classList.add('hide');
            setTimeout(() => {
                alertDiv.remove();
            }, 1000);
        }, 5000);
    }
});

function showMessageFooter(message, source, type) {
    const footerMessageDiv = document.querySelector('.footer-message');
    if (source === 'footer' && footerMessageDiv) {
        footerMessageDiv.textContent = message;
        footerMessageDiv.className = `footer-message ${type} show`;

        setTimeout(() => {
            footerMessageDiv.classList.remove('show');
        }, 5000);
    }
}