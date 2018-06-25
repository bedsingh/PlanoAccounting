
/***********************************************************************************************************
 * Module Name - PlanoAccounting
 * Version Control Block
 * 
 * Date			Version	   Author			Reviewer			Change Description
 * -----------  ---------  --------------	----------------	-------------------------------------------
 * Jun 24, 2018  1.0		   Singh, Bed		XXXXXXXX			Created.
 * -----------  ---------  --------------	----------------	-------------------------------------------
 * 
 ***********************************************************************************************************/

package com.plano.accounting.constants;

/***********************************************************************************************************
 * Java File - CommonConstants.java
 * Author - Bed Singh
 * Date   - Jun 24, 2018
 * Description - 
 ***********************************************************************************************************/

public interface CommonConstants {
	
	String LOG_ANNOTATION_EXPRESSION = "@annotation(com.plano.accounting.annotation.ExecutionTimeLog)";
	String RESOURCE_EXPRESSION = "within(com.plano.accounting.resource..*)";
	String SERVICE_EXPRESSION = "within(com.plano.accounting.service..*)";
	String AOP_EXPRESSION = "within(com.plano.accounting.aop..*)";
	
	String CLASS_NAME = "CLASS=";
	String METHOD = " \tMETHOD=";
	String TIME = "EXECUTION_TIME = ";
	String MSG = " MSG=";
	String BRACES = "{}";
	String MILLIS = " (Millis).";
	String START = " \tSTART ";
	String END = " \tEND ";
	
}
