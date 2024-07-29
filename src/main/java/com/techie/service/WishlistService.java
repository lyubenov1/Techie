package com.techie.service;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.exceptions.product.*;
import com.techie.exceptions.wishlist.*;
import com.techie.repository.*;
import org.slf4j.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.stereotype.*;

import java.util.*;


@Service
public class WishlistService {

    private final WishlistRepository wishlistRepository;
    private final ProductService productService;
    private final ProductImageRepository productImageRepository;
    private static final Logger logger = LoggerFactory.getLogger(WishlistService.class);

    @Autowired
    public WishlistService(WishlistRepository wishlistRepository, ProductService productService,
                           ProductImageRepository productImageRepository) {
        this.wishlistRepository = wishlistRepository;
        this.productService = productService;
        this.productImageRepository = productImageRepository;
    }

    public void createWishlist(UserEntity user, String wishlistName)
                               throws InvalidWishlistNameException, DuplicateWishlistException {
        if (wishlistName == null || wishlistName.trim().isEmpty()) {
            throw new InvalidWishlistNameException("Wishlist name cannot be empty");
        }

        if (wishlistName.length() > 50) {
            throw new InvalidWishlistNameException("Wishlist name cannot be more than 50 characters");
        }


        boolean wishlistExists = wishlistRepository.existsByUserAndName(user, wishlistName);
        if (wishlistExists) {
            throw new DuplicateWishlistException(wishlistName);
        }

        Wishlist wishlist = new Wishlist();
        wishlist.setName(wishlistName);
        user.addWishlist(wishlist);

        wishlistRepository.save(wishlist);
    }



    public WishlistDTO convertToDTO(Wishlist wishlist) {
        Set<Product> products = wishlist.getProducts();
        logger.info("Products in wishlist {}: {}", wishlist.getId(), products);
        setImageForEachProduct(products);  // Since we cannot directly fetch the productImages list from the database due to MultipleBagFetchException.
                                           // This assignment affects only the current instance of the Product object in memory
                                           // and does not persistently alter the default or existing data in the productImages table

        List<ProductDTO> productDTOs = products.stream()
                .map(productService::convertToDTO)
                .toList();
        logger.info("Converted productDTOs: {}", productDTOs);

        return WishlistDTO.builder()
                .id(wishlist.getId())
                .name(wishlist.getName())
                .products(productDTOs)
                .build();
    }

    private void setImageForEachProduct(Set<Product> products) {
        products.forEach(product ->
                product.setProductImages(productImageRepository.findPrimaryImagesByProductId(product.getId())));
    }

    public List<WishlistDTO> getAndConvertWishlists(String username) {
        List<Wishlist> wishlists = wishlistRepository.findByUserEmail(username);
        logger.info("Fetched wishlists: {}", wishlists);
        return wishlists.stream()
                .map(this::convertToDTO)
                .sorted(Comparator.comparing(WishlistDTO::getId))
                .toList();
    }

    public void deleteWishlist(UserEntity user, Long id) throws WishlistNotFoundException {
        Wishlist wishlist = wishlistRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new WishlistNotFoundException(id));

        wishlistRepository.delete(wishlist);
    }

    public void updateWishlistName(UserEntity user, Long id, String newName)
                                            throws WishlistNotFoundException, InvalidWishlistNameException {
        if (newName == null || newName.trim().isEmpty()) {
            throw new InvalidWishlistNameException("New name cannot be empty");
        }
        if (newName.length() > 50) {
            throw new InvalidWishlistNameException("Wishlist name cannot be more than 50 characters");
        }

        Wishlist wishlist = wishlistRepository.findByIdAndUser(id, user)
                .orElseThrow(() -> new WishlistNotFoundException(id));

        if (newName.equals(wishlist.getName())) {
            throw new InvalidWishlistNameException("New name cannot be the same");
        }

        wishlist.setName(newName);
        wishlistRepository.save(wishlist);
    }

    public void addProductToWishlist(UserEntity user, Long wishlistId, Long productId)
                                        throws WishlistNotFoundException, ProductNotFoundException, ProductAlreadyInWishlistException {
        logger.info("Attempting to add product with ID {} to wishlist with ID {} for user {}", productId, wishlistId, user.getUsername());

        Wishlist wishlist = wishlistRepository.findByIdAndUserJoinFetchProducts(wishlistId, user)
                .orElseThrow(() -> new WishlistNotFoundException(wishlistId));
        Product product = productService.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        // Check if the product already exists in the wishlist
        if (wishlist.getProducts().contains(product)) {
            throw new ProductAlreadyInWishlistException(product.getName(), wishlist.getName());
        }

        wishlist.getProducts().add(product);
        wishlistRepository.save(wishlist);

        logger.info("Successfully added product with ID {} to wishlist with ID {}. Wishlist now contains {} products.",
                productId, wishlistId, wishlist.getProducts().size());
    }

    public void removeProductFromWishlist(UserEntity user, Long wishlistId, Long productId)
            throws WishlistNotFoundException, ProductNotFoundException, ProductNotInWishlistException {
        logger.info("Attempting to remove product with ID {} from wishlist with ID {} for user {}", productId, wishlistId, user.getUsername());

        Wishlist wishlist = wishlistRepository.findByIdAndUserJoinFetchProducts(wishlistId, user)
                .orElseThrow(() -> new WishlistNotFoundException(wishlistId));
        Product product = productService.findById(productId)
                .orElseThrow(() -> new ProductNotFoundException(productId));

        // Check if the product exists in the wishlist
        if (!wishlist.getProducts().contains(product)) {
            throw new ProductNotInWishlistException(product.getName(), wishlist.getName());
        }

        wishlist.getProducts().remove(product);
        wishlistRepository.save(wishlist);

        logger.info("Successfully removed product with ID {} from wishlist with ID {}. Wishlist now contains {} products.",
                productId, wishlistId, wishlist.getProducts().size());
    }


    public void removeAllProductsFromWishlist(UserEntity user, Long wishlistId) throws WishlistNotFoundException {
        logger.info("Attempting to remove all products from wishlist with ID {} for user {}", wishlistId, user.getUsername());

        Wishlist wishlist = wishlistRepository.findByIdAndUserJoinFetchProducts(wishlistId, user)
                .orElseThrow(() -> new WishlistNotFoundException(wishlistId));

        wishlist.getProducts().clear();
        wishlistRepository.save(wishlist);

        logger.info("Successfully removed all products from wishlist with ID {}", wishlistId);
    }
}