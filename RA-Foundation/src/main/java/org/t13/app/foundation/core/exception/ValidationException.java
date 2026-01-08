package org.t13.app.foundation.core.exception;

public class ValidationException extends BadRequestException {
    public ValidationException(String message) {
        super(message);
    }
    public ValidationException(String message, Integer code) {
        super(message, code);
    }
}
