package com.healthcare.claims.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcare.claims.dto.PolicyRequestDTO;
import com.healthcare.claims.dto.PolicyResponseDTO;
import com.healthcare.claims.entity.Patient;
import com.healthcare.claims.entity.Policy;
import com.healthcare.claims.exception.ResourceNotFoundException;
import com.healthcare.claims.mapper.PolicyMapper;
import com.healthcare.claims.repository.PatientRepository;
import com.healthcare.claims.repository.PolicyRepository;

import lombok.RequiredArgsConstructor;
@Service
@RequiredArgsConstructor
public class PolicyServiceImpl implements PolicyService{
      @Autowired
      private PolicyRepository policyRepository;

      @Autowired
      private PatientRepository patientRepository;


    @Override
    public PolicyResponseDTO createPolicy(PolicyRequestDTO policyRequestDTO) {
     Patient patient = patientRepository.findById(policyRequestDTO.getPatientId())
            .orElseThrow(() -> new ResourceNotFoundException("Patient not found"));
        Policy policy =PolicyMapper.toEntity(policyRequestDTO,patient);
        Policy savedPolicy = policyRepository.save(policy);
        return PolicyMapper.toDTO(savedPolicy, patient);

       
    }

    @Override
    public PolicyResponseDTO getPolicyById(Long id) {
      Policy policy  =policyRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Policy not found with given Id"));
     Patient patient = policy.getPatient();
      return PolicyMapper.toDTO(policy,patient);
    }


    @Override
    public List<PolicyResponseDTO> getAllPolicies() {
      return  policyRepository.findAll()
                                .stream()
                                  .map(policy -> PolicyMapper.toDTO(policy, policy.getPatient()))
                                      .collect(Collectors.toList());
    }

    @Override
    public PolicyResponseDTO updatePolicyById(PolicyRequestDTO policyRequestDTO, Long id) {
       Policy policy =policyRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Policy not found with given Id"));
    policy.setPolicyName(policyRequestDTO.getPolicyName());
    policy.setCoverageAmount(policyRequestDTO.getCoverageAmount());
    policy.setPremium(policyRequestDTO.getPremium());
    policy.setStatus(policyRequestDTO.getStatus());
    Policy savedPolicy = policyRepository.save(policy);
    return PolicyMapper.toDTO(savedPolicy, savedPolicy.getPatient());
    }

    @Override
    public String deletePolicyById(Long Id) {
      Policy policy  =policyRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Policy not found with given Id"));
      policyRepository.delete(policy);
      return "Policy deleted successfully";
    }

    @Override
    public List<PolicyResponseDTO> getPoliciesByPatientId(Long patientId) {
        Patient patient= patientRepository.findById(patientId).orElseThrow(()->new ResourceNotFoundException("Patient not found with given Id"));
       return policyRepository.findByPatientId(patientId).stream()
        .map(policy->PolicyMapper.toDTO(policy,patient))
        .collect(Collectors.toList());
    }
    
}
