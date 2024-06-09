package com.techie.service;

import jakarta.servlet.http.*;
import lombok.*;
import org.slf4j.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class BreadcrumbService {

    private static final Logger log = LoggerFactory.getLogger(BreadcrumbService.class);

    @Getter
    public static class BreadcrumbItem {
        private final String original;
        private final String capitalized;

        public BreadcrumbItem(String original) {
            this.original = original;
            this.capitalized = capitalize(original);
        }

        private String capitalize(String str) {
            if (str == null || str.isEmpty()) {
                return str;
            }
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }

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
            return Collections.emptyList();
        }

        // Remove query parameters if present
        String currentUrlWithoutParams = currentUrl.split("\\?")[0];

        return Arrays.stream(currentUrlWithoutParams.split("/"))
                .filter(part -> !part.isEmpty())
                .map(BreadcrumbItem::new)
                .collect(Collectors.toList());
    }
}
