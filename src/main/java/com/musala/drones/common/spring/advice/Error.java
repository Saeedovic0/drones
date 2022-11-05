package com.musala.drones.common.spring.advice;

import com.musala.drones.domain.exception.DomainException;
import jakarta.validation.ConstraintViolationException;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;

public record Error(String errorCode, String description) {
    public Error() {
        this("UnknownError", "Operation failed due to unexpected error!");
    }

    public Error(DomainException e) {
        this(e.getMessage(), e.getDescription());
    }

    public static Error invalidInput(String description) {
        return new Error("InvalidInput", description);
    }

    public static List<Error> from(ConstraintViolationException exception) {
        List<Error> errors = new ArrayList<>();
        for (var violation : exception.getConstraintViolations())
            errors.add(Error.invalidInput(violation.getPropertyPath() + " " + violation.getMessage() + "!"));
        return errors;
    }

    public static List<Error> from(BindingResult bindingResult) {
        List<Error> errors = new ArrayList<>();
        if (bindingResult.getFieldErrors().isEmpty())
            for (var error : bindingResult.getAllErrors())
                errors.add(Error.invalidInput(error.getDefaultMessage() + "!"));
        else
            for (var error : bindingResult.getFieldErrors())
                errors.add(Error.invalidInput(error.getField() + " " + error.getDefaultMessage() + "!"));
        return errors;
    }
}
