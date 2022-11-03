package com.musala.drones.app.command;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.musala.drones.domain.model.Drone;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@JsonIgnoreProperties(ignoreUnknown = true)
public record RegisterDroneCommand(
        @NotBlank
        @Size(min = 1, max = 100)
        @JsonProperty(value = "serialNumber", required = true)
        String serialNumber,
        @JsonProperty(value = "model", required = true)
        Drone.Model model,
        @Max(500) // gm
        @JsonProperty(value = "weightLimit", required = true)
        float weightLimit,
        @Max(1) // %
        @JsonProperty(value = "batteryCapacity", required = true)
        float batteryCapacity
) {
    public Drone toDrone() {
        return new Drone(serialNumber, model, weightLimit, batteryCapacity, Drone.State.IDLE);
    }
}
