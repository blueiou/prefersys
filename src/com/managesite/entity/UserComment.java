package com.managesite.entity;

import java.io.Serializable;
import java.util.Set;
public class UserComment implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 1073100192133955730L;
private int comment_id;
private String comment_content;
private String com_creatTime;
//与用户多对一
private User users;
//与优惠信息 多对一
private News news;


public String getCom_creatTime() {
	return com_creatTime;
}
public void setCom_creatTime(String com_creatTime) {
	this.com_creatTime = com_creatTime;
}
public User getUsers() {
	return users;
}
public News getNews() {
	return news;
}
public void setNews(News news) {
	this.news = news;
}
public void setUsers(User users) {
	this.users = users;
}


public int getComment_id() {
	return comment_id;
}
public void setComment_id(int comment_id) {
	this.comment_id = comment_id;
}
public String getComment_content() {
	return comment_content;
}

public void setComment_content(String comment_content) {
	this.comment_content = comment_content;
}

public UserComment() {
	super();
	// TODO Auto-generated constructor stub
}

	
	
}
