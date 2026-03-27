package com.healthcare.claims.service;

import java.util.List;

import com.healthcare.claims.dto.PolicyRequestDTO;
import com.healthcare.claims.dto.PolicyResponseDTO;

public interface PolicyService {
    PolicyResponseDTO createPolicy(PolicyRequestDTO policyRequestDTO);
    PolicyResponseDTO getPolicyById(Long id);
    List<PolicyResponseDTO> getAllPolicies();
    PolicyResponseDTO updatePolicyById(PolicyRequestDTO policyRequestDTO,Long id);
    String deletePolicyById(Long Id);
    List<PolicyResponseDTO>getPoliciesByPatientId(Long patientId);

    
    
    
}
