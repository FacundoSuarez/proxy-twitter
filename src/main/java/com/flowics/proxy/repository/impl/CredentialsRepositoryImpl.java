package com.flowics.proxy.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.flowics.proxy.domain.Credentials;
import com.flowics.proxy.repository.CredentialsRepository;

@Repository
public class CredentialsRepositoryImpl implements CredentialsRepository{

	@Autowired
	private final MongoOperations mongoOperations;

	public CredentialsRepositoryImpl(MongoOperations mongoOperations) {
		Assert.notNull(mongoOperations);
		this.mongoOperations = mongoOperations;
	}
	
	public Optional<Credentials> findOne(String credentialsId) {
		Credentials d = this.mongoOperations.findOne(new Query(Criteria.where("_id").is(credentialsId)), Credentials.class);
        Optional<Credentials> credentials = Optional.ofNullable(d);
        return credentials;

    }

	@Override
	public Credentials saveCredentials(Credentials credentials) {
		this.mongoOperations.save(credentials);
        return findOne(credentials.getId()).get();
	}

	@Override
	public void updateCredentials(Credentials credentials) {
		this.mongoOperations.save(credentials);
	}
	
	@Override
	public List<Credentials> findAll(){
		return this.mongoOperations.findAll(Credentials.class);
	}

}
