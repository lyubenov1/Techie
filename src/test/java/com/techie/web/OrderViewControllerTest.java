package com.techie.web;

import com.techie.domain.entities.Order;
import com.techie.domain.model.DTOs.*;
import com.techie.service.*;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import org.mockito.*;
import static org.mockito.Mockito.*;
import org.springframework.ui.*;

public class OrderViewControllerTest {

    @Mock
    private OrderService orderService;

    @Mock
    private Model model;

    @InjectMocks
    private OrderViewController orderViewController;

    private AutoCloseable closeable;

    @BeforeEach
    void setUp() {
        closeable = MockitoAnnotations.openMocks(this);
    }

    @AfterEach
    void tearDown() throws Exception {
        closeable.close();
    }

    @Test
    void showOrderConfirmation_ShouldReturnOrderView() {
        // Arrange
        Long orderId = 1L;
        Order order = new Order();
        OrderDTO orderDTO = new OrderDTO();

        when(orderService.getOrderById(orderId)).thenReturn(order);
        when(orderService.convertToDTO(order)).thenReturn(orderDTO);

        // Act
        String viewName = orderViewController.showOrderConfirmation(orderId, model);

        // Assert
        assertEquals("order", viewName);
        verify(model).addAttribute("order", orderDTO);
    }
}
