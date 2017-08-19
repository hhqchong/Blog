package com.chong.service;

import java.util.List;

import com.chong.entity.PageBean;
import com.chong.entity.Reply;


public interface ReplyService {

	PageBean<Reply> findAllReply(int currPage);

	void delete(int id);

	List<Reply> findReply(int id);

	void save(Reply reply);


}
