package com.managesite.entity;

import java.io.Serializable;
import java.util.Set;

public class UserComment implements Serializable{
private String comment_id;
private String comment_content;
private Set<User> users;

public String getComment_id() {
	return comment_id;
}

public void setComment_id(String comment_id) {
	this.comment_id = comment_id;
}

public String getComment_content() {
	return comment_content;
}

public void setComment_content(String comment_content) {
	this.comment_content = comment_content;
}

public Set<User> getUsers() {
	return users;
}

public void setUsers(Set<User> users) {
	this.users = users;
}

public UserComment() {
	super();
	// TODO Auto-generated constructor stub
}

	
	
}
