package com.ccc.tcapi.exceptions;

import java.util.Properties;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@RestControllerAdvice
public class ConstraintExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<Object> handleConstraintViolation(ConstraintViolationException ex, WebRequest request) {

        // final List<KeyValue> errors = new ArrayList<KeyValue>();
        final Properties props = new Properties();

        for (final ConstraintViolation<?> violation : ex.getConstraintViolations()) {
            props.setProperty(violation.getPropertyPath().toString(), violation.getMessage());
        }

        return ResponseEntity.badRequest().body(props);

        // Set<ConstraintViolation<?>> violations = ex.getConstraintViolations();
        // String errorMessage = "";
        // if (!violations.isEmpty()) {
        // StringBuilder builder = new StringBuilder();
        // violations.forEach(violation -> builder.append(" " +
        // violation.getLeafBean().getMessage()));
        // errorMessage = builder.toString();
        // } else {
        // errorMessage = "ConstraintViolationException occured.";
        // }
        // return new ResponseEntity<>(errorMessage, HttpStatus.BAD_REQUEST);

    }

}