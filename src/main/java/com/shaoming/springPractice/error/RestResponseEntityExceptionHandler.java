package com.shaoming.springPractice.error;

import com.shaoming.springPractice.model.ErrorMsg;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ProductNotFoundException.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ErrorMsg productNotFoundHandler(ProductNotFoundException ex){
        return new ErrorMsg(HttpStatus.NOT_FOUND, ex.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMsg exceptionHandler(Exception ex){
        return new ErrorMsg(HttpStatus.INTERNAL_SERVER_ERROR, ex.getMessage());
    }
}
