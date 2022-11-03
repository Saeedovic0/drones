package com.musala.drones.domain.exception;

public class DroneBatteryLowException extends DomainException {
    private static final String MESSAGE = "DroneBatteryLow";


    public DroneBatteryLowException() {
        super(MESSAGE);
    }

    public DroneBatteryLowException(Throwable throwable) {
        super(MESSAGE, throwable);
    }
}
