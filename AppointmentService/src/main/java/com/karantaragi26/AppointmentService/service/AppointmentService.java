package com.karantaragi26.AppointmentService.service;

import com.karantaragi26.AppointmentService.DTO.AppointmentRequestDTO;
import com.karantaragi26.AppointmentService.DTO.AppointmentResponseDTO;
import com.karantaragi26.AppointmentService.DTO.DoctorDTO;
import com.karantaragi26.AppointmentService.DTO.PatientDTO;
import com.karantaragi26.AppointmentService.model.AppointmentEntity;
import com.karantaragi26.AppointmentService.repository.AppointmentRepository;
import lombok.RequiredArgsConstructor;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final ExternalApiService externalApiService;

    public AppointmentService(AppointmentRepository appointmentRepository, ExternalApiService externalApiService) {
        this.appointmentRepository = appointmentRepository;
        this.externalApiService = externalApiService;
    }

    public AppointmentResponseDTO createAppointment(AppointmentRequestDTO request) {

        AppointmentEntity appointment = AppointmentEntity.builder()
                .patientId(request.getPatientId())
                .doctorId(request.getDoctorId())
                .appointmentDate(request.getAppointmentTime())
                .reason(request.getReason())
                .build();

        appointment = appointmentRepository.save(appointment);

        PatientDTO patient = externalApiService.getPatientById(request.getPatientId());
        DoctorDTO doctor = externalApiService.getDoctorById(request.getDoctorId());

        AppointmentResponseDTO response = new AppointmentResponseDTO();
        response.setId(appointment.getId());
        response.setPatient(patient);
        response.setDoctor(doctor);
        response.setAppointmentTime(appointment.getAppointmentDate());
        response.setReason(appointment.getReason());

        return response;
    }

    public List<AppointmentResponseDTO> getAllAppointments() {
        return appointmentRepository.findAll().stream().map(appointment -> {
            PatientDTO patient = externalApiService.getPatientById(appointment.getPatientId());
            DoctorDTO doctor = externalApiService.getDoctorById(appointment.getDoctorId());

            AppointmentResponseDTO response = new AppointmentResponseDTO();
            response.setId(appointment.getId());
            response.setPatient(patient);
            response.setDoctor(doctor);
            response.setAppointmentTime(appointment.getAppointmentDate());
            response.setReason(appointment.getReason());
            return response;
        }).collect(Collectors.toList());
    }

}
