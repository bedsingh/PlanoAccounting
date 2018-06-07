
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

package com.plano.accounting.constants;

/***********************************************************************************************************
 * Java File - MappingConstants.java
 * Author - Bed Singh
 * Date   - Jun 6, 2018
 * Description - This class holds all the constants related to the mappings in all the resource and other classes.
 *  
 ***********************************************************************************************************/

public interface MappingConstants {

	String PLANO_ACCOUNTING_API_UP = "{ \"status\" : \"Plano Accounting API is UP.\" }";
	String HEALTH_CHECK_PATH = "healthcheck";
	String CUSTOMERS_PATH = "customers";
	String CUSTOMERS_ID_PATH = "customers/{customerId}";
	
}
