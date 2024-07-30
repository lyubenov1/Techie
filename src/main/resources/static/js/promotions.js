selectedProduct = null;
fetchTimeout = null;

document.addEventListener('DOMContentLoaded', () => {
    fetchFilteredProducts(currentPage);
});


function fetchProducts() {
    const query = document.getElementById('productName').value;
    const dropdown = document.getElementById('productDropdown');

    fetch(`/api/products/promotion/get?query=${encodeURIComponent(query)}`)
        .then(response => {
            if (!response.ok) {
                return response.text().then(text => {
                    if (response.headers.get('content-type')?.includes('text/html')) {
                        throw new Error('Server returned an HTML error page');
                    } else {
                        throw new Error(text || 'Failed to fetch products');
                    }
                });
            }
            return response.json();
        })
        .then(products => {
            populateDropdown(products, dropdown);
        })
        .catch(error => {
            handleError(error.message);
        });
}

function populateDropdown(products, dropdown) {
    dropdown.innerHTML = ''; // Clear previous options
    products.forEach(product => {
        const option = document.createElement('div');
        option.className = 'dropdown-item';
        option.innerHTML = createProductHTML(product);
        option.addEventListener('click', () => openModal(product));
        dropdown.appendChild(option);
    });
    dropdown.style.display = 'block';
}

function createProductHTML(product) {
    return `
        <div class="product-item">
            <img src="${product.imageUrls[0]}" alt="Product Image" class="product-image">
            <div class="product-details-admin">
                <div class="product-name">${product.name}</div>
                <div class="product-price">Price: ${product.originalPrice.toFixed(2)} $</div>
            </div>
        </div>
    `;
}

function openModal(product) {
    closeDropdown();

    selectedProduct = product;
    document.getElementById('productImage').src = product.imageUrls[0];
    document.getElementById('productNameModal').innerText = product.name;
    document.getElementById('originalPrice').innerText = `${product.originalPrice.toFixed(2)} $`;

    document.getElementById('discountInput').value = product.discount || '';

    var modal = new bootstrap.Modal(document.getElementById('promotionsModal'));
    modal.show();
}


function applyDiscount() {
    if (!selectedProduct) return;

    // Retrieve the discount value from the input field
    const discountValue = document.getElementById('discountInput').value;
    // Validate the discount value
    if (discountValue === '' || isNaN(discountValue) || discountValue < 0 || discountValue > 100) {
        handleErrorModal('Please enter a valid discount percentage between 0 and 100.');
        return;
    }
    // Attach the discount value to the selected product
    selectedProduct.discount = parseFloat(discountValue);

    fetch('/api/products/promotion/patch', {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
        body: JSON.stringify(selectedProduct),
    })
        .then(response => {
            if (!response.ok) {
                return response.text().then(text => {
                    if (response.headers.get('content-type')?.includes('text/html')) {
                        throw new Error('Server returned an HTML error page');
                    } else {
                        throw new Error(text || 'Failed to apply discount');
                    }
                });
            }
            return response.text();
        })
        .then(data => {
            console.log('Discount applied successfully:', data);
            handleSuccess('Discount applied successfully');
            fetchFilteredProducts(currentPage); // Refresh the list
            closeModal();
        })
        .catch(error => {
            console.error('Error applying discount:', error);
            handleErrorModal(error.message);
        });
}

function closeModal() {
    var modal = bootstrap.Modal.getInstance(document.getElementById('promotionsModal'));
    if (modal) {
        modal.hide();
    }
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
    const dropdown = document.getElementById('productDropdown');
    dropdown.style.display = 'none';
}

document.addEventListener('DOMContentLoaded', () => {
    const productNameInput = document.getElementById('productName');
    productNameInput.addEventListener('focus', fetchProducts);
    productNameInput.addEventListener('input', fetchProducts);

    document.addEventListener('click', (event) => {
        const dropdown = document.getElementById('productDropdown');
        const productNameInput = document.getElementById('productName');
        if (!dropdown.contains(event.target) && event.target !== productNameInput) {
            dropdown.style.display = 'none';
        }
    });
});

currentPage = 0;
pageSize = 6;

function fetchFilteredProducts(page) {
    const url = `/api/products/discount/get?p=${page}&s=${pageSize}`;

    fetch(url)
        .then(response => {
            if (!response.ok) {
                throw new Error('Failed to fetch products');
            }
            return response.json();
        })
        .then(data => {
            displayProducts(data.content, data.number, data.totalPages, data.totalElements);
        })
        .catch(error => {
            console.error('Error:', error);
            handleError(error.message);
        });
}

function displayProducts(products, currentPage, totalPages, totalProducts) {
    const listingDiv = document.getElementById('product-listing');
    listingDiv.innerHTML = ''; // Clear existing content

    const headerContainer = document.createElement('div');
    headerContainer.className = 'header-container';
    listingDiv.appendChild(headerContainer);

    const header = document.createElement('h3');
    header.textContent = 'List of Products';
    headerContainer.appendChild(header);

    const paginationInfo = document.createElement('span');
    paginationInfo.id = 'paginationInfo';
    paginationInfo.className = 'pagination-info';
    headerContainer.appendChild(paginationInfo);

    const container = document.createElement('div');
    container.id = 'product-container';
    container.className = 'product-container';
    listingDiv.appendChild(container);

    products.forEach(product => {
        const productRow = document.createElement('div');
        productRow.className = 'product-row';
        productRow.innerHTML = `
            <div class="product-info">
                <span class="img"><img src="${product.imageUrls[0]}" alt="Product Image" class="img-thumbnail"></span>
                <span class="name">${product.name}</span>
                <span class="price">Price: $${product.originalPrice.toFixed(2)}</span>
                <span class="product-discount">Discount: ${product.discount.toFixed(2)} %</span>
                <span class="product-discounted-price">Discounted price: ${product.discountedPrice.toFixed(2)} $</span>
            </div>
            <div class="discount-btn"><button onclick="removeDiscount(${product.id})">Remove discount</button></div>
        `;
        container.appendChild(productRow);
    });

    const paginationDiv = document.createElement('div');
    paginationDiv.id = 'productPagination';
    paginationDiv.className = 'product-pagination';
    listingDiv.appendChild(paginationDiv);

    createPagination(currentPage, totalPages, totalProducts);
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
    messageElement.className = type === 'error' ? 'admin-error-message' : 'admin-success-message';
    messageElement.style.display = 'block';
    setTimeout(() => {
        messageElement.style.display = 'none';
    }, 5000);
}

async function removeDiscount(productId) {
    try {
        const response = await fetch(`/api/products/promotion/delete?productId=${productId}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': csrfToken
            }
        });

        const contentType = response.headers.get('content-type');
        const data = contentType.includes('application/json') ? await response.json() : await response.text();

        if (!response.ok) {
            if (contentType.includes('text/html')) {
                throw new Error('Server returned an HTML error page');
            } else {
                throw new Error(data.message || 'Failed to remove discount');
            }
        }

        console.log('Successfully removed discount from product: ', data);
        handleSuccess('Discount removed successfully');
        fetchFilteredProducts(currentPage); // Refresh the list
    } catch (error) {
        console.error('Error removing discount from product:', error);
        handleError(error.message);
    }
}


function createPagination(currentPage, totalPages, totalProducts) {
    const paginationDiv = document.getElementById('productPagination');
    paginationDiv.innerHTML = ''; // Clear existing content

    const prevButton = document.createElement('button');
    prevButton.textContent = '<';
    prevButton.onclick = () => {
        if (currentPage > 0) {
            fetchFilteredProducts(currentPage - 1);
        }
    };
    prevButton.disabled = currentPage === 0;

    const nextButton = document.createElement('button');
    nextButton.textContent = '>';
    nextButton.onclick = () => {
        if (currentPage < totalPages - 1) {
            fetchFilteredProducts(currentPage + 1);
        }
    };
    nextButton.disabled = currentPage === totalPages - 1;

    paginationDiv.appendChild(prevButton);
    paginationDiv.appendChild(nextButton);

    // Update pagination info
    const start = currentPage * pageSize + 1;
    const end = Math.min((currentPage + 1) * pageSize, totalProducts);
    const paginationInfo = document.getElementById('paginationInfo');
    paginationInfo.textContent = `${start}-${end} out of ${totalProducts}`;
}