package com.flowics.proxy.services;

import com.flowics.proxy.domain.twitter.Tweet;

import twitter4j.Status;
import twitter4j.TwitterException;
import twitter4j.User;

public interface TwitterService {
	
	public Tweet getStatus(String id) throws TwitterException, NumberFormatException;
	
	public User getUser(String screenName) throws TwitterException;

}
