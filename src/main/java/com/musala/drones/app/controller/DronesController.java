package com.musala.drones.app.controller;

import com.musala.drones.app.command.LoadMedicationsCommand;
import com.musala.drones.app.command.RegisterDroneCommand;
import com.musala.drones.app.viewmodel.DroneBatteryLevelViewModel;
import com.musala.drones.app.viewmodel.DroneViewModel;
import com.musala.drones.app.viewmodel.MedicationViewModel;
import com.musala.drones.common.paging.PageResponse;
import com.musala.drones.domain.usecase.*;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController(value = "/drones")
public class DronesController {
    @Autowired
    private RegisterDroneUseCase registerDroneUseCase;
    @Autowired
    private LoadDroneWithMedicationsUseCase loadDroneWithMedicationsUseCase;
    @Autowired
    private CheckDroneLoadedMedicationsUseCase checkDroneLoadedMedicationsUseCase;
    @Autowired
    private CheckAvailableDronesUseCase checkAvailableDronesUseCase;
    @Autowired
    private CheckDroneBatteryLevelUseCase checkDroneBatteryLevelUseCase;

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public DroneViewModel registerDrone(@Valid RegisterDroneCommand registerDroneCommand) {
        return registerDroneUseCase.register(registerDroneCommand.toDrone());
    }

    @PostMapping(value = "/{serialNumber}", produces = MediaType.APPLICATION_JSON_VALUE)
    public DroneViewModel loadMedications(@PathVariable(name = "serialNumber") String serialNumber,
                                          @Valid LoadMedicationsCommand loadMedicationsCommand) {
        return loadDroneWithMedicationsUseCase.load(serialNumber, loadMedicationsCommand.toMedications());
    }

    @GetMapping(value = "/{serialNumber}/medications", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MedicationViewModel> checkLoadedMedications(@PathVariable(name = "serialNumber") String serialNumber) {
        return checkDroneLoadedMedicationsUseCase.check(serialNumber);
    }

    @PostMapping(value = "/available", produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResponse<DroneViewModel> checkAvailable(@Valid LoadMedicationsCommand loadMedicationsCommand) {
        return checkAvailableDronesUseCase.check(loadMedicationsCommand.toMedications());
    }

    @GetMapping(value = "/{serialNumber}/battery", produces = MediaType.APPLICATION_JSON_VALUE)
    public DroneBatteryLevelViewModel checkBatteryLevel(@PathVariable(name = "serialNumber") String serialNumber) {
        return checkDroneBatteryLevelUseCase.check(serialNumber);
    }
}
