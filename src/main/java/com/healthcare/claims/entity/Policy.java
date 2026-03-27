package com.healthcare.claims.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="policies")
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Policy {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @Column(nullable=false)
    private String policyName;
    @Column(nullable=false)
    private Double coverageAmount;
    @Column(nullable=false)

    private Double premium;
    @Column(nullable=false)
    private String status;

    @ManyToOne(fetch=FetchType.LAZY)
    @JoinColumn(name="patient_id",nullable=false)
    private Patient patient;


    
}
