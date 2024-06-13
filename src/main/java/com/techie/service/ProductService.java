package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.entities.products.*;
import com.techie.domain.entities.products.accessories.*;
import com.techie.domain.model.*;
import com.techie.domain.model.productsDTOs.*;
import com.techie.repository.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;
import java.util.stream.*;

@Service
public class ProductService {

    private final ProductRepository productRepository;
    private final CommentRepository commentRepository;

    @Autowired
    public ProductService(ProductRepository productRepository, CommentRepository commentRepository) {
        this.productRepository = productRepository;
        this.commentRepository = commentRepository;
    }


    public List<ProductDTO> getProductsByCategory(String categoryName) {
        List<Product> products = productRepository.findByCategoryName(categoryName);
        return products.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private ProductDTO convertToDTO(Product product) {
        ProductDTO productDTO;

        switch (product) {
            case Smartphone smartphone -> productDTO = convertToSmartphoneDTO(smartphone);
            case Tablet tablet -> productDTO = convertToTabletDTO(tablet);
            case Laptop laptop -> productDTO = convertToLaptopDTO(laptop);
            case Earbuds earbuds -> productDTO = convertToEarbudsDTO(earbuds);
            case PowerBank powerbank -> productDTO = convertToPowerbankDTO(powerbank);
            case Charger charger -> productDTO = convertToChargerDTO(charger);
            case Cable cable -> productDTO = convertToCableDTO(cable);
            default -> throw new IllegalStateException("Unexpected value: " + product);
        }

        setBaseProductDTOFields(productDTO, product);
        return productDTO;
    }


    private void setBaseProductDTOFields(ProductDTO productDTO, Product product) {
        List<CommentDTO> commentDTOs = fetchAndConvertCommentsToDTOs(product);

        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setOriginalPrice(product.getOriginalPrice());
        productDTO.setCategoryName(product.getCategory().getName());
        productDTO.setBrandName(product.getBrand().getName());
        productDTO.setImageUrls(product.getProductImages().stream().map(ProductImage::getImageUrl).collect(Collectors.toList()));
        productDTO.setDescription(product.getDescription());
        productDTO.setAverageRating(product.getAverageRating());
        productDTO.setComments(commentDTOs);
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
        return ChargerDTO.builder()
                .adapterType(charger.getAdapterType())
                .build();
    }

    private CableDTO convertToCableDTO(Cable cable) {
        return CableDTO.builder()
                .type(cable.getType())
                .build();
    }

    private PowerBankDTO convertToPowerbankDTO(PowerBank powerbank) {
        return PowerBankDTO.builder()
                .batteryCapacity(powerbank.getBatteryCapacity())
                .color(powerbank.getColor())
                .build();
    }

    private EarbudsDTO convertToEarbudsDTO(Earbuds earbuds) {
        return EarbudsDTO.builder()
                .connectionType(earbuds.getConnectionType())
                .batteryLife(earbuds.getBatteryLife())
                .batteryLifeWithCase(earbuds.getBatteryLifeWithCase())
                .anc(earbuds.isAnc())
                .bluetoothVersion(earbuds.getBluetoothVersion())
                .fit(earbuds.getFit())
                .color(earbuds.getColor())
                .yearOfRelease(earbuds.getYearOfRelease())
                .build();
    }

    private LaptopDTO convertToLaptopDTO(Laptop laptop) {
        return LaptopDTO.builder()
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
    }

    private TabletDTO convertToTabletDTO(Tablet tablet) {
        return TabletDTO.builder()
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
    }

    private SmartphoneDTO convertToSmartphoneDTO(Smartphone smartphone) {
        return SmartphoneDTO.builder()
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
    }
}

