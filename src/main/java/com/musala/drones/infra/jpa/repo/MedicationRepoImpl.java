package com.musala.drones.infra.jpa.repo;

import com.musala.drones.domain.model.Medication;
import com.musala.drones.domain.repo.MedicationRepo;
import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class MedicationRepoImpl implements MedicationRepo {
    @Override
    public List<Medication> findAllByCodeIn(List<String> codes) {
        throw new NotYetImplementedException();
    }

    @Override
    public void addMissing(List<Medication> medications) {
        throw new NotYetImplementedException();
    }
}
