
/***********************************************************************************************************
 * Module Name - PlanoAccounting
 * Version Control Block
 * 
 * Date			Version	   Author			Reviewer			Change Description
 * -----------  ---------  --------------	----------------	-------------------------------------------
 * Jun 6, 2018  1.0		   Singh, Bed		XXXXXXXX			Created.
 * -----------  ---------  --------------	----------------	-------------------------------------------
 * 
 ***********************************************************************************************************/

package com.plano.accounting.request;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

import com.plano.accounting.utility.CustomerType;

/***********************************************************************************************************
 * Java File - CustomerRequest.java
 * Author - Bed Singh
 * Date   - Jun 6, 2018
 * Description - This is the customer or client request object which is send by the user interface applicaiton or 
 * from any other application.  
 ***********************************************************************************************************/

public class CustomerRequest implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long customerId;

	@NotBlank(message = "First Name should not be blank.")
	private String firstName;

	@NotBlank(message = "Last Name should not be blank.")
	private String lastName; 

	private CustomerType customerType;

	@NotBlank(message = "Address Line1 should not be empty.")
	private String addressLine1;

	private String addressLine2;

	@NotBlank(message = "Appartment should not be blank.")
	private String appartment;

	@NotBlank(message = "City should not be blank.")
	private String city;

	@NotNull(message = "State Code should not be empty.")
	@Size(min=2, max=2, message="State Code must be two chars, exampl: TX, NY.")
	private String stateCode;

	@NotNull(message = "PostalCode should not be blank.")
	@Min(value = 1000, message ="Postal Code should not be less than 1000.")
	@Max(value = 999999, message ="Postal Code should not be greater than 999999.")
	private Integer postalCode;

	@NotBlank(message = "Phone should not be blank.")
	private String phoneNumber;

	@Email(message="Email Id is not valid, please pass correct emailid.")
	private String emailId;

	private Long createdByUser;

	@NotNull(message = "Created by User should not be blank.")
	private Long updatedByUser;

	public Long getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public CustomerType getCustomerType() {
		return customerType;
	}

	public void setCustomerType(CustomerType customerType) {
		this.customerType = customerType;
	}

	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getAppartment() {
		return appartment;
	}

	public void setAppartment(String appartment) {
		this.appartment = appartment;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStateCode() {
		return stateCode;
	}

	public void setStateCode(String stateCode) {
		this.stateCode = stateCode;
	}

	public Integer getPostalCode() {
		return postalCode;
	}

	public void setPostalCode(Integer postalCode) {
		this.postalCode = postalCode;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public Long getCreatedByUser() {
		return createdByUser;
	}

	public void setCreatedByUser(Long createdByUser) {
		this.createdByUser = createdByUser;
	}

	public Long getUpdatedByUser() {
		return updatedByUser;
	}

	public void setUpdatedByUser(Long updatedByUser) {
		this.updatedByUser = updatedByUser;
	}

	@Override
	public boolean equals(Object obj) {
		return EqualsBuilder.reflectionEquals(this, obj, false);
	}

	@Override
	public int hashCode() {
		return HashCodeBuilder.reflectionHashCode(this, false);
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
