package com.karantaragi26.AppointmentService.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;

@Document(collection = "appointments")
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AppointmentEntity {

    @Id
    private ObjectId id;

    private ObjectId patientId;
    private ObjectId doctorId;

    private LocalDateTime appointmentDate;
    private String reason;


}
