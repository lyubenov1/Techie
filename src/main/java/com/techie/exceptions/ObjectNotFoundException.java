package com.techie.exceptions;

import org.slf4j.*;

public class ObjectNotFoundException extends RuntimeException {
    private static final Logger logger = LoggerFactory.getLogger(ObjectNotFoundException.class);

    public ObjectNotFoundException(String message) {
        super(message);
        logger.info("ObjectNotFoundException: {}", message, this);
    }
}