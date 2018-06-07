
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

package com.plano.accounting.mapper;

import ma.glasnost.orika.MapperFactory;

/***********************************************************************************************************
 * Java File - OrikaBeanMapping.java
 * Author - Bed Singh
 * Date   - Jun 6, 2018
 * Description - This class is use to transform one java object into another. Example request to entity or 
 * entity to response object. This can also map one list to another list. 
 ***********************************************************************************************************/

public interface OrikaBeanMapping {
	
	/**
	 * This method is use to transform customer request object to customerEntity object.
	 * @param mapperFactory
	 */
	void registerClassMapCustomerRequestToEntity(MapperFactory mapperFactory);
	
	/**
	 * This method is use to transform customer entity object to customer response.
	 * @param mapperFactory
	 */
	void registerClassMapEntityToResponse(MapperFactory mapperFactory);
	
}
