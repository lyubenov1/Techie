document.addEventListener("DOMContentLoaded", function() {
    updateCartBadge();
    fetchCart();
});

function fetchCartData() {
    return fetch('/api/cart/get')
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
        });
}

function updateCartBadge() {
    fetchCartData()
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

function fetchCart() {
    fetchCartData()
        .then(cart => {
            populateCartPage(cart);
        })
        .catch(error => {
            console.error('Error fetching cart data:', error.message);
        });
}


function populateCartPage(cart) {
    const cartContainer = document.querySelector('.cart-container');
    if (!cartContainer) {
        return;
    }

    const cartItemsContainer = cartContainer.querySelector('.cart-items');
    const cartDetailsContainer = cartContainer.querySelector('.cart-details');

    cartItemsContainer.innerHTML = ''; // Clear existing items

    cart.cartItems.forEach(cartItem => {
        const { product } = cartItem;

        const cartItemDiv = document.createElement('div');
        cartItemDiv.className = 'cart-item';

        const img = document.createElement('img');
        img.src = product.imageUrls[0];
        img.alt = product.name;

        const itemDetailsDiv = document.createElement('div');
        itemDetailsDiv.className = 'item-details';

        const h2 = document.createElement('h2');
        h2.textContent = product.name;

        itemDetailsDiv.appendChild(h2);

        const itemPriceDiv = document.createElement('div');
        itemPriceDiv.className = 'item-price';

        const priceP = document.createElement('p');
        priceP.textContent = 'Price: ';

        if (product.discountedPrice !== null && product.discountedPrice !== undefined) {
            // Case when there's a discount
            const originalPriceSpan = document.createElement('span');
            originalPriceSpan.className = 'original-price-discount';
            originalPriceSpan.textContent = `${product.originalPrice.toFixed(2)} $`;

            const discountedPriceSpan = document.createElement('span');
            discountedPriceSpan.className = 'discounted-price';
            discountedPriceSpan.textContent = `${product.discountedPrice.toFixed(2)} $`;

            const discountPercentageSpan = document.createElement('span');
            discountPercentageSpan.className = 'discount-percentage';
            discountPercentageSpan.textContent = `-${product.discount}%`;

            priceP.appendChild(originalPriceSpan);
            priceP.appendChild(document.createTextNode(' ')); // Add a space between prices
            priceP.appendChild(discountedPriceSpan);
            priceP.appendChild(discountPercentageSpan);
        } else {
            // Case when there's no discount
            const originalPriceSpan = document.createElement('span');
            originalPriceSpan.className = 'original-price';
            originalPriceSpan.textContent = `${product.originalPrice.toFixed(2)} $`;

            priceP.appendChild(originalPriceSpan);
        }


        itemPriceDiv.appendChild(priceP);

        const quantityControlsDiv = document.createElement('div');
        quantityControlsDiv.className = 'quantity-controls';

        const decreaseButton = document.createElement('button');
        decreaseButton.className = 'decrease';
        decreaseButton.textContent = '-';

        const quantityInput = document.createElement('input');
        quantityInput.type = 'text';
        quantityInput.value = cartItem.quantity;

        const increaseButton = document.createElement('button');
        increaseButton.className = 'increase';
        increaseButton.textContent = '+';

        quantityControlsDiv.appendChild(decreaseButton);
        quantityControlsDiv.appendChild(quantityInput);
        quantityControlsDiv.appendChild(increaseButton);

        itemPriceDiv.appendChild(quantityControlsDiv);

        cartItemDiv.appendChild(img);
        cartItemDiv.appendChild(itemDetailsDiv);
        cartItemDiv.appendChild(itemPriceDiv);

        cartItemsContainer.appendChild(cartItemDiv);
    })

    const subtotalSpan = cartDetailsContainer.querySelector('.subtotal');
    const totalSpan = cartDetailsContainer.querySelector('.total');

    subtotalSpan.textContent = `${cart.nonDiscountTotal.toFixed(2)} $`;
    totalSpan.textContent = `${cart.grandTotal.toFixed(2)} $`;
}
