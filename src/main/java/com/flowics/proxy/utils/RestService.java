package com.flowics.proxy.utils;

import java.util.Base64;
import java.util.HashMap;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedHashMap;

import org.eclipse.jetty.http.HttpParser.ResponseHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.flowics.proxy.domain.twitter.Token;


@Service
public class RestService {
	
	@Autowired
	private TokenTwitterBuilder tokenTwitterBuilder;
	
	public <T> Object getMethod(String URI, HashMap<String, String> headers, Class<T> className) {

		return null;
	}

	public  <T> Object getMethod(String URI, Class<T> className) {
		
		Token token = tokenTwitterBuilder.getToken();
		Client client = ClientBuilder.newClient();
		T response = client.target(URI)
				.request()
				.header("Authorization", "Bearer "+token.getAccess_token())
				.get(className);
		return response;
	}
	
}
