package com.insurance.insurance_management.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.insurance.insurance_management.entities.Client;
import com.insurance.insurance_management.entities.InsurancePolicy;
import com.insurance.insurance_management.services.InsuranceService;

@RestController
@RequestMapping("/api/policies")
public class InsurancePolicyController {
	
	@Autowired
	private  InsuranceService IS;
	
	// GET /api/policies: Fetch all insurance policies
    @GetMapping
    public ResponseEntity<List<InsurancePolicy>> getAllInsurancePolicies() {
    	List<InsurancePolicy> AllPolicies = this.IS.getAllInsurancePolicies() ;
    	if(AllPolicies.size()<=0) {
    		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    	}
        return ResponseEntity.of(Optional.of(AllPolicies));
    }
    
 // // GET /api/policies: Fetch a specific policy by policy number
    @GetMapping("/{policyNumber}")
    public ResponseEntity<Optional<InsurancePolicy>> getInsurancePoliciesById(@PathVariable Long  policyNumber) {
    	 Optional<InsurancePolicy> policybyid = this.IS.getInsurancePoliciesById(policyNumber);
    	 if(policybyid.isPresent()==false) {
    		 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	 }
    	 return ResponseEntity.of(Optional.of(policybyid));
    }
    
    // POST /api/policies{policyNumber}: Create a new policy
    @PostMapping
    public  ResponseEntity<InsurancePolicy> createInsurancePolicies(@Validated @RequestBody InsurancePolicy policy) {
    	try {
    		InsurancePolicy  I = this.IS.createInsurancePolicies(policy);
    		if(I==null) {
    			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    		}
    		
    		return ResponseEntity.of(Optional.of(I));
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
    }
    
 // PUT /api/policies: update policy
    @PutMapping("/{policyNumber}")
    public ResponseEntity<InsurancePolicy> updateInsurancePolicy(@PathVariable Long  policyNumber,@Validated @RequestBody InsurancePolicy updatedInsurancePolicy) {
    	try {
    		InsurancePolicy update =  this.IS.updateInsurancePolicy(policyNumber,updatedInsurancePolicy);
        	if(update==null) {
        		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        	}
        	else {
        		return  ResponseEntity.of(Optional.of(update));
        	}
    	}
    	catch (Exception e) {
			e.printStackTrace();
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
    }
    
    // DELETE /api/policies{policyNumber}: Delete a policy
    @DeleteMapping("/{policyNumber}")
    public ResponseEntity<Void> deleteClient(@PathVariable Long policyNumber) {
    	try {
    		int deleteupdate=this.IS.deleteInsurancePolicy(policyNumber);
        	if(deleteupdate==1) {
        		return ResponseEntity.status(HttpStatus.OK).build();
        	}
        	else {
        		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        	}
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
		}
    }
}
