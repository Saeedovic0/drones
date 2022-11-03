package com.musala.drones.domain.usecase;

import com.musala.drones.app.viewmodel.DroneViewModel;
import com.musala.drones.domain.exception.DroneBatteryLowException;
import com.musala.drones.domain.exception.DroneNotAvailableException;
import com.musala.drones.domain.exception.DroneNotFoundException;
import com.musala.drones.domain.exception.DroneOverloadException;
import com.musala.drones.domain.model.Drone;
import com.musala.drones.domain.model.Medication;
import com.musala.drones.domain.repo.DroneRepo;
import com.musala.drones.domain.repo.MedicationRepo;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class LoadDroneWithMedicationsUseCase {
    @Autowired
    private DroneRepo droneRepo;

    @Autowired
    private MedicationRepo medicationRepo;

    @Transactional
    public DroneViewModel load(String droneSerialNumber, List<Medication> medications) {
        var drone = droneRepo.findBySerialNumber(droneSerialNumber);

        medicationRepo.addMissing(medications);

        if (drone == null) throw new DroneNotFoundException();
        if (drone.getState() != Drone.State.IDLE) throw new DroneNotAvailableException();
        if (drone.getBatteryCapacity() < 0.25) throw new DroneBatteryLowException();

        drone.setState(Drone.State.LOADING);
        droneRepo.save(drone);

        if (medications.stream().mapToDouble(Medication::getWeight).sum() > drone.getWeightLimit())
            throw new DroneOverloadException();

        drone.getMedicationCodes().addAll(medications.stream().map(Medication::getCode).toList());
        drone.setState(Drone.State.LOADED);

        return DroneViewModel.from(droneRepo.save(drone));
    }
}
