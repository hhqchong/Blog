package com.chong.entity;

import java.util.List;
/**
 * ҳ����,����ҳ��ʾ����
 *  ��ǰҳ����ÿҳ��¼�����ܼ�¼������ҳ����ÿҳ��ʾ����
 * @author chongzi
 *
 */
public class PageBean<T> {
    //��ǰҳ��
	 private int currPage;
	 //ÿҳ��ʾ����
	 private int pageSize;
	 //��ҳ��
	 private int totalPage;
	 //�ܼ�¼��
	 private int totalCount;
	 //ÿҳ��ʾ������
	 private List<T> list;
	public int getCurrPage() {
		return currPage;
	}
	public void setCurrPage(int currPage) {
		this.currPage = currPage;
	}
	public int getPageSize() {
		return pageSize;
	}
	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public List<T> getList() {
		return list;
	}
	public void setList(List<T> list) {
		this.list = list;
	}	
	 
}