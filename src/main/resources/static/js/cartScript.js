document.addEventListener("DOMContentLoaded", function() {
    updateCartBadge();
});

function updateCartBadge() {
    fetch('/api/cart/get')
        .then(response => response.json())
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
            console.error('Error fetching cart data:', error);
            document.querySelector('.badge-notification').style.display = 'none'; // Hide the badge on error
        });
}