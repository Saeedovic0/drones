package com.musala.drones.infra.jpa.repo;

import com.musala.drones.domain.model.Drone;
import com.musala.drones.infra.jpa.entity.DroneEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface DroneEntityRepo extends JpaRepository<DroneEntity, String> {
    Page<DroneEntity> findByStateAndWeightLimitGreaterThanEqualAndBatteryCapacityGreaterThanEqual
            (Drone.State state, float weightLimit, float batteryCapacity, Pageable pageable);
}
