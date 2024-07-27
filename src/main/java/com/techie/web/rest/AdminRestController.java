package com.techie.web.rest;

import com.techie.domain.model.*;
import com.techie.exceptions.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

    private final UserService userService;

    @Autowired
    public AdminRestController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUsers(@RequestParam(required = false) String query)
                                        throws UserAlreadyBlacklistedException {
        try {
            List<UserBlacklistView> users = userService.getUsers(query);
            return ResponseEntity.ok(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }
}
