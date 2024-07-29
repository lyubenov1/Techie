package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import jakarta.servlet.http.*;
import lombok.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;


/**
 * Service class responsible for generating breadcrumbs for navigation.
 */
@Service
public class BreadcrumbService {

    private final CategoryService categoryService;
    private final ProductService productService;

    @Autowired
    public BreadcrumbService(CategoryService categoryService, ProductService productService) {
        this.categoryService = categoryService;
        this.productService = productService;
    }

    /**
     * Represents a breadcrumb item with its original label, capitalized label, and URL.
     */
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

        /**
         * Capitalizes the first letter of the given string.
         *
         * @param str the string to capitalize
         * @return the capitalized string
         */
        private String capitalize(String str) {
            if (str == null || str.isEmpty()) {
                return str;
            }
            return str.substring(0, 1).toUpperCase() + str.substring(1);
        }
    }

    /**
     * Generates a list of breadcrumb items based on the current URL from the request.
     *
     * @param request the HTTP request containing the current URL
     * @return a list of breadcrumb items
     */
    public List<BreadcrumbItem> getBreadcrumbs(HttpServletRequest request) {
        String currentUrl = extractCurrentUrl(request);

        return buildBreadcrumbs(currentUrl, request);
    }

    /**
     * Extracts the current URL from the HTTP request.
     *
     * @param request the HTTP request
     * @return the current URL
     */
    private String extractCurrentUrl(HttpServletRequest request) {
        try {
            return request.getRequestURI().split("\\?")[0];
        } catch (Exception e) {
            return "/";
        }

    }

    /**
     * Constructs breadcrumbs based on the current URL.
     * @return a list of breadcrumb items
     */
    private List<BreadcrumbItem> buildBreadcrumbs(String currentUrl, HttpServletRequest request) {
        List<BreadcrumbItem> breadcrumbs = new ArrayList<>();
        String[] urlParts = currentUrl.split("/");
        StringBuilder urlBuilder = new StringBuilder();

        for (int i = 0; i < urlParts.length; i++) {
            String part = urlParts[i];
            if (part.isEmpty()) continue; // Skip empty parts

            urlBuilder.append("/").append(part);
            String fullUrl = urlBuilder.toString();

            if (isSearchPart(part, i, urlParts)) {
                addSearchBreadcrumb(breadcrumbs, fullUrl, request);
            } else {
                addRegularBreadcrumb(breadcrumbs, fullUrl, part);
            }
        }

        addParentCategoryBreadcrumb(breadcrumbs, urlBuilder);
        return breadcrumbs;
    }

    /**
     * Determines if the current part of the URL is a search part.
     *
     * @param part the current URL part
     * @param index the index of the current part
     * @param parts the array of URL parts
     * @return true if it's the search part, false otherwise
     */
    private boolean isSearchPart(String part, int index, String[] parts) {
        return part.equals("search") && index == parts.length - 1;
    }

    /**
     * Adds a breadcrumb for the search page.
     *
     * @param breadcrumbs the list of breadcrumb items
     * @param url the URL for the search page
     * @param request the HTTP request containing search query parameter
     */
    private void addSearchBreadcrumb(List<BreadcrumbItem> breadcrumbs, String url, HttpServletRequest request) {
        String query = request.getParameter("q");
        String text = (query != null && !query.isEmpty()) ?
                "Search results for \"" + query + "\"" : "Search";
        breadcrumbs.add(new BreadcrumbItem(text, url));
    }

    /**
     * Adds a regular breadcrumb based on whether it represents a product or a category.
     *
     * @param breadcrumbs the list of breadcrumb items
     * @param url the URL for the breadcrumb
     * @param part the URL part to add as a breadcrumb
     */
    private void addRegularBreadcrumb(List<BreadcrumbItem> breadcrumbs, String url, String part) {
        Optional<Product> productOpt = productService.findByName(part);

        if (productOpt.isPresent()) {
            ProductDTO product = productService.convertToDTO(productOpt.get());
            breadcrumbs.add(new BreadcrumbItem(product.getName(), url));
        }
        else if (!part.equals("users")) {
            String formattedPart = formatUrlPart(part);
            breadcrumbs.add(new BreadcrumbItem(formattedPart, url));
        }
    }

    /**
     * Formats a URL part by capitalizing words and replacing hyphens with spaces.
     *
     * @param part the URL part to format
     * @return the formatted string
     */
    private String formatUrlPart(String part) {
        if (!part.contains("-")) return part;

        String[] subParts = part.split("-");
        return Arrays.stream(subParts)
                .filter(subPart -> !subPart.isEmpty())
                .map(this::capitalizeWord)
                .collect(Collectors.joining(" "));
    }

    // Capitalize the first letter of a word
    private String capitalizeWord(String word) {
        return Character.toUpperCase(word.charAt(0)) + word.substring(1).toLowerCase();
    }

    // Adds a breadcrumb for the parent category if applicable
    private void addParentCategoryBreadcrumb(List<BreadcrumbItem> breadcrumbs, StringBuilder urlBuilder) {
        getLastBreadcrumb(breadcrumbs).ifPresent(lastBreadcrumb -> {
            findParentCategory(lastBreadcrumb.getCapitalized())
                    .ifPresent(parentCategory -> {
                        String parentUrl = buildParentUrl(urlBuilder, lastBreadcrumb, parentCategory);
                        insertParentBreadcrumb(breadcrumbs, parentCategory, parentUrl);
                    });
        });
    }

    private Optional<BreadcrumbItem> getLastBreadcrumb(List<BreadcrumbItem> breadcrumbs) {
        return Optional.ofNullable(breadcrumbs.isEmpty() ? null : breadcrumbs.getLast());
    }

    // Finds the parent category for a given category name
    private Optional<Category> findParentCategory(String categoryName) {
        return categoryService.findByName(categoryName)
                .map(Category::getParent);
    }

    // Builds the URL for the parent category
    private String buildParentUrl(StringBuilder urlBuilder, BreadcrumbItem lastBreadcrumb, Category parentCategory) {
        return urlBuilder.toString().replace(
                lastBreadcrumb.getOriginal(),
                parentCategory.getName().toLowerCase()
        );
    }

    /**
     * Inserts a new breadcrumb for the parent category into the breadcrumbs list.
     */
    private void insertParentBreadcrumb(List<BreadcrumbItem> breadcrumbs, Category parentCategory, String parentUrl) {
        breadcrumbs.add(breadcrumbs.size() - 1, new BreadcrumbItem(parentCategory.getName(), parentUrl));
    }

}
