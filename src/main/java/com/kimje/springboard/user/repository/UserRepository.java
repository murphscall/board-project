package com.kimje.springboard.user.repository;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.kimje.springboard.user.model.User;

@Mapper
public interface UserRepository {
	User findByEmail(String email);

	User findByProviderAndProviderId(@Param("provider") String provider, @Param("providerId") String providerId);

	void save (User user);
}
