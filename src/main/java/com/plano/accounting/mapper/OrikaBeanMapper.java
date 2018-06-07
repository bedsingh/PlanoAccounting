
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

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;

/***********************************************************************************************************
 * Java File - OrikaBeanMapper.java
 * Author - Bed Singh
 * Date   - Jun 6, 2018
 * Description - This class is used as a configuration for java bean mapping framework. It registers all the 
 * mapping classes for source and destinations or ClassA to ClassB. It can work list to list or object to object
 * or one type to another type of object.
 * 
 ***********************************************************************************************************/

@Configuration
public class OrikaBeanMapper {

	private static Logger logger = LogManager.getLogger(CustomerMappingImpl.class);

	@Autowired
	@Qualifier(value="customerMappingImpl")
	private OrikaBeanMapping customerMappingImpl;

	private static MapperFactory mapperFactory;
	private static MapperFacade mapperFacade;

	public OrikaBeanMapper() {
		initialize();
	}

	private synchronized void initialize() {
		mapperFactory = new DefaultMapperFactory.Builder().build();
		mapperFacade = mapperFactory.getMapperFacade();
	}

	//Init method
	@PostConstruct
	public void registerMappings() {
		customerMappingImpl.registerClassMapCustomerRequestToEntity(mapperFactory);
		customerMappingImpl.registerClassMapEntityToResponse(mapperFactory);
		//Register mapping here.

		logger.info("Register All Mappings completed successfully.");
	}

	//destroy method
	@PreDestroy
	public void cleanup() {
		mapperFactory = null;
		mapperFacade = null;
		logger.info("Register All Mappings completed successfully.");
	}

	//This method map object to new class 
	public <S, D> D mapObjectToClass(S sourceObject, Class<D> destinationClass) {
		return mapperFacade.map(sourceObject, destinationClass);
	}

	//convert object to object.
	public <S, D> void mapObjectToObject(S sourceObject, D destinationObject) {
		mapperFacade.map(sourceObject, destinationObject);
	}

	//This method convert one list to new destination list.
	public <S, D> List<D> mapAsList(List<S> source, Class<D> destinationClass) {
		List<D> response = Collections.emptyList();
		Optional<List<S>> optional = Optional.ofNullable(source).filter(list -> !list.isEmpty());
		if(optional.isPresent()) {
			response = mapperFacade.mapAsList(source, destinationClass);
		}
		return response;
	}

	public static MapperFactory getMapperFactory() {
		return Optional.ofNullable(mapperFactory).orElse(new DefaultMapperFactory.Builder().build());
	}

	public static MapperFacade getMapperFacade() {
		return Optional.ofNullable(mapperFacade).orElse(mapperFactory.getMapperFacade());
	}

}







