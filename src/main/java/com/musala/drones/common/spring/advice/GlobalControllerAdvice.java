package com.musala.drones.common.spring.advice;

import com.musala.drones.domain.exception.DomainException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.List;
import java.util.Optional;

@ControllerAdvice
@RequestMapping(produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class GlobalControllerAdvice extends ResponseEntityExceptionHandler {

    @ExceptionHandler
    public ResponseEntity<List<Error>> handleUnexpectedError(final Throwable throwable) {
        var description = "Operation failed due to unexpected error!";
        log.error(description, throwable);
        var code = Optional.ofNullable(throwable.getMessage()).orElse("UnknownError");
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(List.of(new Error(code, description)));
    }

    @ExceptionHandler(DomainException.class)
    public ResponseEntity<List<Error>> handleDomainException(final DomainException exception) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(List.of(new Error(exception)));
    }
}
