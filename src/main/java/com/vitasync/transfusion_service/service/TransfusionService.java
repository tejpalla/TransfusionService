package com.vitasync.transfusion_service.service;


import org.springframework.stereotype.Service;

import com.vitasync.transfusion_service.DTO.TransfusionRequestDTO;
import com.vitasync.transfusion_service.model.TransfusionRequest;
import com.vitasync.transfusion_service.repository.TransfusionRequestRepository;

import reactor.core.publisher.Mono;

@Service
public class TransfusionService {

    private final TransfusionRequestRepository requestRepository;

    public TransfusionService(TransfusionRequestRepository requestRepository) {
        this.requestRepository = requestRepository;
    }

    public Mono<TransfusionRequest> requestTransfusion(TransfusionRequestDTO requestDTO) {
        // Here you would add any business logic, like setting the status or timestamp
        TransfusionRequest request = new TransfusionRequest();
        request.setId(requestDTO.getId());
        request.setLocation(requestDTO.getLocation());
        request.setBloodType(requestDTO.getBloodType());
        request.setStatus("PENDING");
        request.setRequestTimestamp(java.time.LocalDateTime.now());
        
        return requestRepository.save(request);
    }
    
}