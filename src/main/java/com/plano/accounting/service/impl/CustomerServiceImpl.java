
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

package com.plano.accounting.service.impl;

import java.net.HttpURLConnection;
import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;
import javax.transaction.Transactional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.plano.accounting.exception.CustomerException;
import com.plano.accounting.mapper.OrikaBeanMapper;
import com.plano.accounting.repository.CustomerRepository;
import com.plano.accounting.repository.entity.CustomerEntity;
import com.plano.accounting.request.CustomerRequest;
import com.plano.accounting.response.CustomerCreatedResponse;
import com.plano.accounting.response.CustomerResponse;
import com.plano.accounting.service.CustomerService;

import ma.glasnost.orika.MappingException;

/***********************************************************************************************************
 * Java File - CustomerServiceImpl.java
 * Author - Bed Singh
 * Date   - Jun 6, 2018
 * Description - This class is use to perform various operations for customer such as get customers, create, update and 
 * delete customer. 
 ***********************************************************************************************************/

@Service
public class CustomerServiceImpl implements CustomerService {

	private static Logger logger = LogManager.getLogger(CustomerServiceImpl.class);

	@Autowired
	private OrikaBeanMapper orikaBeanMapper;

	@Autowired
	private CustomerRepository customerRepository;

	/* (non-Javadoc)
	 * @see com.plano.accounting.service.impl.CustomerService#createCustomer(com.plano.accounting.request.CustomerRequest)
	 */
	@Override
	public CustomerCreatedResponse createCustomer(CustomerRequest customerRequest) throws CustomerException {
		try {
			logger.info("Mapping starting...");
			CustomerEntity customerEntity = orikaBeanMapper.mapObjectToClass(customerRequest, CustomerEntity.class);
			logger.info("Mapping completed for Customer: "+customerEntity.getFirstName()+" "+customerEntity.getLastName());

			customerEntity = customerRepository.save(customerEntity);
			logger.info("New Customer Created: CustomerId: "+customerEntity.getCustomerId()+" Name: "+customerEntity.getFirstName()+" "+customerEntity.getLastName());

			CustomerCreatedResponse response = new CustomerCreatedResponse();
			response.setCreatedTimestamp(customerEntity.getCreatedTimestamp().toString());
			response.setCustomerUserId(customerEntity.getCustomerId());
			return response;
		}
		catch(MappingException mappingException) {
			logger.error("Mapping Exception: Error: "+mappingException.getMessage()+" - "+mappingException);
			final String errorMsg = new StringBuilder()
					.append("ErrorMessage: ").append(mappingException.getMessage())
					.append("Failed to create new customer with data: ").append(customerRequest).toString();
			throw new CustomerException(HttpURLConnection.HTTP_BAD_REQUEST, errorMsg, mappingException);
		}
		catch(DataIntegrityViolationException excepiton) {
			logger.error("DataIntegrityViolationException: Error: "+excepiton.getMessage()+" - "+excepiton);
			final String errorMsg = new StringBuilder()
					.append("ErrorMessage: ").append(excepiton.getMessage())
					.append("Failed to create new customer with data: ").append(customerRequest).toString();
			throw new CustomerException(HttpURLConnection.HTTP_CONFLICT, errorMsg, excepiton); 
		}
		catch(Exception excepiton) {
			logger.error("Exception: "+excepiton.getMessage()+" - "+excepiton);
			final String errorMsg = new StringBuilder()
					.append("ErrorMessage: ").append(excepiton.getMessage())
					.append("Failed to create new customer with data: ").append(customerRequest).toString();
			throw new CustomerException(HttpURLConnection.HTTP_INTERNAL_ERROR, errorMsg, excepiton); 
		}

	}

	/* (non-Javadoc)
	 * @see com.plano.accounting.service.impl.CustomerService#getCustomers(java.lang.String)
	 */
	@Override
	public List<CustomerResponse> getCustomers(String customerType) throws CustomerException {
		final String errorMsg = "Invalid CustomerType "+customerType+" Expected any of Individual or Business.";
		Optional.ofNullable(customerType).filter(type -> ( "Individual".equalsIgnoreCase(type) || "Business".equalsIgnoreCase(type) ))
		.orElseThrow(() -> new CustomerException(HttpURLConnection.HTTP_BAD_REQUEST, errorMsg));

		try {
			logger.info("Fetching customer records for customerType: "+customerType);
			List<CustomerEntity> customerEntityList;
			customerEntityList = customerRepository.findAllByCustomerType(customerType);
			logger.info("Fetched Records from DB, Now mapping from entity to respose.");

			List<CustomerResponse> customerResponseList;
			customerResponseList = orikaBeanMapper.mapAsList(customerEntityList, CustomerResponse.class);
			logger.info("Mapping completed successfully total records "+customerResponseList.size());

			Optional.ofNullable(customerResponseList).filter(list -> list.size() > 0)
			.orElseThrow(() -> new CustomerException(HttpURLConnection.HTTP_NOT_FOUND, "No Data Found for CustomerType "+customerType));

			return customerResponseList;

		}
		catch(MappingException mappingException) {
			logger.error("Mapping Exception: Error: "+mappingException.getMessage()+" - "+mappingException);
			String message = new StringBuilder()
					.append("ErrorMessage: ").append(mappingException.getMessage())
					.append("Mapping Failed for CustomerType : ").append(customerType).toString();
			throw new CustomerException(HttpURLConnection.HTTP_BAD_REQUEST, message, mappingException);
		}
		catch(EntityNotFoundException excepiton) {
			logger.error("EntityNotFoundException: "+excepiton.getMessage()+" - "+excepiton);
			String message = new StringBuilder()
					.append("ErrorMessage: ").append(excepiton.getMessage())
					.append("Mapping Failed for CustomerType : ").append(customerType).toString();
			throw new CustomerException(HttpURLConnection.HTTP_NOT_FOUND, message, excepiton); 
		}
		catch(CustomerException excepiton) {
			logger.error("CustomerException: "+excepiton.getMessage()+" - "+excepiton);
			String message = new StringBuilder()
					.append("ErrorMessage: ").append(excepiton.getErrorMessage())
					.append("Mapping Failed for CustomerType : ").append(customerType).toString();
			throw new CustomerException(excepiton.getErrorNumber(), message, excepiton); 
		}
	}


	/* (non-Javadoc)
	 * @see com.plano.accounting.service.CustomerService#getCustomer(java.lang.Long)
	 */
	@Transactional
	@Override
	public CustomerResponse getCustomer(Long customerId) throws CustomerException {
		try {
			logger.info("Fetching customer records for CustomerId: "+customerId);
			CustomerEntity customerEntity = customerRepository.getOne(customerId);
			logger.info("Fetched Records from DB, Now mapping from entity to respose.");

			CustomerResponse response = orikaBeanMapper.mapObjectToClass(customerEntity, CustomerResponse.class);
			logger.info("Mapping completed successfully for customer: "+response.getCustomerId()+" Name: "+response.getFirstName()+" "+response.getLastName());

			return response;
		}
		catch(MappingException mappingException) {
			logger.error("Mapping Exception: Error: "+mappingException.getMessage()+" - "+mappingException);
			String message = new StringBuilder()
					.append("ErrorMessage: ").append(mappingException.getMessage())
					.append("Mapping Failed for CustomerId : ").append(customerId).toString();
			throw new CustomerException(HttpURLConnection.HTTP_BAD_REQUEST, message, mappingException);
		}
		catch(EntityNotFoundException excepiton) {
			logger.error("EntityNotFoundException: "+excepiton.getMessage()+" - "+excepiton);
			String message = new StringBuilder()
					.append("ErrorMessage: ").append(excepiton.getMessage())
					.append("Mapping Failed for CustomerId : ").append(customerId).toString();
			throw new CustomerException(HttpURLConnection.HTTP_NOT_FOUND, message, excepiton); 
		}
	}


	/* (non-Javadoc)
	 * @see com.plano.accounting.service.CustomerService#updateCustomer(com.plano.accounting.request.CustomerRequest)
	 */
	@Override
	public CustomerResponse updateCustomer(CustomerRequest customerRequest) throws CustomerException {
		CustomerResponse response = null;
		try {
			Optional<CustomerEntity> existingEntity = customerRepository.findById(customerRequest.getCustomerId());
			if(existingEntity.isPresent()) {
				CustomerEntity customerEntity = existingEntity.get();
				logger.info("FindById Success: CustomerId "+customerEntity.getCustomerId()+" Mapping Object to Object.");

				orikaBeanMapper.mapObjectToObject(customerRequest, customerEntity);
				logger.info("Mapping completed for CustomerId: "+customerEntity.getCustomerId());
				logger.info("Updating Entity to DB : "+customerEntity);

				customerEntity = customerRepository.save(customerEntity);
				logger.info("Record has been updated to DB for customer Id: "+customerEntity.getCustomerId());

				response = orikaBeanMapper.mapObjectToClass(customerEntity, CustomerResponse.class);
				logger.info("Transformed Successfully from Entity to Response: "+response);
			}

			return response;
		}
		catch(MappingException mappingException) {
			logger.error("Mapping Exception: Update Customer Data Error: "+mappingException.getMessage()+" - "+mappingException);
			String message = new StringBuilder()
					.append("ErrorMessage: ").append(mappingException.getMessage())
					.append("Mapping Failed for CustomerId : ").append(customerRequest.getCustomerId()).toString();
			throw new CustomerException(HttpURLConnection.HTTP_BAD_REQUEST, message, mappingException);
		}
		catch(EntityNotFoundException excepiton) {
			logger.error("EntityNotFoundException: Update Customer Data "+excepiton.getMessage()+" - "+excepiton);
			String message = new StringBuilder()
					.append("Update Customer Data ErrorMessage: ").append(excepiton.getMessage())
					.append("Mapping Failed for CustomerId : ").append(customerRequest.getCustomerId()).toString();
			throw new CustomerException(HttpURLConnection.HTTP_NOT_FOUND, message, excepiton); 
		}
	}


	/* (non-Javadoc)
	 * @see com.plano.accounting.service.CustomerService#deleteCustomer(java.lang.Long)
	 */
	@Override
	public String deleteCustomer(Long customerId) throws CustomerException {
		try {
			customerRepository.deleteById(customerId);
			return "DELETED";
		}
		catch(EntityNotFoundException exception) {
			logger.error("EntityNotFoundException: "+exception.getMessage()+" - "+exception);
			String message = new StringBuilder()
					.append("ErrorMessage: ").append(exception.getMessage())
					.append("Unable to delete data for CustomerId : ").append(customerId).toString();
			throw new CustomerException(HttpURLConnection.HTTP_NOT_FOUND, message, exception); 
		}
		catch(EmptyResultDataAccessException exception) {
			logger.error("EmptyResultDataAccessException: "+exception.getMessage()+" - "+exception);
			String message = new StringBuilder()
					.append("ErrorMessage: ").append(exception.getMessage())
					.append("Unable to delete data for CustomerId : ").append(customerId).toString();
			throw new CustomerException(HttpURLConnection.HTTP_NOT_FOUND, message, exception); 
		}
	}

}
