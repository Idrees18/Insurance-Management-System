package com.insurance.insurance_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.insurance_management.entities.InsurancePolicy;

public interface InsurancePolicyRepository  extends JpaRepository <InsurancePolicy, Long> {

}
