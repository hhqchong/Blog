package com.chong.service;

import org.springframework.transaction.annotation.Transactional;

import com.chong.entity.User;

public interface UserService {

	User login(User user);

	User findUser(int i);

	void updateUser(User user);

	void updateUserPassword(User user);
}
