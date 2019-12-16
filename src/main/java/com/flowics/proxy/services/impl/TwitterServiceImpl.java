package com.flowics.proxy.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flowics.proxy.domain.twitter.Token;
import com.flowics.proxy.services.TwitterService;
import com.flowics.proxy.utils.TokenTwitterBuilder;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

import twitter4j.Status;
import twitter4j.Twitter;
import twitter4j.TwitterException;
import twitter4j.TwitterFactory;
import twitter4j.User;

@Service
public class TwitterServiceImpl implements TwitterService {

	private Twitter twitter = new TwitterFactory().getInstance();

	@Autowired
	private MongoTemplate mongoTemplate;

//	Gson gson = new Gson();

	@Override
	public Status getStatus(String id) throws TwitterException {
		Status status = null;
		asd();
		status = twitter.showStatus(Long.parseLong(id));
//		String json = gson.toJson(status, String.class);
//		DBObject dbObject = (DBObject) JSON.parse(json);
//		mongoTemplate.insert(dbObject, "status");
		return status;
	}

	@Override
	public User getUser(String screenName) throws TwitterException {
		User user = null;
		user = twitter.showUser(screenName);
//		String json = gson.toJson(user, User.class);
		return user;
	}
	
	
	private String asd() {
		
		Token result = TokenTwitterBuilder.getToken("emjwjOzNJM1VUZBE33pE6FCCJ", "DOZH47EQbfIIs0nnrErrwuvh06315XFRMPo37izCoPnzo5wnsI");

	    System.out.println(result.getAccess_token());
		
		
		return "";
	}

}
