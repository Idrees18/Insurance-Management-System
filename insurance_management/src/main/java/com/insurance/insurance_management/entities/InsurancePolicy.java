package com.insurance.insurance_management.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class InsurancePolicy {
	@Id
    private Long policyNumber;
	@Column(nullable=false)
    private String policytype;
	@Column(nullable=false)
    private double coverageAmount;
	@Column(nullable=false)
    private double premium;
	@Column(nullable=false)
    private LocalDate startDate;
	@Column(nullable=false)
    private LocalDate endDate;
    
	@ManyToOne
	@JoinColumn(nullable=false)
    private Client client;
    
	public long getPolicyNumber() {
		return policyNumber;
	}
	public void setPolicyNumber(long policyNumber) {
		this.policyNumber = policyNumber;
	}
	public String getPolicytype() {
		return policytype;
	}
	public void setPolicytype(String policytype) {
		this.policytype = policytype;
	}
	public double getCoverageAmount() {
		return coverageAmount;
	}
	public void setCoverageAmount(double coverageAmount) {
		this.coverageAmount = coverageAmount;
	}
	public double getPremium() {
		return premium;
	}
	public void setPremium(double premium) {
		this.premium = premium;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public Client getClient() {
		return client;
	}
	public void setClient(Client client) {
		this.client = client;
	}
	
	public InsurancePolicy() {
		super();
		// TODO Auto-generated constructor stub
	}
	public InsurancePolicy(long policyNumber, String policytype, double coverageAmount, double premium,
			LocalDate startDate, LocalDate endDate, Client client) {
		super();
		this.policyNumber = policyNumber;
		this.policytype = policytype;
		this.coverageAmount = coverageAmount;
		this.premium = premium;
		this.startDate = startDate;
		this.endDate = endDate;
		this.client = client;
	}
	@Override
	public String toString() {
		return "InsurancePolicy [policyNumber=" + policyNumber + ", policytype=" + policytype + ", coverageAmount="
				+ coverageAmount + ", premium=" + premium + ", startDate=" + startDate + ", endDate=" + endDate
				+ ", client=" + client + ", getPolicyNumber()=" + getPolicyNumber() + ", getPolicytype()="
				+ getPolicytype() + ", getCoverageAmount()=" + getCoverageAmount() + ", getPremium()=" + getPremium()
				+ ", getStartDate()=" + getStartDate() + ", getEndDate()=" + getEndDate() + ", getClient()="
				+ getClient() + ", getClass()=" + getClass() + ", hashCode()=" + hashCode() + ", toString()="
				+ super.toString() + "]";
	}
	@Override
	public int hashCode() {
		return Objects.hash(client, coverageAmount, endDate, policyNumber, policytype, premium, startDate);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		InsurancePolicy other = (InsurancePolicy) obj;
		return Objects.equals(client, other.client)
				&& Double.doubleToLongBits(coverageAmount) == Double.doubleToLongBits(other.coverageAmount)
				&& Objects.equals(endDate, other.endDate) && policyNumber == other.policyNumber
				&& Objects.equals(policytype, other.policytype)
				&& Double.doubleToLongBits(premium) == Double.doubleToLongBits(other.premium)
				&& Objects.equals(startDate, other.startDate);
	}
	
	
    
    
}
