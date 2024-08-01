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
    private final RegisterService registerService;
    private final SecurityContextRepository securityContextRepository;

    @Autowired
    public RegisterController(RegisterService registerService, SecurityContextRepository securityContextRepository) {
        this.registerService = registerService;
        this.securityContextRepository = securityContextRepository;
    }

    @GetMapping
    public String getRegister(Model model) {
        if (!model.containsAttribute("registerModel")) {
            model.addAttribute("registerModel", new RegisterModel());
        }
        return "register";
    }

    @ModelAttribute("registerModel")
    public RegisterModel initForm() {
        return new RegisterModel();
    }

    @PostMapping
    public String postRegister(
            @Valid @ModelAttribute("registerModel") RegisterModel registerModel,
            BindingResult bindingResult, RedirectAttributes redirectAttributes,
            HttpServletRequest request, HttpServletResponse response) {

        if (bindingResult.hasErrors()) {
            redirectAttributes
                    .addFlashAttribute("registerModel", registerModel)
                    .addFlashAttribute(BINDING_RESULT_PATH + "registerModel", bindingResult);

            return "redirect:/register";
        }

        registerService.registerUser(registerModel, successfulAuth -> {
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