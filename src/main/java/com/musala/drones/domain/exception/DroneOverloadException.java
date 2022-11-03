package com.musala.drones.domain.exception;

public class DroneOverloadException extends DomainException {
    private static final String MESSAGE = "DroneOverload";


    public DroneOverloadException() {
        super(MESSAGE);
    }

    public DroneOverloadException(Throwable throwable) {
        super(MESSAGE, throwable);
    }
}
