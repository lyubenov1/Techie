function handleAccountDeleteClick() {
    const confirmDialog = createConfirmDialog('Are you sure you want to delete your account?');
    document.body.appendChild(confirmDialog);

    confirmDialog.querySelector('.confirm-btn').addEventListener('click', () => {
        confirmDialog.remove();
        deleteAccount();
    });

    confirmDialog.querySelector('.cancel-btn').addEventListener('click', () => {
        confirmDialog.remove();
    });
}

function createConfirmDialog(message) {
    const dialog = document.createElement('div');
    dialog.className = 'custom-confirm-dialog';
    dialog.innerHTML = `
        <div class="confirm-content">
            <p>${message}</p>
            <div class="confirm-buttons">
                <button class="confirm-btn">Yes, delete</button>
                <button class="cancel-btn">Cancel</button>
            </div>
        </div>
    `;
    return dialog;
}

function deleteAccount() {
    console.log('Account deleted');
}

document.querySelector('.delete-account button').addEventListener('click', handleAccountDeleteClick);


const csrfToken = document.getElementById('csrf-token').value;

document.getElementById('savePreferences').addEventListener('click', function() {
    const status = document.getElementById('newsletter-checkbox').checked;

    fetch('/api/settings/subscription/change/status', {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
        body: JSON.stringify({ status: status })
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
    const messageDiv = document.querySelector(`.settings-subscription-message`);
    messageDiv.textContent = message;
    messageDiv.className = `settings-subscription-message show ${type}`;

    setTimeout(() => {
        messageDiv.classList.remove('show');
    }, 5000);
}

document.addEventListener('DOMContentLoaded', (event) => {
    document.getElementById('newsletter-checkbox').checked = document.getElementById('userIsSubscribed').value === 'true';
});


