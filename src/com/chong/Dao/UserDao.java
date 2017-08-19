package com.chong.Dao;

import com.chong.entity.User;

public interface UserDao {
/*	public void deleted(User user);

	public void save(User user);

	public User query(User user);*/
	User login(User user);
	User findUser(int i);
	void updateUser(User user);
	void updateUserPassword(User user);
}
