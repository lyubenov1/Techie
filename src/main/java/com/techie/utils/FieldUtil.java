package com.techie.utils;

import com.techie.domain.model.DTOs.*;

import java.lang.reflect.*;

public class FieldUtil {

    public static Field[] getFields(ProductDTO product) {
        Class<? extends ProductDTO> productClass = product.getClass();   // Get inheritor child class to access its specific fields
        return productClass.getDeclaredFields();
    }

}
