package com.chong.Dao;

import java.util.List;

import javax.annotation.Resource;

import org.hibernate.criterion.DetachedCriteria;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.chong.entity.Reply;
@Repository
public class ReplyDaoImp  implements ReplyDao {
	@Resource
	HibernateTemplate hibernateTemplate;
	public int findCount() {
		String hql = "select count(*) from Reply";
		@SuppressWarnings("unchecked")
		List<Long> list = (List<Long>) hibernateTemplate.find(hql);
		System.out.println("articleDao.findCount()");
		if(list.size()>0){
			return list.get(0).intValue();
		}
		return 0;
	}

	public List<Reply> findAll(int begin, int pageSize) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Reply.class);
		// 查询分页数据
		@SuppressWarnings("unchecked")
		List<Reply> list = (List<Reply>) hibernateTemplate.findByCriteria(criteria,begin,pageSize);
		System.out.println("ReplyDao.findAll()");
		return list;
	}

	public void delete(int id) {
		Reply a = hibernateTemplate.get(Reply.class, id);
		hibernateTemplate.delete(a);
	}

	public List<Reply> findReply(int id) {
		String hql ="from Reply where article_id=?";
		return (List<Reply>) hibernateTemplate.find(hql,id);
	}

	public void save(Reply reply) {
		// TODO Auto-generated method stub
		hibernateTemplate.save(reply);
	}

}
