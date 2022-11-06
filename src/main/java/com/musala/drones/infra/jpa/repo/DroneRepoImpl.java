package com.musala.drones.infra.jpa.repo;

import com.musala.drones.domain.model.Drone;
import com.musala.drones.domain.repo.DroneRepo;
import com.musala.drones.infra.jpa.entity.DroneAuditEntity;
import com.musala.drones.infra.jpa.entity.DroneEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class DroneRepoImpl implements DroneRepo {
    @Autowired
    private DroneEntityRepo droneEntityRepo;

    @Autowired
    private DroneAuditEntityRepo droneAuditEntityRepo;

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

    @Override
    public Page<Drone> findAll(int page, int limit) {
        return droneEntityRepo.findAll(PageRequest.of(page, limit)).map(DroneEntity::toDrone);
    }

    @Override
    public void createHistory(List<Drone> drones) {
        droneAuditEntityRepo.saveAll(drones.stream().map(DroneAuditEntity::new).toList());
    }
}
