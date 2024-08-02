package com.techie.web.rest;

import com.techie.domain.model.*;
import com.techie.service.*;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/password")
public class PasswordResetController {

    private final SettingsService settingsService;

    @Autowired
    public PasswordResetController(SettingsService settingsService) {
        this.settingsService = settingsService;
    }

    @PostMapping("/reset-password/step-one")
    public ResponseEntity<String> resetPasswordStepOne(@RequestBody Map<String, String> request) {
        String email = request.get("email");

        if (email == null || email.isEmpty()) {
            return ResponseEntity.badRequest().body("Email is required");
        }

        try {
            settingsService.resetPasswordStepOne(email);
            return ResponseEntity.ok("Password reset email sent");
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while sending the request");
        }
    }

    @PostMapping("/reset-password/step-two")
    public ResponseEntity<?> resetPasswordStepTwo(@RequestBody @Valid ResetPasswordRequest request) {
        try {
            settingsService.resetPasswordStepTwo(request);
            return ResponseEntity.ok("Password successfully reset!");
        } catch (UsernameNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
        catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while resetting password");
        }
    }
}
