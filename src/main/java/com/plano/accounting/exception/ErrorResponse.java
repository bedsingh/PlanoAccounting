
/***********************************************************************************************************
 * Module Name - PlanoAccounting
 * Version Control Block
 * 
 * Date			Version	   Author			Reviewer			Change Description
 * -----------  ---------  --------------	----------------	-------------------------------------------
 * Jun 7, 2018  1.0		   Singh, Bed		XXXXXXXX			Created.
 * -----------  ---------  --------------	----------------	-------------------------------------------
 * 
 ***********************************************************************************************************/

package com.plano.accounting.exception;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.springframework.http.HttpStatus;

import com.plano.accounting.utility.DateTimeHelper;

/***********************************************************************************************************
 * Java File - ErrorResponse.java
 * Author - Bed Singh
 * Date   - Jun 7, 2018
 * Description - This is the error response class which is use to send to client application when any error.
 ***********************************************************************************************************/

public class ErrorResponse implements Serializable {

	private static final long serialVersionUID = 1L;

	private HttpStatus statusCode;
	private String  errorMessage;
	private String developerText;
	private Date currentTimestamp;
	private List<ErrorResponse> subErrors;

	public ErrorResponse() {
		this.currentTimestamp = DateTimeHelper.currentDateTime();
	}

	public ErrorResponse(HttpStatus statusCode) {
		this();
		this.statusCode = statusCode;
	}

	public ErrorResponse(HttpStatus statusCode, String  errorMessage) {
		this();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
	}

	public ErrorResponse(HttpStatus statusCode, String  errorMessage, String developerText) {
		this();
		this.statusCode = statusCode;
		this.errorMessage = errorMessage;
	}

	public HttpStatus getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(HttpStatus statusCode) {
		this.statusCode = statusCode;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public String getDeveloperText() {
		return developerText;
	}

	public void setDeveloperText(String developerText) {
		this.developerText = developerText;
	}

	public Date getCurrentTimestamp() {
		return currentTimestamp;
	}

	public void setCurrentTimestamp(Date currentTimestamp) {
		this.currentTimestamp = currentTimestamp;
	}

	public List<ErrorResponse> getSubErrors() {
		return subErrors;
	}

	public void setSubErrors(List<ErrorResponse> subErrors) {
		this.subErrors = subErrors;
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
