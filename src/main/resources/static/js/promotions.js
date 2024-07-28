csrfToken = document.getElementById('csrf-token').value;
selectedProduct = null;
fetchTimeout = null;
currentPageType = 'promotion';

// Configuration object
pageConfig = {
    promotion: {
        fetchUrl: '/api/products/promotion/get',
        onProductSelect: openModal
    }
};

document.addEventListener('DOMContentLoaded', () => {
    fetchFilteredProducts();
});

function fetchFilteredProducts() {
    fetchFilteredProductsWithPagination(currentPage);
}

function fetchProducts() {
    const query = document.getElementById('productName').value;
    const dropdown = document.getElementById('productDropdown');

    if (fetchTimeout) {
        clearTimeout(fetchTimeout);
    }

    fetchTimeout = setTimeout(() => {
        fetch(`${pageConfig[currentPageType].fetchUrl}?query=${encodeURIComponent(query)}`)
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
    }, 300);
}

function populateDropdown(products, dropdown) {
    dropdown.innerHTML = ''; // Clear previous options
    products.forEach(product => {
        const option = document.createElement('div');
        option.className = 'dropdown-item';
        option.innerHTML = createProductHTML(product);
        option.addEventListener('click', () => pageConfig[currentPageType].onProductSelect(product));
        dropdown.appendChild(option);
    });
    dropdown.style.display = 'block';
}

function createProductHTML(product) {
    return `
        <div class="product-item">
            <img src="${product.imageUrls[0]}" alt="Product Image" class="product-image">
            <div class="product-details">
                <div class="product-name">${product.name}</div>
                <div class="product-price">Price: ${product.price.toFixed(2)} $</div>
            </div>
        </div>
    `;
}

function openModal(product) {
    closeDropdown();

    selectedProduct = product;
    document.getElementById('productImage').src = product.imageUrls[0];
    document.getElementById('productNameModal').innerText = product.name;
    document.getElementById('originalPrice').innerText = `${product.price.toFixed(2)} $`;
    document.getElementById('discountPercentage').value = '';

    var modal = new bootstrap.Modal(document.getElementById('promotionsModal'));
    modal.show();
}

function applyDiscount() {
    if (!selectedProduct) return;

    selectedProduct.discount = document.getElementById('discountPercentage').value;

    fetch('/api/products/promotion/post', {
        method: 'POST',
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
            fetchFilteredProducts(); // Refresh the list
        })
        .catch(error => {
            console.error('Error applying discount:', error);
            handleErrorModal(error.message);
        });
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

function fetchFilteredProductsWithPagination(page) {
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
                <span class="img"><img src="${product.image}" alt="Product Image" class="img-thumbnail"></span>
                <span class="name">${product.name}</span>
                <span class="price">Price: $${product.price.toFixed(2)}</span>
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
        const response = await fetch(`/api/products/discount/delete?productId=${productId}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': csrfToken
            }
        });

        const data = await response.text();

        if (!response.ok) {
            throw new Error(data);
        }

        console.log('Successfully removed discount from product: ', data);
        handleSuccess(data);
        fetchFilteredProducts() // Refresh the list
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
            fetchFilteredProductsWithPagination(currentPage - 1);
        }
    };
    prevButton.disabled = currentPage === 0;

    const nextButton = document.createElement('button');
    nextButton.textContent = '>';
    nextButton.onclick = () => {
        if (currentPage < totalPages - 1) {
            fetchFilteredProductsWithPagination(currentPage + 1);
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