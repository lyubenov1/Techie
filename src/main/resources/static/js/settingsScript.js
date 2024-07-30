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
                showMessageSettings(result.data, 'settings', 'success');
            } else {
                showMessageSettings(result.data, 'settings', 'error');
            }
        })
        .catch(() => {
            showMessageSettings('An error occurred while updating your subscription.', 'settings', 'error');
        });
});

function showMessageSettings(message, source, type) {
    const settingsMessageDiv = document.querySelector('.settings-subscription-message');
    if (source === 'settings' && settingsMessageDiv) {
        settingsMessageDiv.textContent = message;
        settingsMessageDiv.className = `settings-subscription-message ${type} show`;

        setTimeout(() => {
            settingsMessageDiv.classList.remove('show');
        }, 5000);
    }
}

document.addEventListener('DOMContentLoaded', (event) => {
    document.getElementById('newsletter-checkbox').checked = document.getElementById('userIsSubscribed').value === 'true';
});


