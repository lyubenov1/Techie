package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.entities.products.*;
import com.techie.domain.entities.products.accessories.*;
import com.techie.domain.model.*;
import com.techie.domain.model.productsDTOs.*;
import com.techie.exceptions.*;
import com.techie.repository.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.net.*;
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

    public Optional<Product> findByNameIgnoreCase(String urlProductName) {
        String decodedName = URLDecoder.decode(urlProductName, StandardCharsets.UTF_8);

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
        String productUrl = URLEncoder.encode(product.getName().toLowerCase(), StandardCharsets.UTF_8);

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
        productDTO.setUrl(productUrl);
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
}

