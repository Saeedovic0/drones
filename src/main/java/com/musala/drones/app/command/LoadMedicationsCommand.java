package com.musala.drones.app.command;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.musala.drones.domain.model.Medication;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;

import java.util.List;

public record LoadMedicationsCommand(
        @JsonProperty(required = true) @NotEmpty @Valid List<AddMedicationCommand> medicationItems
) {
    public List<Medication> toMedications() {
        return medicationItems.stream().map(AddMedicationCommand::toMedication).toList();
    }
}
