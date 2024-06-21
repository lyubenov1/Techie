package com.techie.service;

import com.techie.domain.model.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;

import java.util.*;

@Service
public class PaginationService {

    public void handlePagination(List<ProductDTO> products, Model model, int page, int size) {
        int totalProducts = products.size();
        int start = page * size;
        int end = Math.min(start + size, totalProducts);

        List<ProductDTO> paginatedProducts = products.subList(start, end);

        Page<ProductDTO> productsPage = new PageImpl<>(paginatedProducts, PageRequest.of(page, size), totalProducts);

        model.addAttribute("productsPage", productsPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productsPage.getTotalPages());
        model.addAttribute("pageSize", size);
    }
}