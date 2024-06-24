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





document.addEventListener('DOMContentLoaded', function () {
    const accordionElement = document.querySelector('.sidebar-products');
    const filterContainer = document.querySelector('#filterContainer');

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

                // Restore filters from sessionStorage for the accordion view
                const storedFilters = sessionStorage.getItem('filters');
                if (storedFilters && window.location.search) {
                    const filters = JSON.parse(storedFilters);
                    // Restore checkbox states based on filters
                    Object.keys(filters).forEach(key => {
                        filters[key].forEach(value => {
                            const checkbox = document.querySelector(`.accordion-body input[type="checkbox"][name="${key}"][value="${value}"]`);
                            if (checkbox) {
                                checkbox.checked = true;
                            }
                        });
                    });
                }
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

    // Call setupAccordion on window resize to adjust behavior dynamically
    window.addEventListener('resize', function () {
        setupAccordion();
    });

    function setupFilters() {
        const filterSections = document.querySelectorAll('.filter-section');

        filterSections.forEach(section => {
            const scrollspy = section.querySelector('.custom-scrollspy');
            const searchContainer = section.querySelector('.search-container');

            function checkScrollable() {
                if (scrollspy && scrollspy.scrollHeight > scrollspy.clientHeight) {
                    searchContainer.style.display = 'block';
                } else {
                    searchContainer.style.display = 'none';
                }
            }

            function highlightActiveItem() {
                if (!scrollspy) return;
                const items = scrollspy.querySelectorAll('li');
                if (items.length === 0) return;

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

            if (scrollspy) {
                scrollspy.addEventListener('scroll', highlightActiveItem);
                highlightActiveItem();
            }

            // Implement search functionality
            const searchInput = searchContainer.querySelector('input');
            if (searchInput) {
                searchInput.addEventListener('input', function () {
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
            }
        });
    }

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

    function checkAndClearFilters() {
        console.log('checkAndClearFilters called');
        const currentUrl = window.location.pathname;
        const storedFilters = sessionStorage.getItem('filters');

        if (currentUrl.startsWith('/products/') && !window.location.search && storedFilters) {
            console.log('Clearing filters');
            sessionStorage.removeItem('filters');
            const checkboxes = document.querySelectorAll('.sidebar-products input[type="checkbox"]:checked');
            checkboxes.forEach(checkbox => checkbox.checked = false);
            history.replaceState(null, '', currentUrl);
            console.log('Filters cleared');
        }
    }

// Call this function when the page loads
    window.addEventListener('load', () => {
        console.log('Page loaded');
        checkAndClearFilters();
    });

// Add event listener for popstate to handle back/forward navigation
    window.addEventListener('popstate', function (event) {
        console.log('popstate event triggered');
        checkAndClearFilters();
        if (event.state && event.state.filters) {
            console.log('Restoring filters from state', event.state.filters);
            sessionStorage.setItem('filters', JSON.stringify(event.state.filters));
        }
    });



    function fetchFilteredProducts() {
        console.log('fetchFilteredProducts called');
        const filters = {};
        const checkboxes = document.querySelectorAll('.sidebar-products input[type="checkbox"]:checked');

        checkboxes.forEach(function (checkbox) {
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

        console.log('Storing filters in sessionStorage:', filters);
        sessionStorage.setItem('filters', JSON.stringify(filters));

        const userUrl = constructUrl(null, filters);
        console.log('Updating URL with pushState:', userUrl);
        history.pushState({ filters }, null, userUrl);

        console.log('Reloading page to apply filters');
        window.location.reload();
    }

    function fetchProducts(url) {
        console.log('fetchProducts called with URL:', url);
        fetch(url)
            .then(response => {
                if (!response.ok) {
                    throw new Error(`HTTP error! Status: ${response.status}`);
                }
                return response.json();
            })
            .then(data => {
                console.log('Fetched products data:', data);
                updateProductList(data.content);
            })
            .catch(error => {
                console.error('Error fetching products:', error);
            });
    }


    // Restore filters and pagination from sessionStorage and URL
    const storedFilters = sessionStorage.getItem('filters');
    const urlParams = new URLSearchParams(window.location.search);
    const page = urlParams.get('p') || 1;

    if (storedFilters || window.location.search) {
        const filters = storedFilters ? JSON.parse(storedFilters) : {};
        console.log('Restoring filters from sessionStorage or URL:', filters);

        Object.keys(filters).forEach(key => {
            filters[key].forEach(value => {
                const checkbox = document.querySelector(`.sidebar-products input[type="checkbox"][name="${key}"][value="${value}"]`);
                if (checkbox) {
                    checkbox.checked = true;
                }
            });
        });

        const backendUrl = constructUrl(page, filters);
        console.log('Fetching products based on restored filters and pagination:', backendUrl);
        fetchProducts(backendUrl);
    } else {
        const categoryName = document.getElementById('categoryName').value;
        const backendUrl = constructUrl(page);
        console.log('Fetching all products for category with pagination:', backendUrl);
        fetchProducts(backendUrl);
    }


    function constructUrl(page, filters = {}) {
        const categoryName = document.getElementById('categoryName').value;
        const baseUrl = `/products/${categoryName.toLowerCase()}`;

        const filterParams = Object.keys(filters)
            .filter(key => filters[key].length > 0) // Filter out empty filter arrays
            .map(key => `${encodeURIComponent(key)}=${encodeURIComponent(filters[key].join(','))}`)
            .join('&');

        const pageParam = page ? `p=${page}` : ''; // Add page parameter if provided

        const queryString = filterParams ? `${filterParams}&${pageParam}` : pageParam;

        const url = queryString ? `${baseUrl}?${queryString}` : baseUrl;
        console.log('Constructed URL:', url);
        return url;
    }


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

    function createPagination(currentPage, totalPages) {
        const paginationContainer = document.getElementById('pagination');
        paginationContainer.innerHTML = ''; // Clear existing buttons

        function createPageItem(page, text, disabled = false, active = false) {
            const li = document.createElement('li');
            li.className = `page-item${disabled ? ' disabled' : ''}${active ? ' active' : ''}`;
            const a = document.createElement('a');
            a.className = 'page-link';
            a.href = constructUrl(page);
            a.textContent = text;
            li.appendChild(a);
            paginationContainer.appendChild(li);
        }

        function createEllipsisItem(targetPage) {
            const li = document.createElement('li');
            li.className = 'page-item';
            const a = document.createElement('a');
            a.className = 'page-link';
            a.href = constructUrl(targetPage);
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

    const currentPage = parseInt(document.getElementById('currentPage').value);
    const totalPages = parseInt(document.getElementById('totalPages').value);
    createPagination(currentPage, totalPages)
    setupFilters()
});
