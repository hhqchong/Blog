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
	 * 查找文章类型表的信息
	 */
	@SuppressWarnings("unchecked")
	public List<ArticleType> findAll() {
		// TODO Auto-generated method stub
		String hql = "from ArticleType";
		return (List<ArticleType>) hibernateTemplate.find(hql);
	}

	/**
	 * 找到记录条数
	 */
	@SuppressWarnings("unchecked")
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from ArticleType";
		List<Long> list = hibernateTemplate.find(hql);
		System.out.println("articletypeDao.findCount()");
		if (list.size() > 0)
			return list.get(0).intValue(); // 转化成int
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
	 * 通过id查到类型
	 */
	public ArticleType findById(Integer id) {
		// TODO Auto-generated method stub
		return hibernateTemplate.get(ArticleType.class, id);// 底层是调用Session
	}

	/**
	 * 更新文章类型
	 */
	public void update(ArticleType articletype) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(articletype);
	}

	/**
	 * 保存文章类型
	 */
	public void save(ArticleType at) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(at);
	}

	/**
	 * 删除文章类型
	 */
	public void delete(ArticleType at) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(at);
	}

}
