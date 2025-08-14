package com.vitasync.transfusion_service.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.vitasync.transfusion_service.DTO.TransfusionRequestDTO;
import com.vitasync.transfusion_service.model.TransfusionRequest;
import com.vitasync.transfusion_service.service.TransfusionService;

import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/transfusions")
public class TransfusionController {
    private final TransfusionService transfusionService;

    public TransfusionController(TransfusionService transfusionService){
        this.transfusionService = transfusionService;
    }

    @GetMapping("/hello")
    public String hello(){
        return "HelloWorld";
    }

    @PostMapping("/request")
    public Mono<TransfusionRequest> requestTransfusion(@RequestBody TransfusionRequestDTO request){
        return transfusionService.requestTransfusion(request);
    }

}
