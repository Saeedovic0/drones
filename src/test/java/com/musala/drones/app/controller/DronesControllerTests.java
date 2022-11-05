package com.musala.drones.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.musala.drones.app.command.RegisterDroneCommand;
import com.musala.drones.app.viewmodel.DroneViewModel;
import com.musala.drones.common.spring.advice.GlobalControllerAdvice;
import com.musala.drones.domain.model.Drone;
import com.musala.drones.domain.usecase.RegisterDroneUseCase;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.MediaType;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@ActiveProfiles("test")
@ExtendWith(MockitoExtension.class)
class DronesControllerTests {
    private MockMvc mockMvc;
    @Mock
    private RegisterDroneUseCase registerDroneUseCase;
    private ObjectMapper objectMapper;

    @BeforeEach
    void setup() {
        objectMapper = new ObjectMapper();
        var dronesController = new DronesController(
                registerDroneUseCase,
                null,
                null,
                null,
                null
        );
        mockMvc = MockMvcBuilders.standaloneSetup(dronesController)
                .setControllerAdvice(new GlobalControllerAdvice())
                .build();
    }

    @Test
    void registerDrone_2xx() throws Exception {
        var registerDroneCommand = new RegisterDroneCommand(
                "4653356783",
                Drone.Model.MIDDLE_WEIGHT,
                200f,
                0.94f
        );

        var drone = registerDroneCommand.toDrone();

        var droneViewModel = DroneViewModel.from(drone);

        when(registerDroneUseCase.register(any())).thenReturn(droneViewModel);

        var response = objectMapper.writeValueAsString(droneViewModel);

        mockMvc.perform(post("/drones")
                        .contentType(MediaType.APPLICATION_JSON_VALUE)
                        .content(objectMapper.writeValueAsString(registerDroneCommand)))
                .andExpect(status().is2xxSuccessful())
                .andExpect(content().string(response));
    }
}
