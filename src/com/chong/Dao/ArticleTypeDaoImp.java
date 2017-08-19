package com.chong.Dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.chong.entity.ArticleType;
@Repository
public class ArticleTypeDaoImp implements
		ArticleTypeDao {
	@Resource
	HibernateTemplate hibernateTemplate;
	/**
	 * �����������ͱ����Ϣ
	 */
	@SuppressWarnings("unchecked")
	public List<ArticleType> findAll() {
		// TODO Auto-generated method stub
		String hql = "from ArticleType";
		return (List<ArticleType>) hibernateTemplate.find(hql);
	}

	/**
	 * �ҵ���¼����
	 */
	@SuppressWarnings("unchecked")
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from ArticleType";
		List<Long> list = hibernateTemplate.find(hql);
		System.out.println("articletypeDao.findCount()");
		if (list.size() > 0)
			return list.get(0).intValue(); // ת����int
		else
			return 0;
	}

	public List<ArticleType> findAll(int begin, int pageSize) {
		// TODO Auto-generated method stub
		DetachedCriteria criteria = DetachedCriteria
				.forClass(ArticleType.class);
		@SuppressWarnings("unchecked")
		List<ArticleType> list = (List<ArticleType>) hibernateTemplate.findByCriteria(criteria, begin,
						pageSize);
		return list;
	}

	/**
	 * ͨ��id�鵽����
	 */
	public ArticleType findById(Integer id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(ArticleType.class, id);// �ײ��ǵ���Session
	}

	/**
	 * ������������
	 */
	public void update(ArticleType articletype) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(articletype);
	}

	/**
	 * ������������
	 */
	public void save(ArticleType at) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(at);
	}

	/**
	 * ɾ����������
	 */
	public void delete(ArticleType at) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(at);
	}

}
