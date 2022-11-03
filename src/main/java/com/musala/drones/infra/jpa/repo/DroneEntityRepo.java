package com.musala.drones.infra.jpa.repo;

import com.musala.drones.infra.jpa.entity.DroneEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneEntityRepo extends JpaRepository<String, DroneEntity> {

}