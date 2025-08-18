package com.example.DocterService.controller;

import com.example.DocterService.model.DoctorEntity;
import com.example.DocterService.service.DoctorService;
import org.apache.coyote.Response;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/doctors")
public class DocterController {

    @Autowired
    private DoctorService doctorService;


    @PostMapping("/saveDoctors")
    public DoctorEntity saveDoctor(@RequestBody DoctorEntity doctorEntity){
        return doctorService.saveDoctor(doctorEntity);
    }

    @GetMapping("/getDoctors")
    public ResponseEntity<List<DoctorEntity>> getAllDcotor(){
        List<DoctorEntity> doctors = doctorService.getAllDoctor();
        return ResponseEntity.ok(doctors);
    }

    @GetMapping("id/{id}")
    public ResponseEntity<DoctorEntity> getDoctorById(@PathVariable ObjectId id){
        DoctorEntity doctor = doctorService.getDoctor(id).orElse(null);
        return ResponseEntity.ok(doctor);
    }

    @PutMapping("id/{id}")
    public ResponseEntity<DoctorEntity> saveById(@RequestParam ObjectId id, DoctorEntity doctorEntity){
        DoctorEntity SaveDoctor = doctorService.editDoctor(id,doctorEntity);
        return ResponseEntity.ok(SaveDoctor);
    }

    @DeleteMapping("id/{id}")
    public ResponseEntity<Void> deleteDoctor(@PathVariable ObjectId id){
        boolean deleted = doctorService.deleteDoctor(id);
    if(deleted){
        return ResponseEntity.noContent().build();
    }
    return ResponseEntity.notFound().build();
    }
}

