
package com.healthcare.claims.service;
import java.util.List;

import com.healthcare.claims.entity.Patient;


public interface PatientService
{
Patient createPatient(Patient patient);
Patient getPatientById(Long id);
List<Patient> getAllPatients();
Patient updatePatient(Patient patient,Long id);
String deletePatient(Long id);
}