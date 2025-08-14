package com.vitasync.transfusion_service.service;

import org.springframework.stereotype.Service;

import com.vitasync.transfusion_service.model.DonationSchedule;
import com.vitasync.transfusion_service.repository.DonationScheduleRepository;

import reactor.core.publisher.Mono;

@Service
public class DonationService {

    private final DonationScheduleRepository scheduleRepository;

    public DonationService(DonationScheduleRepository scheduleRepository) {
        this.scheduleRepository = scheduleRepository;
    }

    public Mono<DonationSchedule> updateAvailability(DonationSchedule schedule) {
        // You can add logic here to set the initial status to AVAILABLE
        if (schedule.getStatus() == null || schedule.getStatus().isEmpty()) {
            schedule.setStatus("AVAILABLE");
        }

        return scheduleRepository.save(schedule);
    }

}