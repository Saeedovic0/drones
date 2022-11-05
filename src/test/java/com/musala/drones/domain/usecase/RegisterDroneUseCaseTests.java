package com.musala.drones.domain.usecase;

import com.musala.drones.app.viewmodel.DroneViewModel;
import com.musala.drones.domain.model.Drone;
import com.musala.drones.domain.repo.DroneRepo;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.test.context.ActiveProfiles;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class RegisterDroneUseCaseTests {
    @Mock
    private DroneRepo droneRepo;

    @Mock
    private RegisterDroneUseCase registerDroneUseCase;

    @BeforeEach
    void setup() {
        registerDroneUseCase = new RegisterDroneUseCase(droneRepo);
    }

    @Test
    void registerDrone_Successful() {
        var drone = new Drone(
                "4653356783",
                Drone.Model.MIDDLE_WEIGHT,
                200f,
                0.94f,
                Drone.State.IDLE
        );

        given(droneRepo.save(any())).willReturn(drone);

        var result = registerDroneUseCase.register(drone);

        Assertions.assertEquals(DroneViewModel.from(drone), result);
    }
}
