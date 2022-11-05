package com.musala.drones.app.controller;

import com.musala.drones.app.command.LoadMedicationsCommand;
import com.musala.drones.app.command.RegisterDroneCommand;
import com.musala.drones.app.viewmodel.DroneBatteryLevelViewModel;
import com.musala.drones.app.viewmodel.DroneViewModel;
import com.musala.drones.app.viewmodel.MedicationViewModel;
import com.musala.drones.common.paging.PageResponse;
import com.musala.drones.domain.usecase.*;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.Size;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/drones")
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
    public DroneViewModel registerDrone(@RequestBody @Valid RegisterDroneCommand registerDroneCommand) {
        return registerDroneUseCase.register(registerDroneCommand.toDrone());
    }

    @PostMapping(value = "/{serialNumber}/medications", produces = MediaType.APPLICATION_JSON_VALUE)
    public DroneViewModel loadMedications(@PathVariable(name = "serialNumber") String serialNumber,
                                          @RequestBody @Valid LoadMedicationsCommand loadMedicationsCommand) {
        return loadDroneWithMedicationsUseCase.load(serialNumber, loadMedicationsCommand.toMedications());
    }

    @GetMapping(value = "/{serialNumber}/medications", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<MedicationViewModel> checkLoadedMedications(@PathVariable(name = "serialNumber") String serialNumber) {
        return checkDroneLoadedMedicationsUseCase.check(serialNumber);
    }

    @PostMapping(value = "/available", produces = MediaType.APPLICATION_JSON_VALUE)
    public PageResponse<DroneViewModel> checkAvailable(
            @RequestBody @Valid LoadMedicationsCommand loadMedicationsCommand,
            @RequestParam(defaultValue = "1") @Min(1) Integer page,
            @RequestParam(defaultValue = "10") @Size(min = 1, max = 100) Integer limit
    ) {
        return checkAvailableDronesUseCase.check(loadMedicationsCommand.toMedications(), page - 1, limit);
    }

    @GetMapping(value = "/{serialNumber}/battery", produces = MediaType.APPLICATION_JSON_VALUE)
    public DroneBatteryLevelViewModel checkBatteryLevel(@PathVariable(name = "serialNumber") String serialNumber) {
        return checkDroneBatteryLevelUseCase.check(serialNumber);
    }
}
