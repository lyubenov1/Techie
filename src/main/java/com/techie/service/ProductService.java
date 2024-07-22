package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.exceptions.*;
import com.techie.repository.*;
import com.techie.utils.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;
import org.springframework.web.util.*;

import java.lang.reflect.*;
import java.math.*;
import java.nio.charset.*;
import java.util.*;
import java.util.stream.*;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public Optional<Product> findById(Long productId) {
        return productRepository.findById(productId);
    }

    public List<ProductDTO> searchProducts(String query, String categoryName, int limit) {
        List<Product> products;

        if (categoryName == null || categoryName.isEmpty()) {
            products = productRepository.findByNameContainingAndRating(query, PageRequest.of(0, limit));
        } else {
            products = productRepository.findByNameContainingAndCategory(query, categoryName, PageRequest.of(0, limit));
        }

        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public List<ProductDTO> fullSearchProducts(String query) {
        log.info("Fetching products for query: {}", query);

        List<Product> productPage = productRepository.findByNameContaining(query);

        log.info("Fetched {} products", productPage.size());
        return productPage.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public Optional<Product> findByName(String urlProductName) {
        String decodedName = UriUtils.decode(urlProductName, StandardCharsets.UTF_8);

        return productRepository.findByNameIgnoreCase(decodedName);
    }

    public ProductDTO findByNameWithAllImages(String urlProductName) {
        String decodedName = UriUtils.decode(urlProductName, StandardCharsets.UTF_8);
        Optional<Product> productOptional = productRepository.findByNameIgnoreCaseWithAllImages(decodedName);
        Product product = productOptional.orElseThrow(() -> new ProductNotFoundException(urlProductName));
        return convertToDTO(product);
    }

    public List<ProductDTO> getProductsByCategory(Long categoryId) {
        List<Product> products = productRepository.findByCategoryId(categoryId);
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = ProductConversionUtils.convertToDTO(product);
        Map<Integer, Integer> ratingCounts = getRatingCounts(product.getId());
        productDTO.setRatings(ratingCounts);  // Count of reviews for a given rating (1 to 5)
        productDTO.setReviewCount(ratingCounts.values().stream().mapToInt(Integer::intValue).sum()); // Number of all reviews
        return productDTO;
    }

    private Map<Integer, Integer> getRatingCounts(Long productId) {
        List<Object[]> results = productRepository.findRatingCountsByProductId(productId);
        Map<Integer, Integer> ratingCounts = new HashMap<>();

        for (int i = 1; i <= 5; i++) {
            ratingCounts.put(i, 0);  // Initialize all ratings with 0 count
        }

        for (Object[] result : results) {
            Integer rating = ((Number) result[0]).intValue();
            Integer count = ((Number) result[1]).intValue();
            ratingCounts.put(rating, count);
        }

        return ratingCounts;
    }

    public void addSpecifications(ProductDTO productDTO, Model model) {
        model.addAttribute("specifications", retrieveSpecifications(productDTO));
    }

    public Map<String, String> retrieveSpecifications(ProductDTO product) {
        Map<String, String> specifications = new LinkedHashMap<>();

        for (Field field : FieldUtil.getFields(product)) {
            processMapEntry(field, product, specifications);
        }
        return specifications;      // Method to retrieve the specs of each product in a user-friendly format.
    }

    private void processMapEntry(Field field, ProductDTO product, Map<String, String> specifications) {
        try {
            field.setAccessible(true);
            Object value = field.get(product);

            if (value != null) {
                String styledKey = CaseStyleUtil.styleFieldName(field.getName());
                String capitalizedValue = CaseStyleUtil.capitalizeFirstLetter(value.toString());
                specifications.put(styledKey, capitalizedValue);
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    public List<ProductDTO> findSimilarProducts(Product product) {
        BigDecimal minPrice = product.getOriginalPrice().subtract(new BigDecimal("200"));
        BigDecimal maxPrice = product.getOriginalPrice().add(new BigDecimal("200"));

        List<Product> allSimilarProducts = productRepository.findByCategoryAndOriginalPriceBetweenAndIdNot(
                product.getCategory(),
                minPrice,
                maxPrice,
                product.getId()
        );

        // If we have less than 5 products, expand the price range to include more products
        if (allSimilarProducts.size() < 5) {
            minPrice = product.getOriginalPrice().subtract(new BigDecimal("600"));
            maxPrice = product.getOriginalPrice().add(new BigDecimal("600"));

            allSimilarProducts = productRepository.findByCategoryAndOriginalPriceBetweenAndIdNot(
                    product.getCategory(),
                    minPrice,
                    maxPrice,
                    product.getId()
            );
        }

        Map<Brand, List<Product>> productsByBrand = allSimilarProducts.stream()
                .collect(Collectors.groupingBy(Product::getBrand));

        List<Product> selectedProducts = new ArrayList<>();

        for (List<Product> brandProducts : productsByBrand.values()) {
            selectedProducts.addAll(brandProducts.stream().limit(2).toList());
            if (selectedProducts.size() >= 5) {
                break;
            }
        }

        // If we have less than 5 products, add more from any brand
        if (selectedProducts.size() < 5) {
            Set<Product> additionalProducts = new HashSet<>(allSimilarProducts);
            selectedProducts.forEach(additionalProducts::remove);
            selectedProducts.addAll(additionalProducts.stream()
                    .limit(5 - selectedProducts.size())
                    .toList());
        }

        // Shuffle the list to randomize the order
        Collections.shuffle(selectedProducts);

        return selectedProducts.stream()
                .limit(5)
                .map(ProductConversionUtils::convertToDTO)
                .toList();
    }

    public Set<String> retrieveSpecificationKeys(Long idProduct1, Long idProduct2, Long idProduct3) {
        Set<String> specificationKeys = new LinkedHashSet<>();

        if (idProduct1 != null) {
            specificationKeys.addAll(retrieveSpecificationsKeysForProduct(idProduct1));
        } else if (idProduct2 != null) {
            specificationKeys.addAll(retrieveSpecificationsKeysForProduct(idProduct2));
        } else if (idProduct3 != null) {
            specificationKeys.addAll(retrieveSpecificationsKeysForProduct(idProduct3));
        }

        return specificationKeys;   // Only fields for the category of the first non-null product will be displayed
    }

    private Set<String> retrieveSpecificationsKeysForProduct(Long productId) {
        Optional<Product> productOptional = findById(productId);
        if (productOptional.isPresent()) {
            ProductDTO productDTO = ProductConversionUtils.convertToDTO(productOptional.get());
            return retrieveSpecifications(productDTO).keySet();
        }
        return Collections.emptySet();
    }
}

