
/***********************************************************************************************************
 * Module Name - PlanoAccounting
 * Version Control Block
 * 
 * Date			Version	   Author			Reviewer			Change Description
 * -----------  ---------  --------------	----------------	-------------------------------------------
 * Jun 19, 2018  1.0		   Singh, Bed		XXXXXXXX			Created.
 * -----------  ---------  --------------	----------------	-------------------------------------------
 * 
 ***********************************************************************************************************/

package com.plano.accounting.config;

import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.netflix.config.ConfigurationManager;
import com.netflix.hystrix.HystrixCommandProperties;

/***********************************************************************************************************
 * Java File - ApplicationStartupConfig.java
 * Author - Bed Singh
 * Date   - Jun 19, 2018
 * Description - 
 ***********************************************************************************************************/

@Component
public class ApplicationStartupConfig implements ApplicationListener<ApplicationReadyEvent> {



	@Override
	public void onApplicationEvent(ApplicationReadyEvent event) 
	{
		//		ConfigurationManager.getConfigInstance().setProperty("hystrix.command.default.execution.isolation.thread.timeoutInMilliseconds", "20000");
		//		ConfigurationManager.getConfigInstance().setProperty("execution.isolation.thread.timeoutInMilliseconds", "20000");
		//ConfigurationManager.getConfigInstance().setProperty("hystrix.command.HystrixCommandKey.execution.isolation.thread.timeoutInMilliseconds", "20000");

		HystrixCommandProperties.Setter().withExecutionTimeoutInMilliseconds(20000);
		ConfigurationManager.getConfigInstance().setProperty("execution.isolation.thread.timeoutInMilliseconds", "20000");

		System.out.println("1 value>>>>>>>>>>>>>>>>>>>>>>>>>>>> ");
		/*		AbstractConfiguration manager = ConfigurationManager.getConfigInstance();
		for (String key : event.getKeys())
		{
			for (ConfigurationListener listener : manager.getConfigurationListeners()) 
			{
				Object source = event.getSource();
				// TODO: Handle add vs set vs delete?
				int type = AbstractConfiguration.EVENT_SET_PROPERTY;
				String value = env.getProperty(key);

				System.out.println("value>>>>>>>>>>>>>>>>>>>>>>>>>>>> "+value);

				boolean beforeUpdate = false;
				listener.configurationChanged(new ConfigurationEvent(source, type, key, value, beforeUpdate));
			}
		}*/
	}
}
