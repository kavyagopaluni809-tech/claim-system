package com.healthcare.claims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.claims.entity.Patient;
import com.healthcare.claims.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {


    @Autowired
    private PatientService patientService;

    @PostMapping("/create")
    public ResponseEntity<Patient> createPatient(@RequestBody Patient patient)
    {
      Patient createdPatient= patientService.createPatient(patient);
      return new ResponseEntity<>(createdPatient,HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<Patient>> getAllPatients()
    {
        return new ResponseEntity<>(patientService.getAllPatients(),HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable Long id)
    {
        return new ResponseEntity<>(patientService.getPatientById(id),HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient,Long id)
    {
       return new ResponseEntity<>(patientService.updatePatient(patient, id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id)
    {
        return new ResponseEntity<>(patientService.deletePatient(id),HttpStatus.OK);
    }
}
