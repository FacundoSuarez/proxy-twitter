package com.flowics.proxy.domain;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.flowics.proxy.domain.twitter.User;

@Document(collection = "user")
public class UserWithData {

	private User user;
	
	private Long lastUpdated;

	private Long requestCounter = 1L;

	@Id
	private String id;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Long getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public Long getRequestCounter() {
		return requestCounter;
	}

	public void setRequestCounter(Long requestCounter) {
		this.requestCounter = requestCounter;
	}
	
	
}
