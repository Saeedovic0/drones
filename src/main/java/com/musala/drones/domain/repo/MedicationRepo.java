package com.musala.drones.domain.repo;

import com.musala.drones.domain.model.Medication;

import java.util.List;

public interface MedicationRepo {
    List<Medication> findAllByCodeIn(List<String> codes);

    void addMissing(List<Medication> medications);
}
