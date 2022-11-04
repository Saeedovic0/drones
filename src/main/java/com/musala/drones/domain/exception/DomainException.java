package com.musala.drones.domain.exception;

import jakarta.validation.constraints.NotBlank;

public abstract class DomainException extends RuntimeException {
    protected DomainException(final String message) {
        super(message);
    }

    protected DomainException(final String message, final Throwable throwable) {
        super(message, throwable);
    }

    public abstract @NotBlank String getDescription();
}
