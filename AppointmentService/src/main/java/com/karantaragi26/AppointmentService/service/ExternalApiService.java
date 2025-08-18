package com.karantaragi26.AppointmentService.service;


import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.karantaragi26.AppointmentService.DTO.DoctorDTO;
import com.karantaragi26.AppointmentService.DTO.PatientDTO;

@Service
public class ExternalApiService {
    private final WebClient.Builder webClientBuilder;

    // Explicit constructor for dependency injection
    public ExternalApiService(WebClient.Builder webClientBuilder) {
        this.webClientBuilder = webClientBuilder;
    }

    public PatientDTO getPatientById(ObjectId patientId) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8082/api/patients/id/{myId}", patientId.toString())
                .retrieve()
                .bodyToMono(PatientDTO.class)
                .block();
    }

    public DoctorDTO getDoctorById(ObjectId doctorId) {
        return webClientBuilder.build()
                .get()
                .uri("http://localhost:8081/api/doctors/id/{id}", doctorId.toString())
                .retrieve()
                .bodyToMono(DoctorDTO.class)
                .block();
    }
}
