package com.techie.web.rest;

import com.techie.domain.model.requests.*;
import com.techie.exceptions.settings.*;
import com.techie.exceptions.subscription.*;
import com.techie.exceptions.user.*;
import com.techie.service.*;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.*;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    private final SubscriptionService subscriptionService;
    private final SettingsService settingsService;

    @Autowired
    public SettingsController(SubscriptionService subscriptionService, SettingsService settingsService) {
        this.subscriptionService = subscriptionService;
        this.settingsService = settingsService;
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
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
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
                return ResponseEntity.ok("No changes were made");
            }
        } catch (UsernameAlreadyTakenException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating details");
        }
    }

    @PatchMapping("/password/change")
    public ResponseEntity<?> changePassword(@AuthenticationPrincipal UserDetails userDetails,
                                            @RequestBody @Valid ChangePasswordRequest request) {

        try {
            settingsService.changePassword(userDetails, request);
            return ResponseEntity.ok("Password changed successfully");
        } catch (IncorrectPasswordException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating password");
        }
    }

    @PatchMapping("/subscription/change/email")
    public ResponseEntity<?> changeSubscriptionStatusFooter(@Valid @RequestBody SubscriptionUpdateRequest request) {
        String email = request.getEmail();
        try {
            subscriptionService.subscribeFromFooter(email);
            return ResponseEntity.ok("You have successfully subscribed to our newsletter!");
        } catch (UserIsAlreadySubscribedException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (UsernameNotFoundException e) {
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
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while updating subscription status");
        }
    }

    @DeleteMapping("account/delete")
    public ResponseEntity<?> deleteAccount(@AuthenticationPrincipal UserDetails userDetails) {
        try {
            settingsService.deleteAccount(userDetails);
            return ResponseEntity.ok("Confirmation email sent.");
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An unexpected error occurred.");
        }
    }
}
