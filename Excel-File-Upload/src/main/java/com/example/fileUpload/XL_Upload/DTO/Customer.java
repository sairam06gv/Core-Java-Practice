package com.example.fileUpload.XL_Upload.DTO;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Customer {
	@Id
	private int customerId;
	private String firstName;
	private String lastName;
	private String country;
	private int telephone;
	/*
	 * public Customer() { super(); }
	 * 
	 * public Customer(int customerId, String firstName, String lastName, String
	 * country, int telephone) { super(); this.customerId = customerId;
	 * this.firstName = firstName; this.lastName = lastName; this.country = country;
	 * this.telephone = telephone; }
	 * 
	 * public int getCustomerId() { return customerId; }
	 * 
	 * public void setCustomerId(int customerId) { this.customerId = customerId; }
	 * 
	 * public String getFirstName() { return firstName; }
	 * 
	 * public void setFirstName(String firstName) { this.firstName = firstName; }
	 * 
	 * public String getLastName() { return lastName; }
	 * 
	 * public void setLastName(String lastName) { this.lastName = lastName; }
	 * 
	 * public String getCountry() { return country; }
	 * 
	 * public void setCountry(String country) { this.country = country; }
	 * 
	 * public int getTelephone() { return telephone; }
	 * 
	 * public void setTelephone(int telephone) { this.telephone = telephone; }
	 */
}
