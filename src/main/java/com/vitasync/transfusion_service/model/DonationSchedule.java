package com.vitasync.transfusion_service.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("donation_schedules")
public class DonationSchedule {

    @Id
    private Long id;
    private Long donorId; // We'll link to the User service via this ID
    private String bloodType;
    private String location;
    private LocalDateTime availabilityDate;
    private String status; // AVAILABLE, ACCEPTED, CANCELLED
    
}