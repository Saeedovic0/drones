package com.musala.drones.domain.exception;

public class DroneNotFoundException extends DomainException {
    private static final String MESSAGE = "DroneNotRegistered";

    private final String serialNumber;


    public DroneNotFoundException() {
        super(MESSAGE);
        serialNumber = "N/A";
    }

    public DroneNotFoundException(Throwable throwable) {
        super(MESSAGE, throwable);
        serialNumber = "N/A";
    }

    public DroneNotFoundException(String serialNumber) {
        super(MESSAGE);
        this.serialNumber = serialNumber;
    }

    @Override
    public String getDescription() {
        return "Invalid drone serial number: " + serialNumber;
    }
}
