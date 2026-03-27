package com.healthcare.claims.mapper;

import com.healthcare.claims.dto.PolicyRequestDTO;
import com.healthcare.claims.dto.PolicyResponseDTO;
import com.healthcare.claims.entity.Patient;
import com.healthcare.claims.entity.Policy;
public class PolicyMapper {

    public static Policy toEntity(PolicyRequestDTO dto, Patient patient)
    {
        return Policy.builder()
        .policyName(dto.getPolicyName())
        .coverageAmount(dto.getCoverageAmount())
        .premium(dto.getPremium())
        .status(dto.getStatus())
        .patient(patient)
        .build();

    }

    public static PolicyResponseDTO toDTO(Policy policy,Patient patient)
    {
        return PolicyResponseDTO.builder()
        .policyId(policy.getId())
        .policyName(policy.getPolicyName())
        .coverageAmount(policy.getCoverageAmount())
        .premium(policy.getPremium())
        .status(policy.getStatus())
        .patientId(patient.getId())
        .patientFirstName(patient.getFirstName())
        .patientLastName(patient.getLastName())
        .build();

    }
    
}
