package com.managesite.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class NewsType implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4435096488753019620L;
	
	private String type_id;
	private String type;
	
	private Set<News> news=new HashSet<>();
	
	public Set<News> getNews() {
		return news;
	}
	public void setNews(Set<News> news) {
		this.news = news;
	}
	public String getType_id() {
		return type_id;
	}
	public void setType_id(String type_id) {
		this.type_id = type_id;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public NewsType() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
