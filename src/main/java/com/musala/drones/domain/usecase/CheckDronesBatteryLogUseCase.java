package com.musala.drones.domain.usecase;

import com.musala.drones.domain.repo.DroneRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.util.concurrent.TimeUnit;

@Slf4j
@EnableScheduling
@EnableAsync
@Component
public class CheckDronesBatteryLogUseCase {
    @Autowired
    private DroneRepo droneRepo;

    @Async
    @Scheduled(fixedRate = 1, timeUnit = TimeUnit.MINUTES)
    public void check() throws InterruptedException {
        log.info("checking drones battery level task started @ {}", Instant.now());
        var page = 0;
        var limit = 100;
        var hasNext = true;
        while (hasNext) {
            var result = droneRepo.findAll(page, limit);
            droneRepo.createHistory(result.getContent());
            hasNext = result.hasNext();
            page++;
        }
        log.info("checking drones battery level task ended @ {}", Instant.now());
    }
}
