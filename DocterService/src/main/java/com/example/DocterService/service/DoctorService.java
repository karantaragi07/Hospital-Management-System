package com.example.DocterService.service;

import com.example.DocterService.model.DoctorEntity;
import com.example.DocterService.repository.DoctorRepo;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorService {

    @Autowired
    private DoctorRepo doctorRepo;

    public DoctorEntity saveDoctor( DoctorEntity doctorEntity){
    return doctorRepo.save(doctorEntity);
    }

    public List<DoctorEntity> getAllDoctor(){
        return doctorRepo.findAll();
    }

    public Optional<DoctorEntity> getDoctor(ObjectId id){
        return doctorRepo.findById(id);
    }

    public DoctorEntity editDoctor(ObjectId id, DoctorEntity doctorEntity){
         return doctorRepo.findById(id).map(
                 newEntity -> {
                     newEntity.setName(doctorEntity.getName());
                     newEntity.setSchedule(doctorEntity.getSchedule());
                     newEntity.setSpecialization(doctorEntity.getSpecialization());
                     return doctorRepo.save(newEntity);
                 }).orElseThrow(() -> new RuntimeException("Doctor not found with id: "+id));
    }

    public boolean deleteDoctor(ObjectId id){
        if(doctorRepo.existsById(id)) {
            doctorRepo.deleteById(id);
            return true;
        }
        return false;
    }

}
