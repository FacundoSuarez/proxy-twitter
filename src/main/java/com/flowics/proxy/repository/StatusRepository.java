package com.flowics.proxy.repository;

import java.util.Optional;

import com.flowics.proxy.domain.StatusWithData;

public interface StatusRepository {

	public StatusWithData saveStatus(StatusWithData status);

	public void updateStatus(StatusWithData status);
	
	public Optional<StatusWithData> findOne(String statusId);
}
