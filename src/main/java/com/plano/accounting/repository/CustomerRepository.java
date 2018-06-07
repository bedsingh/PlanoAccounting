
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

package com.plano.accounting.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.plano.accounting.repository.entity.CustomerEntity;

/***********************************************************************************************************
 * Java File - CustomerRepository.java
 * Author - Bed Singh
 * Date   - Jun 6, 2018
 * Description - This is the repository interface, spring data jpa has in built implementations for this interface.
 ***********************************************************************************************************/

@Repository
public interface CustomerRepository extends JpaRepository<CustomerEntity, Long> {

	/**
	 * This repository custom method is use to fetch all the customers based on customer type.
	 * The customer type can be Individual or Business.
	 * @param customerType
	 * @return list of { @CustomerEntity } 
	 */
	List<CustomerEntity> findAllByCustomerType(String customerType);


}
