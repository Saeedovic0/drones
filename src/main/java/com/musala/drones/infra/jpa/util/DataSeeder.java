package com.musala.drones.infra.jpa.util;

import com.musala.drones.domain.model.Drone;
import com.musala.drones.domain.model.Medication;
import com.musala.drones.infra.jpa.entity.DroneEntity;
import com.musala.drones.infra.jpa.entity.MedicationEntity;
import com.musala.drones.infra.jpa.repo.DroneEntityRepo;
import com.musala.drones.infra.jpa.repo.MedicationEntityRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
class DataSeeder {
    @Autowired
    DroneEntityRepo droneEntityRepo;

    @Autowired
    MedicationEntityRepo medicationEntityRepo;

    @EventListener
    private void handleContextRefresh(ContextRefreshedEvent event) {
        seedDrones();
        seedMedications();
    }

    private void seedDrones() {
        var drones = List.of(
                new Drone("3457547835", Drone.Model.LIGHT_WEIGHT, 100, 0.67f, Drone.State.IDLE),
                new Drone("7364593854", Drone.Model.LIGHT_WEIGHT, 100, 0.14f, Drone.State.IDLE),
                new Drone("8596036475", Drone.Model.MIDDLE_WEIGHT, 200, 0.94f, Drone.State.IDLE),
                new Drone("9846573849", Drone.Model.MIDDLE_WEIGHT, 200, 0.34f, Drone.State.IDLE),
                new Drone("2345636245", Drone.Model.CRUISER_WEIGHT, 300, 0.97f, Drone.State.IDLE),
                new Drone("5788353253", Drone.Model.CRUISER_WEIGHT, 300, 0.16f, Drone.State.IDLE),
                new Drone("9459789259", Drone.Model.HEAVY_WEIGHT, 400, 0.13f, Drone.State.IDLE),
                new Drone("1327307474", Drone.Model.HEAVY_WEIGHT, 400, 1.00f, Drone.State.IDLE),
                new Drone("2386160445", Drone.Model.HEAVY_WEIGHT, 500, 0.24f, Drone.State.IDLE),
                new Drone("3398773895", Drone.Model.HEAVY_WEIGHT, 500, 0.00f, Drone.State.IDLE)
        );
        droneEntityRepo.saveAll(drones.stream().map(DroneEntity::new).toList());
    }

    private void seedMedications() {
        var medications = List.of(
                new Medication("Panadol-Menstrual", 56, "PANADOL_MENSTRUAL", "https://www.collinsdictionary.com/images/full/capsule_639127393_1000.jpg"),
                new Medication("Panadol-Actifast-Compack", 68, "PANADOL_ACTIFAST_COMPACK", "https://www.collinsdictionary.com/images/full/capsule_639127393_1000.jpg"),
                new Medication("Panadol-Actifast", 43, "PANADOL_Actifast", "https://www.collinsdictionary.com/images/full/capsule_639127393_1000.jpg"),
                new Medication("Panadol-Extra", 90, "PANADOL_EXTRA", "https://www.collinsdictionary.com/images/full/capsule_639127393_1000.jpg"),
                new Medication("Panadol-Pain-Relief", 34, "PANADOL_PAIN_RELIEF", "https://www.collinsdictionary.com/images/full/capsule_639127393_1000.jpg"),
                new Medication("Panadol-Extend", 86, "PANADOL_EXTEND", "https://www.collinsdictionary.com/images/full/capsule_639127393_1000.jpg"),
                new Medication("Panadol-Migraine", 23, "PANADOL_MIGRAINE", "https://www.collinsdictionary.com/images/full/capsule_639127393_1000.jpg"),
                new Medication("Panadol-Night", 57, "PANADOL_NIGHT", "https://www.collinsdictionary.com/images/full/capsule_639127393_1000.jpg"),
                new Medication("Panadol-Joint", 87, "PANADOL_JOINT", "https://www.collinsdictionary.com/images/full/capsule_639127393_1000.jpg"),
                new Medication("Panadol-Sinus", 54, "PANADOL_SINUS", "https://www.collinsdictionary.com/images/full/capsule_639127393_1000.jpg"),
                new Medication("Panadol-Advance", 69, "PANADOL_ADVANCE", "https://www.collinsdictionary.com/images/full/capsule_639127393_1000.jpg")
        );
        medicationEntityRepo.saveAll(medications.stream().map(MedicationEntity::new).toList());
    }
}
