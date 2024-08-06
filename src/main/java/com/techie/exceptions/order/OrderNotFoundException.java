package com.techie.exceptions.order;

import com.techie.exceptions.*;

public class OrderNotFoundException extends ObjectNotFoundException {
    public OrderNotFoundException() {
        super("Order not found");
    }
}
