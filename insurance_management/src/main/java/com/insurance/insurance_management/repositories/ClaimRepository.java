package com.insurance.insurance_management.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.insurance.insurance_management.entities.Claim;

public interface ClaimRepository extends JpaRepository <Claim, Long>{

}
