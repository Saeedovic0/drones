package com.musala.drones.domain.exception;

import com.musala.drones.common.util.StringUtils;

public class DroneBatteryLowException extends DomainException {
    private static final String MESSAGE = "DroneBatteryLow";

    private final String batteryCapacity;

    public DroneBatteryLowException() {
        super(MESSAGE);
        batteryCapacity = "N/A";
    }

    public DroneBatteryLowException(Throwable throwable) {
        super(MESSAGE, throwable);
        batteryCapacity = "N/A";
    }

    public DroneBatteryLowException(float batteryCapacity) {
        super(MESSAGE);
        this.batteryCapacity = StringUtils.toPercentage(batteryCapacity);
    }

    @Override
    public String getDescription() {
        return "Drone battery is very low: " + batteryCapacity;
    }
}
