package com.co.multimedia.manager.crosscutting.exception;

import com.co.multimedia.manager.crosscutting.domain.enums.TypeError;

public class ApiProcessException extends Exception {

    private TypeError typeError;

    public ApiProcessException(Throwable cause, TypeError typeError) {
        super(typeError.getDescription(), cause);
    }

    public ApiProcessException(Throwable cause) {
        super(cause);
    }

    public TypeError getTypeError() {
        return typeError;
    }
}
