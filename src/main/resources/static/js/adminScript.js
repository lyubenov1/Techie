const csrfToken = document.getElementById('csrf-token').value;
let selectedUser = null;
let fetchTimeout = null;

function fetchUsers() {
    const query = document.getElementById('userEmail').value;
    const dropdown = document.getElementById('userDropdown');

    if (fetchTimeout) {
        clearTimeout(fetchTimeout);
    }

    fetchTimeout = setTimeout(() => {
        fetch(`/api/admin/get?query=${encodeURIComponent(query)}`)
            .then(response => {
                if (!response.ok) {
                    return response.text().then(text => {
                        if (response.headers.get('content-type')?.includes('text/html')) {
                            throw new Error('Server returned an HTML error page');
                        } else {
                            throw new Error(text || 'Failed to fetch users');
                        }
                    });
                }
                return response.json();
            })
            .then(users => {
                populateDropdown(users, dropdown);
            })
            .catch(error => {
                handleError(error.message);
            });
    }, 300);
}

function populateDropdown(users, dropdown) {
    dropdown.innerHTML = ''; // Clear previous options
    users.forEach(user => {
        const option = document.createElement('div');
        option.className = 'dropdown-item';
        option.innerHTML = createUserHTML(user);
        option.addEventListener('click', () => openModal(user));
        dropdown.appendChild(option);
    });
    dropdown.style.display = 'block';
}

function createUserHTML(user) {
    return `
        <div class="user-item">
            <img src="${user.profileImage}" alt="User Avatar" class="user-avatar">
            <div class="user-details">
                <div class="user-email">${user.email}</div>
                <div class="user-name">${user.firstName} ${user.lastName}</div>
                <div class="user-role">Role: ${user.role}</div>
            </div>
        </div>
    `;
}

function openModal(user) {
    closeDropdown()

    selectedUser = user;
    document.getElementById('userProfileImage').src = user.profileImage || 'default-profile.png';
    document.getElementById('username').innerText = user.username;
    document.getElementById('email').innerText = user.email;
    document.getElementById('firstName').innerText = user.firstName;
    document.getElementById('lastName').innerText = user.lastName;
    document.getElementById('role').innerText = user.role;
    document.getElementById('createdAt').innerText = user.createdAt;
    document.getElementById('blacklistReason').value = '';

    var modal = new bootstrap.Modal(document.getElementById('blacklistModal'));
    modal.show();
}

function blacklistUser() {
    if (!selectedUser) return;

    selectedUser.reason = document.getElementById('blacklistReason').value;

    fetch('/api/admin/post', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
        body: JSON.stringify(selectedUser),
    })
        .then(response => {
            if (!response.ok) {
                return response.text().then(text => {
                    if (response.headers.get('content-type')?.includes('text/html')) {
                        throw new Error('Server returned an HTML error page');
                    } else {
                        throw new Error(text || 'Failed to blacklist user');
                    }
                });
            }
            return response.text();
        })
        .then(data => {
            console.log('User blacklisted successfully:', data);
            window.location.reload();
        })
        .catch(error => {
            console.error('Error blacklisting user:', error);
            handleErrorModal(error.message);
        });
}

function handleErrorModal(message) {
    const errorMessage = document.getElementById('errorMessageModal');
    errorMessage.textContent = message;
    errorMessage.style.display = 'block';
    setTimeout(() => {
        errorMessage.style.display = 'none';
    }, 5000);
}

function handleError(message) {
    const errorMessage = document.getElementById('errorMessage');
    errorMessage.textContent = message;
    errorMessage.style.display = 'block';
    setTimeout(() => {
        errorMessage.style.display = 'none';
    }, 5000);
}

function closeDropdown() {
    const dropdown = document.getElementById('userDropdown');
    dropdown.style.display = 'none';
}


// Add event listeners for both focus and input events
document.addEventListener('DOMContentLoaded', () => {
    const userEmailInput = document.getElementById('userEmail');
    userEmailInput.addEventListener('focus', fetchUsers);
    userEmailInput.addEventListener('input', fetchUsers);

    // Add click event listener to close dropdown when clicking outside
    document.addEventListener('click', (event) => {
        const dropdown = document.getElementById('userDropdown');
        const userEmailInput = document.getElementById('userEmail');
        if (!dropdown.contains(event.target) && event.target !== userEmailInput) {
            dropdown.style.display = 'none';
        }
    });
});