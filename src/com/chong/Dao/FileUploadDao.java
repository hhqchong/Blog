package com.chong.Dao;

import java.util.List;

import com.chong.entity.Article;
import com.chong.entity.Demo;
import com.chong.entity.PageBean;

public interface FileUploadDao {
	int findCount();
	List<Demo> findAll(int begin,int pagesize);

	void save(Demo demo);

	Demo findById(int id);

	void delete(Demo demo);

	List<Demo> findAllDemo();
}
