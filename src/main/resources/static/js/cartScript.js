document.addEventListener("DOMContentLoaded", function() {
    updateCartBadge();
});

function updateCartBadge() {
    fetch('/api/cart/get')
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
                        throw new Error(text || 'Failed to fetch cart');
                    });
                }
            }
            if (contentType && contentType.includes('application/json')) {
                return response.json();
            } else {
                return response.text();
            }
        })
        .then(cart => {
            const totalQuantity = cart.cartItems.reduce((sum, item) => sum + item.quantity, 0);
            const badgeElement = document.querySelector('.badge-notification');
            if (totalQuantity > 0) {
                badgeElement.textContent = totalQuantity;
                badgeElement.style.display = 'inline-block'; // Show the badge if there are items
            } else {
                badgeElement.style.display = 'none'; // Hide the badge if no items
            }
        })
        .catch(error => {
            console.error('Error fetching cart data:', error.message);
            document.querySelector('.badge-notification').style.display = 'none';
        });
}
