package com.techie.web;

import com.techie.domain.entities.*;
import com.techie.domain.model.DTOs.*;
import com.techie.exceptions.category.*;
import com.techie.exceptions.product.*;
import com.techie.service.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import org.springframework.ui.*;

import java.util.*;

public class ProductControllerTest {

    private ProductController productController;

    @Mock
    private CategoryService categoryService;

    @Mock
    private ProductFilterService productFilterService;

    @Mock
    private PaginationService paginationService;

    @Mock
    private FacetService facetService;

    @Mock
    private ProductService productService;

    @Mock
    private Model model;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
        productController = new ProductController(categoryService, productFilterService, paginationService, facetService, productService);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void searchProducts_ShouldReturnProductsView_WhenProductsFound() {
        // Arrange
        String query = "test";
        Map<String, String> filters = new HashMap<>();
        List<ProductDTO> products = Collections.singletonList(new ProductDTO());

        when(productFilterService.getFilteredSearchProducts(filters, "newest", query)).thenReturn(products);

        // Act
        String viewName = productController.searchProducts(query, filters, 0, "newest", model);

        // Assert
        assertEquals("products", viewName);
        verify(model).addAttribute("searchQuery", query);
        verify(model).addAttribute("products", products);
        verify(facetService).addFacets(products, model);
        verify(paginationService).handlePagination(products, model, 0, PaginationService.DEFAULT_PAGE_SIZE);
    }

    @Test
    void searchProducts_ShouldReturnErrorView_WhenNoProductsFound() {
        // Arrange
        String query = "test";
        Map<String, String> filters = new HashMap<>();

        when(productFilterService.getFilteredSearchProducts(filters, "newest", query)).thenReturn(Collections.emptyList());

        // Act
        String viewName = productController.searchProducts(query, filters, 0, "newest", model);

        // Assert
        assertEquals("error-pages/search-not-found", viewName);
        verify(model).addAttribute("searchQuery", query);
    }

    @Test
    void allProductsPage_ShouldReturnProductsView() throws CategoryNotFoundException {
        // Arrange
        Map<String, String> filters = new HashMap<>();
        List<CategoryDTO> parentCategories = Collections.singletonList(new CategoryDTO());
        List<ProductDTO> products = Collections.singletonList(new ProductDTO());

        when(categoryService.getParentCategoryDTOs()).thenReturn(parentCategories);
        when(productFilterService.getFilteredProductsAll(parentCategories, filters, "newest")).thenReturn(products);

        // Act
        String viewName = productController.allProductsPage(filters, 0, "newest", model);

        // Assert
        assertEquals("products", viewName);
        verify(model).addAttribute("products", products);
        verify(facetService).addFacets(products, model);
        verify(paginationService).handlePagination(products, model, 0, PaginationService.DEFAULT_PAGE_SIZE);
    }

    @Test
    void categoryPage_ShouldReturnProductsView() throws CategoryNotFoundException {
        // Arrange
        String categoryName = "test-category";
        Map<String, String> filters = new HashMap<>();
        CategoryDTO categoryDTO = new CategoryDTO();
        List<ProductDTO> products = Collections.singletonList(new ProductDTO());

        when(categoryService.findByNameAndConvert(categoryName)).thenReturn(categoryDTO);
        when(productFilterService.getFilteredProducts(categoryName, filters, "newest")).thenReturn(products);

        // Act
        String viewName = productController.categoryPage(categoryName, filters, 0, "newest", model);

        // Assert
        assertEquals("products", viewName);
        verify(model).addAttribute("category", categoryDTO);
        verify(facetService).addFacets(products, model);
        verify(paginationService).handlePagination(products, model, 0, PaginationService.DEFAULT_PAGE_SIZE);
    }

    @Test
    void productPage_ShouldReturnProductPageView() throws ProductNotFoundException, CategoryNotFoundException {
        // Arrange
        String categoryName = "test-category";
        String productName = "test-product";
        ProductDTO productDTO = new ProductDTO();

        when(productService.findByNameWithAllImages(productName)).thenReturn(productDTO);
        when(categoryService.findByName(categoryName)).thenReturn(Optional.of(new Category()));

        // Act
        String viewName = productController.productPage(productName, categoryName, model);

        // Assert
        assertEquals("product-page", viewName);
        verify(model).addAttribute("product", productDTO);
        verify(productService).addSpecifications(productDTO, model);
    }

    @Test
    void compareProductsPage_ShouldReturnCompareProductsView() {
        // Arrange
        Long idProduct1 = 1L;
        Long idProduct2 = 2L;
        Long idProduct3 = 3L;
        Set<String> specKeys = new HashSet<>();

        when(productService.retrieveSpecificationKeys(idProduct1, idProduct2, idProduct3)).thenReturn(specKeys);

        // Act
        String viewName = productController.compareProductsPage(idProduct1, idProduct2, idProduct3, model);

        // Assert
        assertEquals("compare-products", viewName);
        verify(model).addAttribute("specificationKeys", specKeys);
    }
}
