package com.flowics.proxy.services.impl;

import java.util.List;

import javax.ws.rs.core.MultivaluedMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.flowics.proxy.domain.Credentials;
import com.flowics.proxy.domain.dto.CredentialsDTO;
import com.flowics.proxy.domain.twitter.Token;
import com.flowics.proxy.repository.CredentialsRepository;
import com.flowics.proxy.services.CredentialsService;
import com.flowics.proxy.utils.TokenTwitterBuilder;

@Service
public class CredentialsServiceImpl implements CredentialsService{
	
	@Autowired
	CredentialsRepository credentialsRepository;
	
	@Autowired TokenTwitterBuilder tokenTwitterBuilder;
	
	public CredentialsDTO createCredentials(CredentialsDTO credentialsDTO) {
		Token token = tokenTwitterBuilder.getToken(credentialsDTO.getAPI_key(), credentialsDTO.getAPI_secret_key());
		credentialsDTO.setToken(token.getAccess_token());
		Credentials result = new Credentials();
		result.setAPIkey(credentialsDTO.getAPI_key());
		result.setAPISecretKey(credentialsDTO.getAPI_secret_key());
		result.setToken(token);
		credentialsRepository.saveCredentials(result);
		return credentialsDTO;
		
	}

	@Override
	public List<Credentials> findAll() {
		return credentialsRepository.findAll();
	}
	
	@Override
	public void updateCredentials(MultivaluedMap<String, Object> headers, Credentials cred, String className) {
		if(className.contentEquals("User")) {
			cred.setRateLimitRemainingUser(Integer.valueOf((String) headers.get("x-rate-limit-remaining").get(0)));
			cred.setRateLimitResetUser(Long.valueOf((String) headers.get("x-rate-limit-reset").get(0)));
		}else if (className.contentEquals("Status")){
			cred.setRateLimitRemainingStatus(Integer.valueOf((String) headers.get("x-rate-limit-remaining").get(0)));
			cred.setRateLimitResetStatus(Long.valueOf((String) headers.get("x-rate-limit-reset").get(0)));
		}
		credentialsRepository.updateCredentials(cred);
	}
	
	@Override
	public boolean checkIfExist(CredentialsDTO credentialsDTO) {
		if(credentialsRepository.findOne(credentialsDTO.getAPI_key()).isPresent()) {
			return true;
		}
		return false;
	}

}
