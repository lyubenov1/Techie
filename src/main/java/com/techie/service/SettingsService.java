package com.techie.service;

import com.cloudinary.*;
import com.cloudinary.utils.*;
import com.techie.domain.entities.*;
import com.techie.exceptions.other.*;
import com.techie.exceptions.user.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.multipart.*;

import java.io.*;
import java.util.*;

@Service
public class SettingsService {

    private final UserService userService;
    private final Cloudinary cloudinary;
    private static final Logger log = LoggerFactory.getLogger(SettingsService.class);

    @Autowired
    public SettingsService(UserService userService, Cloudinary cloudinary) {
        this.userService = userService;
        this.cloudinary = cloudinary;
    }

    public boolean changeUserDetails(String email, String firstName, String lastName, String newUsername)
            throws UsernameNotFoundException, UsernameAlreadyTakenException {
        UserEntity user = userService.findByUsernameNoFetches(email);

        if (user == null) {
            throw new UsernameNotFoundException("User not found");
        }

        boolean isChanged = updateUserDetails(user, firstName, lastName, newUsername);

        if (isChanged) {
            userService.saveUser(user);
        }

        return isChanged;
    }

    private boolean updateUserDetails(UserEntity user, String firstName, String lastName, String newUsername)
                                        throws UsernameAlreadyTakenException {
        boolean isChanged = false;

        if (isNewUsernameValid(user, newUsername)) {
            user.setUsername(newUsername);
            isChanged = true;
        }
        if (isNonEmpty(firstName) && !firstName.equals(user.getFirstName())) {
            user.setFirstName(firstName);
            isChanged = true;
        }
        if (isNonEmpty(lastName) && !lastName.equals(user.getLastName())) {
            user.setLastName(lastName);
            isChanged = true;
        }
        return isChanged;
    }

    private boolean isNewUsernameValid(UserEntity user, String newUsername) throws UsernameAlreadyTakenException {
        if (isNonEmpty(newUsername) && !newUsername.equals(user.getUsername())) {
            if (userService.existsByUsername(newUsername)) {
                throw new UsernameAlreadyTakenException();
            }
            return true;
        }
        return false;
    }

    private boolean isNonEmpty(String value) {
        return value != null && !value.trim().isEmpty();
    }

    @Transactional
    @SuppressWarnings("unchecked")
    public void changeProfileImage(UserDetails userDetails, MultipartFile file) throws IOException {
        UserEntity user = userService.findByUsernameNoFetches(userDetails.getUsername());

        // Check if user already has a profile image
        if (user.getPublicId() != null && !user.getPublicId().isEmpty()) {
            // Delete the existing image from Cloudinary
            try {
                cloudinary.uploader().destroy(user.getPublicId(), ObjectUtils.asMap("invalidate", "true"));
            } catch (IOException e) {
                log.error("Failed to delete existing image from Cloudinary", e);
                throw new CloudinaryImageDeletionException("Failed to delete image: " + user.getPublicId());
            }
        }

        // Upload new file to Cloudinary
        String folderPath = "project/users/" + user.getId();
        Map<String, Object> uploadResult = (Map<String, Object>) cloudinary.uploader().upload(file.getBytes(),
                ObjectUtils.asMap("folder", folderPath));

        // Get the URL and public_id of the uploaded image
        String imageUrl = (String) uploadResult.get("secure_url");
        String publicId = (String) uploadResult.get("public_id");

        userService.updateProfileImage(user, imageUrl, publicId);
    }
}
