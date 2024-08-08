document.addEventListener('DOMContentLoaded', () => {
    // Function to make the GET request
    function makeGetRequest(url) {
        return fetch(url)
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
            orderElement.addEventListener('click', () => showOrderDetails(order));

            const createdAt = new Date(order.createdAt).toLocaleString();
            const grandTotal = order.grandTotal;
            const itemCount = order.orderItems.length;

            orderElement.innerHTML = `
        <h3>Order Created: ${createdAt}</h3>
        <p>Grand Total: $${grandTotal}</p>
        <p>Total Items: ${itemCount}</p>
      `;
            orderHistoryContainer.appendChild(orderElement);
        });
    }

    // Function to display the order details in the modal
    function showOrderDetails(order) {
        const modal = document.getElementById('orderHistoryModal');
        const orderCreatedAtElement = document.getElementById('orderCreatedAt');
        const orderPaymentMethodElement = document.getElementById('orderPaymentMethod');
        const orderAddressElement = document.getElementById('orderAddress');
        const orderGrandTotalElement = document.getElementById('orderGrandTotal');
        const orderItemsListElement = document.getElementById('orderItemsList');

        orderCreatedAtElement.textContent = new Date(order.createdAt).toLocaleString();
        orderPaymentMethodElement.textContent = order.paymentMethod;
        orderAddressElement.textContent = order.deliveryAddress;
        orderGrandTotalElement.textContent = `$${order.grandTotal}`;

        orderItemsListElement.innerHTML = '';
        order.orderItems.forEach(item => {
            const listItem = document.createElement('li');
            listItem.classList.add('list-group-item');
            listItem.textContent = `${item.product.name} - Quantity: ${item.quantity} - Price: $${item.product.price}`;
            orderItemsListElement.appendChild(listItem);
        });

        modal.style.display = 'block';
    }

    // Fetch and display the order history
    makeGetRequest('/api/order/get/all')
        .then(data => displayOrderHistory(data))
        .catch(error => console.error('Error fetching order history:', error));

    // Add event listener to close the order details modal
    const modal = document.getElementById('orderHistoryModal');
    const closeBtn = modal.querySelector('.btn-close');
    closeBtn.addEventListener('click', () => {
        modal.style.display = 'none';
    });
});