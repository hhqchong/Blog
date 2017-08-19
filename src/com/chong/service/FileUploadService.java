package com.chong.service;

import java.util.List;

import com.chong.entity.Demo;
import com.chong.entity.PageBean;

public interface FileUploadService {

	PageBean<Demo> findAll(int currPage);

	void save(Demo demo);

	Demo findById(int id);

	void delete(Demo demo);

	List<Demo> findAllDemo();
}
