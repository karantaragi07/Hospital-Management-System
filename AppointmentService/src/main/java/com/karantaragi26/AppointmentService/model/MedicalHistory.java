package com.karantaragi26.AppointmentService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalHistory {
    private String condition;
    private String diagnosis;
    private String treatment;
}
