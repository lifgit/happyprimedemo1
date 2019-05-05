package com.javahappyprime.demo1.exception;

public class BizarreException extends RuntimeException {

    private ErrorCode errorCode;

    public BizarreException(ErrorCode errorCode, String errorMessage) {
        super(errorMessage);
        this.errorCode = errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }
}
