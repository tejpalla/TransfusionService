package com.vitasync.transfusion_service.DTO;

import lombok.Data;

@Data
public class TransfusionRequestDTO {
    // @Id
    private Long id;
    private Long patientId; // We'll link to the User service via this ID
    private String bloodType;
    private String location;
    // private String status; // PENDING, MATCHED, COMPLETED
    // private LocalDateTime requestTimestamp;
}
