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
        String currentUrl = extractCurrentUrl(request);
        List<BreadcrumbItem> breadcrumbs = buildBreadcrumbs(currentUrl);
        addParentCategoryBreadcrumb(breadcrumbs);
        return breadcrumbs;
    }

    private String extractCurrentUrl(HttpServletRequest request) {
        try {
            return request.getRequestURI().split("\\?")[0];
        } catch (Exception e) {
            log.error("Error getting current URL", e);
            return "/";
        }
    }

    private List<BreadcrumbItem> buildBreadcrumbs(String currentUrl) {
        List<BreadcrumbItem> breadcrumbs = new ArrayList<>();
        StringBuilder urlBuilder = new StringBuilder();

        for (String part : currentUrl.split("/")) {
            if (!part.isEmpty()) {
                urlBuilder.append("/").append(part);
                breadcrumbs.add(new BreadcrumbItem(part, urlBuilder.toString()));
            }
        }
        return breadcrumbs;
    }

    private void addParentCategoryBreadcrumb(List<BreadcrumbItem> breadcrumbs) {
        Optional<BreadcrumbItem> lastBreadcrumb = Optional.ofNullable(breadcrumbs.isEmpty() ? null : breadcrumbs.getLast());
        if (lastBreadcrumb.isPresent()) {
            String lastBreadcrumbCapitalized = lastBreadcrumb.get().getCapitalized();

            Optional<Category> categoryOptional = categoryService.getAllCategories().stream()
                    .filter(c -> c.getName().equals(lastBreadcrumbCapitalized))
                    .findFirst();

            if (categoryOptional.isPresent() && categoryOptional.get().getParent() != null) {
                Category parentCategory = categoryOptional.get().getParent();

                String parentUrl = breadcrumbs.get(breadcrumbs.size() - 2).getUrl();

                breadcrumbs.add(breadcrumbs.size() - 1, new BreadcrumbItem(parentCategory.getName(), parentUrl));
            }
        }
    }
}
