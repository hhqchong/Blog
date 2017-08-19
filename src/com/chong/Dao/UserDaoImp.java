package com.chong.Dao;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.chong.entity.User;

@Repository
public class UserDaoImp implements UserDao {
	@Resource
	HibernateTemplate hibernateTemplate;
	/**
	 * 博客登入
	 */
	public User login(User user) {
		// TODO Auto-generated method stub
		String hql = "from User where username=? and password=?";
		@SuppressWarnings("unchecked")
		List<User> userList =  (List<User>) hibernateTemplate.find(hql,user.getUsername(),user.getPassword());
		if(userList.size()>0){
			// 查到数据返回第一个
			System.out.println(userList.get(0).getUsername()+"查找成功");
			return userList.get(0);
		}
		return null;
	}

	/**
	 * 查找用户,通过id查找
	 */
	public User findUser(int i) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(User.class, i);
	}

	/**
	 * 更新基本资料
	 */
	public void updateUser(User user) {
		// TODO Auto-generated method stub
         hibernateTemplate.update(user);
	}

	/**
	 * 更新密码，账号
	 */
	public void updateUserPassword(User user) {
		// TODO Auto-generated method stub
        User u =hibernateTemplate.get(User.class, user.getId());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        hibernateTemplate.update(u);
	}

}
