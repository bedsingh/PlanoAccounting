
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

package com.plano.accounting.resource;

import static org.hamcrest.CoreMatchers.instanceOf;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import com.plano.accounting.response.CustomerCreatedResponse;
import com.plano.accounting.service.CustomerService;
import com.plano.accounting.utility.ResourceTestDataGenerator;

/***********************************************************************************************************
 * Java File - CustomerResourceTest.java
 * Author - Bed Singh
 * Date   - Jun 7, 2018
 * Description - Junit class for CustomerResource.java
 ***********************************************************************************************************/

@RunWith(SpringRunner.class)
public class CustomerResourceTest {

	@InjectMocks
	private CustomerResource customerResource;

	@Mock
	private CustomerService customerService;


	@Before
	public void setup() {

	}

	@Test
	public void testHealthCheck() {
		String healthCheck = customerResource.healthCheck();
		assertThat(healthCheck, instanceOf(String.class));
		assertEquals("{ \"status\" : \"Plano Accounting API is UP.\" }", healthCheck);
	}

	@Test
	public void testCreateCustomer() {
		Mockito.when(customerService.createCustomer(ResourceTestDataGenerator.getCustomerRequest())).thenReturn(ResourceTestDataGenerator.getCreatedResposne());
		ResponseEntity<CustomerCreatedResponse> responseEntity = customerResource.createCustomer(ResourceTestDataGenerator.getCustomerRequest());

		assertThat(responseEntity, instanceOf(ResponseEntity.class));
		assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
		assertEquals("2018-06-07 03:58:26.88", responseEntity.getBody().getCreatedTimestamp());
		assertEquals(new Long(76877), responseEntity.getBody().getCustomerUserId());
	}

}
