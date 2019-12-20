package com.flowics.proxy.repository.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.flowics.proxy.domain.UserWithData;
import com.flowics.proxy.repository.UserRepository;

@Repository
public class UserRepositoryImpl implements UserRepository{
	
	@Autowired
	private final MongoOperations mongoOperations;

	public UserRepositoryImpl(MongoOperations mongoOperations) {
		Assert.notNull(mongoOperations);
		this.mongoOperations = mongoOperations;
	}
	
	public Optional<UserWithData> findOne(String userId) {
		UserWithData d = this.mongoOperations.findOne(new Query(Criteria.where("user.screen_name").is(userId)), UserWithData.class);
        Optional<UserWithData> user = Optional.ofNullable(d);
        return user;

    }

	@Override
	public UserWithData saveUser(UserWithData user) {
		this.mongoOperations.save(user);
        return findOne(user.getId()).get();
	}

	@Override
	public void updateUser(UserWithData user) {
		this.mongoOperations.save(user);
	}

}
