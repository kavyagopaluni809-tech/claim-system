package com.healthcare.claims.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.claims.dto.PatientRequestDTO;
import com.healthcare.claims.dto.PatientResponseDTO;
import com.healthcare.claims.service.PatientService;

@RestController
@RequestMapping("/api/patients")
public class PatientController {


    @Autowired
    private PatientService patientService;

    @PostMapping("/create")
    public ResponseEntity<PatientResponseDTO> createPatient(@RequestBody PatientRequestDTO patientRequestDTO)
    {
      PatientResponseDTO createdPatient= patientService.createPatient(patientRequestDTO);
      return new ResponseEntity<>(createdPatient,HttpStatus.CREATED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PatientResponseDTO>> getAllPatients()
    {
        return new ResponseEntity<>(patientService.getAllPatients(),HttpStatus.OK);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PatientResponseDTO> getPatientById(@PathVariable Long id)
    {
        return new ResponseEntity<>(patientService.getPatientById(id),HttpStatus.OK);
    }
    
    @PutMapping("/update")
    public ResponseEntity<PatientResponseDTO> updatePatient(@RequestBody PatientRequestDTO patientRequestDTO,Long id)
    {
       return new ResponseEntity<>(patientService.updatePatient(patientRequestDTO, id),HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable Long id)
    {
        return new ResponseEntity<>(patientService.deletePatient(id),HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<PatientResponseDTO>> getPatients(@RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "10") int pageSize)
    {
       return new ResponseEntity<>(patientService.getPatients(pageNum, pageSize),HttpStatus.OK); 
    }

    @GetMapping("/search")
    public ResponseEntity<Page<PatientResponseDTO>> searchPatients(@RequestParam String name, @RequestParam(defaultValue="0") int pageNum, @RequestParam(defaultValue = "10") int pageSize)
    {
        return new ResponseEntity<>(patientService.searchPatients(name, pageNum, pageSize),HttpStatus.OK);
    }
}
