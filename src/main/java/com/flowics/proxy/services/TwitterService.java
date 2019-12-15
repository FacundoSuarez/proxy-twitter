package com.flowics.proxy.services;

import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.User;

public interface TwitterService {
	
	public Status getStatus(String id) throws TwitterException, NumberFormatException;
	
	public User getUser(String screenName) throws TwitterException;

}
