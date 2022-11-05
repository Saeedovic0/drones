package com.musala.drones.infra.jpa.repo;

import com.musala.drones.domain.model.Drone;
import com.musala.drones.domain.repo.DroneRepo;
import com.musala.drones.infra.jpa.entity.DroneEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

@Component
public class DroneRepoImpl implements DroneRepo {
    @Autowired
    private DroneEntityRepo droneEntityRepo;

    @Override
    public Drone save(Drone drone) {
        return droneEntityRepo.save(new DroneEntity(drone)).toDrone();
    }

    @Override
    public Drone findBySerialNumber(String serialNumber) {
        var droneEntity = droneEntityRepo.findById(serialNumber).orElse(null);
        return droneEntity == null ? null : droneEntity.toDrone();
    }

    @Override
    public Page<Drone> findAllAvailable(float totalLoadWeight, int page, int limit) {
        return droneEntityRepo.findByStateAndWeightLimitGreaterThanEqualAndBatteryCapacityGreaterThanEqual(
                        Drone.State.IDLE, totalLoadWeight, 0.25f, PageRequest.of(page, limit))
                .map(DroneEntity::toDrone);
    }
}
