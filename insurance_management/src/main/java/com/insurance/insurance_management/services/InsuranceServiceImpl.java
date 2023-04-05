package com.insurance.insurance_management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.insurance_management.entities.Client;
import com.insurance.insurance_management.entities.InsurancePolicy;
import com.insurance.insurance_management.repositories.InsurancePolicyRepository;

@Service
public class InsuranceServiceImpl implements InsuranceService {
	@Autowired
	InsurancePolicyRepository IR;

	@Override
	public List<InsurancePolicy> getAllInsurancePolicies() {
		return  IR.findAll();
	}

	@Override
	public Optional<InsurancePolicy> getInsurancePoliciesById(Long policyNumber) {
		return IR.findById(policyNumber);
	}

	@Override
	public InsurancePolicy createInsurancePolicies(InsurancePolicy policy) {
		InsurancePolicy alreadypresent;
		Long check = policy.getPolicyNumber();
		Optional<InsurancePolicy> found=IR.findById(check);
		if(found.isPresent()==true) {
			return alreadypresent=null;
		}
		return IR.save(policy);
	}

	@Override
	public InsurancePolicy updateInsurancePolicy(Long policyNumber, InsurancePolicy updatedInsurancePolicy) {
		Optional<InsurancePolicy> existingInsurancePolicy = IR.findById(policyNumber);
		InsurancePolicy notfound=null;
		
		Long changepolicynumber = updatedInsurancePolicy.getPolicyNumber();
		
		if(changepolicynumber!=policyNumber) {
			return notfound;
		}
		 
		 if (existingInsurancePolicy.isPresent()) {
			 InsurancePolicy insurancepolicy = existingInsurancePolicy.get();
			 insurancepolicy.setPolicytype(updatedInsurancePolicy.getPolicytype());
			 insurancepolicy. setCoverageAmount(updatedInsurancePolicy.getCoverageAmount());
			 insurancepolicy.setPremium(updatedInsurancePolicy.getPremium());
			 insurancepolicy.setStartDate(updatedInsurancePolicy.getStartDate());
			 insurancepolicy.setEndDate(updatedInsurancePolicy.getEndDate());
			 insurancepolicy.setClient(updatedInsurancePolicy.getClient());
	            IR.save(insurancepolicy);
	            return updatedInsurancePolicy;
		 }
		 else {
			 return notfound; 
		 }
	}

	@Override
	public int deleteInsurancePolicy(Long policyNumber) {
		int deleteupdate=0;
		Optional<InsurancePolicy> insurancepolicy = IR.findById(policyNumber);
		if (insurancepolicy.isPresent()) {
            IR.delete(insurancepolicy.get());
            deleteupdate=1;
        }
		return deleteupdate; 
	}

}
