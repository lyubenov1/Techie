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

        // Clear the URL
        const currentUrl = window.location.pathname;
        history.pushState(null, '', currentUrl);

        window.location.reload();
    }

    function checkAndClearFilters() {
        const currentUrl = window.location.pathname;
        const storedFilters = sessionStorage.getItem('filters');

        if (currentUrl.startsWith('/products/') && !window.location.search && storedFilters) {
            sessionStorage.removeItem('filters');
            const checkboxes = document.querySelectorAll('.sidebar-products input[type="checkbox"]:checked');
            checkboxes.forEach(checkbox => checkbox.checked = false);
            history.replaceState(null, '', currentUrl);
            console.log('Filters cleared');
        }
    }

    // Set scroll restoration to manual
    if ('history' in window && 'scrollRestoration' in history) {
        history.scrollRestoration = 'manual';
    }

    window.addEventListener('load', () => {
        checkAndClearFilters();

        const storedFilters = sessionStorage.getItem('filters');
        if (storedFilters) {
            updateAppliedFilters(JSON.parse(storedFilters));
        }
    });

    // Add event listener for popstate to handle back/forward navigation
    window.addEventListener('popstate', function (event) {
        checkAndClearFilters();
        if (event.state && event.state.filters) {
            sessionStorage.setItem('filters', JSON.stringify(event.state.filters));
        }
        window.location.reload();
    });

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


    function fetchFilteredProducts() {
        const filters = getCurrentFilters();
        sessionStorage.setItem('filters', JSON.stringify(filters));
        const userUrl = constructUrl(null, filters);
        history.pushState({ filters }, null, userUrl);
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
        const baseUrl = `/products/${categoryName.toLowerCase()}`;

        // Initialize URLSearchParams with existing URL parameters
        const urlParams = new URLSearchParams();

        // Retrieve filters from sessionStorage
        const storedFilters = sessionStorage.getItem('filters');
        const filtersToUse = storedFilters ? JSON.parse(storedFilters) : {};

        // Add filters to URLSearchParams
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

        const queryString = urlParams.toString();
        return queryString ? `${baseUrl}?${queryString}` : baseUrl;
    }


    function createPagination(currentPage, totalPages) {
        const paginationContainer = document.getElementById('pagination');
        paginationContainer.innerHTML = ''; // Clear existing buttons

        const currentFilters = getCurrentFilters();

        function createPageItem(page, text, disabled = false, active = false) {
            const li = document.createElement('li');
            li.className = `page-item${disabled ? ' disabled' : ''}${active ? ' active' : ''}`;
            const a = document.createElement('a');
            a.className = 'page-link';
            a.href = constructUrl(page, currentFilters);
            a.textContent = text;
            li.appendChild(a);
            paginationContainer.appendChild(li);
        }

        function createEllipsisItem(targetPage) {
            const li = document.createElement('li');
            li.className = 'page-item';
            const a = document.createElement('a');
            a.className = 'page-link';
            a.href = constructUrl(targetPage, currentFilters);
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
    setupFilters()
    restoreFilters()
})

