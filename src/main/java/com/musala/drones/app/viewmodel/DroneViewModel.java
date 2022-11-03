package com.musala.drones.app.viewmodel;

import com.musala.drones.domain.model.Drone;

public record DroneViewModel(
        String serialNumber,
        Drone.Model model,
        float weightLimit,
        float batteryCapacity,
        Drone.State state
) {
    public static DroneViewModel from(Drone drone) {
        return new DroneViewModel(
                drone.getSerialNumber(),
                drone.getModel(),
                drone.getWeightLimit(),
                drone.getBatteryCapacity(),
                drone.getState()
        );
    }
}
