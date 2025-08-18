package com.karantaragi26.AppointmentService.repository;

import com.karantaragi26.AppointmentService.model.AppointmentEntity;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AppointmentRepository extends MongoRepository<AppointmentEntity , ObjectId> {

}
