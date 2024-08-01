package com.techie.web.rest;

import com.techie.domain.model.*;
import com.techie.exceptions.subscription.*;
import com.techie.exceptions.user.*;
import com.techie.service.*;
import jakarta.validation.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

import java.io.*;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    private final SubscriptionService subscriptionService;
    private final SettingsService settingsService;
    private final MailService mailService;
    private final TokenService tokenService;
    private static final Logger log = LoggerFactory.getLogger(SettingsController.class);

    @Autowired
    public SettingsController(SubscriptionService subscriptionService, SettingsService settingsService,
                              MailService mailService, TokenService tokenService) {
        this.subscriptionService = subscriptionService;
        this.settingsService = settingsService;
        this.mailService = mailService;
        this.tokenService = tokenService;
    }

    @PatchMapping("/profile-image/change")
    public ResponseEntity<?> changeProfileImage(@AuthenticationPrincipal UserDetails userDetails,
                                                @RequestParam("image") MultipartFile file) {
        if (file.isEmpty()) {
            return ResponseEntity.badRequest().body("Please select a file to upload");
        }

        try {
            settingsService.changeProfileImage(userDetails, file);
            return ResponseEntity.ok().body("Profile image updated successfully");
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to upload image: " + e.getMessage());
        }
    }

    @PatchMapping("/details/change")
    public ResponseEntity<?> changeDetails(@AuthenticationPrincipal UserDetails userDetails,
                                           @RequestBody DetailsChangeRequest request) {
        String firstName = request.getFirstName();
        String lastName = request.getLastName();
        String username = request.getUsername();

        // Validate that at least one field is present
        if (firstName == null && lastName == null && username == null) {
            return ResponseEntity.badRequest().body("At least one field must be provided for update");
        }

        try {
            boolean isUpdated = settingsService.changeUserDetails(userDetails.getUsername(), firstName, lastName, username);
            if (isUpdated) {
                return ResponseEntity.ok("You have successfully changed your details!");
            } else {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("No changes were made");
            }
        } catch (UsernameAlreadyTakenException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating details");
        }
    }

    //@PatchMapping("/password/change")
    //public ResponseEntity<?> changePassword(@AuthenticationPrincipal UserDetails userDetails,
    //                                        @RequestBody @Valid ChangePasswordModel model) {
//
    //}
//
    @PatchMapping("/subscription/change/email")
    public ResponseEntity<?> changeSubscriptionStatusFooter(@Valid @RequestBody SubscriptionUpdateRequest request) {
        String email = request.getEmail();
        try {
            subscriptionService.subscribeFromFooter(email);
            return ResponseEntity.ok("You have successfully subscribed to our newsletter!");
        } catch (UserIsAlreadySubscribedException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating subscription status");
        }
    }

    @PatchMapping("/subscription/change/status")
    public ResponseEntity<?> changeSubscriptionStatusSettings(@AuthenticationPrincipal UserDetails userDetails,
                                                            @Valid @RequestBody SubscriptionUpdateRequest request) {
        Boolean status = request.getStatus();
        try {
            subscriptionService.changeSubscriptionStatusSettings(userDetails.getUsername(), status);
            return ResponseEntity.ok("Subscription status updated successfully.");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating subscription status");
        }
    }

    @DeleteMapping("account/delete")
    public ResponseEntity<?> deleteAccount(@AuthenticationPrincipal UserDetails userDetails) {
        String username = userDetails.getUsername();
        String token = tokenService.createToken(username);
        mailService.sendConfirmationEmail(userDetails.getUsername(), token);
        return ResponseEntity.ok("Confirmation email sent.");
    }

}
