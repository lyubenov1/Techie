package com.techie.web.rest;

import com.techie.domain.model.*;
import com.techie.exceptions.*;
import com.techie.service.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(ReviewController.class);

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUsers(@RequestParam(required = false) String query)
                                        throws UserAlreadyBlacklistedException {
        try {
            List<UserDisplayView> users = userService.getUsers(query);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PostMapping("/blacklist/post")
    public ResponseEntity<String> blacklistUser(@RequestBody UserDisplayView userDisplayView)
                                                  throws UsernameNotFoundException, UserAlreadyBlacklistedException,
                                                      AdminModeratorBlacklistException {
        try {
            userService.blacklistUser(userDisplayView);
            return ResponseEntity.ok().body("User blacklisted");
        } catch (UsernameNotFoundException | UserAlreadyBlacklistedException | AdminModeratorBlacklistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while blacklisting the user");
        }
    }

    @GetMapping("/blacklist/get")
    public ResponseEntity<?> getBlacklistedUsers(@RequestParam(name = "p", required = false) int page,
                                                 @RequestParam(name = "s", required = false) int size) {
        try {
            Page<UserDisplayView> users = userService.getBlacklistedUsers(page, size);
            return getResponseEntity(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/blacklist/delete")
    public ResponseEntity<String> removeFromBlacklist(@RequestParam Long userId)
                                                        throws UserNotInBlacklistException {
        try {
            userService.removeFromBlacklist(userId);
            return ResponseEntity.ok("User successfully removed from blacklist");
        } catch (UserNotInBlacklistException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @PostMapping("/moderator/post")
    public ResponseEntity<String> makeModerator(@RequestBody UserDisplayView userDisplayView)
                                                  throws UserAlreadyHasRoleException {
        try {
            userService.makeModerator(userDisplayView);
            return ResponseEntity.ok("User successfully made moderator");
        } catch (UserAlreadyHasRoleException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());  // 409
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }


    @GetMapping("/moderator/get")
    public ResponseEntity<?> getModerators(@RequestParam(name = "p", required = false) int page,
                                                 @RequestParam(name = "s", required = false) int size) {
        try {
            Page<UserDisplayView> users = userService.getModerators(page, size);
            return getResponseEntity(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    private ResponseEntity<?> getResponseEntity(Page<UserDisplayView> users) {
        Map<String, Object> response = new HashMap<>();
        response.put("content", users.getContent());
        response.put("number", users.getNumber());
        response.put("totalPages", users.getTotalPages());
        response.put("totalElements", users.getTotalElements());
        return ResponseEntity.ok(response);
    }

    @DeleteMapping("/moderator/remove")
    public ResponseEntity<String> removeModerator(@RequestParam Long userId) throws UserNotFoundException {
        try {
            userService.removeModeratorRoleFromUser(userId);
            return ResponseEntity.ok("Moderator role removed successfully");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
