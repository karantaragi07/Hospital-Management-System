package com.example.DocterService.repository;

import com.example.DocterService.model.DoctorEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DoctorRepo extends MongoRepository<DoctorEntity, ObjectId> {
}
