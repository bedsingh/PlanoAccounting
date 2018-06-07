
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

package com.plano.accounting.utility;

/***********************************************************************************************************
 * Java File - CustomerType.java
 * Author - Bed Singh
 * Date   - Jun 6, 2018
 * Description - This enum hold only two values such as Business and Individual
 ***********************************************************************************************************/

public enum CustomerType {

	Individual("Individual"),
	Business("Business");

	private String value;
	
	CustomerType(String value) { this.value = value; }

	@Override
	public String toString() { return this.value; }
	
}
