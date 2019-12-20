package com.flowics.proxy.domain;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.flowics.proxy.domain.twitter.Status;


@Document(collection = "status")
@JsonPropertyOrder({"id_str", "name"})
public class StatusWithData {
	
	@Id
	private String Id;
	
	private Status status;
	
	private Long lastUpdated;
	
	private int requestCounter;


	public String getId() {
		return Id;
	}

	public void setId(String id) {
		Id = id;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public Long getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Long lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	public int getRequestCounter() {
		return requestCounter;
	}

	public void setRequestCounter(int requestCounter) {
		this.requestCounter = requestCounter;
	}



}
