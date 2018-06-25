
/***********************************************************************************************************
 * Module Name - PlanoAccounting
 * Version Control Block
 * 
 * Date			Version	   Author			Reviewer			Change Description
 * -----------  ---------  --------------	----------------	-------------------------------------------
 * Jun 24, 2018  1.0		   Singh, Bed		XXXXXXXX			Created.
 * -----------  ---------  --------------	----------------	-------------------------------------------
 * 
 ***********************************************************************************************************/

package com.plano.accounting.config;

import java.io.Serializable;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

/***********************************************************************************************************
 * Java File - APIPropertyReader.java
 * Author - Bed Singh
 * Date   - Jun 24, 2018
 * Description - 
 ***********************************************************************************************************/

@Configuration
@ConfigurationProperties(prefix="eapi")
@Validated
public class APIPropertyReader implements Serializable {

	private static final long serialVersionUID = 1L;

	@Valid private String environmentName;
	@Valid private Integer timeout;

	private Header header = new Header();
	private Endpoints endpoints = new Endpoints(); 

	@Validated
	public static class Header {
		@NotBlank private String userKey;
		@NotBlank private String userValue;
		@NotBlank private String acceptKey;
		@NotBlank private String acceptValue;
		@NotBlank private String contentTypeKey;
		@NotBlank private String contentTypeValue;


		public String getUserKey() {
			return userKey;
		}

		public void setUserKey(String userKey) {
			this.userKey = userKey;
		}

		public String getUserValue() {
			return userValue;
		}

		public void setUserValue(String userValue) {
			this.userValue = userValue;
		}

		public String getAcceptKey() {
			return acceptKey;
		}

		public void setAcceptKey(String acceptKey) {
			this.acceptKey = acceptKey;
		}

		public String getAcceptValue() {
			return acceptValue;
		}

		public void setAcceptValue(String acceptValue) {
			this.acceptValue = acceptValue;
		}

		public String getContentTypeKey() {
			return contentTypeKey;
		}

		public void setContentTypeKey(String contentTypeKey) {
			this.contentTypeKey = contentTypeKey;
		}

		public String getContentTypeValue() {
			return contentTypeValue;
		}

		public void setContentTypeValue(String contentTypeValue) {
			this.contentTypeValue = contentTypeValue;
		}

	}

	@Validated
	public static class Endpoints {
		@NotBlank private String authTokenEapiUrl;
		@NotBlank private String weatherEapiUrl;

		public String getAuthTokenEapiUrl() {
			return authTokenEapiUrl;
		}

		public void setAuthTokenEapiUrl(String authTokenEapiUrl) {
			this.authTokenEapiUrl = authTokenEapiUrl;
		}

		public String getWeatherEapiUrl() {
			return weatherEapiUrl;
		}

		public void setWeatherEapiUrl(String weatherEapiUrl) {
			this.weatherEapiUrl = weatherEapiUrl;
		}

	}


	public String getEnvironmentName() {
		return environmentName;
	}

	public void setEnvironmentName(String environmentName) {
		this.environmentName = environmentName;
	}

	public Integer getTimeout() {
		return timeout;
	}

	public void setTimeout(Integer timeout) {
		this.timeout = timeout;
	}

	public Header getHeader() {
		return header;
	}

	public void setHeader(Header header) {
		this.header = header;
	}

	public Endpoints getEndpoints() {
		return endpoints;
	}

	public void setEndpoints(Endpoints endpoints) {
		this.endpoints = endpoints;
	}


}
