package com.karanpractice26.PatientService.controller;


import com.karanpractice26.PatientService.model.PatientEntity;
import com.karanpractice26.PatientService.service.PatientService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("api/patients")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping("/save")
    public ResponseEntity<PatientEntity> saveEntry(@RequestBody PatientEntity patientEntity){
        patientEntity.setDateTime(LocalDateTime.now());
        PatientEntity storedPatient = patientService.savePatients(patientEntity);
        return ResponseEntity.status(HttpStatus.CREATED).body(storedPatient);

    }

    @GetMapping("/all")
    public ResponseEntity<List<PatientEntity>> getEntry(){
        List<PatientEntity> getPatients = patientService.getAllPatients();
        return ResponseEntity.ok(getPatients);
    }

    @GetMapping("id/{myId}")
    public ResponseEntity<PatientEntity> getPatient(@PathVariable ObjectId myId){
        return patientService.getPatientById(myId).map(patient -> ResponseEntity.ok(patient)).orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("id/{myId}")
    public ResponseEntity<PatientEntity> putPatient(@PathVariable ObjectId myId , @RequestBody PatientEntity updatedData){
        PatientEntity updatedPatient = patientService.updatePatientById(myId,updatedData);
        return ResponseEntity.ok(updatedPatient);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteData(@RequestParam  ObjectId id){
        return patientService.deleteById(id);
    }
}
