package com.javahappyprime.demo1.aop;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.javahappyprime.demo1.exception.ErrorCode;

public class CustomResponse {

    private boolean success;

    @JsonInclude(Include.NON_NULL)
    private Object data;

    @JsonInclude(Include.NON_NULL)
    private String errorCode;

    @JsonInclude(Include.NON_NULL)
    private String errorMessage;

    public CustomResponse(Object data) {
        this.success = true;
        this.data = data;
    }

    public CustomResponse(String errorCode, String errorMessage) {
        this.success = false;
        this.errorCode = errorCode;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
