package com.musala.drones.infra.jpa.repo;

import com.musala.drones.infra.jpa.entity.DroneAuditEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface DroneAuditEntityRepo extends CrudRepository<DroneAuditEntity, UUID> {
}
