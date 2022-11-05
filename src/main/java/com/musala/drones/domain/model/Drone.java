package com.musala.drones.domain.model;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class Drone {
    @NotBlank
    @Size(min = 1, max = 100)
    private final String serialNumber;
    private final Model model;
    @Max(500) // gm
    private final float weightLimit;
    @Max(1) // %
    private final float batteryCapacity;
    private State state;
    private List<String> medicationCodes = new ArrayList<>();

    public Drone(String serialNumber, Model model, float weightLimit, float batteryCapacity, State state) {
        this.serialNumber = serialNumber;
        this.model = model;
        this.weightLimit = weightLimit;
        this.batteryCapacity = batteryCapacity;
        this.state = state;
    }

    public enum Model {
        LIGHT_WEIGHT, MIDDLE_WEIGHT, CRUISER_WEIGHT, HEAVY_WEIGHT
    }

    public enum State {
        IDLE, LOADING, LOADED, DELIVERING, DELIVERED, RETURNING
    }
}
