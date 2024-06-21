document.addEventListener('DOMContentLoaded', function() {
    var dropdownToggle = document.getElementById('navbarDropdown');
    var barsIcon = document.querySelector('.bars-icon');
    var closeIcon = document.querySelector('.close-icon');
    var dropdownMenu = document.querySelector('.dropdown-menu');

    // Function to update the state of the icons
    function updateIcons() {
        if (dropdownMenu.classList.contains('show')) {
            barsIcon.classList.add('d-none');
            closeIcon.classList.remove('d-none');
        } else {
            barsIcon.classList.remove('d-none');
            closeIcon.classList.add('d-none');
        }
    }

    // Update the icons state on page load
    updateIcons();

    // Add click event listener to the dropdown toggle
    dropdownToggle.addEventListener('click', function() {
        // Toggle the visibility of the dropdown menu
        updateIcons();
    });

    // Add click event listener to the document
    document.addEventListener('click', function(event) {
        // Check if the click event occurred outside the dropdown toggle
        if (!dropdownToggle.contains(event.target)) {
            // Ensure the bars icon is visible when a click occurs outside the dropdown toggle
            barsIcon.classList.remove('d-none');
            closeIcon.classList.add('d-none');
        }
    });

    // Listen for show.bs.dropdown and hide.bs.dropdown events on the dropdown menu
    dropdownMenu.addEventListener('show.bs.dropdown', function() {
        // Ensure the close icon is visible when the dropdown menu is shown
        barsIcon.classList.add('d-none');
        closeIcon.classList.remove('d-none');
    });

    dropdownMenu.addEventListener('hide.bs.dropdown', function() {
        // Ensure the bars icon is visible when the dropdown menu is hidden
        barsIcon.classList.remove('d-none');
        closeIcon.classList.add('d-none');
    });

    var profileIcon = document.getElementById('profile-dropdown');
    var profileDropdownMenu = document.getElementById('profile-dropdown-menu');

    profileIcon.addEventListener('mouseover', function () {
        // Show the profile dropdown menu
        profileDropdownMenu.style.display = 'block';
    });
    profileIcon.addEventListener('mouseout', function () {
        // Hide the profile dropdown menu
        profileDropdownMenu.style.display = 'none';
    });

    // Social media buttons (of footer) to pop up an alert onclick.
    const showAlert = (socialMedia) => {
        const alertPlaceholder = document.getElementById('alertPlaceholder');
        let message = '';

        switch (socialMedia) {
            case 'Facebook':
                message = "We don't have Facebook yet. Check out our LinkedIn and GitHub!";
                break;
            case 'Twitter':
                message = "We don't have Twitter yet. Check out our LinkedIn and GitHub!";
                break;
            case 'Google':
                message = "We haven't registered on Google yet. Check out our LinkedIn and GitHub!";
                break;
            case 'Instagram':
                message = "We don't have an Instagram yet. Check out our LinkedIn and GitHub!";
                break;
            default:
                message = "We don't have information about this social media platform yet. Check out our LinkedIn and GitHub!";
        }

        const existingAlert = alertPlaceholder.querySelector('.alert');

        // Remove the existing alert if it exists
        if (existingAlert) {
            existingAlert.remove();
        }

        const alertDiv = document.createElement('div');
        alertDiv.classList.add('alert', 'alert-warning', 'alert-dismissible', 'fade', 'show');
        alertDiv.setAttribute('role', 'alert');
        alertDiv.innerHTML = `
        ${message}
        <button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button>`;
        alertPlaceholder.appendChild(alertDiv);

        // Automatically remove the alert after 5 seconds
        setTimeout(() => {
            alertDiv.remove();
        }, 5000);
    };

    // Social media buttons (of footer) to pop up an alert onclick.
    const socialMediaButtons = document.querySelectorAll('.btn-floating');

    socialMediaButtons.forEach(button => {
        button.addEventListener('click', function() {
            const socialMedia = this.dataset.socialMedia;
            showAlert(socialMedia);
        });
    });
});



document.addEventListener('DOMContentLoaded', function() {
    function fetchCategories() {
        fetch('/api/categories')
            .then(response => response.json())
            .then(data => {
                const dropdownMenu = document.querySelector('.dropdown-menu');

                data.forEach(category => {
                    const categoryItem = document.createElement('li');
                    categoryItem.classList.add('dropdown-item');

                    const categoryLink = document.createElement('a');
                    categoryLink.href = category.url;
                    categoryLink.textContent = category.name;
                    categoryItem.appendChild(categoryLink);

                    if (category.children && category.children.length > 0) {
                        const submenu = document.createElement('ul');
                        submenu.classList.add('dropdown-submenu');
                        submenu.style.display = 'none'; // Initially hide submenu

                        category.children.forEach(child => {
                            const childItem = document.createElement('li');
                            const childLink = document.createElement('a');
                            childLink.classList.add('dropdown-item');
                            childLink.href = child.url;
                            childLink.textContent = child.name;
                            childItem.appendChild(childLink);
                            submenu.appendChild(childItem);
                        });

                        categoryItem.appendChild(submenu);

                        // Event listeners for different screen sizes
                        function addEventListeners() {
                            const screenWidth = window.innerWidth;

                            if (screenWidth <= 992) {
                                // Remove hover event listeners
                                categoryItem.removeEventListener('mouseover', showSubmenu);
                                categoryItem.removeEventListener('mouseout', hideSubmenu);
                                // Add click event listener
                                categoryItem.addEventListener('click', toggleSubmenu);
                                // Prevent default link behavior for parent categories with subcategories
                                categoryLink.removeAttribute('href');
                            } else {
                                // Remove click event listener
                                categoryItem.removeEventListener('click', toggleSubmenu);
                                // Add hover event listeners
                                categoryItem.addEventListener('mouseover', showSubmenu);
                                categoryItem.addEventListener('mouseout', hideSubmenu);
                                // Re-add href attribute if it doesn't exist
                                categoryLink.href = category.url;
                            }
                        }

                        function showSubmenu() {
                            submenu.style.display = 'block';
                        }

                        function hideSubmenu(event) {
                            if (!event.relatedTarget || !submenu.contains(event.relatedTarget)) {
                                submenu.style.display = 'none';
                            }
                        }

                        function toggleSubmenu(event) {
                            event.stopPropagation();
                            submenu.style.display = submenu.style.display === 'none' ? 'block' : 'none';
                        }

                        // Initial setup
                        addEventListeners();

                        // Update event listeners on window resize
                        window.addEventListener('resize', addEventListeners);
                    }

                    dropdownMenu.appendChild(categoryItem);
                });
            })
            .catch(error => console.error('Error fetching categories:', error));
    }


    fetchCategories();
});




document.addEventListener('DOMContentLoaded', (event) => {
    const filterSections = document.querySelectorAll('.filter-section');

    filterSections.forEach(section => {
        const scrollspy = section.querySelector('.custom-scrollspy');
        const searchContainer = section.querySelector('.search-container');

        function checkScrollable() {
            if (scrollspy.scrollHeight > scrollspy.clientHeight) {
                searchContainer.style.display = 'block';
            } else {
                searchContainer.style.display = 'none';
            }
        }

        function highlightActiveItem() {
            const items = scrollspy.querySelectorAll('li');
            const scrollTop = scrollspy.scrollTop;
            const itemHeight = items[0].offsetHeight;

            items.forEach((item, index) => {
                if (scrollTop >= index * itemHeight && scrollTop < (index + 1) * itemHeight) {
                    item.classList.add('active');
                } else {
                    item.classList.remove('active');
                }
            });
        }

        // Check if scrollable on load
        checkScrollable();

        // Recheck on window resize
        window.addEventListener('resize', checkScrollable);

        scrollspy.addEventListener('scroll', highlightActiveItem);
        highlightActiveItem();

        // Implement search functionality
        const searchInput = searchContainer.querySelector('input');
        searchInput.addEventListener('input', function() {
            const filter = this.value.toLowerCase();
            const items = scrollspy.querySelectorAll('li');

            items.forEach(item => {
                const text = item.textContent.toLowerCase();
                if (text.includes(filter)) {
                    item.style.display = '';
                } else {
                    item.style.display = 'none';
                }
            });
        });
    });
});




document.addEventListener('DOMContentLoaded', function () {
    var accordionElement = document.querySelector('.sidebar-products');
    var filterContainer = document.querySelector('#filterContainer');

    function setupAccordion() {
        var viewportWidth = window.innerWidth;

        if (viewportWidth < 768) {
            // Initialize Bootstrap accordion for sidebar on smaller screens
            if (!accordionElement.classList.contains('accordion')) {
                accordionElement.classList.add('accordion');
                var headingHtml = '<h2 class="accordion-header" id="headingFilters">';
                headingHtml += '<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFilters" aria-expanded="false" aria-controls="collapseFilters">';
                headingHtml += 'Filters</button></h2>';

                var bodyHtml = '<div id="collapseFilters" class="accordion-collapse collapse" aria-labelledby="headingFilters" data-bs-parent=".accordion">';
                bodyHtml += '<div class="accordion-body">' + filterContainer.innerHTML + '</div></div>';

                accordionElement.innerHTML = '<div class="accordion-item">' + headingHtml + bodyHtml + '</div>';
            }
        } else {
            if (accordionElement.classList.contains('accordion')) {
                accordionElement.classList.remove('accordion');
                var accordionBody = document.querySelector('.accordion-body');
                if (accordionBody) {
                    filterContainer.innerHTML = accordionBody.innerHTML;
                    accordionElement.innerHTML = filterContainer.outerHTML;
                }
            }
        }
    }

    setupAccordion(); // Call setupAccordion initially

    // Call setupAccordion on window resize to adjust behavior dynamically
    window.addEventListener('resize', function () {
        setupAccordion();
    });

    // Debounce function to limit the rate of fetchFilteredProducts calls
    function debounce(func, delay) {
        let debounceTimer;
        return function () {
            clearTimeout(debounceTimer);
            debounceTimer = setTimeout(() => func.apply(this, arguments), delay);
        };
    }

    const debounceFetchFilteredProducts = debounce(fetchFilteredProducts, 300);

    document.addEventListener('change', function (event) {
        if (event.target && event.target.matches('.sidebar-products input[type="checkbox"]')) {
            debounceFetchFilteredProducts();
        }
    });

    function fetchFilteredProducts() {
        const filters = {};
        const checkboxes = document.querySelectorAll('.sidebar-products input[type="checkbox"]:checked');

        checkboxes.forEach(function(checkbox) {
            const key = checkbox.getAttribute('name');
            const value = checkbox.value;
            if (!filters[key]) {
                filters[key] = [];
            }
            filters[key].push(value);
        });

        const categoryName = document.getElementById('categoryName').value;

        const queryString = Object.keys(filters).map(key => {
            return encodeURIComponent(key) + '=' + encodeURIComponent(filters[key].join(','));
        }).join('&');

        // Store filters in sessionStorage
        sessionStorage.setItem('filters', JSON.stringify(filters));

        const userUrl = `/products/${categoryName.toLowerCase()}?${queryString}`;

        // Use pushState to update the URL without reloading
        history.pushState({ filters }, null, userUrl);

        // Refresh the page to reload with updated filters
        window.location.reload();
    }

    function fetchProducts(url) {
        fetch(url)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                updateProductList(data.content);
                createPagination(data.page, data.totalPages);
            })
            .catch(error => {
                console.error('Error fetching products:', error);
            });
    }


    function checkAndClearFilters() {
        const currentUrl = window.location.pathname;
        const storedFilters = sessionStorage.getItem('filters');

        if (currentUrl.startsWith('/products/') && !window.location.search && storedFilters) {
            // Clear filters from sessionStorage
            sessionStorage.removeItem('filters');

            // Clear checkboxes
            const checkboxes = document.querySelectorAll('.sidebar-products input[type="checkbox"]:checked');
            checkboxes.forEach(checkbox => checkbox.checked = false);

            // Update the URL to remove query parameters
            history.replaceState(null, '', currentUrl);

            console.log('Filters cleared');

            const categoryName = document.getElementById('categoryName').value;
            fetchProducts(`/api/categories/products/${categoryName}`);
        }
    }

    // Call this function when the page loads
    window.addEventListener('load', checkAndClearFilters);

    // Add event listener for popstate to handle back/forward navigation
    window.addEventListener('popstate', function (event) {
        checkAndClearFilters();
        if (event.state && event.state.filters) {
            // Restore filters from state if available
            sessionStorage.setItem('filters', JSON.stringify(event.state.filters));
        }
    });

    function updateProductList(products) {
        const productsContainer = document.querySelector('.category-products');

        // Clear the existing products
        productsContainer.innerHTML = '';

        // Generate and insert new product cards
        products.forEach(function (product) {
            const productCard = document.createElement('a');
            productCard.classList.add('card');
            productCard.style.width = '18rem';
            productCard.href = `${product.url}`;  // Update this to match the correct URL structure

            const productImage = document.createElement('img');
            productImage.classList.add('card-img-top');
            productImage.src = product.imageUrls[0];
            productImage.alt = 'Product Image';

            const cardBody = document.createElement('div');
            cardBody.classList.add('card-body');

            const cardBodyWrapper = document.createElement('div');
            cardBodyWrapper.classList.add('card-body-wrapper');

            const cardTitle = document.createElement('div');
            cardTitle.classList.add('card-title');
            cardTitle.textContent = product.name;

            const cardText = document.createElement('div');
            cardText.classList.add('card-text');

            const productPrice = document.createElement('span');
            productPrice.textContent = `${Number(product.originalPrice).toFixed(2)} $`;

            const wishlistAndCart = document.createElement('span');
            wishlistAndCart.classList.add('wishlist-and-shopping-cart');

            const addToWishlist = document.createElement('span');
            addToWishlist.classList.add('add-to-wishlist');
            const wishlistIcon = document.createElement('i');
            wishlistIcon.classList.add('far', 'fa-heart', 'fa-md', 'text-white');
            addToWishlist.appendChild(wishlistIcon);

            const shoppingCart = document.createElement('span');
            shoppingCart.classList.add('shopping-cart');
            const cartIcon = document.createElement('i');
            cartIcon.classList.add('fas', 'fa-shopping-cart', 'fa-md', 'text-white');
            shoppingCart.appendChild(cartIcon);

            wishlistAndCart.appendChild(addToWishlist);
            wishlistAndCart.appendChild(shoppingCart);

            cardText.appendChild(productPrice);
            cardText.appendChild(wishlistAndCart);

            cardBodyWrapper.appendChild(cardTitle);
            cardBodyWrapper.appendChild(cardText);

            cardBody.appendChild(cardBodyWrapper);
            productCard.appendChild(productImage);
            productCard.appendChild(cardBody);

            productsContainer.appendChild(productCard);
        });

        console.log('Updated product list:', products);
    }

    // Restore filters from sessionStorage
    const storedFilters = sessionStorage.getItem('filters');
    if (storedFilters && window.location.search) {
        const filters = JSON.parse(storedFilters);
        // Restore checkbox states based on filters
        Object.keys(filters).forEach(key => {
            filters[key].forEach(value => {
                const checkbox = document.querySelector(`.sidebar-products input[type="checkbox"][name="${key}"][value="${value}"]`);
                if (checkbox) {
                    checkbox.checked = true;
                }
            });
        });

        // Construct the backend API URL
        const categoryName = document.getElementById('categoryName').value;
        const queryString = Object.keys(filters).map(key => {
            return encodeURIComponent(key) + '=' + encodeURIComponent(filters[key].join(','));
        }).join('&');
        const backendUrl = `/api/categories/products/${categoryName}?${queryString}`;

        // Fetch products based on restored filters
        fetchProducts(backendUrl);
    } else {
        // If no filters or no query string, fetch all products for the category
        const categoryName = document.getElementById('categoryName').value;
        fetchProducts(`/api/categories/products/${categoryName}`);
    }

    // Pagination logic
    const currentPage = parseInt(document.getElementById('currentPage').value);
    const totalPages = parseInt(document.getElementById('totalPages').value);
    const category = document.getElementById('categoryName').value;
    const pageSize = parseInt(document.getElementById('pageSize').value);

    function createPagination(currentPage, totalPages) {
        const paginationContainer = document.getElementById('pagination');
        paginationContainer.innerHTML = ''; // Clear existing buttons

        function createPageItem(page, text, disabled = false, active = false) {
            const li = document.createElement('li');
            li.className = `page-item${disabled ? ' disabled' : ''}${active ? ' active' : ''}`;
            const a = document.createElement('a');
            a.className = 'page-link';
            a.href = `/products/${category}?page=${page}&size=${pageSize}`;
            a.textContent = text;
            li.appendChild(a);
            paginationContainer.appendChild(li);
        }

        function createEllipsisItem(targetPage) {
            const li = document.createElement('li');
            li.className = 'page-item';
            const a = document.createElement('a');
            a.className = 'page-link';
            a.href = `/products/${category}?page=${targetPage}&size=${pageSize}`;
            a.textContent = '...';
            li.appendChild(a);
            paginationContainer.appendChild(li);
        }

        createPageItem(currentPage > 0 ? currentPage - 1 : 0, '«', currentPage === 0);

        if (totalPages <= 5) {
            for (let i = 0; i < totalPages; i++) {
                createPageItem(i, i + 1, false, i === currentPage);
            }
        } else {
            if (currentPage <= 2) {
                for (let i = 0; i < 3; i++) {
                    createPageItem(i, i + 1, false, i === currentPage);
                }
                createEllipsisItem(totalPages - 2); // Link to second-to-last page
                createPageItem(totalPages - 1, totalPages);
            } else if (currentPage >= totalPages - 3) {
                createPageItem(0, 1);
                createEllipsisItem(1); // Link to second page
                for (let i = totalPages - 3; i < totalPages; i++) {
                    createPageItem(i, i + 1, false, i === currentPage);
                }
            } else {
                createPageItem(0, 1);
                createEllipsisItem(1); // Link to second page
                createPageItem(currentPage, currentPage + 1, false, true);
                createEllipsisItem(totalPages - 2); // Link to second-to-last page
                createPageItem(totalPages - 1, totalPages);
            }
        }

        createPageItem(currentPage < totalPages - 1 ? currentPage + 1 : totalPages - 1, '»', currentPage === totalPages - 1);
    }

    // Initial call to create pagination on page load
    createPagination(currentPage, totalPages);
});
