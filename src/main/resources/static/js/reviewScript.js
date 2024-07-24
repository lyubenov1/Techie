document.addEventListener('DOMContentLoaded', function() {
    const reviewForm = document.getElementById('review-form');
    const csrfToken = document.querySelector('#csrf-token').value;
    const spinner = document.getElementById('upload-spinner');

    reviewForm.addEventListener('submit', function(event) {
        event.preventDefault()

        const rating = document.querySelector('input[name="rate"]:checked');
        if (!rating) {
            console.log("No rating selected");
            showWarning("Rating is required!");
            return;
        }

        const formData = new FormData();
        formData.append('review-comment', document.getElementById('review-comment').value);
        formData.append('rate', rating.value);
        formData.append('productId', productId);

        const files = document.getElementById('image-upload').files;
        for (let i = 0; i < files.length; i++) {
            formData.append('image-upload', files[i]);
        }

        // Show the spinner
        spinner.style.display = 'block';
        document.getElementById('image-preview').style.display = 'none'

        fetch('/api/reviews/create', {
            method: 'POST',
            headers: {
                'X-CSRF-TOKEN': csrfToken
            },
            body: formData
        })
            .then(response => {
                return response.text().then(message => {
                    if (response.ok) {
                        console.log('Review created successfully:', message);
                        showSuccessReviewMessage(message)
                    } else {
                        throw new Error(message || 'Failed to create review');
                    }
                });
            })
            .catch(error => {
                console.error('Error creating review:', error.message);
                showWarning(error.message);
            })
            .finally(() => {
                // Hide the spinner
                spinner.style.display = 'none';
                document.getElementById('image-preview').style.display = 'block';
            });
    });

    const commentTextarea = document.getElementById('review-comment');
    const charCount = document.getElementById('comment-char-count');
    const imageUpload = document.getElementById('image-upload');
    const imagePreview = document.getElementById('image-preview');

    console.log('Elements selected:', { commentTextarea, charCount, imageUpload, imagePreview });

    // Character count
    if (commentTextarea && charCount) {
        commentTextarea.addEventListener('input', function() {
            charCount.textContent = `${this.value.length}/600`;
        });
    }

    // Image upload preview
    if (imageUpload && imagePreview) {
        let uploadedFiles = [];

        imageUpload.addEventListener('change', function() {
            const newFiles = Array.from(this.files);
            console.log('New files selected:', newFiles.length);

            if (uploadedFiles.length + newFiles.length > 3) {
                showWarning("Maximum amount of photos per comment is 3");
                return;
            }

            newFiles.forEach(file => {
                if (uploadedFiles.length < 3) {
                    if (file.size <= 7 * 1024 * 1024) { // Check if file is <= 7 MB
                        uploadedFiles.push(file);
                        const reader = new FileReader();
                        reader.onload = function (e) {
                            console.log('File read successfully');
                            const imgContainer = document.createElement('div');
                            imgContainer.className = 'image-preview-container';

                            const img = document.createElement('img');
                            img.src = e.target.result;

                            const removeIcon = document.createElement('i');
                            removeIcon.className = 'fas fa-times remove-image';
                            removeIcon.addEventListener('click', function () {
                                imgContainer.remove();
                                uploadedFiles = uploadedFiles.filter(f => f !== file);
                                console.log('Image removed, remaining:', uploadedFiles.length);
                            });

                            imgContainer.appendChild(img);
                            imgContainer.appendChild(removeIcon);
                            imagePreview.appendChild(imgContainer);
                            console.log('Image preview added');
                        }
                        reader.readAsDataURL(file);
                    } else {
                        showWarning("File size cannot be more than 7 MB");
                    }
                }
            });
        });
    }

    function showWarning(message) {
        const imageWarning = document.getElementById('image-warning');
        imageWarning.textContent = message;
        imageWarning.classList.add('show');
        setTimeout(() => {
            imageWarning.classList.remove('show');
        }, 5000);
    }

    function showSuccessReviewMessage(message) {
        const productPageMessage = document.querySelector('.product-page-message');
        if (productPageMessage) {
            productPageMessage.textContent = message;
            productPageMessage.classList.add('show');

            setTimeout(() => {
                location.reload();
            }, 3000);
        }
    }
});

const reviewContainer = document.querySelector('.review-list');
let currentPage = 0;
const productId = document.querySelector('.review-list').dataset.productId;
let currentImageIndex = 0;
let imageUrls = [];

function fetchMoreReviews() {
    fetch(`/api/reviews/get/${productId}?p=${currentPage}&s=7`)
        .then(response => response.json())
        .then(reviews => {
            reviews.forEach(review => {
                if (review.comment || review.imageUrls.length > 0) {
                    const reviewElement = document.createElement('div');
                    reviewElement.classList.add('review');
                    reviewElement.innerHTML = `
            <div class="reviewer-info">
              <span class="profile-picture">
                <img src="${review.reviewer.profileImage}" alt="Profile Picture" class="user-profile-image-review">
              </span>
              <span class="reviewer">${review.reviewer.firstName} ${review.reviewer.lastName}
                    ${review.reviewer.role === 'Moderator' || review.reviewer.role === 'Admin' ?
                        '<img src="/images/blue-check.png" alt="Verified" class="blue-check">' : ''}  
              </span>
              <span class="review-date">${review.date}</span>
              <span class="reviewer-role">Role: <span class="role">${review.reviewer.role}</span></span>
            </div>
            <div class="review-body">
                <div class="stars-container">
                    <span class="stars">${'★'.repeat(review.productRating)}${'☆'.repeat(5 - review.productRating)}</span>
                    <div class="rate review-rate" id="review-rate" style="display: none;">
                        <input type="radio" id="rate-star5-${review.id}" name="rate-${review.id}" value="5" ${review.productRating === 5 ? 'checked' : ''} />
                        <label for="rate-star5-${review.id}" title="text">5 stars</label>
                        <input type="radio" id="rate-star4-${review.id}" name="rate-${review.id}" value="4" ${review.productRating === 4 ? 'checked' : ''} />
                        <label for="rate-star4-${review.id}" title="text">4 stars</label>
                        <input type="radio" id="rate-star3-${review.id}" name="rate-${review.id}" value="3" ${review.productRating === 3 ? 'checked' : ''} />
                        <label for="rate-star3-${review.id}" title="text">3 stars</label>
                        <input type="radio" id="rate-star2-${review.id}" name="rate-${review.id}" value="2" ${review.productRating === 2 ? 'checked' : ''} />
                        <label for="rate-star2-${review.id}" title="text">2 stars</label>
                        <input type="radio" id="rate-star1-${review.id}" name="rate-${review.id}" value="1" ${review.productRating === 1 ? 'checked' : ''} />
                        <label for="rate-star1-${review.id}" title="text">1 star</label>
                    </div>
                </div>
                <div class="comment-container">
                    <p class="comment">${review.comment}</p>
                </div>
                <div class="review-images">
                  ${review.imageUrls.map((url, index) => {
                        // Append transformation parameters to the URL
                        const transformedUrl = url.replace("/upload/", "/upload/w_180,h_150,c_fill/");
                        return `<img src="${transformedUrl}" alt="Review image" onclick="openModal('${review.imageUrls}', ${index})">`;
                    }).join('')}
                </div>
            </div>
            <div class="review-options">
                <i class="fa-regular fa-pen-to-square text-white edit-icon fa-lg" data-id="${review.id}"></i>
                <i class="far fa-trash-can text-white delete-icon fa-lg" data-id="${review.id}"></i>
            </div>
            <div class="edit-options" style="display: none;">
                <i class="fa-solid fa-check save-icon fa-lg" data-id="${review.id}"></i>
                <i class="fa-solid fa-xmark cancel-icon fa-lg" data-id="${review.id}"></i>
            </div>
          `;
                    reviewContainer.appendChild(reviewElement);
                    // Apply role-based color
                    const roleElement = reviewElement.querySelector('.role');
                    const role = review.reviewer.role;
                    if (role === 'Admin') {
                        roleElement.style.color = 'rgb(153, 134, 0)';
                    } else if (role === 'Moderator') {
                        roleElement.style.color = 'rgb(25, 135, 84)';
                    } else {
                        roleElement.style.color = 'rgb(225, 222, 218)'; // Default color
                    }
                }
            });
            currentPage++;
            addEventListeners();
        });
}

function addEventListeners() {
    document.querySelectorAll('.edit-icon').forEach(icon => {
        icon.addEventListener('click', handleEditClick);
    });
    document.querySelectorAll('.delete-icon').forEach(icon => {
        icon.addEventListener('click', handleDeleteClick);
    });
    document.querySelectorAll('.save-icon').forEach(icon => {
        icon.addEventListener('click', handleSaveClick);
    });
    document.querySelectorAll('.cancel-icon').forEach(icon => {
        icon.addEventListener('click', handleCancelClick);
    });
}

function handleEditClick(event) {
    const reviewId = event.target.getAttribute('data-id');
    console.log('Edit review with ID:', reviewId);

    // Find the corresponding review element
    const reviewElement = event.target.closest('.review');

    const reviewBody = reviewElement.querySelector('.review-body');

    const commentContainer = reviewBody.querySelector('.comment-container');
    const commentParagraph = commentContainer.querySelector('.comment');

    if (commentParagraph) {
        commentParagraph.contentEditable = true;
        commentParagraph.classList.add('editing');
        commentParagraph.focus();
        // Place cursor at the end of the text
        const range = document.createRange();
        range.selectNodeContents(commentParagraph);
        range.collapse(false);
        const selection = window.getSelection();
        selection.removeAllRanges();
        selection.addRange(range);
    }

    const starsContainer = reviewBody.querySelector('.stars-container');
    const whiteStars = starsContainer.querySelector('.stars');
    const yellowStars = starsContainer.querySelector('.rate');
    if (whiteStars && yellowStars) {
        whiteStars.style.display = 'none';
        yellowStars.style.display = 'block';
        yellowStars.style.position = 'absolute';
        yellowStars.style.top = '0';
        yellowStars.style.left = '0';
    }

    // Show edit options
    const editOptions = reviewElement.querySelector('.edit-options');
    editOptions.style.display = 'flex'; // Show edit options

    // Hide default options
    const reviewOptions = reviewElement.querySelector('.review-options');
    reviewOptions.style.display = 'none';

    // Display delete icons on images
    const reviewImages = reviewBody.querySelector('.review-images');
    reviewImages.querySelectorAll('img').forEach(img => {
        const imageContainer = document.createElement('div');
        imageContainer.style.position = 'relative';
        imageContainer.style.display = 'inline-block';
        imageContainer.style.margin = '5px';

        const removeIcon = document.createElement('i');
        removeIcon.className = 'fas fa-times remove-image';
        removeIcon.style.position = 'absolute';
        removeIcon.style.top = '5px';
        removeIcon.style.right = '5px';
        removeIcon.style.color = '#dc3545';
        removeIcon.style.cursor = 'pointer';
        removeIcon.style.fontSize = '18px';
        removeIcon.addEventListener('click', () => imageContainer.remove());

        img.parentNode.insertBefore(imageContainer, img);
        imageContainer.appendChild(img);
        imageContainer.appendChild(removeIcon);
    });
}

function handleSaveClick(event) {
    const reviewId = event.target.getAttribute('data-id');
    const reviewElement = event.target.closest('.review');

    const starsContainer = reviewElement.querySelector('.stars-container');
    const whiteStars = starsContainer.querySelector('.stars');
    const yellowStars = starsContainer.querySelector('.rate');
    if (whiteStars && yellowStars) {
        whiteStars.style.display = 'inline-block';
        yellowStars.style.display = 'none';
    }

    reviewElement.querySelectorAll('.review-images > div').forEach(container => {
        const img = container.querySelector('img');
        if (img) {
            container.parentNode.insertBefore(img, container);
        }
        container.remove();
    });

    const commentParagraph = reviewElement.querySelector('.comment');
    if (commentParagraph) {
        commentParagraph.contentEditable = false;
        commentParagraph.classList.remove('editing');
    }

    // Get updated values
    const comment = reviewElement.querySelector('.review-body p').textContent;
    const rating = Array.from(reviewElement.querySelectorAll('.rate input:checked')).map(input => input.value)[0];

    // Send PATCH request to update review
    fetch(`/api/reviews/update/${reviewId}`, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
        body: JSON.stringify({ comment, rating })
    })
        .then(response => response.json())
        .then(data => {
            console.log('Review updated:', data);
            // Handle successful update, e.g., reload reviews or show success message
        })
        .catch(error => {
            console.error('Error updating review:', error);
        });

    // Reset UI
    reviewElement.querySelector('.edit-options').style.display = 'none';
    reviewElement.querySelector('.review-options').style.display = 'flex';
}

function handleCancelClick(event) {
    const reviewElement = event.target.closest('.review');
    const starsContainer = reviewElement.querySelector('.stars-container');
    const whiteStars = starsContainer.querySelector('.stars');
    const yellowStars = starsContainer.querySelector('.rate');

    if (whiteStars && yellowStars) {
        whiteStars.style.display = 'inline-block';
        yellowStars.style.display = 'none';
    }

    reviewElement.querySelectorAll('.review-images > div').forEach(container => {
        const img = container.querySelector('img');
        if (img) {
            container.parentNode.insertBefore(img, container);
        }
        container.remove();
    });

    const commentParagraph = reviewElement.querySelector('.comment');
    if (commentParagraph) {
        commentParagraph.contentEditable = false;
        commentParagraph.classList.remove('editing');
    }

    reviewElement.querySelector('.edit-options').style.display = 'none';
    reviewElement.querySelector('.review-options').style.display = 'flex';
}

function handleDeleteClick(event) {
    const reviewId = event.target.getAttribute('data-id');
    if (confirm('Are you sure you want to delete this review?')) {
        fetch(`/api/reviews/${reviewId}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': csrfToken
            }
        })
            .then(response => {
                if (response.ok) {
                    console.log('Review deleted successfully');
                    // Optionally, remove the review element from the DOM
                    event.target.closest('.review').remove();
                } else {
                    throw new Error('Failed to delete review');
                }
            })
            .catch(error => {
                console.error('Error deleting review:', error.message);
            });
    }
}

function openModal(urls, index) {
    var modal = document.getElementById("imageModal");
    var modalImg = document.getElementById("modalImage");
    var captionText = document.getElementById("caption");

    imageUrls = urls.split(',');
    currentImageIndex = index;

    modal.style.display = "flex";
    modalImg.src = imageUrls[currentImageIndex];
    captionText.innerHTML = "";

    // Add event listener for keyboard navigation
    document.addEventListener('keydown', handleKeyDown);
}

function closeModal() {
    var modal = document.getElementById("imageModal");
    modal.style.display = "none";

    // Remove event listener for keyboard navigation
    document.removeEventListener('keydown', handleKeyDown);
}

function changeImage(direction) {
    currentImageIndex += direction;
    if (currentImageIndex < 0) {
        currentImageIndex = imageUrls.length - 1;
    } else if (currentImageIndex >= imageUrls.length) {
        currentImageIndex = 0;
    }
    document.getElementById("modalImage").src = imageUrls[currentImageIndex];
}

function handleKeyDown(event) {
    if (event.key === 'ArrowLeft') {
        changeImage(-1);
    } else if (event.key === 'ArrowRight') {
        changeImage(1);
    }
}

const observer = new IntersectionObserver(entries => {
    if (entries[0].isIntersecting) {
        fetchMoreReviews();
    }
}, { threshold: 1.0 });

observer.observe(document.querySelector('.loading-indicator'));
