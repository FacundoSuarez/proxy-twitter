package com.flowics.proxy.repository;

import java.util.Optional;

import com.flowics.proxy.domain.UserWithData;

public interface UserRepository {

	public UserWithData saveUser(UserWithData user);

	public void updateUser(UserWithData user);

	public Optional<UserWithData> findOne(String userId);

}
