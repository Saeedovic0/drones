package com.musala.drones.domain.usecase;

import com.musala.drones.app.viewmodel.DroneViewModel;
import com.musala.drones.common.paging.PageResponse;
import com.musala.drones.domain.model.Medication;
import com.musala.drones.domain.repo.DroneRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CheckAvailableDronesUseCase {
    @Autowired
    private DroneRepo droneRepo;

    public PageResponse<DroneViewModel> check(List<Medication> medications) {
        return new PageResponse<>(
                droneRepo.findAllAvailable((float) medications.stream().mapToDouble(Medication::getWeight).sum())
                        .map(DroneViewModel::from)
        );
    }
}
