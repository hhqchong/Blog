package com.chong.Dao;

import javax.annotation.Resource;

import org.hibernate.*;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.chong.entity.User;

@Repository
public class UserDaoImplent {

	@Resource
	private SessionFactory sessionFactory;

	public void deleted(User user) {
		// TODO Auto-generated method stub
		System.out.print("hello!\n");
		Session s = sessionFactory.openSession();
		// hibernate��ORMӳ��SQL�������Ķ������еĶ��󣬽�ų���Ա��һ·�ó���Ա��˼����
		s.createQuery("delete User user where user.username=?")
				.setParameter(0, user.getUsername()).executeUpdate();
		System.out.print("deleted seccess!\n");
	}

	public void save(User user) {
		// TODO Auto-generated method stub
		System.out.print("hello2!\n");
		Session s = sessionFactory.getCurrentSession();
		s.save(user);
		System.out.print("save seccess!\n");
	}

	public User query(User user) {
		// TODO Auto-generated method stub
		System.out.print("hello3!\n");
		User u = null;
		Session s = sessionFactory.getCurrentSession();
		Transaction tx = null;
		try {
			tx = s.beginTransaction();
			// hibernate��ORMӳ��SQL�������Ķ������еĶ��󣬽�ų���Ա��һ·�ó���Ա��˼����
			u = (User) s.createQuery("from User user where user.username=?")
					.setParameter(0, user.getUsername()).uniqueResult();
			tx.commit();
		} catch (HibernateException e) {
			if (tx != null) {
				tx.rollback();
			}
			throw e;
		} finally {

			s.close();
		}
		return u;

	}
}
