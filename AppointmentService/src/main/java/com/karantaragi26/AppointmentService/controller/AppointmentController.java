package com.karantaragi26.AppointmentService.controller;

import com.karantaragi26.AppointmentService.DTO.AppointmentRequestDTO;
import com.karantaragi26.AppointmentService.DTO.AppointmentResponseDTO;
import com.karantaragi26.AppointmentService.model.AppointmentEntity;
import com.karantaragi26.AppointmentService.service.AppointmentService;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/appointments")
@RequiredArgsConstructor
public class AppointmentController {

    private final AppointmentService appointmentService;

    @PostMapping
    public AppointmentResponseDTO createAppointment(@RequestBody AppointmentRequestDTO request) {
        return appointmentService.createAppointment(request);
    }

    @GetMapping
    public List<AppointmentResponseDTO> getAllAppointments() {
        return appointmentService.getAllAppointments();
    }


}
