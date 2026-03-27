package com.healthcare.claims.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;


@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PolicyRequestDTO {

    @NotNull(message="Policy Name is required")
    private String policyName;
    @NotNull(message="Coverage Amount is required")
    @Min(value=1,message="Coverage Amount must be greater than 0")
    private Double coverageAmount;
    @NotNull(message="Premium is required")
    @Min(value=1,message="Premium must be greater than 0")
    private Double premium;
    @NotNull(message="Status is required")
    private String status;
    @NotNull(message="Patient Id is required")
    private Long patientId;


    
    
}
