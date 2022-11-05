package com.musala.drones.infra.jpa.repo;

import com.musala.drones.domain.model.Medication;
import com.musala.drones.domain.repo.MedicationRepo;
import com.musala.drones.infra.jpa.entity.MedicationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicationRepoImpl implements MedicationRepo {
    @Autowired
    MedicationEntityRepo medicationEntityRepo;

    @Override
    public List<Medication> findAllByCodeIn(List<String> codes) {
        return medicationEntityRepo.findAllById(codes)
                .stream().map(MedicationEntity::toMedication).toList();
    }

    @Override
    public void addMissing(List<Medication> medications) {
        medicationEntityRepo.saveAll(medications.stream().map(MedicationEntity::new).toList());
    }
}
