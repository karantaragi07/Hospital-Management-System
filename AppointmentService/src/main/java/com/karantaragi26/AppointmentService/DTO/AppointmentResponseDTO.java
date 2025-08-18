package com.karantaragi26.AppointmentService.DTO;

import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
public class AppointmentResponseDTO {
    private ObjectId id;
    private PatientDTO patient;
    private DoctorDTO doctor;
    private LocalDateTime appointmentTime;
    private String reason;
}
