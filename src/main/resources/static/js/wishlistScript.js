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
                productCard.href = '/products/' + product.categoryName.toLowerCase() + '/' + product.url;
                productCard.classList.add('card');
                productCard.style.width = '18rem';

                // Construct the product card HTML here
                productCard.innerHTML = `
                <div class="image-container">
                    <img src="${product.imageUrls[0]}" alt="Product Image" class="card-img-top">
                </div>
                <div class="card-body">
                    <div class="card-body-wrapper">
                        <div class="card-icon-box">
                            <div class="rate">
                                <input type="radio" id="star5_${product.id}" name="rate_${product.id}" value="5" />
                                <label for="star5_${product.id}" title="text">5 stars</label>
                                <input type="radio" id="star4_${product.id}" name="rate_${product.id}" value="4" />
                                <label for="star4_${product.id}" title="text">4 stars</label>
                                <input type="radio" id="star3_${product.id}" name="rate_${product.id}" value="3" />
                                <label for="star3_${product.id}" title="text">3 stars</label>
                                <input type="radio" id="star2_${product.id}" name="rate_${product.id}" value="2" />
                                <label for="star2_${product.id}" title="text">2 stars</label>
                                <input type="radio" id="star1_${product.id}" name="rate_${product.id}" value="1" />
                                <label for="star1_${product.id}" title="text">1 star</label>
                            </div>
                            <div class="delete-icon">
                                 <span class="remove-product">
                                     <i class="far fa-trash-can fa-lg text-white"></i>
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
        }

        // Set up the edit button to trigger the modal with the current wishlist details
        const editButton = document.querySelector('.wishlist-actions button');
        editButton.onclick = function() {
            openEditModal(wishlist);
        };

        document.getElementById('deleteWishlistBtn').addEventListener('click', function() {
            // Copy the wishlist ID from the edit form to the delete form
            document.getElementById('deleteWishlistId').value = document.getElementById('editWishlistId').value;
            // Submit the delete form
            document.getElementById('deleteWishlistForm').submit();
        });
    }

    function openEditModal(wishlist) {
        const editWishlistModal = new bootstrap.Modal(document.getElementById('editWishlistModal'), {});
        const editWishlistNameInput = document.getElementById('editWishlistName');
        const wishlistId = document.getElementById('editWishlistId');

        // Populate the modal with the wishlist details
        editWishlistNameInput.value = wishlist.name;
        wishlistId.value = wishlist.id;

        // Open the modal
        editWishlistModal.show();
    }

    fetchAndPopulateWishlists();
});
