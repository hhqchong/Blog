package com.chong.Dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.chong.entity.Article;
@Repository  //���ݷ����������ΪDao���
public class ArticleDaoImp implements ArticleDao {
	@Resource
	HibernateTemplate hibernateTemplate;
	/**
	 * �������µ�id����ѯ����
	 */
	public Article findById(int article_id) {
		// TODO Auto-generated method stub
		Article a = hibernateTemplate.get(Article.class, article_id);
		return a;
	}
    /**
     * ��������
     */
	public void update(Article article) {
		// TODO Auto-generated method stub
		hibernateTemplate.update(article);
	}
    /**
     * ɾ������
     */
	public void delete(Article article) {
		// TODO Auto-generated method stub
		hibernateTemplate.delete(article);
	}
    /**
     * �������
     */
	public void save(Article article) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(article);
	}

	/**
	 * ��ѯarticle������
	 */
	@SuppressWarnings("unchecked")
	public int findCount() {
		// TODO Auto-generated method stub
		String hql = "select count(*) from Article"; // Hibernate���
		// �������ݿ�ķ�ʽ��Userʵ�����еķ�ʽ��ͬ
		List<Long> list = (List<Long>)hibernateTemplate.find(hql);
		System.out.println("articleDaoImp.findCout()");
		if (list.size() > 0) {
			return list.get(0).intValue(); // ��������
		}
		return 0;
	}

	/**
	 * ����begin��pageSize��ѯ����
	 */
	@SuppressWarnings("unchecked")
	public List<Article> findAll(int begin, int pageSize) {
		// TODO Auto-generated method stub
		// ʹ�ø�����ʵ�����߲�ѯ���ܣ��ܷ���ĵõ���ѯ���������add()�������������Ӳ�ѯԼ��
		DetachedCriteria criteria = DetachedCriteria.forClass(Article.class); // ��������ʵ��
		// ��ѯ��ҳ���ݣ�findByCriteria()�����ṩ��������Ĳ�ѯ��ʽ��
		List<Article> list = (List<Article>)hibernateTemplate.findByCriteria(
				criteria, begin, pageSize);
		System.out.println("articleDao.findAll()");
		return list;
	}

}
