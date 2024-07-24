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
                    const reviewElement = createReviewElement(review);
                    reviewContainer.appendChild(reviewElement);
                    applyRoleBasedColor(reviewElement, review.reviewer.role);
                }
            });
            currentPage++;
            addEventListeners();
        });
}

function createReviewElement(review) {
    let loggedUserId = document.getElementById('loggedUserId').value;
    let loggedUserRole = document.getElementById('loggedUserRole').value;


    const isReviewOwner = String(loggedUserId) === String(review.reviewer.id);
    const isAdminOrModerator = ['Admin', 'Moderator'].includes(loggedUserRole);
    const showReviewOptions = isReviewOwner || isAdminOrModerator;

    const reviewElement = document.createElement('div');
    reviewElement.classList.add('review');
    reviewElement.innerHTML = `
        <div class="reviewer-info">
            <span class="profile-picture">
                <img src="${review.reviewer.profileImage}" alt="Profile Picture" class="user-profile-image-review">
            </span>
            <span class="reviewer">${review.reviewer.firstName} ${review.reviewer.lastName}
                ${review.reviewer.role === 'Moderator' || review.reviewer.role === 'Admin' ? '<img src="/images/blue-check.png" alt="Verified" class="blue-check">' : ''}  
            </span>
            <span class="review-date">${review.date}</span>
            <span class="reviewer-role">Role: <span class="role">${review.reviewer.role}</span></span>
        </div>
        <div class="review-body">
            <div class="stars-container">
                <span class="stars">${'★'.repeat(review.productRating)}${'☆'.repeat(5 - review.productRating)}</span>
                <div class="rate review-rate" id="review-rate" style="display: none;">
                    ${[5, 4, 3, 2, 1].map(rating => `
                        <input type="radio" id="rate-star${rating}-${review.id}" name="rate-${review.id}" value="${rating}" ${review.productRating === rating ? 'checked' : ''} />
                        <label for="rate-star${rating}-${review.id}" title="text">${rating} stars</label>
                    `).join('')}
                </div>
            </div>
            <div class="comment-container">
                <p class="comment">${review.comment}</p>
            </div>
            <div class="review-images">
                ${review.imageUrls.map((url, index) => {
        const transformedUrl = url.replace("/upload/", "/upload/w_180,h_150,c_fill/");
        return `<img src="${transformedUrl}" alt="Review image" onclick="openModal('${review.imageUrls}', ${index})">`;
    }).join('')}
            </div>
        </div>
        <div class="review-options" style="display: ${showReviewOptions ? 'flex' : 'none'};">
            <i class="fa-regular fa-pen-to-square text-white edit-icon fa-lg" data-id="${review.id}"></i>
            <i class="far fa-trash-can text-white delete-icon fa-lg" data-id="${review.id}"></i>
        </div>
        <div class="edit-options" style="display: none;">
            <i class="fa-solid fa-check save-icon fa-xl" data-id="${review.id}"></i>
            <i class="fa-solid fa-xmark cancel-icon fa-xl" data-id="${review.id}"></i>
        </div>
    `;

    return reviewElement;
}

function applyRoleBasedColor(reviewElement, role) {
    const roleElement = reviewElement.querySelector('.role');
    if (role === 'Admin') {
        roleElement.style.color = 'rgb(153, 134, 0)';
    } else if (role === 'Moderator') {
        roleElement.style.color = 'rgb(25, 135, 84)';
    } else {
        roleElement.style.color = 'rgb(225, 222, 218)';
    }
}

function addEventListeners() {
    document.querySelectorAll('.edit-icon').forEach(icon => icon.addEventListener('click', handleEditClick));
    document.querySelectorAll('.delete-icon').forEach(icon => icon.addEventListener('click', handleDeleteClick));
    document.querySelectorAll('.save-icon').forEach(icon => icon.addEventListener('click', handleSaveClick));
    document.querySelectorAll('.cancel-icon').forEach(icon => icon.addEventListener('click', handleCancelClick));
}

function handleEditClick(event) {
    const reviewId = event.target.getAttribute('data-id');
    const reviewElement = event.target.closest('.review');

    toggleEditingState(reviewElement, true);

    // Display delete icons on images
    const reviewImages = reviewElement.querySelector('.review-images');
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
        removeIcon.style.transition = 'font-size 0.3s ease, color 0.3s ease';

        removeIcon.addEventListener('mouseover', () => {
            removeIcon.style.fontSize = '22px';
            removeIcon.style.color = '#f00';
        });

        removeIcon.addEventListener('mouseout', () => {
            removeIcon.style.fontSize = '18px';
            removeIcon.style.color = '#dc3545';
        });

        removeIcon.addEventListener('click', () => imageContainer.remove());

        img.parentNode.insertBefore(imageContainer, img);
        imageContainer.appendChild(img);
        imageContainer.appendChild(removeIcon);
    });
}

function handleSaveClick(event) {
    const reviewId = event.target.getAttribute('data-id');
    const reviewElement = event.target.closest('.review');

    toggleEditingState(reviewElement, false);

    // Get updated values
    const comment = reviewElement.querySelector('.review-body p.comment').textContent;
    const rating = reviewElement.querySelector('.rate input:checked') ? reviewElement.querySelector('.rate input:checked').value : null;
    const remainingImageUrls = Array.from(reviewElement.querySelectorAll('.review-images img')).map(img => img.src);

    // Send PATCH request to update review
    fetch(`/api/reviews/update/${reviewId}`, {
        method: 'PATCH',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        },
        body: JSON.stringify({ comment, rating, remainingImageUrls })
    })
        .then(response => response.json())
        .then(data => {
            console.log('Review updated:', data);
            // Handle successful update, e.g., reload reviews or show success message
        })
        .catch(error => {
            console.error('Error updating review:', error);
        });
}

function handleCancelClick(event) {
    const reviewElement = event.target.closest('.review');
    toggleEditingState(reviewElement, false);
}

function toggleEditingState(reviewElement, isEditing) {
    const starsContainer = reviewElement.querySelector('.stars-container');
    const whiteStars = starsContainer.querySelector('.stars');
    const yellowStars = starsContainer.querySelector('.rate');
    if (whiteStars && yellowStars) {
        whiteStars.style.display = isEditing ? 'none' : 'inline-block';
        yellowStars.style.display = isEditing ? 'block' : 'none';
        if (isEditing) {
            yellowStars.style.position = 'absolute';
            yellowStars.style.top = '0';
            yellowStars.style.left = '0';
        }
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
        commentParagraph.contentEditable = isEditing;
        if (isEditing) {
            commentParagraph.classList.add('editing');
            commentParagraph.focus();
            const range = document.createRange();
            range.selectNodeContents(commentParagraph);
            range.collapse(false);
            const selection = window.getSelection();
            selection.removeAllRanges();
            selection.addRange(range);
        } else {
            commentParagraph.classList.remove('editing');
        }
    }

    reviewElement.querySelector('.edit-options').style.display = isEditing ? 'flex' : 'none';
    reviewElement.querySelector('.review-options').style.display = isEditing ? 'none' : 'flex';
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
