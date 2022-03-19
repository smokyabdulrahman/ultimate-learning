package me.alrahma.ultimatelearning.url.shortner.exceptions;

import me.alrahma.ultimatelearning.url.shortner.dtos.Error;
import org.springframework.boot.web.reactive.error.DefaultErrorAttributes;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.function.ServerRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value
            = { ResourceNotFoundException.class })
    protected ResponseEntity<Error> handleNotFound(
            RuntimeException ex, WebRequest request) {
        String bodyOfResponse = "This should be application specific";

        var error = new Error(HttpStatus.NOT_FOUND, bodyOfResponse, ex);
        return new ResponseEntity<>(error, error.getStatus());
    }
}
