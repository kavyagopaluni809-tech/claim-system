
package com.healthcare.claims.service;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.claims.entity.Patient;
import com.healthcare.claims.repository.PatientRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PatientServiceImpl implements PatientService
 {
    @Autowired
    private  PatientRepository patientRepository;
   

@Override
    public Patient createPatient(Patient patient) {
        Patient savedPatient = null;
        if(patient.getStatus().equals("ACTIVE")) {
            savedPatient = patientRepository.save(patient);
        }
        return savedPatient;
    }

    

    @Override
    public List<Patient> getAllPatients() {
       return patientRepository.findAll();
        
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientRepository.findById(id).orElseThrow(()->new RuntimeException("Patient not found with id"));
    }

    @Override
    public Patient updatePatient(Patient patient,Long id)
{
Patient existingPatient=patientRepository.findById(id).orElseThrow(()->new RuntimeException("Patient not found with id"));
existingPatient.setFirstName(patient.getFirstName());
existingPatient.setLastName(patient.getLastName());
existingPatient.setEmail(patient.getEmail());
existingPatient.setPhoneNumber(patient.getPhoneNumber());
return patientRepository.save(existingPatient);
}



    @Override
    public String deletePatient(Long id) {
       
       patientRepository.deleteById(id);
       return "Patient deleted successfully";
    }
    
}
