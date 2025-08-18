package com.karantaragi26.AppointmentService.DTO;

import java.time.LocalDateTime;
import java.util.List;

import org.bson.types.ObjectId;

import com.karantaragi26.AppointmentService.model.Address;
import com.karantaragi26.AppointmentService.model.MedicalHistory;

import lombok.Data;

@Data
public class PatientDTO {
    private ObjectId id;
    private String name;
    private Address address;
    private List<MedicalHistory> medicalHistory;
    private LocalDateTime dateTime;
}
