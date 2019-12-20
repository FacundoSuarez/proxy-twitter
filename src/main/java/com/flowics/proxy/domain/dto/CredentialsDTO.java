package com.flowics.proxy.domain.dto;

import javax.xml.bind.annotation.XmlRootElement;

import com.fasterxml.jackson.annotation.JsonProperty;

@XmlRootElement
public class CredentialsDTO {

	@JsonProperty("API_key")
	private String API_key;
	
	@JsonProperty("API_secret_key")
	private String API_secret_key;
	
	private String token;

	
	public String getToken() {
		return token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	public String getAPI_key() {
		return API_key;
	}

	public void setAPI_key(String aPI_key) {
		API_key = aPI_key;
	}

	public String getAPI_secret_key() {
		return API_secret_key;
	}

	public void setAPI_secret_key(String aPI_secret_key) {
		API_secret_key = aPI_secret_key;
	}
	
	
}
