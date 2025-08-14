package com.vitasync.transfusion_service.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.vitasync.transfusion_service.model.DonationSchedule;

public interface DonationScheduleRepository extends ReactiveCrudRepository<DonationSchedule, Long> {
    // Find donations by donor ID or availability date
}