package com.techie.service;

import jakarta.servlet.http.HttpServletRequest;
import lombok.Getter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BreadcrumbService {

    private static final Logger log = LoggerFactory.getLogger(BreadcrumbService.class);

    // Inner class to hold breadcrumb item information
    @Getter
    public static class BreadcrumbItem {
        private String original;
        private String capitalized;

        public BreadcrumbItem(String original) {
            this.original = original;
            this.capitalized = capitalize(original);
        }

        // Capitalize the first letter of the string
        private String capitalize(String str) {
            if (str == null || str.isEmpty()) {
                return str;
            }
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }

    // Method to generate breadcrumbs from the current request URL
    public List<BreadcrumbItem> getBreadcrumbs(HttpServletRequest request) {
        String currentUrl;

        try {
            currentUrl = request.getRequestURI();
        } catch (Exception e) {
            log.error("Error getting current URL", e);
            currentUrl = "/";
        }

        if (currentUrl == null || currentUrl.isEmpty() || "/".equals(currentUrl)) {
            log.warn("Current URL is null, empty, or homepage");
            return Collections.emptyList(); // Return an empty list for the homepage
        }

        // Remove query parameters if present
        String currentUrlWithoutParams = currentUrl.split("\\?")[0];

        // Split URL into parts and filter out empty parts
        List<BreadcrumbItem> breadcrumbParts = Arrays.stream(currentUrlWithoutParams.split("/"))
                .filter(part -> !part.isEmpty())
                .map(BreadcrumbItem::new)
                .collect(Collectors.toList());

        // Add "Techie.com" as the root
        breadcrumbParts.add(0, new BreadcrumbItem("Techie.com"));

        return breadcrumbParts;
    }
}
