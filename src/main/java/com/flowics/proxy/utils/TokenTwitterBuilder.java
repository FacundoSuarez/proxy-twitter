package com.flowics.proxy.utils;

import java.util.Base64;
import java.util.List;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowics.proxy.domain.Credentials;
import com.flowics.proxy.domain.twitter.Token;
import com.flowics.proxy.services.CredentialsService;

@Service
public class TokenTwitterBuilder {

	@Autowired
	CredentialsService credentialsService;

	public Token getToken(String username, String password) {
		Client client = ClientBuilder.newClient();
		String encoding = Base64.getEncoder().encodeToString((username + ":" + password).getBytes());
		Token token = client.target("https://api.twitter.com/oauth2/token").request()
				.header("content-type", "application/x-www-form-urlencoded")
				.header("authorization", "Basic " + encoding)
				.post(Entity.entity("grant_type=client_credentials", MediaType.APPLICATION_FORM_URLENCODED),
						Token.class);
		return token;
	}

	public Credentials getBestTokenForStatus() {
		List<Credentials> credentialsReamining = credentialsService.findAll();
		List<Credentials> credentialsResetTime = credentialsReamining;
		credentialsReamining.sort((a,b)->a.getRateLimitRemainingStatus().compareTo(b.getRateLimitRemainingStatus()));
		credentialsResetTime.sort((a,b)->a.getRateLimitRemainingStatus().compareTo(b.getRateLimitRemainingStatus()));
		return getBestTokenToUseStatus(credentialsReamining.get(0), credentialsResetTime.get(credentialsResetTime.size() - 1));
	}
	
	private Credentials getBestTokenToUseStatus(Credentials bestReaming, Credentials bestReset) {
		Integer secondsToResetBestReaming = (int) (System.currentTimeMillis() / 1000 - bestReaming.getRateLimitResetStatus());
		float requestReminingPerSecond1 = (float) secondsToResetBestReaming / bestReaming.getRateLimitRemainingStatus();
		
		int secondsToResetBestReset = (int) (System.currentTimeMillis() / 1000 - bestReset.getRateLimitResetStatus());
		float requestReminingPerSecond2 = (float) secondsToResetBestReset / bestReset.getRateLimitRemainingStatus();
		
		if(requestReminingPerSecond1 < requestReminingPerSecond2) {
			return bestReset;
		}else {
			return bestReaming;
		}
	}
	
	public Credentials getBestTokenForUsers() {
		List<Credentials> credentialsReamining = credentialsService.findAll();
		List<Credentials> credentialsResetTime = credentialsReamining;
		credentialsReamining.sort((a,b)->a.getRateLimitRemainingUser().compareTo(b.getRateLimitRemainingUser()));
		credentialsResetTime.sort((a,b)->b.getRateLimitResetUser().compareTo(a.getRateLimitResetUser()));
		return getBestTokenToUseUser(credentialsReamining.get(0), credentialsResetTime.get(credentialsResetTime.size() -1 ));
	}
	
	private Credentials getBestTokenToUseUser(Credentials bestReaming, Credentials bestReset) {
		Integer secondsToResetBestReaming = (int) (System.currentTimeMillis() / 1000 - bestReaming.getRateLimitResetUser());
		float requestReminingPerSecond1 = (float) secondsToResetBestReaming / bestReaming.getRateLimitRemainingUser();
		
		Integer secondsToResetBestReset = (int) (System.currentTimeMillis() / 1000 - bestReset.getRateLimitResetUser());
		float requestReminingPerSecond2 = (float) secondsToResetBestReset / bestReset.getRateLimitRemainingUser();
		
		if(requestReminingPerSecond1 < requestReminingPerSecond2) {
			return bestReset;
		}else {
			return bestReaming;
		}
	}

	
	
}
