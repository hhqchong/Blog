package com.chong.entity;

import java.sql.Date;
//��Ϊһ�ֳ־û��İ���ORM���õ�ORM��ܿ���ͨ�����Ԫ���ݱ�ǩ��ʹ��ʵ���������ݿ��еı���ӳ���ϵ��
import javax.persistence.*;  

import org.hibernate.annotations.Columns;
/**
 * ����
 * @author chongzi
 *
 */
@Entity
@Table(name="article")
public class Article {
     private int id;
     private String title;
     private String content;
     private Date pubDate;
     private ArticleType articletype;
     @Id  
     @GeneratedValue
     @Column(name = "id", nullable = false)  //���������ݿ��Ӧ������
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
  
    @Column(name = "title", nullable = false, length = 100)
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
    @Column(name = "content", nullable = false, length = 100)
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	 @Column(name = "pub_date", nullable = false)
	public Date getPubDate() {
		return pubDate;
	}
	public void setPubDate(Date pubDate) {
		this.pubDate = pubDate;
	}
	 @ManyToOne  //��ʾ���һ�Ĺ�ϵ���ܶ�ƪ���¿�����ͬһ�������
	 @JoinColumn(name = "articletype_id",referencedColumnName = "id")
	public ArticleType getArticletype() {
		return articletype;
	}
	public void setArticletype(ArticleType articletype) {
		this.articletype = articletype;
	}
     
}
