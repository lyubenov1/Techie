const myModal = document.getElementById('createWishlistModal');
const myInput = document.getElementById('wishlistName');

myModal.addEventListener('shown.bs.modal', () => {
    myInput.focus();
});


document.addEventListener('DOMContentLoaded', () => {

    function fetchAndPopulateWishlists() {
        fetch('/api/wishlist/get')
            .then(response => response.json())
            .then(wishlists => {
                const wishlistItemsDiv = document.querySelector('.wishlist-items');
                wishlistItemsDiv.innerHTML = ''; // Clear existing content

                wishlists.forEach(wishlist => {
                    const wishlistItem = createWishlistItem(wishlist);
                    wishlistItemsDiv.appendChild(wishlistItem);
                });

                // Add "Create a new wishlist" button at the end
                const newWishlistItem = document.createElement('div');
                newWishlistItem.classList.add('wishlist-item', 'new-wishlist');

                const createWishlistBtn = document.createElement('button');
                createWishlistBtn.id = 'create-wishlist-btn';
                createWishlistBtn.classList.add('btn', 'btn-primary');
                createWishlistBtn.type = 'button';
                createWishlistBtn.dataset.bsToggle = 'modal';
                createWishlistBtn.dataset.bsTarget = '#createWishlistModal';

                const plusSpan = document.createElement('span');
                plusSpan.textContent = '+';

                const createTextSpan = document.createElement('span');
                createTextSpan.classList.add('wishlist-item-text', 'create');
                createTextSpan.textContent = 'Create a new wishlist';

                createWishlistBtn.appendChild(plusSpan);
                createWishlistBtn.appendChild(createTextSpan);

                newWishlistItem.appendChild(createWishlistBtn);
                wishlistItemsDiv.appendChild(newWishlistItem);

                // Set default selected wishlist (first one)
                if (wishlists.length > 0) {
                    showWishlist(wishlists[0]);
                }
            })
            .catch(error => {
                console.error('Error fetching wishlists:', error);
            });
    }

    function createWishlistItem(wishlist) {
        const wishlistItem = document.createElement('div');
        wishlistItem.classList.add('wishlist-item', 'clickable');
        wishlistItem.setAttribute('data-wishlist-name', wishlist.name);
        wishlistItem.setAttribute('data-wishlist-size', wishlist.products.length);
        wishlistItem.onclick = function() {
            showWishlist(wishlist);
        };

        const wishlistItemContent = document.createElement('div');
        wishlistItemContent.classList.add('wishlist-item-content');

        const wishlistItemText = document.createElement('div');
        wishlistItemText.classList.add('wishlist-item-text');
        wishlistItemText.textContent = wishlist.name;

        const wishlistItemSize = document.createElement('p');
        wishlistItemSize.textContent = wishlist.products.length + ' products';

        wishlistItemContent.appendChild(wishlistItemText);
        wishlistItemContent.appendChild(wishlistItemSize);

        wishlistItem.appendChild(wishlistItemContent);

        return wishlistItem;
    }


    function showWishlist(wishlist) {
        // Update the wishlist-details section with the passed wishlist object
        const wishlistNameElem = document.getElementById('wishlist-name');
        const wishlistSizeElem = document.getElementById('wishlist-size');
        const wishlistProductsDiv = document.getElementById('wishlist-products');
        const emptyContainer = document.querySelector('.empty-container');

        wishlistNameElem.textContent = wishlist.name;
        wishlistSizeElem.textContent = `${wishlist.products.length} Products`;

        // Clear previous products
        wishlistProductsDiv.innerHTML = '';

        // Clear the empty container
        emptyContainer.innerHTML = '';

        if (wishlist.products.length > 0) {
            wishlist.products.forEach(product => {
                const productCard = document.createElement('a');
                productCard.href = product.url;
                productCard.classList.add('card');
                productCard.style.width = '18rem';

                // Construct the product card HTML here
                productCard.innerHTML = `
                <div class="image-container">
                    <img src="${product.imageUrl}" alt="Product Image" class="card-img-top">
                </div>
                <div class="card-body">
                    <div class="card-body-wrapper">
                        <div class="card-icon-box">
                            <div class="rate">
                                <!-- Rating stars here -->
                            </div>
                            <div class="wishlist-and-shopping-cart">
                                <span class="add-to-wishlist">
                                    <i class="far fa-heart fa-md text-white"></i>
                                </span>
                                <span class="shopping-cart">
                                    <i class="fas fa-shopping-cart fa-md text-white"></i>
                                </span>
                            </div>
                        </div>
                        <div class="card-title">${product.name}</div>
                        <div class="card-text">${product.originalPrice.toFixed(2)} $</div>
                    </div>
                </div>
            `;

                wishlistProductsDiv.appendChild(productCard);
            });
        } else {
            // Handle case when no products are present in the wishlist
            const imageContainer = document.createElement('div');
            imageContainer.classList.add('image-container');

            const emptyBasketImage = document.createElement('img');
            emptyBasketImage.src = '/images/empty_basket.png';
            emptyBasketImage.alt = 'Dummy Icon';
            emptyBasketImage.width = 200; // px
            emptyBasketImage.height = 200;
            imageContainer.appendChild(emptyBasketImage);

            const emptyText = document.createElement('p');
            emptyText.textContent = "You haven't added products to this wishlist yet.";

            emptyContainer.appendChild(imageContainer);
            emptyContainer.appendChild(emptyText);

            wishlistProductsDiv.appendChild(emptyContainer);
        }

        // Set up the edit button to trigger the modal with the current wishlist details
        const editButton = document.querySelector('.wishlist-actions button');
        editButton.onclick = function() {
            openEditModal(wishlist);
        };
    }

    function openEditModal(wishlist) {
        const editWishlistModal = new bootstrap.Modal(document.getElementById('editWishlistModal'), {});
        const editWishlistNameInput = document.getElementById('editWishlistName');
        const wishlistIdInput = document.getElementById('editWishlistId');

        // Populate the modal with the wishlist details
        editWishlistNameInput.value = wishlist.name;
        wishlistIdInput.value = wishlist.id;

        // Open the modal
        editWishlistModal.show();
    }

    fetchAndPopulateWishlists();
});
