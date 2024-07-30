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

