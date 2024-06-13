package com.techie.service;

import com.techie.domain.entities.*;
import jakarta.servlet.http.*;
import lombok.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class BreadcrumbService {

    private static final Logger log = LoggerFactory.getLogger(BreadcrumbService.class);
    private final CategoryService categoryService;

    @Autowired
    public BreadcrumbService(CategoryService categoryService) {
        this.categoryService = categoryService;
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

    @Cacheable(cacheNames = "breadcrumbs", key = "#root.args[0].requestURI")
    public List<BreadcrumbItem> getBreadcrumbs(HttpServletRequest request) {
        String currentUrl = extractCurrentUrl(request);

        return buildBreadcrumbs(currentUrl);
    }


    private String extractCurrentUrl(HttpServletRequest request) {
        try {
            return request.getRequestURI().split("\\?")[0];
        } catch (Exception e) {
            log.error("Error getting current URL", e);
            return "/";
        }

    }

    private List<BreadcrumbItem> buildBreadcrumbs(String currentUrl){
        List<BreadcrumbItem> breadcrumbs = new ArrayList<>();
        StringBuilder urlBuilder = new StringBuilder();

        for (String part : currentUrl.split("/")) {
            if (!part.isEmpty()) {
                String partWithoutHyphens = part.replace("-", " ");

                urlBuilder.append("/").append(part);
                breadcrumbs.add(new BreadcrumbItem(partWithoutHyphens, urlBuilder.toString()));
            }
        }

        addParentCategoryBreadcrumb(breadcrumbs, urlBuilder);
        return breadcrumbs;

    }

    private void addParentCategoryBreadcrumb(List<BreadcrumbItem> breadcrumbs, StringBuilder urlBuilder) {
        Optional<BreadcrumbItem> lastBreadcrumb = Optional.ofNullable(breadcrumbs.isEmpty() ? null : breadcrumbs.getLast());
        if (lastBreadcrumb.isPresent()) {
            String lastBreadcrumbCapitalized = lastBreadcrumb.get().getCapitalized();

            Optional<Category> categoryOptional = categoryService.findByName(lastBreadcrumbCapitalized);

            if (categoryOptional.isPresent() && categoryOptional.get().getParent() != null) {
                Category parentCategory = categoryOptional.get().getParent();

                String parentUrl = urlBuilder.toString().replace(lastBreadcrumb.get().getOriginal(),
                        parentCategory.getName().toLowerCase().replace(" ", "-"));

                breadcrumbs.add(breadcrumbs.size() - 1, new BreadcrumbItem(parentCategory.getName(), parentUrl));
            }
        }
    }

}
