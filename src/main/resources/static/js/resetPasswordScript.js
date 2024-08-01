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
    messageDiv.textContent = message;
    messageDiv.className = `${messageDivClass} ${type}`; // Apply success or error class

    setTimeout(() => {
        messageDiv.textContent = '';
        messageDiv.className = messageDivClass; // Remove success or error class
    }, 5000);
}

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
            showMessage(result.data, 'error', messageDivClass);
        }
    } catch (error) {
        showMessage('An error occurred while processing the request.', 'error', messageDivClass);
    }
}

function sendResetPasswordStepOneRequest(email) {
    return sendRequest('/api/password/reset-password/step-one', { email: email }, 'forgot-password-msg');
}

function sendResetPasswordStepTwoRequest(password, confirmPassword) {
    return sendRequest('/api/password/reset-password/step-two',
        { password: password, confirmPassword: confirmPassword }, 'reset-password-msg', () => {
        window.location.href = '/';
    });
}


document.getElementById('resetPasswordButton').addEventListener('click', function(event) {
    const email = document.getElementById('email').value;
    sendResetPasswordStepOneRequest(email)
        .then(() => console.log('Step one request completed'))
        .catch((error) => console.error('Step one request failed', error));
});

document.getElementById('submitButton').addEventListener('click', function() {
    const password = document.getElementById('password').value;
    const confirmPassword = document.getElementById('confirmPassword').value;
    sendResetPasswordStepTwoRequest(password, confirmPassword)
        .then(() => console.log('Step two request completed'))
        .catch((error) => console.error('Step two request failed', error));
});

