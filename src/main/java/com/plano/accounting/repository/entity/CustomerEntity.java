
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

package com.plano.accounting.repository.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/***********************************************************************************************************
 * Java File - CustomerEntity.java
 * Author - Bed Singh
 * Date   - Jun 6, 2018
 * Description - 
 ***********************************************************************************************************/

@Entity
@Table(name = "CUST", uniqueConstraints = { 
		@UniqueConstraint(columnNames = { "EMAIL" }), 
		@UniqueConstraint(columnNames = { "FRST_NM", "LAST_NM", "PHN_NUMBER" }) } )
public class CustomerEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="CUST_ID", unique = true, nullable = false)
	private Long customerId;

	@Column(name="FRST_NM")
	private String firstName;

	@Column(name="LAST_NM")
	private String lastName; 

	@Column(name="CUST_TYPE")
	private String customerType; 

	@Column(name="ADDR_LINE_1")
	private String addressLine1;

	@Column(name="ADDR_LINE_2")
	private String addressLine2;

	@Column(name="APRTMNT")
	private String appartment;

	@Column(name="CITY")
	private String city;

	@Column(name="ST_CD")
	private String stateCode;

	@Column(name="ZIP_CD")
	private Integer postalCode;

	@Column(name="PHN_NUMBER")
	private String phoneNumber;

	@Column(name="EMAIL")
	private String emailId;

	@Column(name="CRETD_DT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date createdTimestamp;

	@Column(name="CRETD_BY_ID", nullable = false)
	private Long createdByUser;

	@Column(name="UPDT_BY_ID", nullable = false)
	private Long updatedByUser;

	@Column(name="UPDT_DT", nullable = false)
	@Temporal(TemporalType.TIMESTAMP)
	private Date updatedTimestamp;


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

	public String getCustomerType() {
		return customerType;
	}

	public void setCustomerType(String customerType) {
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

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
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

	public Date getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Date updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
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
