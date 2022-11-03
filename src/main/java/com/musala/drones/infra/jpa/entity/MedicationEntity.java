package com.musala.drones.infra.jpa.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Entity(name = "Medication")
@Table(name = "medication")
public class MedicationEntity {
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "weight", nullable = false)
    private float weight;
    @Id
    @Column(name = "code", nullable = false)
    private String code;
    @Column(name = "image_url", nullable = false)
    private String imageUrl;
}
