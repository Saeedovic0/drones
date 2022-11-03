package com.musala.drones.domain.repo;

import com.musala.drones.domain.model.Drone;
import org.springframework.data.domain.Page;

public interface DroneRepo {
    Drone save(Drone drone);

    Drone findBySerialNumber(String serialNumber);

    Page<Drone> findAllAvailable(float totalLoadWeight);
}
