package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.entities.products.*;
import com.techie.domain.entities.products.accessories.*;
import com.techie.domain.model.*;
import com.techie.domain.model.productsDTOs.*;
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
    private final CommentRepository commentRepository;
    private static final Logger log = LoggerFactory.getLogger(ProductService.class);

    @Autowired
    public ProductService(ProductRepository productRepository, CommentRepository commentRepository) {
        this.productRepository = productRepository;
        this.commentRepository = commentRepository;
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

    public Optional<Product> findByNameIgnoreCase(String urlProductName) {
        String decodedName = UriUtils.decode(urlProductName, StandardCharsets.UTF_8);

        return productRepository.findByNameIgnoreCase(decodedName);
    }

    public List<ProductDTO> getProductsByCategory(Long categoryId) {
        List<Product> products = productRepository.findByCategoryId(categoryId);
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    public ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO = new ProductDTO();

        try {
            switch (product) {
                case Smartphone smartphone -> productDTO = convertToSmartphoneDTO(smartphone);
                case Tablet tablet -> productDTO = convertToTabletDTO(tablet);
                case Laptop laptop -> productDTO = convertToLaptopDTO(laptop);
                case Earbuds earbuds -> productDTO = convertToEarbudsDTO(earbuds);
                case PowerBank powerbank -> productDTO = convertToPowerbankDTO(powerbank);
                case Charger charger -> productDTO = convertToChargerDTO(charger);
                case Cable cable -> productDTO = convertToCableDTO(cable);
                default -> throw new IllegalStateException("Unexpected product type: " + product.getClass().getSimpleName());
            }
        } catch (MissingProductDataException | DTOConversionException e) {
            log.error("Error converting product to DTO: {}", e.getMessage(), e);
        }

        setBaseProductDTOFields(productDTO, product);

        return productDTO;
    }


    private void setBaseProductDTOFields(ProductDTO productDTO, Product product) {
        if (product == null || product.getId() == null) {
            throw new MissingProductDataException("Product or product ID is missing");
        }

        List<CommentDTO> commentDTOs = fetchAndConvertCommentsToDTOs(product);
        String encodedUrl = UriUtils.encodeFragment(product.getName().toLowerCase(), StandardCharsets.UTF_8);

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setOriginalPrice(product.getOriginalPrice());
        productDTO.setCategoryName(product.getCategory().getName());
        productDTO.setBrandName(product.getBrand().getName());
        productDTO.setImageUrls(product.getProductImages().stream().map(ProductImage::getImageUrl).collect(Collectors.toList()));
        productDTO.setStock(product.getStock());
        productDTO.setDescription(product.getDescription());
        productDTO.setAverageRating(product.getAverageRating());
        productDTO.setComments(commentDTOs);
        productDTO.setUrl(encodedUrl);
    }

    private List<CommentDTO> fetchAndConvertCommentsToDTOs(Product product) {
        List<Comment> comments = commentRepository.findAllByProductIdWithAssociations(product.getId());
        return comments.stream().map(this::convertToCommentDTO).toList();
    }

    private CommentDTO convertToCommentDTO(Comment comment) {
        return CommentDTO.builder()
                .id(comment.getId())
                .content(comment.getContent())
                .timestamp(comment.getTimestamp())
                .user(comment.getUser().getUsername())
                .upvoteCount(comment.getUpvote())
                .downvoteCount(comment.getDownvote())
                .imageUrls(comment.getImages().stream().map(CommentImage::getImageUrl).collect(Collectors.toList()))
                .build();
    }

    private ChargerDTO convertToChargerDTO(Charger charger) {
        try {
            return ChargerDTO.chargerBuilder()
                    .adapterType(charger.getAdapterType())
                    .build();
        } catch (Exception e) {
            throw new DTOConversionException("Error converting Charger to DTO", e);
        }
    }

    private CableDTO convertToCableDTO(Cable cable) {

        try {
            return CableDTO.cableBuilder()
                    .type(cable.getType())
                    .build();
        } catch (Exception e) {
            throw new DTOConversionException("Error converting Cable to DTO", e);
        }
    }

    private PowerBankDTO convertToPowerbankDTO(PowerBank powerbank) {
        try {
            return PowerBankDTO.powerBankBuilder()
                    .batteryCapacity(powerbank.getBatteryCapacity())
                    .color(powerbank.getColor())
                    .build();
        } catch (Exception e) {
            throw new DTOConversionException("Error converting PowerBank to DTO", e);
        }
    }

    private EarbudsDTO convertToEarbudsDTO(Earbuds earbuds) {
        try {
            return EarbudsDTO.earbudsBuilder()
                    .connectionType(earbuds.getConnectionType())
                    .batteryLife(earbuds.getBatteryLife())
                    .batteryLifeWithCase(earbuds.getBatteryLifeWithCase())
                    .anc(earbuds.isAnc())
                    .bluetoothVersion(earbuds.getBluetoothVersion())
                    .fit(earbuds.getFit())
                    .color(earbuds.getColor())
                    .yearOfRelease(earbuds.getYearOfRelease())
                    .build();
        } catch (Exception e) {
            throw new DTOConversionException("Error converting Earbuds to DTO", e);
        }
    }

    private LaptopDTO convertToLaptopDTO(Laptop laptop) {
        try {
            return LaptopDTO.laptopBuilder()
                    .screenSize(laptop.getScreenSize())
                    .screenResolution(laptop.getScreenResolution())
                    .processor(laptop.getProcessor())
                    .gpu(laptop.getGpu())
                    .ram(laptop.getRam())
                    .storageType(laptop.getStorageType())
                    .storage(laptop.getStorage())
                    .operatingSystem(laptop.getOperatingSystem())
                    .color(laptop.getColor())
                    .yearOfRelease(laptop.getYearOfRelease())
                    .build();
        } catch (Exception e) {
            throw new DTOConversionException("Error converting Laptop to DTO", e);
        }
    }

    private TabletDTO convertToTabletDTO(Tablet tablet) {
        try {
            return TabletDTO.tabletBuilder()
                    .screenSize(tablet.getScreenSize())
                    .screenResolution(tablet.getScreenResolution())
                    .ram(tablet.getRam())
                    .storage(tablet.getStorage())
                    .batteryCapacity(tablet.getBatteryCapacity())
                    .frontCamera(tablet.getFrontCamera())
                    .rearCamera(tablet.getRearCamera())
                    .refreshRate(tablet.getRefreshRate())
                    .color(tablet.getColor())
                    .operatingSystem(tablet.getOperatingSystem())
                    .yearOfRelease(tablet.getYearOfRelease())
                    .build();
        } catch (Exception e) {
            throw new DTOConversionException("Error converting Tablet to DTO", e);
        }
    }

    private SmartphoneDTO convertToSmartphoneDTO(Smartphone smartphone) {
        try {
            return SmartphoneDTO.smartphoneBuilder()
                    .screenSize(smartphone.getScreenSize())
                    .screenResolution(smartphone.getScreenResolution())
                    .ram(smartphone.getRam())
                    .storage(smartphone.getStorage())
                    .batteryCapacity(smartphone.getBatteryCapacity())
                    .frontCamera(smartphone.getFrontCamera())
                    .rearCamera(smartphone.getRearCamera())
                    .refreshRate(smartphone.getRefreshRate())
                    .color(smartphone.getColor())
                    .operatingSystem(smartphone.getOperatingSystem())
                    .yearOfRelease(smartphone.getYearOfRelease())
                    .build();
        } catch (Exception e) {
            throw new DTOConversionException("Error converting Smartphone to DTO", e);
        }
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
                .map(this::convertToDTO)
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

        return specificationKeys;
    }

    private Set<String> retrieveSpecificationsKeysForProduct(Long productId) {
        Optional<Product> productOptional = findById(productId);
        if (productOptional.isPresent()) {
            ProductDTO productDTO = convertToDTO(productOptional.get());
            return retrieveSpecifications(productDTO).keySet();
        }
        return Collections.emptySet();
    }
}

