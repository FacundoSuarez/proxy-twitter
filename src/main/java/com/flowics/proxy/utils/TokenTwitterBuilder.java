package com.flowics.proxy.utils;

import java.util.Base64;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.flowics.proxy.domain.twitter.Token;

@Service
public class TokenTwitterBuilder {
	
	@Value("${twitter.username}")
	private String username;
	
	@Value("${twitter.password}")
	private String password;
	
	public Token getToken() {
		Client client = ClientBuilder.newClient();
		String encoding = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
		Token token = client.target("https://api.twitter.com/oauth2/token")
				.request()
				.header("content-type", "application/x-www-form-urlencoded")
				.header("authorization", "Basic "+encoding)
				.post(Entity.entity("grant_type=client_credentials",MediaType.APPLICATION_FORM_URLENCODED), Token.class);
		return token;
	}

}
