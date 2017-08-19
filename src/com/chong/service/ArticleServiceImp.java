package com.chong.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chong.Dao.ArticleDao;
import com.chong.entity.Article;
import com.chong.entity.PageBean;

@Service
public class ArticleServiceImp implements ArticleService {
	@Resource
	private ArticleDao articleDao;
    /**
     * ��ҳ��ѯ����
     */
	public PageBean<Article> findAll(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Article> pageBean =new PageBean<Article>();
		//��װ��ǰҳ��
		 pageBean.setCurrPage(currPage);
		 //��װÿҳ��¼��
		 int pageSize =7;
		 pageBean.setPageSize(pageSize);
		 //��װ�ܼ�¼��
		 int totalCount =articleDao.findCount();
		 pageBean.setTotalCount(totalCount);
		 //��װҳ��
		 int totalPage;
		 if(totalCount%pageSize==0){  //������ʱ���պþ����Ǹ�ҳ��
			 totalPage =totalCount/pageSize;
		 }else{
			   totalPage=totalCount/pageSize+1;
		 }
		 pageBean.setTotalPage(totalPage);
		 //��װ��ǰҳ�ļ�¼
		 int  begin =(currPage-1)*pageSize;
		 List<Article> list =articleDao.findAll(begin, pageSize);
		 pageBean.setList(list);
		 return pageBean;
	}

	public Article findById(int article_id) {
		// TODO Auto-generated method stub

		return articleDao.findById(article_id);
	}

	public void update(Article article) {
		// TODO Auto-generated method stub
         articleDao.update(article);
	}

	public void delete(Article article) {
		// TODO Auto-generated method stub
       articleDao.delete(article);
	}

	public void save(Article article) {
		// TODO Auto-generated method stub
         articleDao.save(article);
	}

}
