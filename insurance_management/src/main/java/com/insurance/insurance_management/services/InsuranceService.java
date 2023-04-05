package com.insurance.insurance_management.services;

import java.util.List;
import java.util.Optional;

import com.insurance.insurance_management.entities.InsurancePolicy;

public interface InsuranceService {
	public List<InsurancePolicy> getAllInsurancePolicies();
	public Optional<InsurancePolicy> getInsurancePoliciesById(Long  policyNumber);
	public InsurancePolicy createInsurancePolicies(InsurancePolicy policy);
	public InsurancePolicy updateInsurancePolicy(Long policyNumber,InsurancePolicy updatedInsurancePolicy);
	public int deleteInsurancePolicy(Long policyNumber);
}
