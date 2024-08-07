document.addEventListener("DOMContentLoaded", function() {
    updateCartBadge();
    fetchCart();
    fetchAddresses();
    document.getElementById('finishOrderBtn').addEventListener('click', finishOrder);
});

document.querySelector('.checkout-button').addEventListener('click', openCheckoutModal);

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

function openCheckoutModal() {
    fetchCartData()
        .then(cart => {
            const checkoutModal = new bootstrap.Modal(document.getElementById('checkoutModal'));
            document.getElementById('modalTotalAmount').textContent = `${cart.grandTotal.toFixed(2)} $`;
            document.getElementById('checkoutModal').dataset.cartData = JSON.stringify(cart);
            checkoutModal.show();
        })
        .catch(error => {
            console.error('Error fetching cart data:', error.message);
        });
}

function fetchAddresses() {
    fetch('/api/address/get')
        .then(response => response.json())
        .then(addresses => {
            const deliveryAddressSelect = document.getElementById('deliveryAddress');
            addresses.forEach(address => {
                const option = document.createElement('option');
                option.value = address.id;
                option.textContent = address.name;
                deliveryAddressSelect.appendChild(option);
            });
        })
        .catch(error => {
            console.error('Error fetching addresses:', error.message);
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

        const itemMsgSpan = document.createElement('span');
        itemMsgSpan.className = 'item-msg';
        itemMsgSpan.id = `item-msg-${cartItem.id}`;
        itemMsgSpan.style.display = 'none';
        itemDetailsDiv.appendChild(itemMsgSpan);

        const trashIcon = document.createElement('i');
        trashIcon.className = 'far fa-trash-can fa-lg trash-icon';
        trashIcon.onclick = function() {
            removeItem(cartItem.id);
        };
        itemDetailsDiv.appendChild(trashIcon);

        cartItemDiv.appendChild(itemDetailsDiv);

        const itemPriceDiv = document.createElement('div');
        itemPriceDiv.className = 'item-price';

        const priceP = document.createElement('p');
        const priceLabelSpan = document.createElement('span');
        priceLabelSpan.className = 'price-label';
        priceLabelSpan.textContent = 'Price: ';
        priceP.appendChild(priceLabelSpan);

        if (product.discountedPrice !== null && product.discountedPrice !== undefined) {
            // Case when there's a discount
            const priceWrapper = document.createElement('div');
            priceWrapper.className = 'price-wrapper';

            const originalPriceSpan = document.createElement('span');
            originalPriceSpan.className = 'original-price-discount';
            originalPriceSpan.textContent = `${product.originalPrice.toFixed(2)} $`;

            const discountedPriceSpan = document.createElement('span');
            discountedPriceSpan.className = 'discounted-price';
            discountedPriceSpan.textContent = `${product.discountedPrice.toFixed(2)} $`;

            priceP.appendChild(priceLabelSpan);
            priceP.appendChild(originalPriceSpan);
            priceP.appendChild(priceWrapper);
            priceWrapper.appendChild(discountedPriceSpan);
        } else {
            // Case when there's no discount (unchanged)
            const originalPriceSpan = document.createElement('span');
            originalPriceSpan.className = 'original-price';
            originalPriceSpan.textContent = `${cartItem.originalPrice.toFixed(2)} $`;

            priceP.appendChild(priceLabelSpan);
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
        quantityInput.value = cartItem.quantity.toString();

        function validateQuantity(value) {
            const numberValue = parseInt(value, 10);
            return isNaN(numberValue) ? 1 : Math.max(numberValue, 1);
        }

        const increaseButton = document.createElement('button');
        increaseButton.className = 'increase';
        increaseButton.textContent = '+';

        quantityControlsDiv.appendChild(decreaseButton);
        quantityControlsDiv.appendChild(quantityInput);
        quantityControlsDiv.appendChild(increaseButton);

        itemPriceDiv.appendChild(quantityControlsDiv);

        decreaseButton.addEventListener('click', () => {
            let currentValue = parseInt(quantityInput.value, 10);
            if (!isNaN(currentValue) && currentValue > 1) {
                quantityInput.value = (currentValue - 1).toString();
                updateCartItem(cartItem.id, quantityInput.value);
            }
        });

        increaseButton.addEventListener('click', () => {
            let currentValue = parseInt(quantityInput.value, 10);
            if (!isNaN(currentValue)) {
                quantityInput.value = (currentValue + 1).toString();
                updateCartItem(cartItem.id, quantityInput.value);
            }
        });

        quantityInput.addEventListener('change', () => {
            const validatedValue = validateQuantity(quantityInput.value);
            quantityInput.value = validatedValue.toString();
            updateCartItem(cartItem.id, quantityInput.value);
        });

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

function updateCartItem(cartItemId, newQuantity) {
    // Convert newQuantity to an integer
    const quantityValue = parseInt(newQuantity, 10);

    // Ensure it's a valid number and not NaN
    if (isNaN(quantityValue) || quantityValue < 1) {
        console.error('Invalid quantity value:', newQuantity);
        return;
    }

    fetch('/api/cart/items/update', {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
        body: JSON.stringify({
            id: cartItemId,
            quantity: quantityValue
        })
    })
        .then(response => {
            if (response.status === 409) {
                return response.text().then(errorMessage => {
                    throw new Error(errorMessage);
                });
            }
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.text();
        })
        .then(data => {
            console.log('Item updated successfully:', data);
            fetchCart();
            updateCartBadge()
        })
        .catch(error => {
            console.error('Error updating item:', error.message);
            showMsg(cartItemId, error.message, 'error');
        });
}

function showMsg(cartItemId, message, type) {
    const msgSpan = document.getElementById(`item-msg-${cartItemId}`);
    if (msgSpan) {
        msgSpan.textContent = message;
        msgSpan.className = `item-msg ${type}`;
        msgSpan.style.display = 'inline-block';
        msgSpan.style.opacity = '1';
        msgSpan.style.transition = 'opacity 0.3s ease-in-out';

        setTimeout(() => {
            msgSpan.style.opacity = '0';
            setTimeout(() => {
                msgSpan.textContent = '';
                msgSpan.className = 'item-msg';
                msgSpan.style.display = 'none';
            }, 300);
        }, 5000);
    } else {
        console.error(`Message span not found for item ${cartItemId}`);
    }
}

function removeItem(cartItemId) {
    fetch('/api/cart/items/remove', {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
        body: JSON.stringify({ id: cartItemId })
    })
        .then(response => {
            const contentType = response.headers.get('Content-Type');
            if (!response.ok) {
                if (contentType && contentType.includes('application/json')) {
                    return response.json().then(errorData => {
                        throw new Error(errorData.message || 'An error occurred while removing the item');
                    });
                } else {
                    return response.text().then(errorText => {
                        throw new Error(errorText || 'An error occurred while removing the item');
                    });
                }
            }
            if (contentType && contentType.includes('application/json')) {
                return response.json();
            } else {
                return response.text();
            }
        })
        .then(data => {
            if (typeof data === 'string') {
                console.log('Item removed successfully:', data);
            } else {
                console.log('Item removed successfully:', data.message || data);
            }
            fetchCart();
            updateCartBadge()
        })
        .catch(error => {
            console.error('Error removing item:', error.message);
        });
}

function finishOrder() {
    const modal = document.getElementById('checkoutModal');
    const cart = JSON.parse(modal.dataset.cartData);
    const paymentMethod = document.getElementById('paymentMethod').value;

    let orderData;
    const isAnonymous = !document.getElementById('deliveryAddress');

    if (!isAnonymous) {
        // Authenticated user
        const deliveryAddressId = document.getElementById('deliveryAddress').value;
        orderData = {
            total: cart.grandTotal,
            addressId: parseInt(deliveryAddressId, 10),
            paymentMethod: paymentMethod,
            cartDTO: cart
        };
    } else {
        // Unauthenticated user
        const deliveryAddressInput = document.getElementById('deliveryAddressAnonymous');
        const emailAddressInput = document.getElementById('emailAddressAnonymous');

        // Client-side validation
        if (!paymentMethod) {
            showCustomAlert('Please select a payment method');
            return;
        }

        if (!deliveryAddressInput || !deliveryAddressInput.value) {
            showCustomAlert('Please enter a delivery address');
            return;
        }

        if (!emailAddressInput || !emailAddressInput.value) {
            showCustomAlert('Please enter an email address');
            return;
        }

        orderData = {
            total: cart.grandTotal,
            anonymousAddress: deliveryAddressInput.value,
            anonymousEmail: emailAddressInput.value,
            paymentMethod: paymentMethod,
            cartDTO: cart
        };
    }
    console.log('Order Data:', orderData);

    fetch('/api/order/post', {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
        body: JSON.stringify(orderData)
    })
        .then(response => {
            if (!response.ok) {
                return response.json().then(errors => { throw errors; });
            }
            return response.json();
        })
        .then(order => {
            window.location.href = `/order?id=${order.orderId}`;
            console.log('Order placed successfully:', order);
        })
        .catch(errors => {
            console.error('Error placing order:', errors);
            if (isAnonymous) {
                if (Array.isArray(errors)) {
                    showCustomAlert(errors.join('\n'));
                } else {
                    showCustomAlert(errors.message || 'An error occurred while placing the order');
                }
            } else {
                console.error('An error occurred while placing the order');
            }
        });
}

function showCustomAlert(message) {
    const alertElement = document.getElementById('custom-alert-cart');
    if (alertElement) {
        document.getElementById('custom-alert-message').textContent = message;
        alertElement.style.display = 'block';
    } else {
        console.error('Custom alert element not found');
    }
}

function closeCustomAlert() {
    const alertElement = document.getElementById('custom-alert-cart');
    if (alertElement) {
        alertElement.style.display = 'none';
    }
}