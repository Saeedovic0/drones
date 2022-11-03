package com.musala.drones.infra.jpa.entity;

import com.musala.drones.domain.model.Drone;
import com.vladmihalcea.hibernate.type.json.JsonType;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Type;

import java.util.List;

@NoArgsConstructor
@Entity(name = "Drone")
@Table(name = "drone")
public class DroneEntity {
    @Id
    @Column(name = "serial_number", nullable = false, length = 100)
    private String serialNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "model", nullable = false)
    private Drone.Model model;

    @Column(name = "weight_limit", nullable = false)
    private float weightLimit;

    @Column(name = "battery_capacity", nullable = false)
    private float batteryCapacity;

    @Enumerated(EnumType.STRING)
    @Column(name = "state", nullable = false)
    private Drone.State state;

    @Type(JsonType.class)
    @Column(name = "medication_codes")
    private List<String> medicationCodes;


    public DroneEntity(Drone drone) {
        serialNumber = drone.getSerialNumber();
        model = drone.getModel();
        weightLimit = drone.getWeightLimit();
        batteryCapacity = drone.getBatteryCapacity();
        state = drone.getState();
        medicationCodes = drone.getMedicationCodes();
    }
}
