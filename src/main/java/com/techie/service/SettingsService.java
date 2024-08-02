package com.techie.service;

import com.cloudinary.*;
import com.cloudinary.utils.*;
import com.techie.domain.entities.*;
import com.techie.domain.model.*;
import com.techie.exceptions.other.*;
import com.techie.exceptions.settings.*;
import com.techie.exceptions.user.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.security.crypto.password.*;
import org.springframework.stereotype.*;
import org.springframework.transaction.annotation.*;
import org.springframework.web.multipart.*;

import java.io.*;
import java.util.*;

@Service
public class SettingsService {

    private final UserService userService;
    private final Cloudinary cloudinary;
    private final MailService mailService;
    private final TokenService tokenService;
    private final PasswordEncoder passwordEncoder;
    private static final Logger log = LoggerFactory.getLogger(SettingsService.class);

    @Autowired
    public SettingsService(UserService userService, Cloudinary cloudinary,
                           MailService mailService, TokenService tokenService,
                           PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.cloudinary = cloudinary;
        this.mailService = mailService;
        this.tokenService = tokenService;
        this.passwordEncoder = passwordEncoder;
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

    @Transactional
    public void changePassword(UserDetails userDetails, ChangePasswordRequest request) {
        UserEntity user = userService.findByUsernameNoFetches(userDetails.getUsername());

        // Check if the old password is correct
        if (!passwordEncoder.matches(request.getOldPassword(), user.getPassword())) {
            throw new IncorrectPasswordException();
        }

        // Encode the new password
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // Update the user's password
        user.setPassword(encodedPassword);
        userService.saveUser(user);
        mailService.sendInformativeEmail(userDetails.getUsername());
    }

    public void deleteAccount(UserDetails userDetails) {
        String username = userDetails.getUsername();
        String token = tokenService.createToken(username);
        mailService.sendConfirmationEmail(userDetails.getUsername(), token);
    }

    @Transactional
    public void resetPasswordStepOne(String email) {
        // This will throw UsernameNotFoundException if the user is not found
        userService.findByUsernameNoFetches(email);

        String token = tokenService.createToken(email);
        mailService.sendResetPasswordEmail(email, token);
    }

    @Transactional
    public void verifyToken(String token) {
        String email = tokenService.getEmailByToken(token);
        if (email == null) {
            throw new IllegalArgumentException("Invalid or expired token");
        }
        tokenService.removeToken(token);
    }

    @Transactional
    public void resetPasswordStepTwo(ResetPasswordRequest request) {
        String token = tokenService.getEmailByToken(request.getToken());
        UserEntity user = userService.findByUsernameNoFetches(token);

        // Encode the new password
        String encodedPassword = passwordEncoder.encode(request.getPassword());

        // Update the user's password
        user.setPassword(encodedPassword);
        userService.saveUser(user);
        mailService.sendInformativeEmail(user.getEmail());
    }
}
