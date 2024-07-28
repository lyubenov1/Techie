package com.techie.web.rest;

import com.techie.domain.model.*;
import com.techie.exceptions.*;
import com.techie.service.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
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

    @PostMapping("/post")
    public ResponseEntity<String> blacklistUser(@RequestBody UserDisplayView userDisplayView) {
        try {
            userService.blacklistUser(userDisplayView);
            return ResponseEntity.ok().body("User blacklisted");
        } catch (UsernameNotFoundException | UserAlreadyBlacklistedException | AdminBlacklistException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while blacklisting the user");
        }
    }

}
