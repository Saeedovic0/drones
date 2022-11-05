package com.musala.drones.domain.repo;

import com.musala.drones.domain.model.Drone;
import org.springframework.data.domain.Page;

import java.util.List;

public interface DroneRepo {
    Drone save(Drone drone);

    Drone findBySerialNumber(String serialNumber);

    Page<Drone> findAllAvailable(float totalLoadWeight, int page, int limit);

    Page<Drone> findAll(int page, int limit);

    void createHistory(List<Drone> drones);
}
