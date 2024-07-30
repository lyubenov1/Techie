package com.techie.web.rest;

import com.techie.domain.model.*;
import com.techie.exceptions.subscription.*;
import com.techie.exceptions.user.*;
import com.techie.service.*;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/settings")
public class SettingsController {

    private final UserService userService;
    private final SubscriptionService subscriptionService;

    @Autowired
    public SettingsController(UserService userService, SubscriptionService subscriptionService) {
        this.userService = userService;
        this.subscriptionService = subscriptionService;
    }

    //@PatchMapping("/profile-image/change")
    //public ResponseEntity<?> changeProfileImage(@AuthenticationPrincipal UserDetails userDetails) {
//
    //}
//
    //@PatchMapping("/details/change")
    //public ResponseEntity<?> changeDetails(@AuthenticationPrincipal UserDetails userDetails,
    //                                       @RequestBody UserDetailsChangeModel model) {
//
    //}
//
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
            subscriptionService.changeSubscriptionStatusFooter(email);
            return ResponseEntity.ok("You have successfully subscribed to our newsletter!");
        } catch (UserIsAlreadySubscribedException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
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
        }
    }

    //@DeleteMapping("account/delete")
    //public ResponseEntity<?> deleteAccount(@AuthenticationPrincipal UserDetails userDetails) {
//
    //}

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleException(Exception e) {
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
    }
}
