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

function fetchMoreReviews() {
    fetch(`/api/reviews/${productId}?p=${currentPage}&s=7`)
        .then(response => response.json())
        .then(reviews => {
            reviews.forEach(review => {
                if (review.comment) {
                    const reviewElement = document.createElement('div');
                    reviewElement.classList.add('review');
                    reviewElement.innerHTML = `
            <div class="review-header">
              <div class="review-info">
                <span class="profile-picture">
                  <img src="${review.reviewer.profileImage}" alt="Profile Picture" class="user-profile-image">
                </span>
                <span class="reviewer">${review.reviewer.firstName} ${review.reviewer.lastName}</span>
              </div>
              <div class="stars-and-date">
                <span class="stars">${'★'.repeat(review.productRating)}${'☆'.repeat(5 - review.productRating)}</span>
                <span class="review-date">${new Date(review.date).toLocaleDateString()}</span>
              </div>
            </div>
            <div class="review-body">
              <p>${review.comment}</p>
              <div class="review-images">
                ${review.imageUrls.map(url => `<img src="${url}" alt="Review image">`).join('')}
              </div>
            </div>
          `;
                    reviewContainer.appendChild(reviewElement);
                }
            });
            currentPage++;
        });
}

const observer = new IntersectionObserver(entries => {
    if (entries[0].isIntersecting) {
        fetchMoreReviews();
    }
}, { threshold: 1.0 });

observer.observe(document.querySelector('.loading-indicator'));
