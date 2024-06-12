package com.techie.service;

import com.techie.domain.entities.*;
import jakarta.servlet.http.*;
import lombok.*;
import org.modelmapper.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class BreadcrumbService {

    private static final Logger log = LoggerFactory.getLogger(BreadcrumbService.class);
    private final CategoryService categoryService;
    private final ModelMapper modelMapper;

    @Autowired
    public BreadcrumbService(CategoryService categoryService, ModelMapper modelMapper) {
        this.categoryService = categoryService;
        this.modelMapper = modelMapper;
    }

    @Getter
    public static class BreadcrumbItem {
        private final String original;
        private final String capitalized;
        private final String url;

        public BreadcrumbItem(String original, String url) {
            this.original = original;
            this.capitalized = capitalize(original);
            this.url = url;
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

        // Remove query parameters if present
        String currentUrlWithoutParams = currentUrl.split("\\?")[0];

        List<BreadcrumbItem> breadcrumbs = new ArrayList<>();
        StringBuilder urlBuilder = new StringBuilder();

        for (String part : currentUrlWithoutParams.split("/")) {
            if (!part.isEmpty()) {
                urlBuilder.append("/").append(part); // Build the URL incrementally
                breadcrumbs.add(new BreadcrumbItem(part, urlBuilder.toString()));
            }
        }

        // Check if the last breadcrumb is a category and has a parent
        Optional<BreadcrumbItem> lastBreadcrumb = Optional.ofNullable(breadcrumbs.isEmpty() ? null : breadcrumbs.getLast());
        if (lastBreadcrumb.isPresent()) {
            String lastBreadcrumbCapitalized = lastBreadcrumb.get().getCapitalized();

            Optional<Category> categoryOptional = categoryService.getAllCategories().stream()
                    .filter(c -> c.getName().equals(lastBreadcrumbCapitalized))
                    .findFirst();

            if (categoryOptional.isPresent() && categoryOptional.get().getParent() != null) {
                Category parentCategory = categoryOptional.get().getParent();

                String parentUrl = urlBuilder.toString().replace(lastBreadcrumb.get().getOriginal(),
                        parentCategory.getName().toLowerCase().replace(" ", "-"));

                breadcrumbs.add(breadcrumbs.size() - 1, new BreadcrumbItem(parentCategory.getName(), parentUrl));
            }
        }

        return breadcrumbs;
    }
}
