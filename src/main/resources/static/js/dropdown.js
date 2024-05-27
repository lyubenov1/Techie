// Function to show dropdown menu
function showDropdown(menuId) {
    var menu = document.getElementById(menuId);
    if (menu) {
        menu.style.display = "block";
    }
}

// Function to hide dropdown menu
function hideDropdown(menuId) {
    var menu = document.getElementById(menuId);
    if (menu) {
        menu.style.display = "none";
    }
}

function showSubcategories(category) {
    var subMenu = document.getElementById(category + "-menu");
    if (subMenu) {
        subMenu.style.display = "block";
    }
}

function hideSubcategories(category) {
    var subMenu = document.getElementById(category + "-menu");
    if (subMenu) {
        subMenu.style.display = "none";
    }
}
