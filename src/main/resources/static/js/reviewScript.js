document.addEventListener('DOMContentLoaded', function() {
    const commentTextarea = document.getElementById('review-comment');
    const charCount = document.getElementById('comment-char-count');
    const imageUpload = document.getElementById('image-upload');
    const imagePreview = document.getElementById('image-preview');
    const imageWarning = document.getElementById('image-warning');

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
        imageWarning.textContent = message;
        imageWarning.classList.add('show');
        setTimeout(() => {
            imageWarning.classList.remove('show');
        }, 5000);
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

