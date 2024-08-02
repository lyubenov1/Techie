// Utility functions
async function handleResponse(response) {
    const contentType = response.headers.get('Content-Type');
    if (contentType?.includes('text/html')) {
        await response.text(); // Consume the response body
        return { status: response.status, data: 'An error occurred. Please try again later.' };
    } else if (contentType?.includes('application/json')) {
        const data = await response.json();
        return { status: response.status, data: data };
    } else {
        const text = await response.text();
        return { status: response.status, data: text };
    }
}

function showMessage(message, type, messageDivClass) {
    const messageDiv = document.querySelector(`.${messageDivClass}`);
    messageDiv.innerHTML = ''; // Clear previous content
    messageDiv.className = `${messageDivClass} ${type}`; // Apply success or error class

    if (Array.isArray(message)) {
        // If message is an array, create a list
        const ul = document.createElement('ul');
        ul.className = 'message-list';
        message.forEach(msg => {
            const li = document.createElement('li');
            li.textContent = msg;
            ul.appendChild(li);
        });
        messageDiv.appendChild(ul);
    } else {
        // If it's a single message, display it directly
        messageDiv.textContent = message;
    }

    setTimeout(() => {
        messageDiv.innerHTML = '';
        messageDiv.className = messageDivClass; // Remove success or error class
    }, 5000);
}

// AJAX request function
async function sendRequest(endpoint, body, messageDivClass, successCallback) {
    try {
        const response = await fetch(endpoint, {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': csrfToken
            },
            body: JSON.stringify(body)
        });

        const result = await handleResponse(response);

        if (result.status === 200) {
            showMessage(result.data, 'success', messageDivClass);
            if (successCallback) {
                setTimeout(successCallback, 5000);
            }
        } else {
            // Format error messages
            let errorMessages = [];
            if (typeof result.data === 'object' && result.data !== null) {
                for (let key in result.data) {
                    errorMessages.push(result.data[key]);
                }
            } else {
                errorMessages.push(result.data);
            }
            showMessage(errorMessages, 'error', messageDivClass);
        }
    } catch (error) {
        showMessage('An error occurred while processing the request.', 'error', messageDivClass);
    }
}

// Password reset functions
function sendResetPasswordStepOneRequest(email) {
    return sendRequest('/api/password/reset-password/step-one', { email: email }, 'forgot-password-msg');
}

function sendResetPasswordStepTwoRequest(password, confirmPassword, token) {
    return sendRequest('/api/password/reset-password/step-two',
        { password: password, confirmPassword: confirmPassword, token: token },
        'reset-password-msg',
        () => {
            window.location.href = '/login'; // Redirect to login page after successful reset
        }
    );
}

// Event listeners
document.addEventListener('DOMContentLoaded', function() {
    // Step One: Request password reset
    const resetPasswordButton = document.getElementById('resetPasswordButton');
    if (resetPasswordButton) {
        resetPasswordButton.addEventListener('click', function(event) {
            const email = document.getElementById('email').value;
            sendResetPasswordStepOneRequest(email)
                .then(() => console.log('Step one request completed'))
                .catch((error) => console.error('Step one request failed', error));
        });
    }

    // Step Two: Submit new password
    const resetPasswordForm = document.getElementById('resetPasswordForm');
    if (resetPasswordForm) {
        resetPasswordForm.addEventListener('submit', function(event) {
            event.preventDefault(); // Prevent the default form submission

            const formData = new FormData(resetPasswordForm);
            const password = formData.get('password');
            const confirmPassword = formData.get('confirmPassword');
            const token = formData.get('token');

            sendResetPasswordStepTwoRequest(password, confirmPassword, token)
                .then(() => console.log('Step two request completed'))
                .catch((error) => console.error('Step two request failed', error));
        });
    }
});