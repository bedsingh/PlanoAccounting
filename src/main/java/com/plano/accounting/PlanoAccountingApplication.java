package com.plano.accounting;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/***********************************************************************************************************
 * Java File - PlanoAccountingApplication.java
 * Author - Bed Singh
 * Date   - June 06, 2018
 * Description - Plano Accounting:
 * Plano Accounting is a firm (company) owned by John Doe, that helps clients manage their accounting books and file their tax returns. 
 * He has 2 seasonal employees - Mike and Martha - who help him out with filing simple tax returns during peak tax season. 
 * Plano Accounting has 20 existing clients. This year they are planning to grow their business and are willing to add more clients. 
 * New clients could be either an Individual or a Business. Since they need to reach out to their clients for any questions or documents, 
 * they want to keep their clients' contact information up to date. Occasionally when a client switches to a different accounting firm they 
 * also have to remove the client from their system. 
 * 
 * This is the main java class to run the plano accounting api. 
 ***********************************************************************************************************/

@EnableJpaRepositories
@EnableAutoConfiguration
@EntityScan(basePackages= {"com.plano.accounting.repository.entity"})
@ComponentScan(basePackages = {"com.plano.accounting"})
@SpringBootApplication
public class PlanoAccountingApplication extends SpringBootServletInitializer {

	private static Logger logger = LogManager.getLogger(PlanoAccountingApplication.class);

	public static void main(String[] args) {
		final String dashLine = "-------------------------------------------------------------------------";
		logger.info(dashLine);
		logger.info("************** PLANO ACCOUNTING API STARTING, PLEASE WAIT. ************** ");
		logger.info(dashLine);

		SpringApplication.run(PlanoAccountingApplication.class, args);

		logger.info(dashLine);
		logger.info("************** PLANO ACCOUNTING API STARTED SUCCESSFULLY. *************** ");
		logger.info(dashLine);
	} 

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(PlanoAccountingApplication.class);
	}

}
