package com.insurance.insurance_management.entities;

import java.time.LocalDate;
import java.util.Objects;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Claim {
	@Id
    private Long claimNumber;
	@Column(nullable=false)
    private String description;
	@Column(nullable=false)
    private LocalDate claimDate;
	@Column(nullable=false)
    private String claimStatus;
    
    @ManyToOne
    @JoinColumn(nullable=false)
    private InsurancePolicy insurancePolicy;

	public Long getClaimNumber() {
		return claimNumber;
	}

	public void setClaimNumber(Long claimNumber) {
		this.claimNumber = claimNumber;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getClaimDate() {
		return claimDate;
	}

	public void setClaimDate(LocalDate claimDate) {
		this.claimDate = claimDate;
	}

	public String getClaimStatus() {
		return claimStatus;
	}

	public void setClaimStatus(String claimStatus) {
		this.claimStatus = claimStatus;
	}

	public InsurancePolicy getInsurancePolicy() {
		return insurancePolicy;
	}

	public void setInsurancePolicy(InsurancePolicy insurancePolicy) {
		this.insurancePolicy = insurancePolicy;
	}
	
	

	public Claim() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Claim(Long claimNumber, String description, LocalDate claimDate, String claimStatus,
			InsurancePolicy insurancePolicy) {
		super();
		this.claimNumber = claimNumber;
		this.description = description;
		this.claimDate = claimDate;
		this.claimStatus = claimStatus;
		this.insurancePolicy = insurancePolicy;
	}

	@Override
	public String toString() {
		return "Claim [claimNumber=" + claimNumber + ", description=" + description + ", claimDate=" + claimDate
				+ ", claimStatus=" + claimStatus + ", insurancePolicy=" + insurancePolicy + ", getClaimNumber()="
				+ getClaimNumber() + ", getDescription()=" + getDescription() + ", getClaimDate()=" + getClaimDate()
				+ ", getClaimStatus()=" + getClaimStatus() + ", getInsurancePolicy()=" + getInsurancePolicy()
				+ ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()=" + super.toString()
				+ "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(claimDate, claimNumber, claimStatus, description, insurancePolicy);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Claim other = (Claim) obj;
		return Objects.equals(claimDate, other.claimDate) && Objects.equals(claimNumber, other.claimNumber)
				&& Objects.equals(claimStatus, other.claimStatus) && Objects.equals(description, other.description)
				&& Objects.equals(insurancePolicy, other.insurancePolicy);
	}
}

