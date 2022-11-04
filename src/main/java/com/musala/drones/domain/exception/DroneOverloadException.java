package com.musala.drones.domain.exception;

public class DroneOverloadException extends DomainException {
    private static final String MESSAGE = "DroneOverload";

    private Float weightLimit;
    private Float weightProvided;


    public DroneOverloadException() {
        super(MESSAGE);
    }

    public DroneOverloadException(Throwable throwable) {
        super(MESSAGE, throwable);
    }

    public DroneOverloadException(float weightLimit, float weightProvided) {
        super(MESSAGE);
        this.weightLimit = weightLimit;
        this.weightProvided = weightProvided;
    }

    @Override
    public String getDescription() {
        return String.format("Drone weight limit exceeded, limit: %s, provided: %s",
                weightLimit == null ? "N/A" : weightLimit,
                weightProvided == null ? "N/A" : weightProvided
        );
    }
}
