package com.techie.web;

import com.techie.service.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.userdetails.*;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

@Controller
@RequestMapping("/email")
public class EmailLinkController {

    private final UserService userService;
    private final SubscriptionService subscriptionService;
    private final SettingsService settingsService;

    @Autowired
    public EmailLinkController(UserService userService, SubscriptionService subscriptionService,
                               SettingsService settingsService) {
        this.userService = userService;
        this.subscriptionService = subscriptionService;
        this.settingsService = settingsService;
    }

    @GetMapping("/confirm-delete")
    public String confirmDelete(@RequestParam("token") String token, RedirectAttributes redirectAttributes) {
        try {
            userService.confirmDelete(token);
            redirectAttributes.addFlashAttribute("messageSuccess", "Account successfully deleted");
        } catch (IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("messageError", e.getMessage());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("messageError", "An error occurred while processing your request.");
        }
        return "redirect:/";
    }

    @GetMapping("/unsubscribe")
    public String unsubscribeFromNewsletter(@RequestParam("token") String token, RedirectAttributes redirectAttributes) {
        try {
            subscriptionService.unsubscribe(token);
            redirectAttributes.addFlashAttribute("messageSuccess", "Successfully unsubscribed from Newsletter");
        } catch (UsernameNotFoundException | IllegalArgumentException e) {
            redirectAttributes.addFlashAttribute("messageError", e.getMessage());
        } catch (Exception e) {
            redirectAttributes.addFlashAttribute("messageError", "An error occurred while processing your request.");
        }
        return "redirect:/";
    }
}
