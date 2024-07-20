let isDropdownOpen = false;

document.getElementById('save-to-wishlist').addEventListener('click', function(event) {
    event.preventDefault();
    const dropdown = document.getElementById('wishlist-dropdown');

    if (isDropdownOpen) {
        dropdown.style.display = 'none';
        isDropdownOpen = false;
    } else {
        // Fetch the user's wishlists
        fetch('/api/wishlist/get')
            .then(response => response.json())
            .then(wishlists => {
                dropdown.innerHTML = ''; // Clear existing options
                if (wishlists.length > 1) {
                    // Add "Choose a wishlist" option
                    const chooseOption = document.createElement('span');
                    chooseOption.className = 'wishlist-option choose-option';
                    chooseOption.textContent = 'Choose a wishlist';
                    dropdown.appendChild(chooseOption);

                    wishlists.forEach(wishlist => {
                        const option = document.createElement('a');
                        option.href = '#';
                        option.className = 'wishlist-option';
                        option.textContent = wishlist.name;
                        option.dataset.wishlistId = wishlist.id;
                        dropdown.appendChild(option);
                    });
                    dropdown.style.display = 'block'; // Show dropdown
                    isDropdownOpen = true;
                } else {
                    // If only one wishlist, add product directly to it
                    const wishlistId = wishlists[0].id;
                    addToWishlist(wishlistId);
                }
            });
    }
});

// Close dropdown when clicking outside
document.addEventListener('click', function(event) {
    const dropdown = document.getElementById('wishlist-dropdown');
    const saveButton = document.getElementById('save-to-wishlist');
    if (!saveButton.contains(event.target) && !dropdown.contains(event.target)) {
        dropdown.style.display = 'none';
        isDropdownOpen = false;
    }
});

document.getElementById('wishlist-dropdown').addEventListener('click', function(event) {
    if (event.target.classList.contains('wishlist-option') && !event.target.classList.contains('choose-option')) {
        event.preventDefault();
        const wishlistId = event.target.dataset.wishlistId;
        addToWishlist(wishlistId);
    }
});


function showMessage(message, isError = false) {
    const messagePopup = document.createElement('div');
    messagePopup.className = `message-popup ${isError ? 'error' : 'success'}`;
    messagePopup.textContent = message;

    const wishlistWrapper = document.querySelector('.wishlist-wrapper');
    wishlistWrapper.appendChild(messagePopup);

    // Show message
    messagePopup.classList.add('show');

    // Hide message after 5 seconds
    setTimeout(() => {
        messagePopup.classList.remove('show');
        setTimeout(() => {
            wishlistWrapper.removeChild(messagePopup);
        }, 300); // Wait for fade out transition
    }, 5000);
}

function addToWishlist(wishlistId) {
    const productId = document.getElementById('product-id').value;
    const csrfToken = document.getElementById('csrf-token').value;

    fetch(`/api/wishlist/add/${wishlistId}/${productId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        }
    })
        .then(response => {
            return response.text().then(message => {
                if (response.ok) {
                    showMessage(message, false); // Show success message
                } else if (response.status === 409) {
                    showMessage(message, true); // Show error message for conflict
                } else {
                    throw new Error(message || 'Failed to add product to wishlist');
                }
            });
        })
        .catch(error => {
            showMessage(error.message, true);
        });

    // Close dropdown after attempting to add
    const dropdown = document.getElementById('wishlist-dropdown');
    dropdown.style.display = 'none';
    isDropdownOpen = false;
}


document.getElementById('add-to-cart').addEventListener('click', function(event) {
    event.preventDefault();
    addToCart();
});

function addToCart() {
    const productId = document.getElementById('product-id').value;
    const csrfToken = document.getElementById('csrf-token').value;

    fetch(`/api/cart/add/${productId}`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        }
    })
        .then(response => {
            if (response.ok) {
                alert('Product added to cart');
            } else {
                alert('Failed to add product to cart');
            }
        });
}