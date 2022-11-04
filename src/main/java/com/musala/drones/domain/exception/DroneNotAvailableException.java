package com.musala.drones.domain.exception;

import com.musala.drones.domain.model.Drone;

public class DroneNotAvailableException extends DomainException {
    private static final String MESSAGE = "DroneBusy";

    private Drone.State state;


    public DroneNotAvailableException() {
        super(MESSAGE);
    }

    public DroneNotAvailableException(Throwable throwable) {
        super(MESSAGE, throwable);
    }

    public DroneNotAvailableException(Drone.State state) {
        super(MESSAGE);
        this.state = state;
    }

    @Override
    public String getDescription() {
        return "Drone is currently unavailable, state: " + state.name();
    }
}
