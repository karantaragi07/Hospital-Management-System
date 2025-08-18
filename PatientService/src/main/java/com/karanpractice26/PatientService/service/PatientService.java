package com.karanpractice26.PatientService.service;

import com.karanpractice26.PatientService.model.PatientEntity;
import com.karanpractice26.PatientService.repository.PatientRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PatientService {

    @Autowired
    private PatientRepository patientRepository;

    public PatientEntity savePatients(PatientEntity patientEntity){
        return patientRepository.save(patientEntity);
    }

    public List<PatientEntity> getAllPatients(){
        return patientRepository.findAll();
    }

    public Optional<PatientEntity> getPatientById(ObjectId id){
        return patientRepository.findById(id);
    }

    public PatientEntity updatePatientById(ObjectId id,PatientEntity updatedData){
        return patientRepository.findById(id).map(existingPatient -> {
                existingPatient.setName(updatedData.getName());
                existingPatient.setAddress(updatedData.getAddress());
                existingPatient.setMedicalHistory(updatedData.getMedicalHistory());
                    return patientRepository.save(existingPatient);
        })
    .orElseThrow(() -> new RuntimeException("Patient not found with id: " + id));
    }

    public ResponseEntity<?> deleteById(ObjectId id){
        if (patientRepository.existsById(id)) {
            patientRepository.deleteById(id);
            return ResponseEntity.noContent().build();
        }else {
            return ResponseEntity.notFound().build();
        }
    }
}
