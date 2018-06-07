
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

import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

/***********************************************************************************************************
 * Java File - DateTimeHelper.java
 * Author - Bed Singh
 * Date   - Jun 6, 2018
 * Description - This is the helper class for all date and time operations.
 * 
 ***********************************************************************************************************/

public class DateTimeHelper {

	/**
	 * Return current data and time in UTC format.
	 * @return
	 */
	public static Date currentDateTime() {
		ZonedDateTime utc = ZonedDateTime.now(ZoneOffset.UTC);
		return Date.from(utc.toInstant());
	}
	
}

