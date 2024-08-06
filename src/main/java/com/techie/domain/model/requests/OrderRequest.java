package com.techie.domain.model.requests;

import com.techie.domain.enums.*;
import com.techie.domain.model.DTOs.*;
import lombok.*;

import java.math.*;

@Getter
@Setter
public class OrderRequest {
    private BigDecimal total;
    private Long addressId;
    private String anonymousAddress;
    private String anonymousEmail;
    private PaymentMethod paymentMethod;
    private CartDTO cartDTO;
}
