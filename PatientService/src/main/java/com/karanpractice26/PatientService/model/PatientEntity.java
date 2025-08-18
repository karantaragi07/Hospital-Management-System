package com.karanpractice26.PatientService.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "patient")
public class PatientEntity {
    @Id
    private ObjectId id;
    private String name;
    private Address address;
    private List<MedicalHistory> medicalHistory;
    private LocalDateTime dateTime;
}
