package com.flowics.proxy.services;

import com.flowics.proxy.domain.twitter.Status;

public interface StatusService {
	
	public Status getStatus(String id) throws Exception;

}
