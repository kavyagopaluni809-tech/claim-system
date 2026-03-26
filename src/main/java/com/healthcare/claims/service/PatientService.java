
package com.healthcare.claims.service;
import java.util.List;

import com.healthcare.claims.dto.PatientRequestDTO;
import com.healthcare.claims.dto.PatientResponseDTO;


public interface PatientService
{
PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO);
PatientResponseDTO getPatientById(Long id);
List<PatientResponseDTO> getAllPatients();
PatientResponseDTO updatePatient(PatientRequestDTO patientRequestDTO,Long id);
String deletePatient(Long id);
}