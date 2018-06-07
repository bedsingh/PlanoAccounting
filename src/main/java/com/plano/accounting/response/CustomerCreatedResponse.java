
/***********************************************************************************************************
 * Module Name - PlanoAccounting
 * Version Control Block
 * 
 * Date			Version	   Author			Reviewer			Change Description
 * -----------  ---------  --------------	----------------	-------------------------------------------
 * Jun 6, 2018  1.0		   Singh, Bed		XXXXXXXX			Created.
 * -----------  ---------  --------------	----------------	-------------------------------------------

 ***********************************************************************************************************/

package com.plano.accounting.response;

import java.io.Serializable;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;

/***********************************************************************************************************
 * Java File - CustomerCreatedResponse.java
 * Author - Bed Singh
 * Date   - Jun 6, 2018
 * Description - This is the response send as part of success response when customer is created. 
 * 
 ***********************************************************************************************************/

public class CustomerCreatedResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long customerUserId;
	private String createdTimestamp;

	public Long getCustomerUserId() {
		return customerUserId;
	}

	public void setCustomerUserId(Long customerUserId) {
		this.customerUserId = customerUserId;
	}

	public String getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(String createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
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
