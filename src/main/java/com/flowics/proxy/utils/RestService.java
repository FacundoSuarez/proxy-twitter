package com.flowics.proxy.utils;
import java.util.HashMap;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowics.proxy.domain.twitter.Token;

@Service
public class RestService {

	@Autowired
	private TokenTwitterBuilder tokenTwitterBuilder;

	public <T> Object getMethod(String URI, HashMap<String, String> headers, Class<T> className) {

		return null;
	}

	public <T> Object getMethod(String URI, Class<T> className) {

//		Token token = tokenTwitterBuilder.getToken();
		Client client = ClientBuilder.newClient();
		T response = client.target(URI).request().header("Authorization", "Bearer " + "AAAAAAAAAAAAAAAAAAAAADsPBQEAAAAAq0vjLGEK6NffslpBkBocyriupiA%3DDfZPQUeIFD28qPviiLS2xnux7l0xr4URtpCh4puv2oKt0IIzyq")
				.get(className);
		return response;
	}

}
