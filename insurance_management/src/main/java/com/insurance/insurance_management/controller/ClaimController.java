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

import com.insurance.insurance_management.entities.Claim;
import com.insurance.insurance_management.entities.InsurancePolicy;
import com.insurance.insurance_management.services.ClaimService;

@RestController
@RequestMapping("/api/claims")
public class ClaimController {
	
	@Autowired
	private  ClaimService CLS;
	
	// GET /api/claims: Fetch all claims
    @GetMapping
    public ResponseEntity<List<Claim>>getAllClaims(){
    	List<Claim> AllClaims = this.CLS.getAllClaims() ;
    	if(AllClaims.size()<=0) {
    		return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    	}
        return ResponseEntity.of(Optional.of(AllClaims));
    }
    
 // // GET /api/claim: Fetch a specific claim by claim number
    @GetMapping("/{claimNumber}")
    public ResponseEntity<Optional<Claim>> getClaimById(@PathVariable Long claimNumber) {
    	 Optional<Claim> claimbyid = this.CLS.getClaimById(claimNumber);
    	 if(claimbyid.isPresent()==false) {
    		 return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    	 }
    	 return ResponseEntity.of(Optional.of(claimbyid));
    }
    
 // POST /api/claims{claimNumber}: Create a new claim
    @PostMapping
    public  ResponseEntity<Claim> createnewClaim(@Validated @RequestBody Claim claim) {
    	try {
    		Claim  CL = this.CLS.createnewClaim(claim);
    		if(CL==null) {
    			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
    		}
    		
    		return ResponseEntity.of(Optional.of(CL));
    	}
    	catch (Exception e) {
    		e.printStackTrace();
    		return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
    }
    
 // PUT /api/claims: update claim
    @PutMapping("/{claimNumber}")
    public ResponseEntity<Claim>updateClaim(@PathVariable Long claimNumber,@Validated @RequestBody Claim updatedclaim) {
    	try {
    		Claim update =  this.CLS.updateClaim(claimNumber, updatedclaim);
    		System.out.println(update);
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
    
    //DELETE /api/claims{claimNumber}: Delete a claim
    @DeleteMapping("/{claimNumber}")
    public ResponseEntity<Void> deleteClaim(@PathVariable Long  claimNumber) {
    	try {
    		int deleteupdate=this.CLS.deleteClaim(claimNumber);
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
