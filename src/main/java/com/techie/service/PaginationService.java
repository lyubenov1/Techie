package com.techie.service;

import com.techie.domain.model.*;
import org.springframework.data.domain.*;
import org.springframework.stereotype.*;
import org.springframework.ui.*;

import java.util.*;

@Service
public class PaginationService {

    public Page<ProductDTO> paginate(List<ProductDTO> products, int page, int size) {
        int totalProducts = products.size();
        int start = page * size;
        int end = Math.min(start + size, totalProducts);

        List<ProductDTO> paginatedProducts = products.subList(start, end);
        return new PageImpl<>(paginatedProducts, PageRequest.of(page, size), totalProducts);
    }

    public void handlePagination(List<ProductDTO> products, Model model, int page, int size) {
        Page<ProductDTO> productsPage = paginate(products, page, size);

        model.addAttribute("productsPage", productsPage);
        model.addAttribute("currentPage", page);
        model.addAttribute("totalPages", productsPage.getTotalPages());
        model.addAttribute("pageSize", size);
    }
}
