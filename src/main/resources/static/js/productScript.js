document.addEventListener('DOMContentLoaded', function() {
    // Select all wishlist icons
    document.querySelectorAll('.add-to-wishlist').forEach(icon => {
        icon.addEventListener('click', function(event) {
            event.preventDefault(); // Prevent default anchor behavior
            event.stopPropagation(); // Stop event from bubbling up
            const productId = this.dataset.productId;
            addProductToWishlist(productId, this);
        });

        // Enlarge the icon on hover
        icon.addEventListener('mouseover', function() {
            this.style.transform = 'scale(1.2)';
        });

        icon.addEventListener('mouseout', function() {
            this.style.transform = 'scale(1)';
        });
    });

    // Select all shopping cart icons
    document.querySelectorAll('.shopping-cart').forEach(icon => {
        icon.addEventListener('click', function(event) {
            event.preventDefault();
            event.stopPropagation();
            const productId = this.dataset.productId;
            addProductToCart(productId, this);
        });

        // Enlarge the icon on hover
        icon.addEventListener('mouseover', function() {
            this.style.transform = 'scale(1.2)';
        });

        icon.addEventListener('mouseout', function() {
            this.style.transform = 'scale(1)';
        });
    });

    function addProductToCart(productId, icon) {
        const itemDTO = {
            productId: productId,
            quantity: 1
        };

        fetch('/api/cart/items', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': csrfToken
            },
            body: JSON.stringify(itemDTO)
        })
            .then(response => {
                if (response.ok) {
                    return response.json();
                } else {
                    return response.text().then(message => {
                        throw new Error(message || 'Failed to add product to cart');
                    });
                }
            })
            .then(createdItem => {
                console.log('Product added to cart successfully:', createdItem);
                showTickIcon(icon);
            })
            .catch(error => {
                console.error('Error adding product to cart:', error.message);
                shakeIcon(icon);
            });
    }

    function addProductToWishlist(productId, icon) {    // Different function than the original addToWishlist.
                                                             // This one is designed for product cards
        fetch('/api/wishlist/get')
            .then(response => {
                if (response.redirected) {
                    window.location.href = response.url; // Redirect to the login page
                    return;
                }
                return response.json();
            })
            .then(wishlists => {
                if (!wishlists) return; // Exit if already redirected
                // Add product to the first wishlist (index 0)
                const wishlistId = wishlists[0].id;
                fetch(`/api/wishlist/add/${wishlistId}/${productId}`, {
                    method: 'PATCH',
                    headers: {
                        'Content-Type': 'application/json',
                        'X-CSRF-TOKEN': csrfToken
                    }
                })
                    .then(response => {
                        return response.text().then(message => {
                            if (response.ok) {
                                console.log('Product added successfully:', message);
                                showTickIcon(icon);
                            } else {
                                throw new Error(message || 'Failed to add product to wishlist');
                            }
                        });
                    })
                    .catch(error => {
                        console.error('Error adding product:', error.message);
                        shakeIcon(icon);
                    });
            })
    }

    function showTickIcon(icon) {
        const originalIcon = icon.innerHTML;
        icon.innerHTML = '<i class="fas fa-check"></i>';
        icon.style.transition = 'transform 0.3s ease';
        icon.style.transform = 'scale(1.2)';

        setTimeout(() => {
            icon.style.transform = 'scale(1)';
            setTimeout(() => {
                icon.innerHTML = originalIcon;
            }, 300); // Wait for scale down animation to finish
        }, 2700); // Start scale down after 2.7 seconds (total 3 seconds)
    }

    function shakeIcon(icon) {
        icon.classList.add('shake');
        setTimeout(() => {
            icon.classList.remove('shake');
        }, 500); // Duration of the shake animation
    }

    const addToCartButton = document.querySelector('.add-to-cart');

    addToCartButton.addEventListener('click', (event) => {
        event.preventDefault();
        updateCart();
    });
});

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
            .then(response => {
                return response.json();
            })
            .then(wishlists => {
                if (!wishlists) return; // Exit if already redirected
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

function addToWishlist(wishlistId) {    // Function designed specifically for the main product page's "Save" button
    const productId = document.getElementById('product-id').value;

    fetch(`/api/wishlist/add/${wishlistId}/${productId}`, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        }
    })
        .then(response => {
            // Check if the response is HTML
            const contentType = response.headers.get('Content-Type');
            return response.text().then(message => {
                if (response.ok) {
                    if (contentType.includes('text/html')) {
                        showMessage('An unexpected error occurred.', true);
                    } else {
                        showMessage(message, false); // Show success message
                    }
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

function updateCart() {
    const productId = document.getElementById('product-id').value;

    const itemDTO = {
        productId: productId,
        quantity: 1  // Default quantity
    };

    fetch('/api/cart/items', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
        body: JSON.stringify(itemDTO)
    })
        .then(response => {
            return response.text().then(message => {
                if (response.ok) {
                    if (response.headers.get('content-type')?.includes('text/html')) {
                        showMessage('An unexpected error occurred.', true);
                    } else {
                        console.log(message);
                        showMessage("Product added successfully to your cart!", false); // Show success message
                    }
                } else if (response.status === 409) {
                    showMessage(message, true); // Show error message for conflict (e.g., not enough stock)
                } else {
                    throw new Error(message || 'Failed to add product to cart');
                }
            });
        })
        .catch(error => {
            showMessage(error.message, true);
        });
}