package com.musala.drones.domain.usecase;

import com.musala.drones.app.viewmodel.MedicationViewModel;
import com.musala.drones.domain.exception.DroneNotFoundException;
import com.musala.drones.domain.repo.DroneRepo;
import com.musala.drones.domain.repo.MedicationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CheckDroneLoadedMedicationsUseCase {
    @Autowired
    private DroneRepo droneRepo;

    @Autowired
    private MedicationRepo medicationRepo;

    public List<MedicationViewModel> check(String droneSerialNumber) {
        var drone = droneRepo.findBySerialNumber(droneSerialNumber);
        if (drone == null) throw new DroneNotFoundException();

        return medicationRepo.findAllByCodeIn(drone.getMedicationCodes())
                .stream().map(MedicationViewModel::from).toList();

    }
}
