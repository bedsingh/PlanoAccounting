
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

package com.plano.accounting.service;

import java.util.List;

import com.plano.accounting.exception.CustomerException;
import com.plano.accounting.request.CustomerRequest;
import com.plano.accounting.response.CustomerCreatedResponse;
import com.plano.accounting.response.CustomerResponse;

/***********************************************************************************************************
 * Java File - CustomerService.java
 * Author - Bed Singh
 * Date   - Jun 6, 2018
 * Description - This service interface is use to handle multiple customer operations such as get, create, update and delete
 * 
 ***********************************************************************************************************/

public interface CustomerService {

	/**
	 * This method is use to create the new customer and call repository to save into database. If any error come during 
	 * creation of customer data then it throws CustomerException. This method first transform request object to entity 
	 * with the help of orika bean mapper framework.
	 * @param customerRequest
	 * @return object of { @CustomerCreatedResponse }
	 * @throws CustomerException
	 */
	CustomerCreatedResponse createCustomer(CustomerRequest customerRequest) throws CustomerException;

	/**
	 * This method is use to fetch the customer / client details based on the customerType value.
	 * CustomerType can be Individual or Business and based on that it should return the list of customer details.
	 * If there is no data found for any customer type then it should throw CustomerException with 404 exception. 
	 * @param customerType
	 * @return list of { @List<CustomerResponse> }
	 * @throws CustomerException
	 */
	List<CustomerResponse> getCustomers(String customerType) throws CustomerException;

	/**
	 * This method return single record based on customerId
	 * @param customerId
	 * @return
	 * @throws CustomerException
	 */
	CustomerResponse getCustomer(Long customerId) throws CustomerException;


	/**
	 * This method is use to update the customer data
	 * @param customerRequest
	 * @return updated object of { @CustomerResponse }
	 * @throws CustomerException
	 */
	CustomerResponse updateCustomer(CustomerRequest customerRequest) throws CustomerException;

	/**
	 * This method is use to delete the customer based on customer id
	 * @param customerId
	 * @return String DELETED response.
	 * @throws CustomerException
	 */
	String deleteCustomer(Long customerId) throws CustomerException;

}
