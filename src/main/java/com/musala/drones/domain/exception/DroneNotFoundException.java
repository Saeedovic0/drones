package com.musala.drones.domain.exception;

public class DroneNotFoundException extends DomainException {
    private static final String MESSAGE = "DroneNotRegistered";


    public DroneNotFoundException() {
        super(MESSAGE);
    }

    public DroneNotFoundException(Throwable throwable) {
        super(MESSAGE, throwable);
    }
}
