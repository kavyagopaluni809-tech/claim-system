package com.healthcare.claims.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.claims.entity.Patient;

@Repository

public interface PatientRepository extends JpaRepository<Patient,Long>
{

}