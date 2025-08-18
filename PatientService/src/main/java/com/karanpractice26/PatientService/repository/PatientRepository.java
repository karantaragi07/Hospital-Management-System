package com.karanpractice26.PatientService.repository;

import com.karanpractice26.PatientService.model.PatientEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PatientRepository extends MongoRepository<PatientEntity, ObjectId> {
}
