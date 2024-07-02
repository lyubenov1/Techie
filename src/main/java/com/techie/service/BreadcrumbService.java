package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.model.*;
import jakarta.servlet.http.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.cache.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;

@Service
public class BreadcrumbService {

    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public BreadcrumbService(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
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

        return buildBreadcrumbs(currentUrl, request);
    }


    private String extractCurrentUrl(HttpServletRequest request) {
        try {
            return request.getRequestURI().split("\\?")[0];
        } catch (Exception e) {
            return "/";
        }

    }

    private List<BreadcrumbItem> buildBreadcrumbs(String currentUrl, HttpServletRequest request){
        List<BreadcrumbItem> breadcrumbs = new ArrayList<>();
        StringBuilder urlBuilder = new StringBuilder();

        String[] parts = currentUrl.split("/");
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            if (!part.isEmpty()) {
                urlBuilder.append("/").append(part);

                if (part.equals("search") && i == parts.length - 1) {
                    // If it's the last part, and it's "Search"
                    String query = request.getParameter("q");
                    if (query != null && !query.isEmpty()) {
                        String searchText = "Search results for \"" + query + "\"";
                        breadcrumbs.add(new BreadcrumbItem(searchText, urlBuilder.toString()));
                    } else {
                        breadcrumbs.add(new BreadcrumbItem("Search", urlBuilder.toString()));
                    }
                } else {
                    // Check if the part is a product
                    Optional<Product> productOpt = productService.findByNameIgnoreCase(part);

                    if (productOpt.isPresent()) {
                        // If it's a product, use the product name
                        ProductDTO product = productService.convertToDTO(productOpt.get());
                        breadcrumbs.add(new BreadcrumbItem(product.getName(), urlBuilder.toString()));
                    } else {
                        breadcrumbs.add(new BreadcrumbItem(part, urlBuilder.toString()));
                    }
                }
            }
        }

        addParentCategoryBreadcrumb(breadcrumbs, urlBuilder);
        return breadcrumbs;

    }

    private void addParentCategoryBreadcrumb(List<BreadcrumbService.BreadcrumbItem> breadcrumbs, StringBuilder urlBuilder) {
        Optional<BreadcrumbItem> lastBreadcrumb = Optional.ofNullable(breadcrumbs.isEmpty() ? null : breadcrumbs.getLast());
        if (lastBreadcrumb.isPresent()) {
            String lastBreadcrumbCapitalized = lastBreadcrumb.get().getCapitalized();

            Optional<Category> categoryOptional = categoryService.findByName(lastBreadcrumbCapitalized);

            if (categoryOptional.isPresent() && categoryOptional.get().getParent() != null) {
                Category parentCategory = categoryOptional.get().getParent();

                String parentUrl = urlBuilder.toString().replace(lastBreadcrumb.get().getOriginal(),
                        parentCategory.getName().toLowerCase());

                breadcrumbs.add(breadcrumbs.size() - 1, new BreadcrumbItem(parentCategory.getName(), parentUrl));
            }
        }
    }

}
