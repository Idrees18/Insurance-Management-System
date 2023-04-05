package com.insurance.insurance_management.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.insurance.insurance_management.entities.Claim;
import com.insurance.insurance_management.repositories.ClaimRepository;

@Service
public class ClaimServiceimpl implements ClaimService {
	
	@Autowired
	ClaimRepository CLR;

	@Override
	public List<Claim> getAllClaims() {
		return  CLR.findAll();
	}

	@Override
	public Optional<Claim> getClaimById(Long claimNumber) {
		return CLR.findById(claimNumber);
	}

	@Override
	public Claim createnewClaim(Claim claim) {
		Claim  alreadypresent;
		Long check = claim.getClaimNumber();
		Optional< Claim > found=CLR.findById(check);
		if(found.isPresent()==true) {
			return alreadypresent=null;
		}
		return CLR.save( claim );
	}

	@Override
	public Claim updateClaim(Long claimNumber, Claim updatedclaim) {
		Optional<Claim> existingclaim = CLR.findById(claimNumber);
		Claim notfound=null;
		
//		Long changeclaimnumber = updatedclaim.getClaimNumber();
//		System.out.println(changeclaimnumber);
//		System.out.println(claimNumber);
//		System.out.println(existingclaim);
//		
//		if(changeclaimnumber!=claimNumber) {
//			System.out.println("condition true for claim number");
//			return notfound;
//		}
		 
		 if (existingclaim.isPresent()==true) {
			 System.out.println("condition true");
			 Claim claim = existingclaim.get();
			 claim. setDescription( updatedclaim.getDescription());
			 claim.setClaimDate( updatedclaim.getClaimDate());
			 claim.setClaimStatus( updatedclaim.getClaimStatus());
			 claim.setInsurancePolicy( updatedclaim.getInsurancePolicy());
	         CLR.save(claim);
	         return updatedclaim;
		 }
		 else {
			 return notfound; 
		 }
	}

	@Override
	public int deleteClaim(Long claimNumber) {
		int deleteupdate=0;
		Optional<Claim> claim = CLR.findById(claimNumber);
		if (claim.isPresent()) {
            CLR.delete(claim.get());
            deleteupdate=1;
        }
		return deleteupdate; 
	}

}
