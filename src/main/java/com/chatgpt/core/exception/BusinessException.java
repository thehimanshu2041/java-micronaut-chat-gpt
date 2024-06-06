package com.chatgpt.core.exception;

import java.io.Serializable;

public class BusinessException extends RuntimeException implements Serializable {

    private static final long serialVersionUID = 1L;

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(Throwable cause) {
        super(cause);
    }

    public BusinessException(String message, Throwable cause) {
        super(message, cause);
    }

}
