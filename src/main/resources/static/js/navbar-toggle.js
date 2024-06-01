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
        // Check if the click event occurred outside of the dropdown toggle
        if (!dropdownToggle.contains(event.target)) {
            // Ensure the bars icon is visible when a click occurs outside of the dropdown toggle
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
});