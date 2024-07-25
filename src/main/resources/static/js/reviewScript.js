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
                    if (file.size <= 7 * 1024 * 1024) { // Check if the file is <= 7 MB
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
const loadingIndicator = document.querySelector('.indicator-text');
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

            // Hide loading indicator if there are no more reviews to load
            if (reviews.length === 0) {
                loadingIndicator.style.display = 'none';
            }
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
            <span class="thumbs" data-review-id="${review.id}"> 
                <span class="vote-wrapper">
                    <i class="fa-solid fa-thumbs-up vote-icon"></i>
                    <span class="vote-count upvote-count">${review.upvote}</span>
                </span>
                <span class="vote-wrapper">
                    <i class="fa-solid fa-thumbs-down vote-icon"></i>
                    <span class="vote-count downvote-count">${review.downvote}</span>
                </span>
            </span>
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
            <div class="review-actions">
               <i class="fa-regular fa-pen-to-square text-white edit-icon fa-lg" data-id="${review.id}"></i>
               <i class="far fa-trash-can text-white delete-icon fa-lg" data-id="${review.id}"></i>
            </div>
            <div class="error-message" style="display: none;"></div>
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
    const reviewElement = event.target.closest('.review');

    // Store original state of review
    reviewElement.dataset.originalState = JSON.stringify({
        comment: reviewElement.querySelector('.comment').textContent,
        rating: reviewElement.querySelector('.stars').innerHTML,
        images: Array.from(reviewElement.querySelectorAll('.review-images img')).map(img => img.outerHTML)
    });

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
        .then(response => {
            if (!response.ok) {
                return response.text().then(text => {
                    throw new Error(text || 'Failed to update review');
                });
            } else {
                return response.json();
            }
        })
        .then(updatedReview => {
            console.log('Review updated:', updatedReview);
            // Update the review in the DOM with the new data
            updateReviewInDOM(reviewElement, updatedReview);
            toggleEditingState(reviewElement, false);
            showSuccessMessage('Review edited successfully');
        })
        .catch(error => {
            console.error('Error updating review:', error.message);
            toggleEditingState(reviewElement, false);
            showErrorMessage(error.message, reviewElement);
        });
}

function updateReviewInDOM(reviewElement, updatedReview) {
    // Update the review content in the DOM
    reviewElement.querySelector('.comment').textContent = updatedReview.comment;
    reviewElement.querySelector('.stars').innerHTML = '★'.repeat(updatedReview.productRating) + '☆'.repeat(5 - updatedReview.productRating);

    const imagesContainer = reviewElement.querySelector('.review-images');
    imagesContainer.innerHTML = updatedReview.imageUrls.map((url, index) => {
        const transformedUrl = url.replace("/upload/", "/upload/w_180,h_150,c_fill/");
        return `<img src="${transformedUrl}" alt="Review Image ${index + 1}" class="review-image">`;
    }).join('');
}


function handleCancelClick(event) {
    const reviewElement = event.target.closest('.review');
    // Restore original state
    const originalState = JSON.parse(reviewElement.dataset.originalState);
    reviewElement.querySelector('.comment').textContent = originalState.comment;
    reviewElement.querySelector('.stars').innerHTML = originalState.rating;
    reviewElement.querySelector('.review-images').innerHTML = originalState.images.join('');

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

    if (!isEditing) {
        // Remove the stored original state when exiting edit mode
        delete reviewElement.dataset.originalState;
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
    const reviewElement = event.target.closest('.review');

    // Create and show a custom confirmation dialog
    const confirmDialog = createConfirmDialog('Are you sure you want to delete this review?');
    document.body.appendChild(confirmDialog);

    confirmDialog.querySelector('.confirm-btn').addEventListener('click', () => {
        confirmDialog.remove();
        deleteReview(reviewId, reviewElement);
    });

    confirmDialog.querySelector('.cancel-btn').addEventListener('click', () => {
        confirmDialog.remove();
    });
}

function createConfirmDialog(message) {
    const dialog = document.createElement('div');
    dialog.className = 'custom-confirm-dialog';
    dialog.innerHTML = `
        <div class="confirm-content">
            <p>${message}</p>
            <div class="confirm-buttons">
                <button class="confirm-btn">Yes, delete</button>
                <button class="cancel-btn">Cancel</button>
            </div>
        </div>
    `;
    return dialog;
}

function deleteReview(reviewId, reviewElement) {
    fetch(`/api/reviews/${reviewId}`, {
        method: 'DELETE',
        headers: {
            'Content-Type': 'application/json',
            'X-CSRF-TOKEN': csrfToken
        }
    })
        .then(response => {
            if (response.ok) {
                showSuccessMessage('Review deleted successfully');
                reviewElement.remove();
            } else {
                return response.text().then(text => {
                    throw new Error(text || 'Failed to delete review');
                });
            }
        })
        .catch(error => {
            console.error('Error deleting review:', error.message);
            showErrorMessage(error.message, reviewElement);
        });
}

function showSuccessMessage(message) {
    const messageElement = createMessageElement(message, 'success');
    document.body.appendChild(messageElement);
    setTimeout(() => {
        messageElement.remove();
    }, 3000);
}

function showErrorMessage(message, reviewElement) {
    const errorMessageElement = reviewElement.querySelector('.error-message');
    errorMessageElement.textContent = message;
    errorMessageElement.style.display = 'block';
    setTimeout(() => {
        errorMessageElement.style.display = 'none';
    }, 5000);
}

function createMessageElement(message, type) {
    const messageElement = document.createElement('div');
    messageElement.className = `message ${type}`;
    messageElement.textContent = message;
    return messageElement;
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

function smoothScroll(target, duration) {
    var targetElement = document.querySelector(target);
    var targetPosition = targetElement.getBoundingClientRect().top;
    var startPosition = window.pageYOffset;
    var distance = targetPosition - startPosition;
    var startTime = null;

    function animation(currentTime) {
        if (startTime === null) startTime = currentTime;
        var timeElapsed = currentTime - startTime;
        var run = ease(timeElapsed, startPosition, distance, duration);
        window.scrollTo(0, run);
        if (timeElapsed < duration) requestAnimationFrame(animation);
    }

    function ease(t, b, c, d) {
        t /= d / 2;
        if (t < 1) return c / 2 * t * t + b;
        t--;
        return -c / 2 * (t * (t - 2) - 1) + b;
    }

    requestAnimationFrame(animation);
}

document.getElementById('scrollToReviews').addEventListener('click', function(event) {
    event.preventDefault();
    smoothScroll('.product-customer-reviews', 800);
});

document.getElementById('scrollToReviewForm').addEventListener('click', function(event) {
    const loggedUserId = document.getElementById('loggedUserId').value;
    event.preventDefault();

    if (!loggedUserId) {
        window.location.href = '/login'; // Redirect to the login page
    } else {
        smoothScroll('.product-customer-reviews', 800); // Smooth scroll to the reviews section
    }
});


