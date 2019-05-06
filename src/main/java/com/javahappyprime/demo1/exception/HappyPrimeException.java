package com.javahappyprime.demo1.exception;

public class HappyPrimeException extends RuntimeException {

    private ErrorCode errorCode;

    public HappyPrimeException(ErrorCode errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
