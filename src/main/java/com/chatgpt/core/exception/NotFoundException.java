package com.chatgpt.core.exception;

import java.io.Serializable;

/**
 * Root level hierarchy for Exceptions that are related to a no data found.<br>
 */
public class NotFoundException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public NotFoundException(String message) {
        super(message);
    }

    public NotFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NotFoundException(Throwable cause) {
        super(cause);
    }
}
