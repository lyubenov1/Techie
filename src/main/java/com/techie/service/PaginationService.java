package com.techie.service;

import com.techie.domain.model.*;
import org.slf4j.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;

import java.util.*;

@Service
public class PaginationService {

    public static final int DEFAULT_PAGE_SIZE = 25;
    private final Logger logger = LoggerFactory.getLogger(PaginationService.class);

    public Page<ProductDTO> paginate(List<ProductDTO> products, int page, int size) {
        int totalProducts = products.size();
        int start = Math.min(page * size, totalProducts);
        int end = Math.min(start + size, totalProducts);

        logger.info("Paginating products - start: {}, end: {}", start, end);

        List<ProductDTO> paginatedProducts = products.subList(start, end);
        return new PageImpl<>(paginatedProducts, PageRequest.of(page, size), totalProducts);
    }

    public void handlePagination(List<ProductDTO> products, Model model, int page, int size) {
        Page<ProductDTO> productsPage = paginate(products, page, size);

        model.addAttribute("productsPage", productsPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productsPage.getTotalPages());
        model.addAttribute("pageSize", size);

        logger.info("Handling pagination - currentPage: {}, totalPages: {}", page, productsPage.getTotalPages());
    }
}