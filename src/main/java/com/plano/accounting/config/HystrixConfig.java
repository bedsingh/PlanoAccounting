/*
*//***********************************************************************************************************
 * Module Name - PlanoAccounting
 * Version Control Block
 * 
 * Date			Version	   Author			Reviewer			Change Description
 * -----------  ---------  --------------	----------------	-------------------------------------------
 * Jun 19, 2018  1.0		   Singh, Bed		XXXXXXXX			Created.
 * -----------  ---------  --------------	----------------	-------------------------------------------
 * 
 ***********************************************************************************************************//*

package com.plano.accounting.config;

import java.util.Set;

import org.springframework.context.annotation.Configuration;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.netflix.hystrix.HystrixCommandProperties.ExecutionIsolationStrategy;

*//***********************************************************************************************************
 * Java File - HystrixConfig.java
 * Author - Bed Singh
 * Date   - Jun 19, 2018
 * Description - 
 ***********************************************************************************************************//*

@Configuration
public class HystrixConfig  extends HystrixCommand<Set<String>> {

	String msisdn;
	static String HYSTRIX_COMMAND_GROUP_KEY = "HYSTRIX_COMMAND_GROUP_KEY";
	static String HYSTRIX_ZK_CONFIG_PATH = "HYSTRIX_ZK_CONFIG_PATH";
	
	
	private static final Setter cachedSetter = 
			Setter
			.withGroupKey(HystrixCommandGroupKey.Factory.asKey("HYSTRIX_COMMAND_GROUP_KEY"))
			.andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
					.withExecutionIsolationStrategy(ExecutionIsolationStrategy.SEMAPHORE)
					.withExecutionTimeoutEnabled(false)
					.withExecutionIsolationSemaphoreMaxConcurrentRequests(50)
					.withExecutionTimeoutInMilliseconds(2000)
					.withFallbackEnabled(false)
					.withCircuitBreakerEnabled(true)
					.withRequestCacheEnabled(false));

	public HystrixConfig(String msisdn) throws HikeException {
		super(cachedSetter);
		this.msisdn = msisdn;
	}

	@Override
	protected Set<String> run() throws Exception {
		return null;
	}
}
*/