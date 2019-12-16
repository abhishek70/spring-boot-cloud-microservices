package com.abhishekd.profileservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Custom Resource Not Found Exception Handler
     * @param ex
     * @param webRequest
     * @return
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(ResourceNotFoundException ex, HttpServletRequest webRequest) {

        ExceptionResponse errorInfo =  new ExceptionResponse(404, HttpStatus.NOT_FOUND, ex.getMessage() , webRequest.getRequestURI());

        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }

    /**
     * Custom Resource Not Found Exception Handler
     * @param ex
     * @param webRequest
     * @return
     */
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<Object> handleAllExceptions(Exception ex, HttpServletRequest webRequest) {

        ExceptionResponse errorInfo =  new ExceptionResponse(500, HttpStatus.INTERNAL_SERVER_ERROR, "Internal Server Error", webRequest.getRequestURI());

        return new ResponseEntity<>(errorInfo, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
