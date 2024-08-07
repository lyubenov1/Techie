package com.techie.domain.model.requests;

import com.techie.domain.enums.*;
import com.techie.domain.model.DTOs.*;
import jakarta.validation.constraints.*;
import lombok.*;

import java.math.*;

@Getter
@Setter
public class OrderRequest {
    private BigDecimal total;
    private Long addressId;
    private PaymentMethod paymentMethod;
    private CartDTO cartDTO;
    private String anonymousAddress;
    @Email(message = "Invalid email address")
    private String anonymousEmail;
}
