package com.insurance.insurance_management.services;

import java.util.List;
import java.util.Optional;

import com.insurance.insurance_management.entities.Claim;

public interface ClaimService {
	public List<Claim> getAllClaims();
	public Optional<Claim> getClaimById(Long claimNumber);
	public Claim createnewClaim(Claim claim);
	public Claim updateClaim(Long claimNumber,Claim updatedclaim);
	public int deleteClaim(Long claimNumber);
}
