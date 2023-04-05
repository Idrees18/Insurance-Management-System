package com.insurance.insurance_management.entities;

import java.time.LocalDate;
import java.util.Objects;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Client {
		@Id
		@GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
		@Column(nullable=false)
	    private String name;
		@Column(nullable=false)
	    private LocalDate dateOfBirth;
		@Column(nullable=false)
	    private String address;
		@Column(nullable=false ,unique=true)
	    private Long phno;
		@Column(nullable=false ,unique=true)
	    private String email;
	    
	    public Long getId() {
	    	return id;
		}
//		public void setId(Long id) {
//			this.id = id;
//		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		public LocalDate getDateOfBirth() {
			return dateOfBirth;
		}
		public void setDateOfBirth(LocalDate dateOfBirth) {
			this.dateOfBirth = dateOfBirth;
		}
		public String getAddress() {
			return address;
		}
		public void setAddress(String address) {
			this.address = address;
		}
		public Long getPhno() {
			return phno;
		}
		public void setPhno(Long phno) {
			this.phno = phno;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
		}
	    
		
		public Client() {
			super();
			// TODO Auto-generated constructor stub
		}
		public Client(String name, LocalDate dateOfBirth, String address, Long phno, String email) {
			super();
			//this.id = id;
			this.name = name;
			this.dateOfBirth = dateOfBirth;
			this.address = address;
			this.phno = phno;
			this.email = email;
		}
		
		@Override
		public int hashCode() {
			return Objects.hash(address, dateOfBirth, email, id, name, phno);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Client other = (Client) obj;
			return Objects.equals(address, other.address) && Objects.equals(dateOfBirth, other.dateOfBirth)
					&& Objects.equals(email, other.email) && Objects.equals(id, other.id)
					&& Objects.equals(name, other.name) && Objects.equals(phno, other.phno);
		}
		@Override
		public String toString() {
			return "Client [id=" + id + ", name=" + name + ", dateOfBirth=" + dateOfBirth + ", address=" + address
					+ ", phno=" + phno + ", email=" + email + ", getId()=" + getId() + ", getName()=" + getName()
					+ ", getDateOfBirth()=" + getDateOfBirth() + ", getAddress()=" + getAddress() + ", getPhno()="
					+ getPhno() + ", getEmail()=" + getEmail() + ", getClass()=" + getClass() + ", hashCode()="
					+ hashCode() + ", toString()=" + super.toString() + "]";
		}
}
