package com.musala.drones.domain.usecase;

import com.musala.drones.app.viewmodel.DroneViewModel;
import com.musala.drones.domain.model.Drone;
import com.musala.drones.domain.repo.DroneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class RegisterDroneUseCase {
    @Autowired
    private DroneRepo droneRepo;

    public DroneViewModel register(Drone drone) {
        return DroneViewModel.from(droneRepo.save(drone));
    }
}
