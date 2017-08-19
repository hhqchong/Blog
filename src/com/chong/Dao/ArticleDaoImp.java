package com.chong.Dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.chong.entity.Article;
@Repository  //数据访问组件，即为Dao组件
public class ArticleDaoImp implements ArticleDao {
	@Resource
	HibernateTemplate hibernateTemplate;
	/**
	 * 根据文章的id来查询文章
	 */
	public Article findById(int article_id) {
		// TODO Auto-generated method stub
		Article a = hibernateTemplate.get(Article.class, article_id);
		return a;
	}
    /**
     * 更新文章
     */
	public void update(Article article) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(article);
	}
    /**
     * 删除文章
     */
	public void delete(Article article) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(article);
	}
    /**
     * 添加文章
     */
	public void save(Article article) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(article);
	}

	/**
	 * 查询article的总数
	 */
	@SuppressWarnings("unchecked")
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Article"; // Hibernate语句
		// 访问数据库的方式与User实体类中的方式不同
		List<Long> list = (List<Long>)hibernateTemplate.find(hql);
		System.out.println("articleDaoImp.findCout()");
		if (list.size() > 0) {
			return list.get(0).intValue(); // 返回总数
		}
		return 0;
	}

	/**
	 * 根据begin，pageSize查询数据
	 */
	@SuppressWarnings("unchecked")
	public List<Article> findAll(int begin, int pageSize) {
		// TODO Auto-generated method stub
		// 使用该类来实现离线查询功能，很方便的得到查询结果，采用add()方法还可以增加查询约束
		DetachedCriteria criteria = DetachedCriteria.forClass(Article.class); // 创建该类实例
		// 查询分页数据，findByCriteria()方法提供许多条件的查询方式。
		List<Article> list = (List<Article>)hibernateTemplate.findByCriteria(
				criteria, begin, pageSize);
		System.out.println("articleDao.findAll()");
		return list;
	}

}
