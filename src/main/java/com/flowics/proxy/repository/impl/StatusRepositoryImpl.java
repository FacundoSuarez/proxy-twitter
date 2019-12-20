package com.flowics.proxy.repository.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;

import com.flowics.proxy.domain.StatusWithData;
import com.flowics.proxy.domain.twitter.Status;
import com.flowics.proxy.repository.StatusRepository;

@Repository
public class StatusRepositoryImpl implements StatusRepository {

	@Autowired
	private final MongoOperations mongoOperations;

	public StatusRepositoryImpl(MongoOperations mongoOperations) {
		Assert.notNull(mongoOperations);
		this.mongoOperations = mongoOperations;
	}
	
	public Optional<StatusWithData> findOne(String statusId) {
		StatusWithData d = this.mongoOperations.findOne(new Query(Criteria.where("_id").is(statusId)), StatusWithData.class);
        Optional<StatusWithData> status = Optional.ofNullable(d);
        return status;

    }

	@Override
	public StatusWithData saveStatus(StatusWithData status) {
		this.mongoOperations.save(status);
        return findOne(status.getId()).get();
	}

	@Override
	public void updateStatus(StatusWithData status) {
		this.mongoOperations.save(status);
	}


}
