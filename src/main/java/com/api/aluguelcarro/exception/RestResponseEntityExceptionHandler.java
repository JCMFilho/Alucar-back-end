package com.api.aluguelcarro.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.text.ParseException;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler({ EmailSenderException.class, ValidationException.class })
    public ResponseEntity<Object> handleValidationException(
            Exception ex, WebRequest request) {

        return new ResponseEntity<Object>(
                ex.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler({ ParseException.class })
    public ResponseEntity<Object> handleParseException(Exception ex, WebRequest request) {
        return new ResponseEntity<Object>(
                "Data informada inválida", new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }
}
