package com.techie.utils;

import com.techie.domain.entities.*;
import com.techie.domain.entities.products.*;
import com.techie.domain.entities.products.accessories.*;
import com.techie.domain.model.DTOs.*;
import com.techie.domain.model.DTOs.productsDTOs.*;
import com.techie.domain.model.*;
import com.techie.exceptions.product.*;
import org.slf4j.*;
import org.springframework.web.util.*;

import java.nio.charset.*;
import java.util.stream.*;

public class ProductConversionUtils {

    private static final Logger log = LoggerFactory.getLogger(ProductConversionUtils.class);

    public static ProductAdminView convertToAdminView(Product product) {
        return ProductAdminView.builder()
                .id(product.getId())
                .name(product.getName())
                .originalPrice(product.getOriginalPrice())
                .discount(product.getDiscount())
                .discountedPrice(product.getDiscountedPrice())
                .imageUrls(product.getProductImages().stream().map(ProductImage::getImageUrl).collect(Collectors.toList()))
                .build();
    }

    public static ProductDTO convertToDTO(Product product) {
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


    private static void setBaseProductDTOFields(ProductDTO productDTO, Product product) {
        if (product == null || product.getId() == null) {
            throw new MissingProductDataException("Product or product ID is missing");
        }

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
        productDTO.setUrl(encodedUrl);
        productDTO.setDiscountedPrice(product.getDiscountedPrice());
        productDTO.setDiscount(product.getDiscount());
    }

    private static ChargerDTO convertToChargerDTO(Charger charger) {
        try {
            return ChargerDTO.chargerBuilder()
                    .adapterType(charger.getAdapterType())
                    .build();
        } catch (Exception e) {
            throw new DTOConversionException("Error converting Charger to DTO", e);
        }
    }

    private static CableDTO convertToCableDTO(Cable cable) {

        try {
            return CableDTO.cableBuilder()
                    .type(cable.getType())
                    .build();
        } catch (Exception e) {
            throw new DTOConversionException("Error converting Cable to DTO", e);
        }
    }

    private static PowerBankDTO convertToPowerbankDTO(PowerBank powerbank) {
        try {
            return PowerBankDTO.powerBankBuilder()
                    .batteryCapacity(powerbank.getBatteryCapacity())
                    .color(powerbank.getColor())
                    .build();
        } catch (Exception e) {
            throw new DTOConversionException("Error converting PowerBank to DTO", e);
        }
    }

    private static EarbudsDTO convertToEarbudsDTO(Earbuds earbuds) {
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

    private static LaptopDTO convertToLaptopDTO(Laptop laptop) {
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

    private static TabletDTO convertToTabletDTO(Tablet tablet) {
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

    private static SmartphoneDTO convertToSmartphoneDTO(Smartphone smartphone) {
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
