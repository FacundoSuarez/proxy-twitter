package com.flowics.proxy.services;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import com.flowics.proxy.domain.Credentials;
import com.flowics.proxy.domain.dto.CredentialsDTO;

public interface CredentialsService {

	public void updateCredentials(MultivaluedMap<String, Object> headers, Credentials cred, String className);

	public CredentialsDTO createCredentials(CredentialsDTO credentials);
	
	public List<Credentials> findAll();
}
