package com.vitasync.transfusion_service.Controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitasync.transfusion_service.model.DonationSchedule;
import com.vitasync.transfusion_service.service.DonationService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/donations")
public class DonationController {

    private final DonationService donationService;

    public DonationController(DonationService donationService) {
        this.donationService = donationService;
    }

    @PostMapping("/availability")
    public Mono<DonationSchedule> updateAvailability(@RequestBody DonationSchedule schedule) {
        return donationService.updateAvailability(schedule);
    }

    @PostMapping("/confirm/{requestId}")
    public Mono<String> confirmDonation(@PathVariable Long requestId) {
        // For the MVP, we'll just return a success message.
        // Later, we will add business logic to update the request status and publish a Kafka event.
        System.out.println("Donation confirmation received for request ID: " + requestId);
        return Mono.just("Donation confirmed for request ID: " + requestId);
    }
}