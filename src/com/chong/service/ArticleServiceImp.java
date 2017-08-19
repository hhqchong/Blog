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
     * 分页查询文章
     */
	public PageBean<Article> findAll(Integer currPage) {
		// TODO Auto-generated method stub
		PageBean<Article> pageBean =new PageBean<Article>();
		//封装当前页数
		 pageBean.setCurrPage(currPage);
		 //封装每页记录数
		 int pageSize =7;
		 pageBean.setPageSize(pageSize);
		 //封装总记录数
		 int totalCount =articleDao.findCount();
		 pageBean.setTotalCount(totalCount);
		 //封装页数
		 int totalPage;
		 if(totalCount%pageSize==0){  //能整除时，刚好就是那个页数
			 totalPage =totalCount/pageSize;
		 }else{
			   totalPage=totalCount/pageSize+1;
		 }
		 pageBean.setTotalPage(totalPage);
		 //封装当前页的记录
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
