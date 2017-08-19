package com.chong.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.chong.Dao.UserDao;
import com.chong.entity.User;
@Service
public class UserServiceImp implements UserService {
    @Resource
	private UserDao userdao;

	public User login(User user) {
		// TODO Auto-generated method stub
		return userdao.login(user);
	}

	public User findUser(int i) {
		// TODO Auto-generated method stub
		
		return userdao.findUser(i);
	}

	public void updateUser(User user) {
		// TODO Auto-generated method stub
		userdao.updateUser(user);
	}

	public void updateUserPassword(User user) {
		// TODO Auto-generated method stub
		  userdao.updateUserPassword(user);
	}


  
    
}
