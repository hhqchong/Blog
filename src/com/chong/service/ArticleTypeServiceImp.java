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
     * ֱ�Ӳ�ѯ���������Ϣ
     */
	public List<ArticleType> findAllType() {
		// TODO Auto-generated method stub
		return articleTypeDao.findAll();
	}
    /**
     * ��ҳ��ѯ��Ϣ
     */
	@SuppressWarnings("unchecked")
	public PageBean<ArticleType> findAll(int currPage) {
		// TODO Auto-generated method stub
		//��װpageBean��Ϣ
		PageBean pageBean =new PageBean();
		//��ǰҳ
		pageBean.setCurrPage(currPage);
		//ÿҳ��¼��
		int pageSize =7;
		pageBean.setPageSize(pageSize);
		//�ܵļ�¼��
		pageBean.setTotalCount(articleTypeDao.findCount());
		//��ҳ��
		int totalCount=pageBean.getTotalCount();
	    pageBean.setTotalPage((int)Math.ceil(totalCount/pageSize));//ֱ�Ӳ�������ȡ���ķ�ʽ����ҳ��
        //ÿҳ��ʾ����
	    int begin = (currPage - 1) * pageSize;
	    pageBean.setList(articleTypeDao.findAll(currPage, pageSize));
	    return pageBean;
	}
   /**
    * ͨ��id��ѯ��Ϣ
    */
	public ArticleType findById(Integer id) {
		// TODO Auto-generated method stub
		return articleTypeDao.findById(id);
	}
    /**
     * ������������
     */
	public void update(ArticleType articletype) {
		// TODO Auto-generated method stub
		articleTypeDao.update(articletype);
	}
    /**
     * ������������
     */
	public void save(ArticleType at) {
		// TODO Auto-generated method stub
		articleTypeDao.save(at);
	}
    /**
     * ɾ����������
     */
	public void delete(ArticleType at) {
		// TODO Auto-generated method stub
		articleTypeDao.delete(at);
	}

}
