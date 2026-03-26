
package com.healthcare.claims.service;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.claims.dto.PatientRequestDTO;
import com.healthcare.claims.dto.PatientResponseDTO;
import com.healthcare.claims.entity.Patient;
import com.healthcare.claims.mapper.PatientMapper;
import com.healthcare.claims.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService
 {
    @Autowired
    private  PatientRepository patientRepository;
   

@Override
    public PatientResponseDTO createPatient(PatientRequestDTO patientRequestDTO) {
        Patient patient = PatientMapper.toEntity(patientRequestDTO);
        Patient savedPatient = null;
        if(patient.getStatus().equals("ACTIVE")) {
            savedPatient = patientRepository.save(patient);
        }
        return PatientMapper.toDTO(savedPatient);
    }

    

    @Override
    public List<PatientResponseDTO> getAllPatients() {
       return patientRepository.findAll()
       .stream()
       .map(PatientMapper::toDTO)
       .collect(Collectors.toList());
        
    }

    @Override
    public PatientResponseDTO getPatientById(Long id) {
        Patient patient= patientRepository.findById(id).orElseThrow(()->new RuntimeException("Patient not found with id"));
        return PatientMapper.toDTO(patient);
    }

    @Override
    public PatientResponseDTO updatePatient(PatientRequestDTO patientRequestDTO,Long id)
{
Patient existingPatient=patientRepository.findById(id).orElseThrow(()->new RuntimeException("Patient not found with id"));
existingPatient.setFirstName(patientRequestDTO.getFirstName());
existingPatient.setLastName(patientRequestDTO.getLastName());
existingPatient.setEmail(patientRequestDTO.getEmail());
existingPatient.setPhoneNumber(patientRequestDTO.getPhoneNumber());
return PatientMapper.toDTO(patientRepository.save(existingPatient));
}



    @Override
    public String deletePatient(Long id) {
       
       patientRepository.deleteById(id);
       return "Patient deleted successfully";
    }
    
}
