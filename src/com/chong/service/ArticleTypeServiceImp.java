package com.chong.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.chong.Dao.ArticleTypeDao;
import com.chong.entity.ArticleType;
import com.chong.entity.PageBean;
@Service
public class ArticleTypeServiceImp implements ArticleTypeService {
	@Resource
	private ArticleTypeDao articleTypeDao;
    /**
     * 直接查询表的所有信息
     */
	public List<ArticleType> findAllType() {
		// TODO Auto-generated method stub
		return articleTypeDao.findAll();
	}
    /**
     * 分页查询信息
     */
	@SuppressWarnings("unchecked")
	public PageBean<ArticleType> findAll(int currPage) {
		// TODO Auto-generated method stub
		//封装pageBean信息
		PageBean pageBean =new PageBean();
		//当前页
		pageBean.setCurrPage(currPage);
		//每页记录数
		int pageSize =7;
		pageBean.setPageSize(pageSize);
		//总的记录数
		pageBean.setTotalCount(articleTypeDao.findCount());
		//总页数
		int totalCount=pageBean.getTotalCount();
	    pageBean.setTotalPage((int)Math.ceil(totalCount/pageSize));//直接采用向上取整的方式设置页数
        //每页显示数据
	    int begin = (currPage - 1) * pageSize;
	    pageBean.setList(articleTypeDao.findAll(currPage, pageSize));
	    return pageBean;
	}
   /**
    * 通过id查询信息
    */
	public ArticleType findById(Integer id) {
		// TODO Auto-generated method stub
		return articleTypeDao.findById(id);
	}
    /**
     * 更新文章类型
     */
	public void update(ArticleType articletype) {
		// TODO Auto-generated method stub
		articleTypeDao.update(articletype);
	}
    /**
     * 保存文章类型
     */
	public void save(ArticleType at) {
		// TODO Auto-generated method stub
		articleTypeDao.save(at);
	}
    /**
     * 删除文章类型
     */
	public void delete(ArticleType at) {
		// TODO Auto-generated method stub
		articleTypeDao.delete(at);
	}

}
