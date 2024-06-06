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



    fetchCategories();

    // Dropdown categories menu on hover show subcategories
    document.querySelector('.dropdown-menu').addEventListener('mouseover', function(event) {
        const target = event.target;
        if (target.classList.contains('dropdown-item') && target.nextElementSibling) {
            target.nextElementSibling.style.display = 'block';
        }
    });

    document.querySelector('.dropdown-menu').addEventListener('mouseout', function(event) {
        const target = event.target;
        if (target.classList.contains('dropdown-item') && target.nextElementSibling) {
            target.nextElementSibling.style.display = 'none';
        }
    });


});



function fetchCategories() {
    fetch('/api/categories')
        .then(response => response.json())
        .then(data => {
            const dropdownMenu = document.querySelector('.dropdown-menu');
            data.forEach(category => {
                const categoryItem = document.createElement('li');
                const categoryLink = document.createElement('a');
                categoryLink.classList.add('dropdown-item');
                categoryLink.href = category.url;
                categoryLink.textContent = category.name;
                categoryItem.appendChild(categoryLink);

                if (category.children && category.children.length > 0) {
                    const submenu = document.createElement('ul');
                    submenu.classList.add('dropdown-submenu');
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
                }

                dropdownMenu.appendChild(categoryItem);
            });
        })
        .catch(error => console.error('Error fetching categories:', error));


}
