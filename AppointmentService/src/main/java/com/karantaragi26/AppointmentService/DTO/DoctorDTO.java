package com.karantaragi26.AppointmentService.DTO;

import lombok.Data;
import org.bson.types.ObjectId;

import java.util.List;

@Data
public class DoctorDTO {
    private ObjectId id;
    private String name;
    private List<String> specialization;
    private List<String> schedule;
}
