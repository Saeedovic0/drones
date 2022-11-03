package com.musala.drones.app.viewmodel;

import com.musala.drones.domain.model.Medication;

public record MedicationViewModel(
        String name,
        float weight,
        String code,
        String imageUrl
) {
    public static MedicationViewModel from(Medication medication) {
        return new MedicationViewModel(
                medication.getName(),
                medication.getWeight(),
                medication.getCode(),
                medication.getImageUrl()
        );
    }
}
