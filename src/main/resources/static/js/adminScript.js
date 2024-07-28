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

    fetch('/api/admin/blacklist/post', {
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


let currentPage = 0;
const pageSize = 6;

function fetchBlacklistedUsers(page) {
    fetch(`/api/admin/blacklist/get?p=${page}&s=${pageSize}`)
        .then(response => response.json())
        .then(data => {
            displayBlacklistedUsers(data.content, data.number, data.totalPages, data.totalElements);
        })
        .catch(error => {
            console.error('Error fetching blacklisted users:', error);
        });
}

function displayBlacklistedUsers(users, currentPage, totalPages, totalUsers) {
    const listingDiv = document.getElementById('blacklist-listing');
    listingDiv.innerHTML = ''; // Clear existing content

    const headerContainer = document.createElement('div');
    headerContainer.className = 'header-container';
    listingDiv.appendChild(headerContainer);

    const header = document.createElement('h3');
    header.textContent = 'List of blacklisted users';
    headerContainer.appendChild(header);

    const paginationInfo = document.createElement('span');
    paginationInfo.id = 'paginationInfo';
    paginationInfo.className = 'pagination-info';
    headerContainer.appendChild(paginationInfo);

    const container = document.createElement('div');
    container.id = 'blacklist-container';
    container.className = 'blacklist-container';
    listingDiv.appendChild(container);

    users.forEach(user => {
        const userRow = document.createElement('div');
        userRow.className = 'user-row';
        userRow.innerHTML = `
            <div class="user-info">
                <span class="img"><img src="${user.profileImage}" alt="Profile Image" class="img-thumbnail"></span>
                <span class="email">${user.email}</span>
                <span class="timestamp">${user.blacklistTimestamp}</span>
                <span class="reason">Reason: ${user.reason}</span>
            </div>
            <div class="delete-btn"><button onclick="removeFromBlacklist(${user.id})">Remove</button></div>
        `;
        container.appendChild(userRow);
    });

    const paginationDiv = document.createElement('div');
    paginationDiv.id = 'blacklistPagination';
    paginationDiv.className = 'blacklist-pagination';
    listingDiv.appendChild(paginationDiv);

    createPagination(currentPage, totalPages, totalUsers);
}

async function removeFromBlacklist(userId) {
    try {
        const response = await fetch(`/api/admin/blacklist/delete?userId=${userId}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': csrfToken
            }
        });

        const data = await response.text();

        if (!response.ok) {
            throw new Error(data);
        }

        console.log('User removed from blacklist successfully:', data);
        handleSuccess(data);
        fetchBlacklistedUsers(currentPage); // Refresh the list
    } catch (error) {
        console.error('Error removing user from blacklist:', error);
        handleError(error.message);
    }
}

function handleError(message) {
    showMessage(message, 'error');
}

function handleSuccess(message) {
    showMessage(message, 'success');
}

function showMessage(message, type) {
    const messageElement = document.getElementById('infoMessage');
    messageElement.textContent = message;
    messageElement.className = type === 'error' ? 'blacklist-error-message' : 'blacklist-success-message';
    messageElement.style.display = 'block';
    setTimeout(() => {
        messageElement.style.display = 'none';
    }, 5000);
}

function createPagination(currentPage, totalPages, totalUsers) {
    const paginationDiv = document.getElementById('blacklistPagination');
    paginationDiv.innerHTML = ''; // Clear existing content

    const prevButton = document.createElement('button');
    prevButton.textContent = '<';
    prevButton.onclick = () => {
        if (currentPage > 0) {
            fetchBlacklistedUsers(currentPage - 1);
        }
    };
    prevButton.disabled = currentPage === 0;

    const nextButton = document.createElement('button');
    nextButton.textContent = '>';
    nextButton.onclick = () => {
        if (currentPage < totalPages - 1) {
            fetchBlacklistedUsers(currentPage + 1);
        }
    };
    nextButton.disabled = currentPage === totalPages - 1;

    paginationDiv.appendChild(prevButton);
    paginationDiv.appendChild(nextButton);

    // Update pagination info
    const start = currentPage * pageSize + 1;
    const end = Math.min((currentPage + 1) * pageSize, totalUsers);
    const paginationInfo = document.getElementById('paginationInfo');
    paginationInfo.textContent = `${start}-${end} out of ${totalUsers}`;
}


// Call the function to load the first page of blacklisted users when the page loads
document.addEventListener('DOMContentLoaded', () => {
    fetchBlacklistedUsers(currentPage);
});
