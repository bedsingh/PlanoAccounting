
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

package com.plano.accounting.resource;

import java.util.List;

import javax.validation.Valid;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.plano.accounting.constants.MappingConstants;
import com.plano.accounting.exception.CustomerException;
import com.plano.accounting.request.CustomerRequest;
import com.plano.accounting.response.CustomerCreatedResponse;
import com.plano.accounting.response.CustomerResponse;
import com.plano.accounting.service.CustomerService;


/***********************************************************************************************************
 * Java File - CustomerResource.java
 * Author - Bed Singh
 * Date   - Jun 6, 2018
 * Description - This class is responsible to handle the operations such as get, put, post, delete client informations.
 * 
 ***********************************************************************************************************/

@RestController
@RequestMapping(path="/", 
produces={ MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, 
consumes={MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
public class CustomerResource implements MappingConstants {

	private static Logger logger = LogManager.getLogger(CustomerResource.class);

	@Autowired
	private CustomerService customerService;


	/**
	 * This method is use to check the running status of the application. it will return response such as:
	 * { "status": "Plano Accounting API is UP." }
	 * @return { @String } object.
	 */
	@RequestMapping(path = HEALTH_CHECK_PATH, method = RequestMethod.GET)
	public String healthCheck() {
		logger.info("Health Check for Plano Account API.");
		return PLANO_ACCOUNTING_API_UP;
	}

	/**
	 * This method is use to create new customer and return response entity of created response object. 
	 * @param customerRequest
	 * @return object of { @ResponseEntity<CustomerCreatedResponse> }
	 * @throws CustomerException
	 */
	@RequestMapping(path = CUSTOMERS_PATH, method = RequestMethod.POST)
	public ResponseEntity<CustomerCreatedResponse> createCustomer(@Valid @RequestBody CustomerRequest customerRequest ) throws CustomerException
	{
		logger.info("Create Custoemr for CustomerName: "+customerRequest.getFirstName()+" "+customerRequest.getLastName());
		CustomerCreatedResponse createdResponse = null;
		createdResponse = customerService.createCustomer(customerRequest);

		return new ResponseEntity<CustomerCreatedResponse>(createdResponse, HttpStatus.CREATED);
	}

	/**
	 * This method return the list of customers response based on query parameter of customerType.
	 * @param customerType
	 * @return { @List<CustomerResponse> }
	 * @throws CustomerException
	 */
	@RequestMapping(path = CUSTOMERS_PATH, method = RequestMethod.GET)
	@CrossOrigin(origins="*")
	public ResponseEntity<List<CustomerResponse>> getCustomers(@RequestParam(value="customerType") String customerType) throws CustomerException
	{
		logger.info("Get Customers for CustomerType: "+customerType);
		List<CustomerResponse> customersList = null;
		customersList = customerService.getCustomers(customerType);

		return new ResponseEntity<List<CustomerResponse>>(customersList, HttpStatus.OK);
	}

	/**
	 * This resource method is use to fetch single customer result based on customerId
	 * @param customerId
	 * @return
	 * @throws CustomerException
	 */
	@RequestMapping(path = CUSTOMERS_ID_PATH, method = RequestMethod.GET)
	public ResponseEntity<CustomerResponse> getCustomer(@PathVariable(value="customerId") Long customerId) throws CustomerException
	{
		logger.info("Get Customer customerId: "+customerId);
		CustomerResponse customerResponse = null;
		customerResponse = customerService.getCustomer(customerId);

		return new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.OK);
	}


	@RequestMapping(path = CUSTOMERS_ID_PATH, method = RequestMethod.PUT)
	public ResponseEntity<CustomerResponse> updateCustomer(
			@Valid @RequestBody CustomerRequest customerRequest,
			@PathVariable(value="customerId") Long customerId) throws CustomerException
	{
		logger.info("Updating Customer Data - Name: "+customerRequest.getFirstName()+" "+customerRequest.getLastName());
		CustomerResponse customerResponse = null;
		customerResponse = customerService.updateCustomer(customerRequest);

		return new ResponseEntity<CustomerResponse>(customerResponse, HttpStatus.OK);
	}


	/**
	 * This method is use to delete single record based on the customerId
	 * @param customerId
	 * @return
	 * @throws CustomerException
	 */
	@RequestMapping(path = CUSTOMERS_ID_PATH, method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteCustomer(@PathVariable(value="customerId") Long customerId) throws CustomerException
	{
		logger.info("Delete customerId: "+customerId);
		String status = customerService.deleteCustomer(customerId);
		return new ResponseEntity<String>(status, HttpStatus.NO_CONTENT);
	}

}







