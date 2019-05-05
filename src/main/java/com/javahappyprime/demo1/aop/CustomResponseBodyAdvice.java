package com.javahappyprime.demo1.aop;

import com.javahappyprime.demo1.exception.BizarreException;
import com.javahappyprime.demo1.exception.ErrorCode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.MethodParameter;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import javax.servlet.http.HttpServletRequest;

@ControllerAdvice
public class CustomResponseBodyAdvice implements ResponseBodyAdvice {

    private final static Logger LOGGER = LoggerFactory.getLogger(CustomResponseBodyAdvice.class);

    @Override
    public boolean supports(MethodParameter methodParameter, Class aClass) {
        Boolean isRest = AnnotationUtils.isAnnotationDeclaredLocally(
                            RestController.class,
                            methodParameter.getContainingClass()
                         );
        ResponseBody responseBody = AnnotationUtils.findAnnotation(methodParameter.getMethod(), ResponseBody.class);
        return isRest || responseBody != null ? true : false;
    }

    @Override
    public Object beforeBodyWrite(Object o,
                                  MethodParameter methodParameter,
                                  MediaType mediaType,
                                  Class aClass,
                                  ServerHttpRequest serverHttpRequest,
                                  ServerHttpResponse serverHttpResponse) {
        if (o instanceof CustomResponse) {
            return o;
        }
        return new CustomResponse(o);
    }

    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public CustomResponse handleAllException(HttpServletRequest request, Exception ex) {
        LOGGER.error("Something wrong,", ex);
        String errorCode = ErrorCode.UNKNOWN.toString();
        if (ex instanceof BizarreException) {
            errorCode = ((BizarreException)ex).getErrorCode().toString();
        } else if (ex instanceof HttpClientErrorException) {
            HttpStatus httpStatus = ((HttpClientErrorException)ex).getStatusCode();
            errorCode = String.valueOf(httpStatus.value());
        }
        return new CustomResponse(errorCode, ex.getMessage());
    }
}
