package com.techie.exceptions;

public class ImageTooBigException extends RuntimeException {
    public ImageTooBigException(String imageName) {
        super("Image " + imageName + " is over the maximum size of 1 MB.");
    }
}
