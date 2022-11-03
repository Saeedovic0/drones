package com.musala.drones.infra.jpa.repo;

import com.musala.drones.domain.model.Drone;
import com.musala.drones.domain.repo.DroneRepo;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Component;

@Component
public class DroneRepoImpl implements DroneRepo {
    @Override
    public Drone save(Drone drone) {
        throw new NotYetImplementedException();
    }

    @Override
    public Drone findBySerialNumber(String serialNumber) {
        throw new NotYetImplementedException();
    }

    @Override
    public Page<Drone> findAllAvailable(float totalLoadWeight) {
        throw new NotYetImplementedException();
    }
}
