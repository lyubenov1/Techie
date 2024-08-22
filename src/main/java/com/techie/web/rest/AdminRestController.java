package com.techie.web.rest;

import com.techie.domain.model.models.*;
import com.techie.exceptions.product.*;
import com.techie.exceptions.role.*;
import com.techie.exceptions.user.*;
import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.http.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api/admin")
public class AdminRestController {

    private final AdminService adminService;

    @Autowired
    public AdminRestController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/get")
    public ResponseEntity<?> getUsers(@RequestParam(required = false) String query)
                                        throws UserAlreadyBlacklistedException {
        try {
            List<UserDisplayView> users = adminService.getUsers(query);
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
            adminService.blacklistUser(userDisplayView);
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
            Page<UserDisplayView> users = adminService.getBlacklistedUsers(page, size);
            return getResponseEntity(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/blacklist/delete")
    public ResponseEntity<String> removeFromBlacklist(@RequestParam Long userId)
                                                        throws UserNotInBlacklistException {
        try {
            adminService.removeFromBlacklist(userId);
            return ResponseEntity.ok("User successfully removed from blacklist");
        } catch (UserNotInBlacklistException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred: " + e.getMessage());
        }
    }

    @PatchMapping("/moderator/patch")
    public ResponseEntity<String> makeModerator(@RequestBody UserDisplayView userDisplayView)
                                                  throws UserAlreadyHasRoleException {
        try {
            adminService.makeModerator(userDisplayView);
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
            Page<UserDisplayView> users = adminService.getModerators(page, size);
            return getResponseEntity(users);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @DeleteMapping("/moderator/remove")
    public ResponseEntity<String> removeModerator(@RequestParam Long userId) {
        try {
            adminService.removeModeratorRoleFromUser(userId);
            return ResponseEntity.ok("Moderator role removed successfully");
        } catch (UserNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (UserDoesNotHaveRoleException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());  // 409 Conflict
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/promotion/get")
    public ResponseEntity<?> getPromotionProducts(@RequestParam(required = false) String query) {
        try {
            List<ProductAdminView> products = adminService.getProductsAdmin(query);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @GetMapping("/discount/get")
    public ResponseEntity<?> getDiscountedProducts(@RequestParam(name = "p", required = false) int page,
                                                   @RequestParam(name = "s", required = false) int size) {
        try {
            Page<ProductAdminView> products = adminService.getDiscountedProducts(page, size);
            return getResponseEntity(products);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    @PatchMapping("/promotion/patch")
    public ResponseEntity<?> discountProduct(@RequestBody ProductAdminView productAdminView)
            throws ProductNotFoundException, ProductAlreadyDiscountedException {
        try {
            adminService.discountProduct(productAdminView);
            return ResponseEntity.ok().body("Product successfully discounted");
        } catch (ProductNotFoundException | ProductAlreadyDiscountedException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("An error occurred while discounting the product");
        }
    }

    @DeleteMapping("/promotion/delete")
    public ResponseEntity<String> removeDiscount(@RequestParam Long productId)
            throws ProductNotFoundException {
        try {
            adminService.removeDiscount(productId);
            return ResponseEntity.ok("Discount successfully removed from product");
        } catch (ProductNotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(e.getMessage());
        }
    }

    private <T> ResponseEntity<?> getResponseEntity(Page<T> page) {
        Map<String, Object> response = new HashMap<>();
        response.put("content", page.getContent());
        response.put("number", page.getNumber());
        response.put("totalPages", page.getTotalPages());
        response.put("totalElements", page.getTotalElements());
        return ResponseEntity.ok(response);
    }
}
