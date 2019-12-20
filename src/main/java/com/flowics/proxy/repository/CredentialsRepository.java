package com.flowics.proxy.repository;

import java.util.List;
import java.util.Optional;

import com.flowics.proxy.domain.Credentials;

public interface CredentialsRepository {
	
	public Credentials saveCredentials(Credentials credentials);
	
	public void updateCredentials(Credentials credentials);

	public Optional<Credentials> findOne(String credentialsId);
	
	public List<Credentials> findAll();
}
