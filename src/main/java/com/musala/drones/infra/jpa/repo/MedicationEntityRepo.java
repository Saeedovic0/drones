package com.musala.drones.infra.jpa.repo;

import com.musala.drones.infra.jpa.entity.MedicationEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MedicationEntityRepo extends JpaRepository<MedicationEntity, String> {
}
