package com.chong.Dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.chong.entity.Demo;
import com.chong.entity.PageBean;
@Repository
public class FileUploadDaoImp implements
		FileUploadDao {
	@Resource
	HibernateTemplate hibernateTemplate;
	/**
	 * �ܼ�¼����
	 */
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Demo";
		List<Long> list = hibernateTemplate.find(hql);
		if (list.size() > 0)
			return list.get(0).intValue();
		else
			return 0;
	}

	/**
	 * ��ҳ��ѯ
	 */

	@SuppressWarnings("unchecked")
	public List<Demo> findAll(int begin, int pagesize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria.forClass(Demo.class);

		return hibernateTemplate.findByCriteria(criteria, begin,
				pagesize);
	}

	/**
	 * ����ͼƬ��Ϣ
	 */
	public void save(Demo demo) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(demo);
	}

	/**
	 * ����id��ѯdemo
	 */
	public Demo findById(int id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(Demo.class, id);
	}

	/**
	 * ɾ��demo
	 */
	public void delete(Demo demo) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(demo);
	}

	@SuppressWarnings("unchecked")
	public List<Demo> findAllDemo() {
		// TODO Auto-generated method stub
		String hql = "from Demo";
		return hibernateTemplate.find(hql);
	}

}
