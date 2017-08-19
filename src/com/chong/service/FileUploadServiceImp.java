package com.chong.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chong.Dao.FileUploadDao;
import com.chong.entity.Demo;
import com.chong.entity.PageBean;
@Service
public class FileUploadServiceImp implements FileUploadService {
	 @Resource
     FileUploadDao fileUpLoadDao;
	public PageBean<Demo> findAll(int currPage) {
		// TODO Auto-generated method stub
		PageBean<Demo> pageBean = new PageBean<Demo>();
		// 封装当前页数
		pageBean.setCurrPage(currPage);
		// 封装每页记录数
		int pageSize = 7;
		pageBean.setPageSize(pageSize);
		// 封装总记录数
		int totalCount = fileUpLoadDao.findCount();
		pageBean.setTotalCount(totalCount);
		// 封装页数
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		// 封装当前页记录
		int begin = (currPage - 1) * pageSize;
		List<Demo> list = fileUpLoadDao.findAll(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	public void save(Demo demo) {
		// TODO Auto-generated method stub
		fileUpLoadDao.save(demo);
	}

	public Demo findById(int id) {
		// TODO Auto-generated method stub
		return fileUpLoadDao.findById(id);
	}

	public void delete(Demo demo) {
		// TODO Auto-generated method stub
		fileUpLoadDao.delete(demo);
	}

	public List<Demo> findAllDemo() {
		// TODO Auto-generated method stub
		return fileUpLoadDao.findAllDemo();
    }

}
