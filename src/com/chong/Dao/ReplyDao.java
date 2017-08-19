package com.chong.Dao;

import java.util.List;

import com.chong.entity.Reply;


public interface ReplyDao {

	int findCount();

	List<Reply> findAll(int begin, int pageSize);

	void delete(int id);

	List<Reply> findReply(int id);

	void save(Reply reply);

}
