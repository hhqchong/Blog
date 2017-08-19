package com.chong.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


import com.chong.Dao.ReplyDao;
import com.chong.entity.PageBean;
import com.chong.entity.Reply;
@Service
public class ReplyServiceImp implements ReplyService {

	@Resource
	private ReplyDao replyDao;
	public PageBean<Reply> findAllReply(int currPage) {
		PageBean<Reply> pageBean = new PageBean<Reply>();
		// ��װ��ǰҳ��
		pageBean.setCurrPage(currPage);
		// ��װÿҳ��¼��
		int pageSize = 7;
		pageBean.setPageSize(pageSize);
		// ��װ�ܼ�¼��
		int totalCount = replyDao.findCount();
		pageBean.setTotalCount(totalCount);
		// ��װҳ��
		int totalPage;
		if (totalCount % pageSize == 0) {
			totalPage = totalCount / pageSize;
		} else {
			totalPage = totalCount / pageSize + 1;
		}
		pageBean.setTotalPage(totalPage);
		// ��װ��ǰҳ��¼
		int begin = (currPage - 1) * pageSize;
		List<Reply> list = replyDao.findAll(begin, pageSize);
		pageBean.setList(list);
		return pageBean;
	}

	public void delete(int id) {
		replyDao.delete(id);
		
	}

	public List<Reply> findReply(int id) {
		// TODO Auto-generated method stub
		return replyDao.findReply(id);
	}

	public void save(Reply reply) {
		// TODO Auto-generated method stub
		replyDao.save(reply);
	}

}
