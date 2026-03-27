package com.healthcare.claims.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class PolicyResponseDTO {
    private Long policyId;
    private String policyName;
    private Double coverageAmount;
    private Double premium;
    private String status;
    private Long patientId;
    private String patientFirstName;
    private String patientLastName;

}
