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


    const showAlert = (message) => {
        const alertPlaceholder = document.getElementById('alertPlaceholder');

        const existingAlert = alertPlaceholder.querySelector('.alert');

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
        button.addEventListener('click', function(event) {
            event.preventDefault();

            const socialMedia = this.dataset.socialMedia;
            if (!this.hasAttribute('href')) {
                switch (socialMedia) {
                    case 'Facebook':
                        showAlert("We don't have Facebook yet. Check out our LinkedIn and GitHub!");
                        break;
                    case 'Twitter':
                        showAlert("We don't have Twitter yet. Check out our LinkedIn and GitHub!");
                        break;
                    case 'Google':
                        showAlert("We haven't registered on Google yet. Check out our LinkedIn and GitHub!");
                        break;
                    case 'Instagram':
                        showAlert("We don't have an Instagram yet. Check out our LinkedIn and GitHub!");
                        break;
                }
            } else {
                window.location.href = this.getAttribute('href');
            }
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
            if (!accordionElement.classList.contains('accordion')) {
                accordionElement.classList.add('accordion');

                let mainAccordionHtml = '<div class="accordion-item">';
                mainAccordionHtml += '<h2 class="accordion-header" id="headingFilters">';
                mainAccordionHtml += '<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapseFilters" aria-expanded="false" aria-controls="collapseFilters">';
                mainAccordionHtml += 'Filters</button></h2>';
                mainAccordionHtml += '<div id="collapseFilters" class="accordion-collapse collapse" aria-labelledby="headingFilters" data-bs-parent=".accordion">';
                mainAccordionHtml += '<div class="accordion-body">';

                // Add applied filters section
                const appliedFiltersContainer = filterContainer.querySelector('#appliedFiltersContainer');
                if (appliedFiltersContainer) {
                    mainAccordionHtml += appliedFiltersContainer.outerHTML;
                }

                // Create nested accordions for each filter
                const filterSections = filterContainer.querySelectorAll('.filter-section');
                filterSections.forEach((section, index) => {
                    const filterCriteria = section.querySelector('h5').textContent;
                    const filterId = `filter-${index}`;

                    mainAccordionHtml += `<div class="accordion-item">`;
                    mainAccordionHtml += `<h2 class="accordion-header" id="heading-${filterId}">`;
                    mainAccordionHtml += `<button class="accordion-button collapsed" type="button" data-bs-toggle="collapse" data-bs-target="#collapse-${filterId}" aria-expanded="false" aria-controls="collapse-${filterId}">`;
                    mainAccordionHtml += `${filterCriteria}</button></h2>`;
                    mainAccordionHtml += `<div id="collapse-${filterId}" class="accordion-collapse collapse" aria-labelledby="heading-${filterId}" data-bs-parent="#collapseFilters">`;
                    mainAccordionHtml += `<div class="accordion-body">`;

                    const filterList = section.querySelector('.filter-list');
                    if (filterList) mainAccordionHtml += filterList.outerHTML;

                    mainAccordionHtml += `</div></div></div>`;
                });

                mainAccordionHtml += '</div></div></div>';
                accordionElement.innerHTML = mainAccordionHtml;


                restoreFilters();
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

    function camelCaseToWords(camelCase) {
        // Split on uppercase letters (except at the beginning)
        let words = camelCase.split(/(?=[A-Z])/);

        if (words.length > 1 && words[0].toLowerCase() === 'brand' && words[1].toLowerCase() === 'name') {
            words = [words[0]];        // Specific case, if the filter key is "brandName", only "Brand" shall be displayed
        }

        let result = '';
        words.forEach((word, index) => {
            if (index === 0) {
                result += word.charAt(0).toUpperCase() + word.slice(1);
            } else {
                result += word.charAt(0).toLowerCase() + word.slice(1);
            }

            if (index < words.length - 1) {
                result += ' ';
            }
        });

        return result;
    }

    function updateAppliedFilters(filters) {
        const appliedFiltersList = document.getElementById('appliedFiltersList');
        const appliedFiltersContainer = document.getElementById('appliedFiltersContainer');

        appliedFiltersList.innerHTML = '';
        let hasFilters = false;

        const existingClearAllWrapper = appliedFiltersContainer.querySelector('.clear-all-wrapper');
        if (existingClearAllWrapper) {
            existingClearAllWrapper.remove();
        }

        Object.keys(filters).forEach(key => {
            let displayKey = camelCaseToWords(key);

            filters[key].forEach(value => {
                const li = document.createElement('li');
                li.innerHTML = `• ${displayKey}: <span class="filter-value">${value}</span> <i class="fa-solid fa-xmark fa-sm filter-remove-icon"></i>`;
                const removeIcon = li.querySelector('.filter-remove-icon');
                removeIcon.addEventListener('click', () => clearFilter(key, value));
                appliedFiltersList.appendChild(li);
                hasFilters = true;
            });
        });

        if (hasFilters) {
            const clearAllWrapper = document.createElement('div');
            clearAllWrapper.classList.add('clear-all-wrapper');

            const clearAllDiv = document.createElement('div');
            clearAllDiv.textContent = 'Clear all';
            clearAllDiv.classList.add('clear-all-text');
            clearAllDiv.onclick = clearAllFilters;

            clearAllWrapper.appendChild(clearAllDiv);
            appliedFiltersContainer.appendChild(clearAllWrapper);
        }

        appliedFiltersContainer.style.display = hasFilters ? 'block' : 'none';
    }

    function clearFilter(key, value) {
        let filters = JSON.parse(sessionStorage.getItem('filters')) || {};

        if (filters[key]) {
            filters[key] = filters[key].filter(v => v !== value);
            if (filters[key].length === 0) {
                delete filters[key];
            }
        }

        sessionStorage.setItem('filters', JSON.stringify(filters));

        const checkbox = document.querySelector(`.sidebar-products input[type="checkbox"][name="${key}"][value="${value}"]`);
        if (checkbox) {
            checkbox.checked = false;
        }

        const currentUrl = new URL(window.location.href);
        const searchParams = currentUrl.searchParams;
        searchParams.delete(key, value);
        history.pushState(null, '', currentUrl);

        window.location.reload();
    }

    function clearAllFilters() {
        sessionStorage.removeItem('filters');

        const checkboxes = document.querySelectorAll('.sidebar-products input[type="checkbox"]:checked');
        checkboxes.forEach(checkbox => checkbox.checked = false);

        // Preserve the 'q'(querySearch) parameter if it exists
        const urlParams = new URLSearchParams(window.location.search);
        const queryParam = urlParams.get('q');

        let newUrl = window.location.pathname;
        if (queryParam) {
            newUrl += `?q=${encodeURIComponent(queryParam)}`;
        }

        history.pushState(null, '', newUrl);
        window.location.reload();
    }

    // Set scroll restoration to manual
    if ('history' in window && 'scrollRestoration' in history) {
        history.scrollRestoration = 'manual';
    }

    function restoreFilters() {
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
            updateAppliedFilters(filters);
        }
    }


    document.addEventListener('change', function (event) {
        if (event.target && event.target.matches('.sidebar-products input[type="checkbox"]')) {
            fetchFilteredProducts();
        }
    });

    function checkAndClearFilters() {
        const currentUrl = new URL(window.location.href);
        const hasSearchQuery = currentUrl.searchParams.has('q');
        const storedFilters = sessionStorage.getItem('filters');
        const hasFiltersInUrl = Array.from(currentUrl.searchParams.keys()).some(key => key !== 'q' && key !== 'p' && key !== 'sort');

        if (currentUrl.pathname.startsWith('/products') && !hasFiltersInUrl && (hasSearchQuery || !currentUrl.search) && storedFilters) {
            sessionStorage.removeItem('filters');
            const checkboxes = document.querySelectorAll('.sidebar-products input[type="checkbox"]:checked');
            checkboxes.forEach(checkbox => checkbox.checked = false);
            console.log('Filters cleared');
        }
    }

    function fetchFilteredProducts() {
        const filters = getCurrentFilters();
        sessionStorage.setItem('filters', JSON.stringify(filters));
        const sortSelect = document.getElementById('sort');
        const sort = sortSelect ? sortSelect.value : 'newest';
        const userUrl = constructUrl(null);
        history.pushState({ filters, sort }, null, userUrl);
        window.location.reload();
    }


    // Helper function to get current filters from checkboxes
    function getCurrentFilters() {
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
        return filters;
    }



    function constructUrl(page, filters = {}) {
        const categoryName = document.getElementById('categoryName').value;
        let baseUrl;

        if (categoryName === 'All') {
            baseUrl = '/products';
        }
        else if (categoryName === 'Search') {
            baseUrl = '/products/search'
        }
        else {
            baseUrl = `/products/${categoryName.toLowerCase()}`;
        }

        const urlParams = new URLSearchParams();

        // Add existing filters
        const storedFilters = sessionStorage.getItem('filters');
        const filtersToUse = storedFilters ? JSON.parse(storedFilters) : {};
        Object.keys(filtersToUse).forEach(key => {
            filtersToUse[key].forEach(value => {
                urlParams.append(key, value);
            });
        });

        // Add or update the page parameter
        if (page) {
            urlParams.set('p', page);
        } else {
            urlParams.delete('p');
        }

        // Add sort parameter
        const sortSelect = document.getElementById('sort');
        if (sortSelect) {
            urlParams.set('sort', sortSelect.value);
        }

        // Add search query parameter
        const searchQueryParam = document.getElementById('searchQueryParam');
        if (searchQueryParam && searchQueryParam.value.trim().length > 2) {
            urlParams.set('q', searchQueryParam.value.trim());
        }

        const queryString = urlParams.toString();
        return queryString ? `${baseUrl}?${queryString}` : baseUrl;
    }

    // Add event listener for sort change
    document.getElementById('sort').addEventListener('change', function() {
        window.location.href = constructUrl(null);
    });


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
    setupAccordion()
    checkAndClearFilters()
    setupFilters()
    restoreFilters()
})



document.addEventListener('DOMContentLoaded', function () {
    const thumbnails = document.querySelectorAll('.thumbnail img');
    const mainPhoto = document.getElementById('main-photo');
    let currentIndex = 0;

    thumbnails.forEach((thumbnail, index) => {
        thumbnail.addEventListener('mouseenter', () => {
            if (index !== currentIndex) {
                let direction = index > currentIndex ? 'left' : 'right';
                mainPhoto.style.transition = 'none'; // Disable transition for immediate position change
                mainPhoto.style.transform = direction === 'left' ? 'translateX(100%)' : 'translateX(-100%)';
                mainPhoto.style.opacity = 0; // Hide the image initially
                setTimeout(() => {
                    mainPhoto.src = thumbnail.src;
                    mainPhoto.style.transition = 'transform 0.5s ease-in-out, opacity 0.5s ease-in-out';
                    mainPhoto.style.transform = 'translateX(0)';
                    mainPhoto.style.opacity = 1; // Fade the image in
                }, 50);
                currentIndex = index;
            }
        });
    });
});


document.addEventListener('DOMContentLoaded', function() {
    var toggleBtn = document.getElementById('toggleDescriptionBtn');
    var descriptionDiv = document.getElementById('productDescription');

    toggleBtn.addEventListener('click', function() {
        descriptionDiv.classList.toggle('expand');
        var expanded = descriptionDiv.classList.contains('expand');
        toggleBtn.setAttribute('aria-expanded', String(expanded));
    });
});


document.addEventListener('DOMContentLoaded', function() {
    function loadSimilarProducts() {
        const productName = document.querySelector('h1').textContent;

        fetch(`/api/products/${encodeURIComponent(productName)}/similar`)
            .then(response => response.json())
            .then(products => {
                const similarProductsDiv = document.querySelector('.similar-products');
                similarProductsDiv.innerHTML = products.map(product => `
                    <a href="${product.url}" class="card" style="width: 18rem;">
                        <div class="image-container">
                            <img src="${product.imageUrls[0]}" class="card-img-top" alt="Product Image">
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
                                <div class="card-text">
                                    <span>${product.originalPrice.toFixed(2)} $</span>
                                </div>
                            </div>
                        </div>
                    </a>
                `).join('');

            })
            .catch(error => console.error('Error:', error));
    }

    // Call the function to load similar products
    loadSimilarProducts();
});




document.addEventListener('DOMContentLoaded', function () {
    function setupSearchBar(searchBar, searchResults, updateUrlFunction) {
        searchBar.addEventListener('input', function () {
            let query = this.value;
            if (query.length > 2) {
                fetch(`/api/search?query=${encodeURIComponent(query)}`)
                    .then(response => response.json())
                    .then(data => {
                        if (!data.matchedProducts) {
                            throw new Error('Invalid response format');
                        }
                        let matchedProducts = data.matchedProducts;
                        searchResults.innerHTML = '';
                        searchResults.style.display = 'block';
                        matchedProducts.forEach(function (product) {
                            searchResults.innerHTML += `
                                <a href="${updateUrlFunction(product, searchBar.id)}" class="product">
                                    <img src="${product.imageUrls[0]}" alt="Product Image">
                                    <div class="details">
                                        <div class="name">${product.name}</div>
                                        <div class="price">${product.originalPrice.toFixed(2)} $</div>
                                    </div>
                                </a>`;
                        });
                    })
                    .catch(error => {
                        console.error('Error:', error);
                        searchResults.innerHTML = '<div class="error">An error occurred while fetching results</div>';
                    });
            } else {
                searchResults.innerHTML = '';
                searchResults.style.display = 'none';
            }
        });

        document.addEventListener('click', function(event) {
            if (!searchBar.contains(event.target) && !searchResults.contains(event.target)) {
                searchResults.innerHTML = '';
                searchResults.style.display = 'none';
            }
        });
    }

    function headerSearchUrl(product) {
        return `/products/${product.categoryName.toLowerCase()}/${product.url}`;
    }

    // Setup header search bar
    const headerSearchBar = document.getElementById('searchBar');
    const headerSearchResults = document.getElementById('searchResults');
    setupSearchBar(headerSearchBar, headerSearchResults, headerSearchUrl);
});


document.addEventListener('DOMContentLoaded', function () {
    function setupSearchBar(searchBar, searchResults, updateUrlFunction) {
        searchBar.addEventListener('input', function () {
            let query = this.value;
            if (query.length > 2) {
                fetch(`/api/search?query=${encodeURIComponent(query)}`)
                    .then(response => response.json())
                    .then(data => {
                        if (!data.matchedProducts) {
                            throw new Error('Invalid response format');
                        }
                        let matchedProducts = data.matchedProducts;
                        searchResults.innerHTML = '';
                        searchResults.style.display = 'block';
                        matchedProducts.forEach(function (product) {
                            searchResults.innerHTML += `
                                <a href="${updateUrlFunction(product, searchBar.id)}" class="product">
                                    <img src="${product.imageUrls[0]}" alt="Product Image">
                                    <div class="details">
                                        <div class="name">${product.name}</div>
                                        <div class="price">${product.originalPrice.toFixed(2)} $</div>
                                    </div>
                                </a>`;
                        });
                    })
                    .catch(error => {
                        console.error('Error:', error);
                        searchResults.innerHTML = '<div class="error">An error occurred while fetching results</div>';
                    });
            } else {
                searchResults.innerHTML = '';
                searchResults.style.display = 'none';
            }
        });

        document.addEventListener('click', function(event) {
            if (!searchBar.contains(event.target) && !searchResults.contains(event.target)) {
                searchResults.innerHTML = '';
                searchResults.style.display = 'none';
            }
        });
    }

    function compareSearchUrl(product, searchBarId) {
        const url = new URL(window.location);
        const searchParams = new URLSearchParams(url.search);

        if (searchBarId === 'searchBar1') {
            searchParams.set('idProduct1', product.id);
        } else if (searchBarId === 'searchBar2') {
            searchParams.set('idProduct2', product.id);
        } else if (searchBarId === 'searchBar3') {
            searchParams.set('idProduct3', product.id);
        }

        return `${url.pathname}?${searchParams.toString()}`;
    }

    // Setup compare product search bars
    const compareSearchBars = ['searchBar1', 'searchBar2', 'searchBar3'];
    compareSearchBars.forEach(id => {
        const compareSearchBar = document.getElementById(id);
        const compareSearchResults = document.getElementById(`searchResults${id.charAt(id.length - 1)}`);
        setupSearchBar(compareSearchBar, compareSearchResults, compareSearchUrl);
    });
});


document.getElementById('compareButton').addEventListener('click', function() {
    const productId = this.getAttribute('data-product-id');
    window.location.href = `/products/compare-products?idProduct1=${encodeURIComponent(productId)}`;
});