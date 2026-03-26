package com.healthcare.claims.mapper;

import com.healthcare.claims.dto.PatientRequestDTO;
import com.healthcare.claims.dto.PatientResponseDTO;
import com.healthcare.claims.entity.Patient;

public class PatientMapper {

 public static Patient toEntity(PatientRequestDTO dto)
 {
    return Patient.builder()
    .firstName(dto.getFirstName())
    .lastName(dto.getLastName())
    .email(dto.getEmail())
    .phoneNumber(dto.getPhoneNumber())
    .status(dto.getStatus())
  .build();
    
 }  
 
 public static PatientResponseDTO toDTO(Patient patient)
 {
    return PatientResponseDTO.builder()
    .firstName(patient.getFirstName())
    .lastName(patient.getLastName())
    .email(patient.getEmail())
    .phoneNumber(patient.getPhoneNumber())
    .build();

 }
}
