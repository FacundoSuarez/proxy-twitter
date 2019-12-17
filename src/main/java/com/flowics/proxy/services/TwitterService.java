package com.flowics.proxy.services;

import com.flowics.proxy.domain.twitter.Status;
import com.flowics.proxy.domain.twitter.User;

public interface TwitterService {
	
	public Status getStatus(String id) throws NumberFormatException;
	
	public User getUser(String screenName);

}
