package com.techie.exceptions;

public class CategoryNotFoundException extends ObjectNotFoundException {
    public CategoryNotFoundException(String categoryName) {
        super("Category with name \"" + categoryName + "\" not found");

    }
}
