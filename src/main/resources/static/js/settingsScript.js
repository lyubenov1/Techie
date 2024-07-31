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

document.querySelector('.delete-account button').addEventListener('click', handleAccountDeleteClick);

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
    const csrfToken = document.querySelector('meta[name="_csrf"]').getAttribute('content');
    const url = '/api/settings/account/delete';

    fetch(url, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        }
    })
        .then(response => {
            const contentType = response.headers.get('content-type');
            if (!response.ok) {
                if (contentType && contentType.includes('application/json')) {
                    return response.json().then(errorData => {
                        throw new Error(errorData.message || 'An error occurred');
                    });
                } else if (contentType && contentType.includes('text/html')) {
                    throw new Error('An unexpected error occurred');
                } else {
                    return response.text().then(text => {
                        throw new Error(text || 'Failed to initialize the deletion');
                    });
                }
            }
            if (contentType && contentType.includes('application/json')) {
                return response.json();
            } else {
                return response.text();
            }
        })
        .then(result => {
            localStorage.setItem('settingsSuccessMessage', result.message || result);
            window.location.reload();
        })
        .catch((error) => {
            localStorage.setItem('settingsErrorMessage', error.message || error);
            window.location.reload();
        });
}

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
                showMessageSettingsSubscription(result.data, 'settings', 'success');
            } else {
                showMessageSettingsSubscription(result.data, 'settings', 'error');
            }
        })
        .catch(() => {
            showMessageSettingsSubscription('An error occurred while updating your subscription.', 'settings', 'error');
        });
});

function showMessageSettingsSubscription(message, source, type) {
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
    checkAndDisplaySuccessMessage();
    checkAndDisplayErrorMessage();

    // Edit Details Modal
    const editDetailsBtn = document.querySelector('.edit-details-button');
    const editDetailsModal = document.getElementById('changeDetailsModal');
    const editDetailsForm = document.getElementById('changeDetailsForm');
    const userDetailsDiv = document.querySelector('.user-details');

    if (editDetailsBtn && editDetailsModal && editDetailsForm && userDetailsDiv) {
        editDetailsBtn.addEventListener('click', () => {
            // Pre-populate the form fields before opening the modal
            const firstName = userDetailsDiv.dataset.firstname;
            const lastName = userDetailsDiv.dataset.lastname;
            const username = userDetailsDiv.dataset.username;

            editDetailsForm.querySelector('input[name="firstName"]').value = firstName;
            editDetailsForm.querySelector('input[name="lastName"]').value = lastName;
            editDetailsForm.querySelector('input[name="username"]').value = username;

            openModal(editDetailsModal);
        });
        editDetailsForm.addEventListener('submit', (e) => handleFormSubmit(
            e, editDetailsForm, '/api/settings/details/change', 'PATCH', 'change-details-modal-error'));
    }

    // Change Password Modal
    const changePasswordBtn = document.querySelector('.change-password-btn');
    const changePasswordModal = document.getElementById('changePasswordModal');
    const changePasswordForm = document.getElementById('changePasswordForm');

    if (changePasswordBtn && changePasswordModal && changePasswordForm) {
        changePasswordBtn.addEventListener('click', () => openModal(changePasswordModal));
        changePasswordForm.addEventListener('submit', (e) => handleFormSubmit(
            e, changePasswordForm, '/api/settings/password/change', 'PATCH', 'change-password-modal-error'));
    }
});

function openModal(modal) {
    const bootstrapModal = new bootstrap.Modal(modal);
    bootstrapModal.show();
}

function handleFormSubmit(e, form, url, method, errorSpanClass) {
    e.preventDefault();
    const formData = new FormData(form);
    const data = Object.fromEntries(formData.entries());

    fetch(url, {
        method: method,
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
        body: JSON.stringify(data)
    })
        .then(response => {
            const contentType = response.headers.get('content-type');
            if (!response.ok) {
                if (contentType && contentType.includes('application/json')) {
                    return response.json().then(errorData => {
                        throw new Error(errorData.message || 'An error occurred');
                    });
                } else if (contentType && contentType.includes('text/html')) {
                    throw new Error('An unexpected error occurred');
                } else {
                    return response.text().then(text => {
                        throw new Error(text || 'Failed to make the change');
                    });
                }
            }
            if (contentType && contentType.includes('application/json')) {
                return response.json();
            } else {
                return response.text();
            }
        })
        .then(result => {
            closeModal(form.closest('.modal'));
            // Store the success message in localStorage
            localStorage.setItem('settingsSuccessMessage', result.message || result);
            window.location.reload();
        })
        .catch((error) => {
            showMessageSettings(error.message, 'error', errorSpanClass);
        });
}

function checkAndDisplaySuccessMessage() {
    const successMessage = localStorage.getItem('settingsSuccessMessage');
    if (successMessage) {
        showMessageSettings(successMessage, 'success');
        localStorage.removeItem('settingsSuccessMessage');
    }
}

function checkAndDisplayErrorMessage() {
    const errorMessage = localStorage.getItem('settingsErrorMessage');
    if (errorMessage) {
        showErrorMessage(errorMessage.message);
        localStorage.removeItem('settingsErrorMessage');
    }
}

function closeModal(modal) {
    const bootstrapModal = bootstrap.Modal.getInstance(modal);
    if (bootstrapModal) {
        bootstrapModal.hide();
    }
}
function showMessageSettings(message, type, errorSpanClass) {
    if (type === 'success') {
        const successDiv = document.querySelector('.settings-success');
        if (successDiv) {
            successDiv.textContent = message;
            successDiv.classList.add('show');
            setTimeout(() => {
                successDiv.classList.remove('show');
            }, 5000);
        }
    } else if (type === 'error') {
        const errorSpan = document.querySelector(`.${errorSpanClass}`);
        if (errorSpan) {
            errorSpan.textContent = message;
            errorSpan.classList.add('show');
            setTimeout(() => {
                errorSpan.classList.remove('show');
                errorSpan.textContent = '';
            }, 5000);
        }
    }
}

const spinner = document.getElementById('upload-spinner-settings');

document.getElementById('image-upload').addEventListener('change', function() {
    spinner.style.display = 'block';
    var form = document.getElementById('profileImageForm');
    var formData = new FormData(form);

    fetch('/api/settings/profile-image/change', {
        method: 'PATCH',
        headers: {
            'X-CSRF-TOKEN': csrfToken
        },
        body: formData
    })
        .then(response => {
            const contentType = response.headers.get('content-type');
            if (!response.ok) {
                if (contentType && contentType.includes('application/json')) {
                    return response.json().then(errorData => {
                        throw new Error(errorData.message || 'An error occurred');
                    });
                } else if (contentType && contentType.includes('text/html')) {
                    throw new Error('An unexpected error occurred');
                } else {
                    return response.text().then(text => {
                        throw new Error(text || 'Failed to change profile image');
                    });
                }
            }
            if (contentType && contentType.includes('application/json')) {
                return response.json();
            } else {
                return response.text();
            }
        })
        .then(result => {
            // Store the success message in localStorage
            localStorage.setItem('settingsSuccessMessage', result.message || result);
            window.location.reload();
        })
        .catch((error) => {
            showErrorMessage(error.message);
        })
        .finally(() => {
        // Hide the spinner
        spinner.style.display = 'none';
    });
});

function showErrorMessage(message) {
    const errorDiv = document.querySelector('.settings-success');

    if (errorDiv) {
        errorDiv.textContent = message;

        errorDiv.classList.remove('settings-success');
        errorDiv.classList.add('settings-error');

        errorDiv.classList.add('show');
        setTimeout(() => {
            errorDiv.classList.remove('show');
            errorDiv.classList.remove('settings-error');
            errorDiv.classList.add('settings-success');
        }, 5000);
    }
}