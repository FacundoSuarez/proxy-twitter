package com.flowics.proxy.utils;

import java.io.IOException;
import java.util.Base64;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.client.authentication.HttpAuthenticationFeature;
import org.glassfish.jersey.client.oauth2.OAuth2ClientSupport;
import org.glassfish.jersey.client.oauth2.OAuth2CodeGrantFlow;
import org.glassfish.jersey.client.oauth2.TokenResult;

import com.flowics.proxy.domain.twitter.Token;
import com.flowics.proxy.domain.twitter.Tweet;

public class TokenTwitterBuilder {

	public static String asd(String username, String password) {
		String encoding = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
//		HttpPost httpPost = new HttpPost("https://api.twitter.com/oauth2/token?grant_type=client_credentials");
//		httpPost.setHeader(HttpHeaders.AUTHORIZATION, "Basic " + encoding);

		return null;

	}

	public static Token getToken(String username, String password) {
		HttpAuthenticationFeature feature = HttpAuthenticationFeature.basicBuilder()
			    .nonPreemptive()
			    .credentials(username, password)
			    .build();

		ClientConfig clientConfig = new ClientConfig();
		clientConfig.register(feature) ;
		Client client = ClientBuilder.newClient();
		String encoding = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
		Token token = client.target("https://api.twitter.com/oauth2/token").queryParam("grant_type", "client_credentials")
				.request(MediaType.APPLICATION_JSON)
				.header("content-type", "application/x-www-form-urlencoded")
				.property(HttpAuthenticationFeature.HTTP_AUTHENTICATION_BASIC_USERNAME, "emjwjOzNJM1VUZBE33pE6FCCJ")
				.property(HttpAuthenticationFeature.HTTP_AUTHENTICATION_BASIC_PASSWORD, "DOZH47EQbfIIs0nnrErrwuvh06315XFRMPo37izCoPnzo5wnsI")
				.post(Entity.json(null), Token.class);

//		OAuth2CodeGrantFlow.Builder builder = OAuth2ClientSupport.authorizationCodeGrantFlowBuilder(clientId,
//				"https://example.com/oauth/authorization", "https://example.com/oauth/token");
//		OAuth2CodeGrantFlow flow = builder.property(OAuth2CodeGrantFlow.Phase.AUTHORIZATION, "readOnly", "true")
//				.scope("contact").build();
//		String authorizationUri = flow.start();
//
//		// Here we must redirect the user to the authorizationUri
//		// and let the user approve an access for our app.
//
//		// We must handle redirection back to our web resource
//		// and extract code and state from the request
//		final TokenResult result = flow.finish(code, state);
//		System.out.println("Access Token: " + result.get);

		return token;
	}

}
