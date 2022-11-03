package com.musala.drones;

import jakarta.annotation.PostConstruct;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.TimeZone;

@SpringBootApplication
public class DronesApplication {

    public static void main(String[] args) {
        SpringApplication.run(DronesApplication.class, args);
    }

    @PostConstruct
    void postInit() {
        TimeZone.setDefault(TimeZone.getTimeZone("UTC"));
    }
}
