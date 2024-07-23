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

                if (wishlists.length > 0) {
                    if (isNavigatedFromAnotherPage()) {
                        // User came from another page, show the Main wishlist
                        showWishlist(wishlists[0]);
                    } else {
                        // User refreshed the page or navigated within the wishlist page
                        // We'll show the last viewed wishlist or the first one if there's no last viewed
                        const lastViewedWishlistId = localStorage.getItem('lastViewedWishlistId');
                        const wishlistToShow = lastViewedWishlistId
                            ? wishlists.find(w => w.id.toString() === lastViewedWishlistId)
                            : wishlists[0];
                        showWishlist(wishlistToShow || wishlists[0]);
                    }
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
        localStorage.setItem('lastViewedWishlistId', wishlist.id.toString());

        wishlistNameElem.textContent = wishlist.name;
        wishlistSizeElem.textContent = `${wishlist.products.length} Products`;

        // Clear previous products
        wishlistProductsDiv.innerHTML = '';

        // Clear the empty container
        emptyContainer.innerHTML = '';

        if (wishlist.products.length > 0) {
            // Show the Delete All button
            document.getElementById('wishlistDeleteAll').style.display = 'inline-block';

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
                            <div class="rate-rating">
                                 <!-- Empty stars as background -->
                                 <div class="stars-outer">
                                     <div class="stars-inner"></div>
                                 </div>
                                 <span class="stars-rating wishlist"></span>
                            </div>
                            <div class="delete-icon">
                                 <span class="remove-product" data-product-id="${product.id}">
                                     <i class="far fa-trash-can fa-lg text-white"></i>
                                 </span>
                            </div>
                        </div>
                        <div class="card-title">${product.name}</div>
                        <div class="card-text">${product.originalPrice.toFixed(2)} $</div>
                    </div>
                </div>
            `;
                // Set the width of stars-inner based on averageRating
                const starsInner = productCard.querySelector('.stars-inner');
                starsInner.style.width = (product.averageRating / 5.0 * 100) + '%';

                // Set the text of stars-rating based on averageRating
                const starsRating = productCard.querySelector('.stars-rating');
                starsRating.textContent = `(${product.averageRating})`;
                wishlistProductsDiv.appendChild(productCard);
            });

            // Event listener for the trash-can icon
            document.querySelectorAll('.remove-product').forEach(icon => {
                icon.addEventListener('click', function(event) {
                    event.preventDefault(); // Prevent default anchor behavior
                    event.stopPropagation(); // Stop event from bubbling up
                    const productId = this.dataset.productId;
                    deleteProductFromWishlist(wishlist.id, productId);
                });

                // Enlarge the icon on hover
                icon.addEventListener('mouseover', function() {
                    this.style.transform = 'scale(1.2)';
                });

                icon.addEventListener('mouseout', function() {
                    this.style.transform = 'scale(1)';
                });
            });
        }
        else {
            // Hide the Delete All button
            document.getElementById('wishlistDeleteAll').style.display = 'none';

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

        document.getElementById('wishlistDeleteAll').addEventListener('click', function() {
            const wishlistId = wishlist.id;
            const csrfToken = document.getElementById('csrf-token').value;

            fetch(`/api/wishlist/removeAll/${wishlistId}`, {
                method: 'DELETE',
                headers: {
                    'Content-Type': 'application/json',
                    'X-CSRF-TOKEN': csrfToken
                }
            })
                .then(response => {
                    if (!response.ok) {
                        return response.text().then(text => { throw new Error(text) });
                    }
                    window.location.reload();
                    return response.text();
                })
                .then(data => {
                    console.log(data);
                })
                .catch(error => {
                    console.error('Error:', error);
                    alert("An error occurred while removing all products from the wishlist: " + error.message);
                });
        });


        const editButton = document.getElementById('wishlistEditButton');

        // If the selected wishlist is the main one, hide the 'Edit' button.
        if (wishlist.name !== "Main wishlist") {
            editButton.style.display = 'inline-block';
        } else {
            editButton.style.display = 'none';
        }

        // Set up the edit button to trigger the modal with the current wishlist details
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

    function deleteProductFromWishlist(wishlistId, productId) {
        const csrfToken = document.getElementById('csrf-token').value;

        fetch(`/api/wishlist/remove/${wishlistId}/${productId}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': csrfToken
            }
        })
            .then(response => {
                return response.text().then(message => {
                    if (response.ok) {
                        console.log('Product removed successfully:', message);
                        // Reload the page
                        window.location.reload();
                    } else {
                        throw new Error(message || 'Failed to remove product from wishlist');
                    }
                });
            })
            .catch(error => {
                console.error('Error deleting product:', error.message);
            });
    }

    function isNavigatedFromAnotherPage() {
        return document.referrer !== '' &&
            !document.referrer.includes('/users/profile/wishlist');
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
