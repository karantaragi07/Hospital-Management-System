package com.karanpractice26.PatientService.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MedicalHistory {
    private String date;
    private String diagnosis;
    private String notes;
}
