package com.example.DocterService.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.http.ResponseEntity;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "doctors")
public class DoctorEntity {
    @Id
    private ObjectId id;
    private String name;
    private List<String> specialization;
    private List<String> schedule;


}
