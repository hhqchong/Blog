/**
 * 
 */
package com.chong.entity;

import javax.persistence.*;

/**
 * 文章的类型
 * @author chongzi
 *
 */
@Entity
@Table(name="articletype")
public class ArticleType {
	private int id;
	private String type;
	@Id
	@GeneratedValue
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	@Column(name="type",nullable = false,length = 30)
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
}
