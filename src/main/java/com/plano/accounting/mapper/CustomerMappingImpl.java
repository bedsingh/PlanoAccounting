
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

import java.util.Optional;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import com.plano.accounting.repository.entity.CustomerEntity;
import com.plano.accounting.request.CustomerRequest;
import com.plano.accounting.response.CustomerResponse;
import com.plano.accounting.utility.DateTimeHelper;

import ma.glasnost.orika.CustomMapper;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.MappingContext;

/***********************************************************************************************************
 * Java File - CustomerMappingImpl.java
 * Author - Bed Singh
 * Date   - Jun 6, 2018
 * Description - This class implements all the transformations methods for customer operations. 
 * 
 ***********************************************************************************************************/

@Component
public class CustomerMappingImpl implements OrikaBeanMapping {

	private static Logger logger = LogManager.getLogger(CustomerMappingImpl.class);

	/* (non-Javadoc)
	 * @see com.plano.accounting.mapper.OrikaBeanMapping#registerClassMapCustomerRequestToEntity(ma.glasnost.orika.MapperFactory)
	 */
	@Override
	public void registerClassMapCustomerRequestToEntity(MapperFactory mapperFactory) {
		//Map Customer request to Customer Entity
		mapperFactory.classMap(CustomerRequest.class, CustomerEntity.class)
		.exclude("createdByUser")
		//.fieldAToB("updatedByUser", "updatedByUser")
		.mapNulls(false)
		.byDefault()
		.customize(new CustomMapper<CustomerRequest, CustomerEntity>() {
			@Override
			public void mapAtoB(CustomerRequest source, CustomerEntity destination, MappingContext context) {
				//This will call when we update the record
				boolean createdTimestampExist = Optional.ofNullable(destination.getCreatedTimestamp()).isPresent();
				if(!createdTimestampExist) {
					destination.setCreatedTimestamp(DateTimeHelper.currentDateTime());
					destination.setCreatedByUser(source.getCreatedByUser());
				}
				destination.setUpdatedTimestamp(DateTimeHelper.currentDateTime());
				//logger.info("Mapping completed for CustomerRequest to CustomerEntity.");
			}
		})
		.register();
	}

	
	/* (non-Javadoc)
	 * @see com.plano.accounting.mapper.OrikaBeanMapping#registerClassMapEntityToResponse(ma.glasnost.orika.MapperFactory)
	 */
	@Override
	public void registerClassMapEntityToResponse(MapperFactory mapperFactory) {
		mapperFactory.classMap(CustomerEntity.class, CustomerResponse.class)
		.mapNulls(false)
		.byDefault()
		.customize(new CustomMapper<CustomerEntity, CustomerResponse>() {
			@Override
			public void mapAtoB(CustomerEntity source, CustomerResponse destination, MappingContext context) {
				logger.info("Mapping Customer Entity to Customer Response.");
			}
		})
		.register();

	}
}
