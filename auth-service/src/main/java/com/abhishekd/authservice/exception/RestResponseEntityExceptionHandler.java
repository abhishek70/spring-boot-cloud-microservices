package com.abhishekd.authservice.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import javax.servlet.http.HttpServletRequest;

@Slf4j
@Order(Ordered.HIGHEST_PRECEDENCE)
@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    /**
     * Custom Resource Not Found Exception Handler
     * @param exception
     * @param webRequest
     * @return
     */
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler({ResourceNotFoundException.class})
    public ResponseEntity<Object> handleNotFoundException(ResourceNotFoundException exception, HttpServletRequest webRequest) {

        ExceptionResponse errorInfo =  new ExceptionResponse(404, HttpStatus.NOT_FOUND, "Resource Not Found", webRequest.getRequestURI());

        return new ResponseEntity<>(errorInfo, HttpStatus.NOT_FOUND);
    }

    /**
     * Custom Resource Not Found Exception Handler
     * @param exception
     * @param webRequest
     * @return
     */
    @ResponseStatus(HttpStatus.CONFLICT)
    @ExceptionHandler({ResourceExistsException.class})
    public ResponseEntity<Object> handleResourceExistsException(ResourceExistsException exception, HttpServletRequest webRequest) {

        ExceptionResponse errorInfo =  new ExceptionResponse(409, HttpStatus.CONFLICT, exception.getMessage(), webRequest.getRequestURI());

        return new ResponseEntity<>(errorInfo, HttpStatus.CONFLICT);
    }

    /**
     * Method Argument not valid exception handler
     * @param ex
     * @param headers
     * @param status
     * @param request
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        BindingResult result = ex.getBindingResult();
        FieldError error = result.getFieldError();

        log.info(error.getDefaultMessage());
        log.info(error.getField());

        String message = error.getField() + " : " + error.getDefaultMessage();

        ExceptionResponse errorInfo =  new ExceptionResponse(400, HttpStatus.BAD_REQUEST, message, request.getContextPath());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);

    }

    /**
     * Method for handling constraint violation exception
     * @param ex
     * @param request
     * @return
     */
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(javax.validation.ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(Exception ex, HttpServletRequest request) {

        ExceptionResponse errorInfo =  new ExceptionResponse(400, HttpStatus.BAD_REQUEST, "Bad Request", request.getRequestURI());
        return new ResponseEntity<>(errorInfo, HttpStatus.BAD_REQUEST);

    }
}
