package com.musala.drones.infra.jpa.entity;

import com.musala.drones.domain.model.Drone;
import jakarta.persistence.*;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.UUID;

@NoArgsConstructor
@Entity(name = "DroneAudit")
@Table(name = "drone_audit")
public class DroneAuditEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private UUID id;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "create_date", nullable = false, updatable = false)
    private Date createDate;

    @Column(name = "drone_serial_number", nullable = false, updatable = false)
    private String droneSerialNumber;

    @Enumerated(EnumType.STRING)
    @Column(name = "drone_state", nullable = false, updatable = false)
    private Drone.State droneState;

    @Column(name = "battery_level", nullable = false, updatable = false)
    private float batteryLevel;

    public DroneAuditEntity(Drone drone) {
        droneSerialNumber = drone.getSerialNumber();
        droneState = drone.getState();
        batteryLevel = drone.getBatteryCapacity();
    }
}
