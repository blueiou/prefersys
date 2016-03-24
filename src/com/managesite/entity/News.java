package com.managesite.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public class News implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 3370270384981039768L;

	private String new_id;
	private String title; //新闻标题
	private int symbol;//新闻标志
	private String descript; //新闻描述
	 private String creatTime;
	 
	//与类别多对一
	private NewsType type;
	//与用户多对1
	private User user;
	//与图片1对多
	private Set<NewsImg> imgs;
	//与新闻性质多对1
	private NewsLabel labels;
	
	public NewsLabel getLabels() {
		return labels;
	}
	public void setLabels(NewsLabel labels) {
		this.labels = labels;
	}
	public int getSymbol() {
		return symbol;
	}
	public void setSymbol(int symbol) {
		this.symbol = symbol;
	}
	public Set<NewsImg> getImgs() {
		return imgs;
	}
	public void setImgs(Set<NewsImg> imgs) {
		this.imgs = imgs;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	public NewsType getType() {
		return type;
	}
	public void setType(NewsType type) {
		this.type = type;
	}
	public String getNew_id() {
		return new_id;
	}
	public void setNew_id(String new_id) {
		this.new_id = new_id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public News() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}