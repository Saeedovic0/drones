package com.musala.drones.domain.model;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.URL;

@AllArgsConstructor
@Getter
public class Medication {
    @Pattern(regexp = "^[A-Za-z\\d-_]$")
    private String name;
    private float weight;
    @Pattern(regexp = "^[A-Z\\d_]$")
    private String code;
    @URL
    private String imageUrl;
}
