document.addEventListener('DOMContentLoaded', function() {
    const loggedUserId = document.getElementById('loggedUserId').value;

    document.getElementById('reviewsBox').addEventListener('click', function() {
        window.location.href = '/products';
    });

    document.getElementById('wishlistsBox').addEventListener('click', function() {
        if (!loggedUserId) {
            window.location.href = '/login';
        } else {
            window.location.href = '/users/profile/wishlist';
        }
    });

    document.querySelectorAll('.gallery__item').forEach(item => {
        item.addEventListener('click', function() {
            const brand = item.getAttribute('data-brand');
            window.location.href = `/products?brandName=${brand}`;
        });
    });
});
