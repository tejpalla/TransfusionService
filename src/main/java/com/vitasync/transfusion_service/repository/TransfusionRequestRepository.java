package com.vitasync.transfusion_service.repository;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;

import com.vitasync.transfusion_service.model.TransfusionRequest;

import reactor.core.publisher.Flux;

public interface TransfusionRequestRepository extends ReactiveCrudRepository<TransfusionRequest, Long> {

    // You can add custom queries here later, for example:
    Flux<TransfusionRequest> findByStatus(String status); 
}