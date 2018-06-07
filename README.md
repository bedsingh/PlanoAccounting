## About Plano Accounting
Context: Plano Accounting is a firm (company) owned by John Doe, that helps clients manage their accounting books and file their tax returns. He has 2 seasonal employees - Mike and Martha - who help him out with filing simple tax returns during peak tax season. Plano Accounting has 20 existing clients. This year they are planning to grow their business and are willing to add more clients. New clients could be either an Individual or a Business. Since they need to reach out to their clients for any questions or documents, they want to keep their clients' contact information up to date. Occasionally when a client switches to a different accounting firm they also have to remove the client from their system. 

## Prerequisites
To Run Plano Accounting application local in your system, you should have the following tools and software installed.
* Java version - jdk1.8.0_171 or Any Jdk 8 ( jdk-8u171-windows-x64.exe)
* Apache Maven - apache-maven-3.5.3
* Spring Tool Suite - Version: 3.9.3.RELEASE
* Orika Bean Mapping Framework - To transform Object(s)
* Tomcat Server - Embadded to the application
* Spring Boot - Version: 2.0.2.RELEASE
* Postman client for testing Rest endpoints
* Spring Data JPA With Hibernate
* Apache Common Lang 3 for Utility helper
* PostgreSQL Server Database - Version: 10
* dbForge Studio for PostgreSQL - UI for PostgreSQL 
* GitBash - Git-2.17.1.2-64-bit.exe
* Validation - javax.validation
* Junit Mockito

## Some URLs to download softwares
* Postgresql download: https://www.enterprisedb.com/downloads/postgres-postgresql-downloads
* dbForge Studio for PostgreSQ: https://www.devart.com/dbforge/postgresql/studio/download.html

## Running the Application
* Install Java 8, PostGreSQL DB, Maven, GitBash, dbForge UI pgsql, Postman
* Set the class path and path for Java and Maven such as M2_HOME, JAVA_HOME etc. 
* Clone this project to your system: git clone https://github.com/bedsingh/PlanoAccounting.git
* Import as maven project to STS IDE and make sure there should not be any error.
* First time: change spring.jpa.hibernate.ddl-auto=update to spring.jpa.hibernate.ddl-auto=create in application-dev.properties file.
* Open PlanoAccountingApplication.java -> Right Click on File and Run As -> Spring Boot Application
* You will see the message like below 
```java
2018-06-07 11:44:43.922  INFO 7740 --- [  restartedMain] c.p.a.PlanoAccountingApplication         : -------------------------------------------------------------------------
2018-06-07 11:44:43.923  INFO 7740 --- [  restartedMain] c.p.a.PlanoAccountingApplication         : ************** PLANO ACCOUNTING API STARTED SUCCESSFULLY. *************** 
2018-06-07 11:44:43.923  INFO 7740 --- [  restartedMain] c.p.a.PlanoAccountingApplication         : -------------------------------------------------------------------------
```
* These are the rest endpoints you need to run in postman
 - Health Check: http://localhost:8084/plano-accounting-web/healthcheck
   Header: 
   Accept:application/json
   Content-Type:application/json
*  Success Result of health check: 
   {
    "status": "Plano Accounting API is UP."
   }
* You can see more endpoints in this page.

```java
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


## Postman Setup
Get Customers URL: http://localhost:8084/plano-accounting-web/customers?customerType=Business
Header details will be same for every endpoints: 
Accept:application/json
Content-Type:application/json

POST : http://localhost:8084/plano-accounting-web/customers
Create Customer Request : 
{
	"customerId": "24",
	"firstName" : "John",
	"lastName" : "Doe",
	"customerType" : "Individual",
	"addressLine1" : "8001 Long Drive",
	"addressLine2" : "Galaxy Apt",
	"appartment" : "4500",
	"city" : "Richardson",
	"stateCode" : "NY",
	"postalCode" : "75924",
	"phoneNumber" : "222-555-9997",
	"emailId" : "john@gmail.com",
	"createdByUser": "1237",
	"updatedByUser" : "1237" 
}

Response: 
{
    "customerUserId": 29,
    "createdTimestamp": "Thu Jun 07 12:05:31 CDT 2018"
}

```

## Technical Architecture Diagram
![PDF](https://github.com/bedsingh/PlanoAccounting/blob/master/Technical_Diagram_Screen.JPG)

# Deployment
Tomcat server

# Build with
$ mvn clean compile package

## Author

*  **Ved Singh** - *Initial Work*

