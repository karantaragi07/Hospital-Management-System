package com.karantaragi26.AppointmentService.DTO;

import lombok.Data;
import org.bson.types.ObjectId;

import java.time.LocalDateTime;

@Data
public class AppointmentRequestDTO {
    private ObjectId patientId;
    private ObjectId doctorId;
    private LocalDateTime appointmentTime;
    private String reason;
}
