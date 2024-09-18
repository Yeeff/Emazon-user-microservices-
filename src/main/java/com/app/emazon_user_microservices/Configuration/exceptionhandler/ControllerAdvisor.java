package com.app.emazon_user_microservices.Configuration.exceptionhandler;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.support.DefaultHandlerExceptionResolver;

import java.time.LocalDateTime;

@ControllerAdvice
@RequiredArgsConstructor
public class ControllerAdvisor {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ExceptionResponse> handleValidationExceptions(MethodArgumentNotValidException ex) {
        StringBuilder errorMessageBuilder = new StringBuilder();

        ex.getBindingResult().getFieldErrors().forEach(error -> {
            if (errorMessageBuilder.length() > 0) {
                errorMessageBuilder.append(", ");
            }
            errorMessageBuilder.append(error.getDefaultMessage());
        });

        String errorMessage = errorMessageBuilder.toString();

        return ResponseEntity.badRequest().body(new ExceptionResponse(errorMessage,
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ExceptionResponse> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex) {

        return ResponseEntity.badRequest().body(new ExceptionResponse(ex.getMessage(),
                HttpStatus.BAD_REQUEST.toString(), LocalDateTime.now()));
    }
}
