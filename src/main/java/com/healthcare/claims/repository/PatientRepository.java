package com.healthcare.claims.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.claims.entity.Patient;

@Repository

public interface PatientRepository extends JpaRepository<Patient,Long>
{
 Page<Patient> findAll(Pageable pageable);

 Page<Patient> findByFirstNameContainingIgnoreCase(String name,Pageable pageable);

 Page<Patient> findByEmailContainingIgnoreCase(String email,Pageable pageable);
}