package com.musala.drones.common.spring.advice;

import com.musala.drones.domain.exception.DomainException;

public record Error(String errorCode, String description) {
    public Error(DomainException e) {
        this(e.getMessage(), e.getDescription());
    }
}
