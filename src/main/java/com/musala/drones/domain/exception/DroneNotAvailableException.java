package com.musala.drones.domain.exception;

public class DroneNotAvailableException extends DomainException {
    private static final String MESSAGE = "DroneBusy";


    public DroneNotAvailableException() {
        super(MESSAGE);
    }

    public DroneNotAvailableException(Throwable throwable) {
        super(MESSAGE, throwable);
    }
}
