package com.web.luft.SpringWeb.exception;

public class DuplicateEmailException extends RuntimeException {
    private String message;

    public DuplicateEmailException(String message) {
        super(String.format("%s ", message));
        this.message = message;
    }
    public String getMessage() {
        return message;
    }
}
