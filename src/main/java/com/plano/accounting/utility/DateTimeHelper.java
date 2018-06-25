
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

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Date;
import java.util.Optional;

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

	/**
	 * Convert given date string to date object with give date pattern.
	 * @param dateStr
	 * @param pattern
	 * @return
	 */
	public static Date convertToDate(final String dateStr, final String pattern) {
		try {
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern(pattern);
			LocalDateTime parsed = LocalDateTime.parse(dateStr, formatter);
			ZonedDateTime zonedDateTime = ZonedDateTime.of(parsed, ZoneId.systemDefault());
			return Date.from(zonedDateTime.toInstant());

		}
		catch(DateTimeParseException | IllegalArgumentException exception) {
			exception.printStackTrace();
		}
		return null;
	}


	/**
	 * Convert given date into particular string format.
	 * @param date
	 * @param datePattern
	 * @return
	 */
	public static String convertToString(final Date date, String datePattern) {
		datePattern = Optional.ofNullable(datePattern).orElse("yyyy-MM-dd'T'HH:mm:ss.SSSX");
		return DateTimeFormatter.ofPattern(datePattern)
				.withZone(ZoneOffset.UTC)
				.format(date.toInstant());
	}

}

