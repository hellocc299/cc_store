package com.cc.Exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author CC
 * @Date 2023/2/1
 */
@ControllerAdvice
@RestController
@Slf4j
public class ExceptionAdvice {

    @ResponseBody
    @ExceptionHandler(BusinessException.class)
    public ErrorR handleException(Exception ex) {
        if (ex instanceof BusinessException) {
            log.warn(ex.getMessage(), ex);
            BusinessException businessException = (BusinessException) ex;
            return ErrorR.create(businessException.getCode(), businessException.getMessage());
        } else {
            log.error(ex.getMessage(), ex);
            return ErrorR.create(HttpStatus.INTERNAL_SERVER_ERROR.value(), ex.getMessage());
        }
    }
}
