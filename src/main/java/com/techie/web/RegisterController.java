package com.techie.web;

import com.techie.domain.model.*;
import com.techie.service.*;
import jakarta.servlet.http.*;
import jakarta.validation.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.security.core.context.*;
import org.springframework.security.web.context.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.validation.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.*;

@Controller
@RequestMapping("/register")
public class RegisterController {

    private static final String BINDING_RESULT_PATH = "org.springframework.validation.BindingResult.";
    private final UserService userService;
    private final SecurityContextRepository securityContextRepository;

    @Autowired
    public RegisterController(UserService userService, SecurityContextRepository securityContextRepository) {
        this.userService = userService;
        this.securityContextRepository = securityContextRepository;
    }

    @GetMapping
    public String getRegister(Model model) {
        if (!model.containsAttribute("userRegisterForm")) {
            model.addAttribute("userRegisterForm", new UserRegisterFormDTO());
        }
        return "register";
    }

    @ModelAttribute("userRegisterForm")
    public UserRegisterFormDTO initForm() {
        return new UserRegisterFormDTO();
    }

    @PostMapping
    public String postRegister(
            @Valid @ModelAttribute("userRegisterForm") UserRegisterFormDTO userRegisterForm,
            BindingResult bindingResult,
            RedirectAttributes redirectAttributes,
            HttpServletRequest request,
            HttpServletResponse response) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("userRegisterForm", userRegisterForm)
                    .addFlashAttribute(BINDING_RESULT_PATH + "userRegisterForm", bindingResult);

            return "redirect:/register";
        }

        userService.registerUser(userRegisterForm, successfulAuth -> {
            SecurityContextHolderStrategy strategy = SecurityContextHolder.getContextHolderStrategy();

            SecurityContext context = strategy.createEmptyContext();
            context.setAuthentication(successfulAuth);

            strategy.setContext(context);

            securityContextRepository.saveContext(context, request, response);
        });

        redirectAttributes.addFlashAttribute("successMessage", "Registration successful!");
        return "redirect:/";
    }
}