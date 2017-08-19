package com.chong.service;

import com.chong.entity.Article;
import com.chong.entity.PageBean;

public interface ArticleService {
	PageBean<Article> findAll(Integer currPage);
	Article findById(int article_id); //通过id查找文章
	void update(Article article);  //更新文章
	void delete(Article article);  //删除文章
	void save(Article article);    //保存文章
}
