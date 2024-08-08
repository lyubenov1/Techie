package com.techie.domain.enums;

import java.util.*;
import java.util.stream.*;

public enum PaymentMethod {
    DEBIT_CARD,
    CREDIT_CARD,
    CASH,
    BANK_TRANSFER,
    PAYPAL,
    BITCOIN;


    @Override
    public String toString() {
        // Split by underscore, capitalize each word, and join with a space
        return Arrays.stream(name().toLowerCase().split("_"))
                .map(word -> Character.toUpperCase(word.charAt(0)) + word.substring(1))
                .collect(Collectors.joining(" "));
    }
}
