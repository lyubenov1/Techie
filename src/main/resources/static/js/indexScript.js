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


    setTimeout(function() {
        const successMessage = document.querySelector('.message-success');
        const errorMessage = document.querySelector('.message-error');
        if (successMessage) {
            successMessage.classList.add('fade-out');
            // After the fade-out transition, hide the element
            setTimeout(() => {
                successMessage.style.display = 'none';
            }, 500);
        }
        if (errorMessage) {
            errorMessage.classList.add('fade-out');
            // After the fade-out transition, hide the element
            setTimeout(() => {
                errorMessage.style.display = 'none';
            }, 500);
        }
    }, 5000); // 5 seconds

});
