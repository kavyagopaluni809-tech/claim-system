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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.claims.dto.PolicyRequestDTO;
import com.healthcare.claims.service.PolicyService;
import com.healthcare.claims.dto.PolicyResponseDTO;
import com.healthcare.claims.entity.Patient;

@RestController
@RequestMapping("/api/policies")
public class PolicyController {

    @Autowired
    private PolicyService policyService;

    @PostMapping("/create")
    public ResponseEntity<PolicyResponseDTO> createPolicy(@RequestBody PolicyRequestDTO policyRequestDTO)
    {
        PolicyResponseDTO policyResponseDTO = policyService.createPolicy(policyRequestDTO);
        return new ResponseEntity<>(policyResponseDTO,HttpStatus.CREATED);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PolicyResponseDTO> getPolicyById(@PathVariable Long id)
    {
        PolicyResponseDTO policyResponseDTO = policyService.getPolicyById(id);
        return new ResponseEntity<>(policyResponseDTO,HttpStatus.OK);
    }
    
    @GetMapping("/getAll")
    public ResponseEntity<List<PolicyResponseDTO>> getAllPolicies()
    {
        return new ResponseEntity<>(policyService.getAllPolicies(),HttpStatus.OK);
    
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<PolicyResponseDTO> updatePolicyById(@RequestBody PolicyRequestDTO policyRequestDTO,@PathVariable Long id)
    {
        PolicyResponseDTO policyResponseDTO = policyService.updatePolicyById(policyRequestDTO, id);
        return new ResponseEntity<>(policyResponseDTO,HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deletePolicyById(@PathVariable Long id)
    {
        String response=policyService.deletePolicyById(id);
        return new ResponseEntity<>(response,HttpStatus.OK);
    }

    @GetMapping("/getByPatientId/{patienntId}")
    public ResponseEntity<List<PolicyResponseDTO>> getPoliciesByPatientId(@PathVariable Long patientId)
    {
       List<PolicyResponseDTO> policies =policyService.getPoliciesByPatientId(patientId);
       return new ResponseEntity<>(policies,HttpStatus.OK);
    }

    @GetMapping("/page")
    public ResponseEntity<Page<PolicyResponseDTO>> getPoliciesByPage(@RequestParam(defaultValue = "0") int pageNum,@RequestParam(defaultValue = "10") int pageSize)
    {
        Page<PolicyResponseDTO> policies = policyService.getPolicies(pageNum, pageSize);
        return new ResponseEntity<>(policies,HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<Page<PolicyResponseDTO>> searchPolicies(@RequestParam String keyword, @RequestParam(defaultValue = "0") int pageNum, @RequestParam(defaultValue = "10") int pageSize)
    {
        Page<PolicyResponseDTO> policies = policyService.searchPolicies(keyword, pageNum, pageSize);
        return new ResponseEntity<>(policies, HttpStatus.OK);
    }

}
    
    


