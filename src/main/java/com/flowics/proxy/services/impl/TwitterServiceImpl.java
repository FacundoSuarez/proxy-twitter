package com.flowics.proxy.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;


import com.flowics.proxy.domain.twitter.Status;
import com.flowics.proxy.domain.twitter.User;
import com.flowics.proxy.services.TwitterService;
import com.flowics.proxy.utils.MongoUtilities;
import com.flowics.proxy.utils.RestService;
import com.google.gson.Gson;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

@Service
public class TwitterServiceImpl implements TwitterService {
	
	@Autowired
	private RestService restService;
	
	@Autowired
	private MongoUtilities mongoUtilities;

	@Value("${twitter.statusUrl}")
	private String statusUrl;

	@Value("${twitter.userUrl}")
	private String userUrl;
	
	Gson gson = new Gson();
	
	@Override
	public Status getStatus(String id) {
		Status result = (Status) restService.getMethod(statusUrl+id, Status.class);
		String json = gson.toJson(result, Status.class);
		mongoUtilities.save(json, "status");
		return result;
	}

	@Override
	public User getUser(String screenName)   {
		User result = (User) restService.getMethod(userUrl+screenName, User.class);
		String json = gson.toJson(result, User.class);
		mongoUtilities.save(json, "user");
		return result;
	}

}
