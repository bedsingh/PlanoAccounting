
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

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/***********************************************************************************************************
 * Java File - PlanoAccountingExcepitonHandler.java
 * Author - Bed Singh
 * Date   - Jun 7, 2018
 * Description - This class is the Global Exception Handler when any exception thrown by rest controller classes.
 ***********************************************************************************************************/

@RestControllerAdvice(basePackages= { "com.plano.accounting.resource" } )
public class PlanoAccountingExcepitonHandler {

	private static Logger logger = LogManager.getLogger(PlanoAccountingExcepitonHandler.class);

	/**
	 * This is the exception method called by global exception handler when customer exception is thrown by rest controller.
	 * @param exception
	 * @return object of { @ResponseEntity<ErrorResponse> }
	 */
	@ExceptionHandler(value = { CustomerException.class })
	public ResponseEntity<ErrorResponse> handleCustomerException(CustomerException exception) {
		logger.info("Handling Global Excepiton... ");
		ErrorResponse errorResponse = new ErrorResponse();
		errorResponse.setDeveloperText(exception.getDeveloperText());
		errorResponse.setErrorMessage(exception.getMessage());
		errorResponse.setStatusCode(HttpStatus.valueOf(exception.getErrorNumber()));
		return new ResponseEntity<ErrorResponse>(errorResponse, HttpStatus.valueOf(exception.getErrorNumber()));
	}
}
