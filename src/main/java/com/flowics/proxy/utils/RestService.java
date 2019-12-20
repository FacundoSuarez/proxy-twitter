package com.flowics.proxy.utils;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.core.Response;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.flowics.proxy.domain.Credentials;
import com.flowics.proxy.domain.twitter.Token;
import com.flowics.proxy.services.CredentialsService;

@Service
public class RestService {

	@Autowired
	private TokenTwitterBuilder tokenTwitterBuilder;
	
	@Autowired
	private CredentialsService credentialsService;
	
	@Value("${twitter.token}")
	private String token;
	
	public <T> Object getMethod(String URI, Class<T> className) throws Exception{
		Client client = ClientBuilder.newClient();
		Credentials cred = selectToken(URI, className);
		try {
			Response response = client.target(URI)
					.request()
					.header("Authorization", "Bearer "+ cred.getToken().getAccess_token())
					.get(Response.class);
			T objectt = className.newInstance();
			objectt	=   response.readEntity(className);
			updateCredentials(response.getHeaders(), cred, className.getSimpleName());
			return objectt;
		} catch (Exception e) {
			e.printStackTrace();
			throw new Exception(e.getMessage());
			//FIXME podria agarrar el numero de ID y no ir a consultar si se que no existe
		}
	}
	
	private <T> Credentials selectToken(String URI, Class<T> className) {
		Credentials cred = new Credentials();
		if(className.getSimpleName().equals("Status")) {
			cred = tokenTwitterBuilder.getBestTokenForStatus();
			token = cred.getToken().getAccess_token();
		} else if (className.getSimpleName().equals("User")) {
			cred = tokenTwitterBuilder.getBestTokenForUsers();
			token = cred.getToken().getAccess_token();
		}
		return cred;
	}
	
	private void updateCredentials(MultivaluedMap<String, Object> headers, Credentials cred, String className) {
		credentialsService.updateCredentials(headers, cred, className);
	}
	

}
