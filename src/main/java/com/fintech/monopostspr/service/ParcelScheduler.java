package com.fintech.monopostspr.service;

import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ParcelScheduler {

    private final ParcelDeliveringService parcelDeliveringService;

    @Async
    @Scheduled(fixedRate = 1000)
    public void checkParcels() {
        parcelDeliveringService.saveStatus();
    }
}
