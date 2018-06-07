
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

package com.plano.accounting.utility;

import com.plano.accounting.request.CustomerRequest;
import com.plano.accounting.response.CustomerCreatedResponse;

/***********************************************************************************************************
 * Java File - ResourceTestDataGenerator.java
 * Author - Bed Singh
 * Date   - Jun 7, 2018
 * Description - This is the utility class to generate the test data for the resource classes.
 ***********************************************************************************************************/

public class ResourceTestDataGenerator {

	/**
	 * 
	 * @return
	 */
	public static CustomerRequest getCustomerRequest() {
		CustomerRequest request = new CustomerRequest();
		request.setAddressLine1("9009 Rich Drive");
		request.setAddressLine2("Galaxy Apt");
		request.setAppartment("B-6789");
		request.setCity("Frisco");
		request.setCreatedByUser(46456L);
		request.setCustomerId(123456L);
		request.setCustomerType(CustomerType.Business);
		request.setEmailId("ved-temp@gmail.com");
		request.setFirstName("Ved");
		request.setLastName("Singh");
		request.setPhoneNumber("222-555-9997");
		request.setPostalCode(75200);
		request.setStateCode("TX");
		request.setUpdatedByUser(46456L);

		return request;
	}
	
	public static CustomerCreatedResponse getCreatedResposne() {
		CustomerCreatedResponse createdResponse = new CustomerCreatedResponse();
		createdResponse.setCreatedTimestamp("2018-06-07 03:58:26.88");
		createdResponse.setCustomerUserId(76877L);
		return createdResponse;
	}
}
