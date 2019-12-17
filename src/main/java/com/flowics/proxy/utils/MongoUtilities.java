package com.flowics.proxy.utils;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.flowics.proxy.domain.twitter.Status;
import com.google.gson.Gson;
import com.mongodb.DBObject;
import com.mongodb.util.JSON;

@Service
public class MongoUtilities {

	@Autowired
	private MongoTemplate mongoTemplate;
	
	Gson gson = new Gson();
	
	public void save(String json, String collection) {
		DBObject dbObject = (DBObject) JSON.parse(json);
		mongoTemplate.insert(dbObject, collection);
	}
	
}
