const myModal = document.getElementById('createAddressModal');
const myInput = document.getElementById('addressName');

myModal.addEventListener('shown.bs.modal', () => {
    myInput.focus();
});

document.addEventListener('DOMContentLoaded', () => {
    const addressDeleteButton = document.getElementById('deleteAddress');

    function fetchAndPopulateAddresses() {
        fetch('/api/address/get')
            .then(response => response.json())
            .then(addresses => {
                const addressItemsDiv = document.querySelector('.address-items');
                addressItemsDiv.innerHTML = ''; // Clear existing content

                addresses.forEach(address => {
                    const addressItem = createAddressItem(address);
                    addressItemsDiv.appendChild(addressItem);
                });

                // Add "Create a new address" button at the end
                const newAddressItem = document.createElement('div');
                newAddressItem.classList.add('address-item', 'new-address');

                const createAddressBtn = document.createElement('button');
                createAddressBtn.id = 'create-address-btn';
                createAddressBtn.classList.add('btn', 'btn-primary');
                createAddressBtn.type = 'button';
                createAddressBtn.dataset.bsToggle = 'modal';
                createAddressBtn.dataset.bsTarget = '#createAddressModal';

                const plusSpan = document.createElement('span');
                plusSpan.textContent = '+';

                const createTextSpan = document.createElement('span');
                createTextSpan.classList.add('address-item-text', 'create');
                createTextSpan.textContent = 'Create a new address';

                createAddressBtn.appendChild(plusSpan);
                createAddressBtn.appendChild(createTextSpan);

                newAddressItem.appendChild(createAddressBtn);
                addressItemsDiv.appendChild(newAddressItem);

                if (addresses.length > 0) {
                    const lastViewedAddressId = localStorage.getItem('lastViewedAddressId');
                    const addressToShow = lastViewedAddressId
                        ? addresses.find(a => a.id.toString() === lastViewedAddressId)
                        : addresses[0];
                    showAddress(addressToShow || addresses[0]);
                }
            })
            .catch(error => {
                console.error('Error fetching addresses:', error);
            });
    }

    function createAddressItem(address) {
        const addressItem = document.createElement('div');
        addressItem.classList.add('address-item', 'clickable');
        addressItem.setAttribute('data-address-name', address.name);
        addressItem.onclick = function() {
            showAddress(address);
        };

        const addressItemContent = document.createElement('div');
        addressItemContent.classList.add('address-item-content');

        const addressItemText = document.createElement('div');
        addressItemText.classList.add('address-item-text');
        addressItemText.textContent = address.name;

        addressItemContent.appendChild(addressItemText);
        addressItem.appendChild(addressItemContent);

        return addressItem;
    }

    function showAddress(address) {
        const addressNameElem = document.getElementById('address-name');
        const addressDetailsDiv = document.getElementById('addressDetails');

        localStorage.setItem('lastViewedAddressId', address.id.toString());

        addressNameElem.textContent = address.name;

        // Clear previous address details
        addressDetailsDiv.innerHTML = '';

        // Populate address details
        const detailsToShow = [
            { key: 'Address Line 1', value: address.addressLine1 },
            { key: 'Address Line 2', value: address.addressLine2 },
            { key: 'City', value: address.city },
            { key: 'Country', value: address.country },
            { key: 'Zipcode', value: address.zipcode }
        ];

        detailsToShow.forEach(detail => {
            if (detail.value) {  // Only create element if value exists
                const detailElem = document.createElement('p');
                detailElem.innerHTML = `<strong>${detail.key}:</strong> ${detail.value}`;
                addressDetailsDiv.appendChild(detailElem);
            }
        });

        const editButton = document.getElementById('editAddress');
        editButton.style.display = 'inline-block';
        editButton.onclick = function() {
            openEditModal(address);
        };

        addressDeleteButton.style.display = 'inline-block';
        addressDeleteButton.onclick = function() {
            deleteAddress(address.id);
        };
    }

    const createAddressForm = document.getElementById('createAddressForm');
    createAddressForm.addEventListener('submit', function(event) {
        event.preventDefault();
        createNewAddress();
    });

    function createNewAddress() {
        const csrfToken = document.getElementById('csrf-token').value;

        // Create an AddressDTO object from form inputs
        const addressDTO = {
            name: document.getElementById('addressName').value,
            addressLine1: document.getElementById('addressLine1').value,
            addressLine2: document.getElementById('addressLine2').value,
            city: document.getElementById('city').value,
            country: document.getElementById('country').value,
            zipcode: document.getElementById('zipcode').value
        };

        fetch('/api/address/create', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': csrfToken
            },
            body: JSON.stringify(addressDTO)
        })
            .then(response => {
                if (!response.ok) {
                    return response.text().then(text => {
                        if (response.headers.get('content-type')?.includes('text/html')) {
                            throw new Error('An unexpected error occurred');
                        } else {
                            throw new Error(text || 'Failed to create address');
                        }
                    });
                }
                return response.text();
            })
            .then(data => {
                console.log(data);
                showSuccessMessage("Address created successfully!");
                // Close the modal
                const modal = bootstrap.Modal.getInstance(document.getElementById('createAddressModal'));
                modal.hide();
                // Reset the form
                createAddressForm.reset();
                // Refresh the address list
                fetchAndPopulateAddresses();
            })
            .catch(error => {
                console.error('Error:', error);
                showErrorMessage("An error occurred while creating the address: " + error.message);
            });
    }

    const editAddressForm = document.getElementById('editAddressForm');
    const deleteAddressBtn = document.getElementById('deleteAddressBtn');

    editAddressForm.addEventListener('submit', function(event) {
        event.preventDefault();
        updateAddress();
    });

    deleteAddressBtn.addEventListener('click', function() {
        const addressId = document.getElementById('editAddressId').value;
        deleteAddress(addressId);
    });

    function openEditModal(address) {
        const editAddressModal = new bootstrap.Modal(document.getElementById('editAddressModal'), {});

        // Populate the form fields
        document.getElementById('editAddressId').value = address.id;
        document.getElementById('editAddressName').value = address.name;
        document.getElementById('editAddressLine1').value = address.addressLine1;
        document.getElementById('editAddressLine2').value = address.addressLine2 || '';
        document.getElementById('editCity').value = address.city;
        document.getElementById('editCountry').value = address.country;
        document.getElementById('editZipcode').value = address.zipcode;

        // Open the modal
        editAddressModal.show();
    }

    function updateAddress() {
        const addressId = document.getElementById('editAddressId').value;
        const csrfToken = document.getElementById('csrf-token').value;

        // Create an updated AddressDTO object
        const updatedAddressDTO = {
            id: addressId,
            name: document.getElementById('editAddressName').value,
            addressLine1: document.getElementById('editAddressLine1').value,
            addressLine2: document.getElementById('editAddressLine2').value,
            city: document.getElementById('editCity').value,
            country: document.getElementById('editCountry').value,
            zipcode: document.getElementById('editZipcode').value
        };

        fetch(`/api/address/edit`, {
            method: 'PATCH',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': csrfToken
            },
            body: JSON.stringify(updatedAddressDTO)
        })
            .then(response => {
                if (!response.ok) {
                    return response.text().then(text => {
                        if (response.headers.get('content-type')?.includes('text/html')) {
                            throw new Error('An unexpected error occurred');
                        } else {
                            throw new Error(text || 'Failed to update address');
                        }
                    });
                }
                return response.text();
            })
            .then(data => {
                console.log(data);
                showSuccessMessage("Address updated successfully!");
                // Close the modal
                const modal = bootstrap.Modal.getInstance(document.getElementById('editAddressModal'));
                modal.hide();
                // Refresh the address list
                fetchAndPopulateAddresses();
            })
            .catch(error => {
                console.error('Error:', error);
                showErrorMessage("An error occurred while updating the address: " + error.message);
            });
    }

    function deleteAddress(addressId) {
        const csrfToken = document.getElementById('csrf-token').value;

        fetch(`/api/address/delete/${addressId}`, {
            method: 'DELETE',
            headers: {
                'Content-Type': 'application/json',
                'X-CSRF-TOKEN': csrfToken
            }
        })
            .then(response => {
                if (!response.ok) {
                    return response.text().then(text => {
                        if (response.headers.get('content-type')?.includes('text/html')) {
                            throw new Error('An unexpected error occurred');
                        } else {
                            throw new Error(text || 'Failed to delete address');
                        }
                    });
                }
                return response.text();
            })
            .then(data => {
                console.log(data);
                showSuccessMessage("Address deleted successfully!");
                // Close the modal
                const modal = bootstrap.Modal.getInstance(document.getElementById('editAddressModal'));
                modal.hide();
                // Refresh the address list
                fetchAndPopulateAddresses();
            })
            .catch(error => {
                console.error('Error:', error);
                showErrorMessage("An error occurred while deleting the address: " + error.message);
            });
    }


    function showSuccessMessage(message) {
        const successDiv = document.querySelector('.address-success');
        const successP = successDiv.querySelector('p');
        successP.textContent = message;

        successDiv.classList.add('show');

        setTimeout(() => {
            successDiv.classList.remove('show');
        }, 5500);
    }

    function showErrorMessage(message) {
        const errorSpan = document.querySelector('.address-modal-error');
        errorSpan.textContent = message;

        errorSpan.style.display = 'block';
        errorSpan.style.opacity = '0';

        // Force a reflow before changing the opacity
        errorSpan.offsetHeight;

        errorSpan.style.opacity = '1';

        setTimeout(() => {
            errorSpan.style.opacity = '0';
            setTimeout(() => {
                errorSpan.style.display = 'none';
                errorSpan.textContent = '';
            }, 500);
        }, 5000);
    }

    fetchAndPopulateAddresses();
});