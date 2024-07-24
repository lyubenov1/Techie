document.addEventListener('DOMContentLoaded', function() {
    const reviewForm = document.getElementById('review-form');
    const csrfToken = document.querySelector('#csrf-token').value;

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
                    uploadedFiles.push(file);
                    const reader = new FileReader();
                    reader.onload = function(e) {
                        console.log('File read successfully');
                        const imgContainer = document.createElement('div');
                        imgContainer.className = 'image-preview-container';

                        const img = document.createElement('img');
                        img.src = e.target.result;

                        const removeIcon = document.createElement('i');
                        removeIcon.className = 'fas fa-times remove-image';
                        removeIcon.addEventListener('click', function() {
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
                if (review.comment) {
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
                <span class="stars">${'★'.repeat(review.productRating)}${'☆'.repeat(5 - review.productRating)}</span>
              <p>${review.comment}</p>
              <div class="review-images">
                  ${review.imageUrls.map((url, index) => {
                        // Append transformation parameters to the URL
                        const transformedUrl = url.replace("/upload/", "/upload/w_180,h_150,c_fill/");
                        return `<img src="${transformedUrl}" alt="Review image" onclick="openModal('${review.imageUrls}', ${index})">`;
                    }).join('')}
              </div>
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
        });
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
