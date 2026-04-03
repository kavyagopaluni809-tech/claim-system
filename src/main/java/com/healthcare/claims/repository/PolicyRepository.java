package com.healthcare.claims.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcare.claims.entity.Policy;
@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {
    List<Policy> findByPatientId(Long patientId);
    Page<Policy> findAll(Pageable pageable);
    Page<Policy> findByPolicyNameContainingIgnoreCase(String policyName,Pageable pageable);

    Page<Policy> findByStatus(String status, Pageable pageable);

}
