package org.acme.exception;

public class Exception extends RuntimeException {
    private final String errorCode;
    private final String errorMessage;

    public Exception(String errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public String getErrorCode() {
        return errorCode;
    }

    @Override
    public String getMessage() {
        return errorMessage;
    }
}
