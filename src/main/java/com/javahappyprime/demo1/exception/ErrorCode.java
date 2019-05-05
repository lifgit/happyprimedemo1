package com.javahappyprime.demo1.exception;

public enum ErrorCode {

    UNKNOWN("10000"),
    INVALID_NUMBER("10001"),
    RANDOM_NUMBER_BAD_REQUEST("10002"),
    ;

    private String errorCode;

    ErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return errorCode;
    }
}
