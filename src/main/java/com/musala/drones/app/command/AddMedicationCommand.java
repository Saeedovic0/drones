package com.musala.drones.app.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musala.drones.domain.model.Medication;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.URL;

public record AddMedicationCommand(
        @JsonProperty(required = true) @Pattern(regexp = "^[A-Za-z\\d-_]$") String name,
        @JsonProperty(required = true) @Positive float weight,
        @JsonProperty(required = true) @Pattern(regexp = "^[A-Z\\d_]$") String code,
        @JsonProperty(required = true) @URL String imageUrl) {

    public Medication toMedication() {
        return new Medication(name, weight, code, imageUrl);
    }
}
