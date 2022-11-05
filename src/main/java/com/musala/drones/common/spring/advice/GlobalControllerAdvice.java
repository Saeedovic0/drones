package com.musala.drones.common.spring.advice;

import com.musala.drones.domain.exception.DomainException;
import jakarta.validation.ConstraintViolationException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;

@ControllerAdvice
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<List<Error>> handleUnexpectedError(final Throwable throwable) {
        var globalError = new Error();
        log.error(globalError.errorCode(), throwable);
        return ResponseEntity.internalServerError().body(List.of(new Error()));
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<List<Error>> handleDomainException(final DomainException exception) {
        return ResponseEntity.badRequest().body(List.of(new Error(exception)));
    }

    @ExceptionHandler({ConstraintViolationException.class})
    public ResponseEntity<Object> handleConstraintViolationException(final ConstraintViolationException ex) {
        return ResponseEntity.badRequest().body(Error.from(ex));
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(
            MethodArgumentNotValidException ex,
            HttpHeaders headers,
            HttpStatusCode status,
            WebRequest request
    ) {
        return ResponseEntity.badRequest().body(Error.from(ex.getBindingResult()));
    }
}
