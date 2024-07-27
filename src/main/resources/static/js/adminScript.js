let fetchTimeout;

function fetchUsers() {
    const query = document.getElementById('userEmail').value;
    const errorMessage = document.getElementById('errorMessage');
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
        option.addEventListener('click', () => selectUser(user));
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
            </div>
        </div>
    `;
}

const csrfToken = document.getElementById('csrf-token').value;

function selectUser(user) {
    console.log('Selected user:', user);
    // Send POST request to blacklist the user
    fetch('/api/admin/post', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
        body: JSON.stringify(user)
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
        return response.json();
    })
        .then(data => {
            console.log('User blacklisted successfully:', data);
            // You can add more logic here, like updating the UI
        })
        .catch(error => {
            handleError(error.message);
        });

    // Close the dropdown after selection
    document.getElementById('userDropdown').style.display = 'none';
}

function handleError(message) {
    const errorMessage = document.getElementById('errorMessage');
    errorMessage.textContent = message;
    errorMessage.style.display = 'block';
}

function closeDropdown(event) {
    const dropdown = document.getElementById('userDropdown');
    const userEmailInput = document.getElementById('userEmail');
    if (!dropdown.contains(event.target) && event.target !== userEmailInput) {
        dropdown.style.display = 'none';
    }
}

// Add event listeners for both focus and input events
document.addEventListener('DOMContentLoaded', () => {
    const userEmailInput = document.getElementById('userEmail');
    userEmailInput.addEventListener('focus', fetchUsers);
    userEmailInput.addEventListener('input', fetchUsers);

    // Add click event listener to close dropdown when clicking outside
    document.addEventListener('click', closeDropdown);
});