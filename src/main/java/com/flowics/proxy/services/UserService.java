package com.flowics.proxy.services;

import com.flowics.proxy.domain.twitter.User;

public interface UserService {
	
	public User getUser(String screenName) throws Exception;

}
