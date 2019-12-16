package com.flowics.proxy.services.impl;

import javax.ws.rs.core.MultivaluedHashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.flowics.proxy.domain.twitter.Token;
import com.flowics.proxy.domain.twitter.Tweet;
import com.flowics.proxy.services.TwitterService;
import com.flowics.proxy.utils.RestService;
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
	
	@Autowired
	private RestService restService;

	@Value("${twitter.statusUrl}")
	private String statusUrl;

	@Override
	public Tweet getStatus(String id) {
		Tweet result = (Tweet) restService.getMethod(statusUrl+id, Tweet.class);
		return result;
	}
	
	
	public Tweet getTweet(String id) {
		
		return null;
	}

	@Override
	public User getUser(String screenName) throws TwitterException {
		User user = null;
		user = twitter.showUser(screenName);
//		String json = gson.toJson(user, User.class);
		return user;
	}
	
	
	private String asd() {
	
		Tweet result = (Tweet) restService.getMethod("https://api.twitter.com/1.1/statuses/show.json?id=210462857140252672",  Tweet.class);

//	    System.out.println(result.getAccess_token());
		
		
		return "";
	}

}
