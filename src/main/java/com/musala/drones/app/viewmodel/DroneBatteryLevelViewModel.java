package com.musala.drones.app.viewmodel;

import com.musala.drones.common.util.StringUtils;
import com.musala.drones.domain.model.Drone;

public record DroneBatteryLevelViewModel(
        String batteryLevel
) {
    public static DroneBatteryLevelViewModel from(Drone drone) {
        return new DroneBatteryLevelViewModel(StringUtils.toPercentage(drone.getBatteryCapacity()));
    }
}
