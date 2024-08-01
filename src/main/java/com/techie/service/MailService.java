package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.exceptions.subscription.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.core.io.*;
import org.springframework.mail.*;
import org.springframework.mail.javamail.*;
import org.springframework.scheduling.annotation.*;
import org.springframework.stereotype.*;
import org.springframework.util.*;

import java.io.*;
import java.nio.charset.*;
import java.util.*;

@Service
public class MailService {

    private final JavaMailSender mailSender;
    private final UserService userService;
    private static final Logger log = LoggerFactory.getLogger(MailService.class);

    @Autowired
    public MailService(JavaMailSender mailSender, UserService userService) {
        this.mailSender = mailSender;
        this.userService = userService;
    }

    public void sendConfirmationEmail(String to, String token) {
        String subject = "Confirm your account deletion";
        String confirmationUrl = "http://localhost:8080/email/confirm-delete?token=" + token;
        String message = "To confirm your account deletion, please click the link below:\n" + confirmationUrl;

        SimpleMailMessage email = new SimpleMailMessage();
        email.setTo(to);
        email.setSubject(subject);
        email.setText(message);

        mailSender.send(email);
    }

    @Async
    public void sendDiscountNotification(Product product) {
        List<UserEntity> subscribedUsers = userService.getSubscribedUsers();

        for (UserEntity user : subscribedUsers) {
            try {
                sendEmail(user.getEmail(), product);
            } catch (Exception e) {
                log.error("Failed to send discount notification email to user: {}. Error: {}", user.getEmail(), e.getMessage(), e);
            }
        }
    }

    private void sendEmail(String to, Product product) {
        try {
            String subject = "Discount on Product: " + product.getName();
            String body = buildEmailBody(product);

            SimpleMailMessage message = new SimpleMailMessage();
            message.setTo(to);
            message.setSubject(subject);
            message.setText(body);

            mailSender.send(message);
            log.info("Discount notification email sent to {}", to);
        } catch (Exception e) {
            log.error("Failed to send email to {}. Error: {}", to, e.getMessage(), e);
            throw new EmailNotificationException("Failed to send email.", e);
        }
    }

    private String buildEmailBody(Product product) throws IOException {
        String template = loadTemplate();
        return template
                .replace("{{productImageUrl}}", product.getProductImages().getFirst().getImageUrl())
                .replace("{{productName}}", product.getName())
                .replace("{{originalPrice}}", product.getOriginalPrice().toString())
                .replace("{{discountedPrice}}", product.getDiscountedPrice().toString());
    }

    private String loadTemplate() throws IOException {
        Resource resource = new ClassPathResource("templates/" + "product-discount-email.html");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }
}