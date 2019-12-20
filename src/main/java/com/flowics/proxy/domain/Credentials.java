package com.flowics.proxy.domain;

import org.springframework.data.mongodb.core.mapping.Document;

import com.flowics.proxy.domain.twitter.Token;

@Document("credentials")
public class Credentials {
	
	private String APIkey;
	
	private String APISecretKey;
	
	private Token token;
	
	private String id;
	
	private Long rateLimitResetStatus = 1L;
	
	private Integer rateLimitRemainingStatus = 900;

	private Long rateLimitResetUser = 1L;
	
	private Integer rateLimitRemainingUser = 900;

	public String getAPIkey() {
		return APIkey;
	}

	public void setAPIkey(String aPIkey) {
		APIkey = aPIkey;
	}

	public String getAPISecretKey() {
		return APISecretKey;
	}

	public void setAPISecretKey(String aPISecretKey) {
		APISecretKey = aPISecretKey;
	}

	public Token getToken() {
		return token;
	}

	public void setToken(Token token) {
		this.token = token;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getRateLimitResetStatus() {
		return rateLimitResetStatus;
	}

	public void setRateLimitResetStatus(Long rateLimitResetStatus) {
		this.rateLimitResetStatus = rateLimitResetStatus;
	}

	public Integer getRateLimitRemainingStatus() {
		return rateLimitRemainingStatus;
	}

	public void setRateLimitRemainingStatus(Integer rateLimitRemainingStatus) {
		this.rateLimitRemainingStatus = rateLimitRemainingStatus;
	}

	public Long getRateLimitResetUser() {
		return rateLimitResetUser;
	}

	public void setRateLimitResetUser(Long rateLimitResetUser) {
		this.rateLimitResetUser = rateLimitResetUser;
	}

	public Integer getRateLimitRemainingUser() {
		return rateLimitRemainingUser;
	}

	public void setRateLimitRemainingUser(Integer rateLimitRemainingUser) {
		this.rateLimitRemainingUser = rateLimitRemainingUser;
	}

}