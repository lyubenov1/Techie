document.addEventListener('DOMContentLoaded', () => {
    // Function to make the GET request
    function fetchOrderHistory() {
        return fetch('/api/order/get/all')
            .then(response => response.json())
            .catch(error => console.error('Error:', error));
    }

    // Function to display the order history
    function displayOrderHistory(orders) {
        const orderHistoryContainer = document.querySelector('.order-history-list');
        orderHistoryContainer.innerHTML = '';

        orders.forEach(order => {
            const orderElement = document.createElement('div');
            orderElement.classList.add('order-history-item');
            orderElement.dataset.orderId = order.orderId;

            const createdAt = order.createdAt;
            const grandTotal = order.grandTotal;
            const orderId = order.orderId;
            const itemCount = order.orderItems.reduce((sum, item) => sum + item.quantity, 0);

            orderElement.innerHTML = `
            <p>Order ID: <strong>${orderId}</strong></p>
            <p>Created: <strong>${createdAt}</strong></p>
            <p>Grand Total: <strong>$${grandTotal}</strong></p>
            <p>Total Items: <strong>${itemCount}</strong></p>
        `;

            orderHistoryContainer.appendChild(orderElement);
        });

        // Add event listener to the order history container
        orderHistoryContainer.addEventListener('click', (event) => {
            if (event.target.closest('.order-history-item')) {
                const orderId = event.target.closest('.order-history-item').dataset.orderId;
                const order = orders.find(o => o.orderId == orderId); // Use == to compare string and number
                if (order) {
                    showOrderDetails(order);
                } else {
                    console.error('Order not found!');
                }
            }
        });

    }

    // Function to display the order details in the modal
    function showOrderDetails(order) {
        const modalElement = document.getElementById('orderHistoryModal');
        const orderCreatedAtElement = document.getElementById('orderCreatedAt');
        const orderPaymentMethodElement = document.getElementById('orderPaymentMethod');
        const orderAddressElement = document.getElementById('orderAddress');
        const orderGrandTotalElement = document.getElementById('orderGrandTotal');
        const orderItemsListElement = document.getElementById('orderItemsList');

        orderCreatedAtElement.textContent = order.createdAt;
        orderPaymentMethodElement.textContent = order.paymentMethod;
        orderAddressElement.textContent = order.address;
        orderGrandTotalElement.textContent = `$${order.grandTotal}`;

        orderItemsListElement.innerHTML = '';
        order.orderItems.forEach(item => {
            const listItem = document.createElement('li');
            listItem.classList.add('list-group-item');

            // Set the inner HTML of the list item to have each attribute on a new line with the values in bold
            listItem.innerHTML = `
                 <div><strong>Product Name:</strong> ${item.product.name}</div>
                 <div><strong>Quantity:</strong> ${item.quantity}</div>
                 <div><strong>Total Price:</strong> $${item.totalPrice}</div>
            `;

            orderItemsListElement.appendChild(listItem);
        });


        // Use Bootstrap's modal show method
        const modal = new bootstrap.Modal(modalElement);
        modal.show();
    }

    // Fetch and display the order history
    fetchOrderHistory()
        .then(data => displayOrderHistory(data))
        .catch(error => console.error('Error fetching order history:', error));

    // Add event listener to close the order details modal
    const modal = document.getElementById('orderHistoryModal');
    const closeBtn = modal.querySelector('.btn-close');
    closeBtn.addEventListener('click', () => {
        modal.style.display = 'none';
    });
});