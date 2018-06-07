
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

package com.plano.accounting.exception;

/***********************************************************************************************************
 * Java File - CustomerException.java
 * Author - Bed Singh
 * Date   - Jun 6, 2018
 * Description - Custom exception to send common response to the client.
 ***********************************************************************************************************/

public class CustomerException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	private Integer errorNumber;
	private String  errorMessage;
	private Throwable errorCause;
	private String developerText;

	public CustomerException(Integer errorNumber) {
		this.errorNumber = errorNumber;
	}
	
	public CustomerException(Integer errorNumber, String errorMessage) {
		this.errorNumber = errorNumber;
		this.errorMessage = errorMessage;
	}

	public CustomerException(Integer errorNumber, String errorMessage, Throwable errorCause) {
		this.errorNumber = errorNumber;
		this.errorMessage = errorMessage;
		this.errorCause = errorCause;
	}

	public CustomerException(Integer errorNumber, String errorMessage, Throwable errorCause, String developerText) {
		this.errorNumber = errorNumber;
		this.errorMessage = errorMessage;
		this.errorCause = errorCause;
		this.developerText = developerText;
	}


	public Integer getErrorNumber() {
		return errorNumber;
	}

	public void setErrorNumber(Integer errorNumber) {
		this.errorNumber = errorNumber;
	}

	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}

	public Throwable getErrorCause() {
		return errorCause;
	}

	public void setErrorCause(Throwable errorCause) {
		this.errorCause = errorCause;
	}

	public String getDeveloperText() {
		return developerText;
	}

	public void setDeveloperText(String developerText) {
		this.developerText = developerText;
	}

}
