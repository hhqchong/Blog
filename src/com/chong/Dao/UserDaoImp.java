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
	 * ���͵���
	 */
	public User login(User user) {
		// TODO Auto-generated method stub
		String hql = "from User where username=? and password=?";
		@SuppressWarnings("unchecked")
		List<User> userList =  (List<User>) hibernateTemplate.find(hql,user.getUsername(),user.getPassword());
		if(userList.size()>0){
			// �鵽���ݷ��ص�һ��
			System.out.println(userList.get(0).getUsername()+"���ҳɹ�");
			return userList.get(0);
		}
		return null;
	}

	/**
	 * �����û�,ͨ��id����
	 */
	public User findUser(int i) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(User.class, i);
	}

	/**
	 * ���»�������
	 */
	public void updateUser(User user) {
		// TODO Auto-generated method stub
         hibernateTemplate.update(user);
	}

	/**
	 * �������룬�˺�
	 */
	public void updateUserPassword(User user) {
		// TODO Auto-generated method stub
        User u =hibernateTemplate.get(User.class, user.getId());
        u.setUsername(user.getUsername());
        u.setPassword(user.getPassword());
        hibernateTemplate.update(u);
	}

}
