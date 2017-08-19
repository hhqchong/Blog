package com.chong.service;

import com.chong.entity.Article;
import com.chong.entity.PageBean;

public interface ArticleService {
	PageBean<Article> findAll(Integer currPage);
	Article findById(int article_id); //ͨ��id��������
	void update(Article article);  //��������
	void delete(Article article);  //ɾ������
	void save(Article article);    //��������
}
