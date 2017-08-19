package com.chong.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.chong.entity.ArticleType;
import com.chong.entity.PageBean;

public interface ArticleTypeService {
	List<ArticleType> findAllType();

	PageBean<ArticleType> findAll(int currPage);

	ArticleType findById(Integer id);

	void update(ArticleType articletype);

	void save(ArticleType at);

	void delete(ArticleType at);
}
