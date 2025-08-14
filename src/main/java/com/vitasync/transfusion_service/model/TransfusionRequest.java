package com.vitasync.transfusion_service.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

import lombok.Data;

@Data
@Table("transfusion_requests")
public class TransfusionRequest {

    @Id
    private Long id;
    private Long patientId; // We'll link to the User service via this ID
    private String bloodType;
    private String location;
    private String status; // PENDING, MATCHED, COMPLETED
    private LocalDateTime requestTimestamp;
}