package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.exceptions.email.*;
import jakarta.mail.internet.*;
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
import java.text.*;
import java.util.*;

@Service
public class MailService {

    private final JavaMailSender mailSender;
    private final UserService userService;
    private final TokenService tokenService;
    private static final Logger log = LoggerFactory.getLogger(MailService.class);

    @Autowired
    public MailService(JavaMailSender mailSender, UserService userService,
                       TokenService tokenService) {
        this.mailSender = mailSender;
        this.userService = userService;
        this.tokenService = tokenService;
    }

    public void sendConfirmationEmail(String to, String token) {
        try {
            String subject = "Confirm your account deletion";
            String confirmationUrl = "http://localhost:8080/email/confirm-delete?token=" + token;
            String message = "To confirm your account deletion, please click the link below:\n" + confirmationUrl;

            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(to);
            email.setSubject(subject);
            email.setText(message);

            mailSender.send(email);
        } catch (Exception e) {
            throw new EmailNotificationException("Failed to send email.", e);
        }
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
            String htmlBody = buildEmailBody(to, product);

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlBody, true); // Set to true for HTML content

            mailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new EmailNotificationException("Failed to send email.", e);
        }
    }

    private String buildEmailBody(String userEmail, Product product) throws IOException {
        String template = loadTemplate();
        String unsubscribeToken = tokenService.createToken(userEmail);
        String unsubscribeUrl = "http://localhost:8080/email/unsubscribe?token=" + unsubscribeToken;

        DecimalFormat priceFormat = new DecimalFormat("#,##0.00");
        DecimalFormat discountFormat = new DecimalFormat("#");

        return template
                .replace("{{productImageUrl}}", product.getProductImages().getFirst().getImageUrl())
                .replace("{{productName}}", product.getName())
                .replace("{{originalPrice}}", "$" + priceFormat.format(product.getOriginalPrice()))
                .replace("{{discountedPrice}}", "$" + priceFormat.format(product.getDiscountedPrice()))
                .replace("{{discount}}", discountFormat.format(product.getDiscount()) + "%")
                .replace("{{unsubscribeUrl}}", unsubscribeUrl);
    }

    private String loadTemplate() throws IOException {
        Resource resource = new ClassPathResource("templates/" + "product-discount-email.html");
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }

    public void sendInformativeEmail(String to) {
        try {
            String subject = "Password change";
            String message = "Your password has been changed. If it wasn't you, contact us immediately.";

            SimpleMailMessage email = new SimpleMailMessage();
            email.setTo(to);
            email.setSubject(subject);
            email.setText(message);

            mailSender.send(email);
        } catch (Exception e) {
            throw new EmailNotificationException("Failed to send email.", e);
        }
    }

    public void sendResetPasswordEmail(String to, String resetToken) {
        try {
            String subject = "Reset Your Password";
            String resetUrl = "http://localhost:8080/email/reset-password?token=" + resetToken;
            String htmlBody = "<p>Click the link below to reset your password:</p>"
                    + "<p><a href=\"" + resetUrl + "\" style=\"text-decoration: none; color: #007bff;\">Reset Password</a></p>";

            MimeMessage mimeMessage = mailSender.createMimeMessage();
            MimeMessageHelper helper = new MimeMessageHelper(mimeMessage, true, "UTF-8");

            helper.setTo(to);
            helper.setSubject(subject);
            helper.setText(htmlBody, true); // Set to true for HTML content

            mailSender.send(mimeMessage);
        } catch (Exception e) {
            throw new EmailNotificationException("Failed to send email.", e);
        }
    }
}
