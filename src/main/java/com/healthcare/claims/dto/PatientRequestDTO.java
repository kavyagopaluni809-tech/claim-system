package com.healthcare.claims.dto;


import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PatientRequestDTO {

    @NotBlank(message="First name is required")
    private String firstName;

    @NotBlank(message="Last name is required")
    private String lastName;

    @Email(message="Email should be valid")
    private String email;

    @Size(min=10,max=15,message="Phone Number should be between 10 and 15 characters")
    private String phoneNumber;
    
    @NotBlank(message="Status is required")
    private String status;
}
