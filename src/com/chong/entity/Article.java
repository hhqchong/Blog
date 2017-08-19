package com.chong.entity;

import java.sql.Date;
//作为一种持久化的包，ORM中用到ORM框架可以通过这个元数据标签，使得实体类与数据库中的表建立映射关系。
import javax.persistence.*;  

import org.hibernate.annotations.Columns;
/**
 * 文章
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
     @Column(name = "id", nullable = false)  //定义与数据库对应的列名
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
	 @ManyToOne  //表示多对一的关系，很多篇文章可能是同一类的文章
	 @JoinColumn(name = "articletype_id",referencedColumnName = "id")
	public ArticleType getArticletype() {
		return articletype;
	}
	public void setArticletype(ArticleType articletype) {
		this.articletype = articletype;
	}
     
}
