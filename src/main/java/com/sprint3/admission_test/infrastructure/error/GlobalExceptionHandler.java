package com.sprint3.admission_test.infrastructure.error;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;
import com.sprint3.admission_test.domain.exceptions.AlreadyExistsException;
import com.sprint3.admission_test.domain.exceptions.NotFoundException;
import org.springframework.http.*;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.format.DateTimeParseException;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collector;

@RestControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<String> handlerNotFound(NotFoundException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(AlreadyExistsException.class)
    public ResponseEntity<String> alreadyExistsHandler(AlreadyExistsException ex) {
        return new ResponseEntity<>(ex.getMessage(), HttpStatus.CONFLICT);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        ProblemDetail body = ProblemDetail.forStatusAndDetail(status, "Validation failed for " + ex.getFieldErrors().size() + " fields");

        Map<String, String> errors = ex.getFieldErrors().stream()
                .collect(LinkedHashMap::new,
                        (map, error) -> map.put(error.getField(), error.getDefaultMessage()),
                        Map::putAll);

        body.setProperty("errors", errors);

        return this.createResponseEntity(body, headers, status, request);
    }

    @Override
    protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex, HttpHeaders headers, HttpStatusCode status, WebRequest request) {
        Throwable cause = ex.getCause();
        ProblemDetail body = ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST, ex.getMessage());

        if (cause instanceof InvalidFormatException dte) {
            body.setDetail(dte.getCause().getMessage());
        } else {
            return super.handleHttpMessageNotReadable(ex, headers, status, request);
        }

        return this.createResponseEntity(body, headers, status, request);
    }
}
