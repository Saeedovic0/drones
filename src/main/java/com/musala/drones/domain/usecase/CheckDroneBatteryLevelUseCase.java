package com.musala.drones.domain.usecase;

import com.musala.drones.app.viewmodel.DroneBatteryLevelViewModel;
import com.musala.drones.domain.exception.DroneNotFoundException;
import com.musala.drones.domain.repo.DroneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CheckDroneBatteryLevelUseCase {
    @Autowired
    private DroneRepo droneRepo;

    public DroneBatteryLevelViewModel check(String serialNumber) {
        var drone = droneRepo.findBySerialNumber(serialNumber);
        if (drone == null) throw new DroneNotFoundException();
        return DroneBatteryLevelViewModel.from(drone);
    }
}
