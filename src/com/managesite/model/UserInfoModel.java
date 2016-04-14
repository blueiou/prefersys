package com.managesite.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import com.managesite.entity.Role;
import com.managesite.entity.UserInfo;

public class UserInfoModel {
	public  String email;
	public Date createDate;
	public String userid;  
	public String username;  
	public String password;  
	public UserInfo userInfo;
	public Set<String> userRole=new HashSet<>();
	
	public Set<String> getUserRole() {
		return userRole;
	}
	public void setUserRole(Set<String> userRole) {
		this.userRole = userRole;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public String getUserid() {
		return userid;
	}
	public void setUserid(String userid) {
		this.userid = userid;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public UserInfo getUserInfo() {
		return userInfo;
	}
	public void setUserInfo(UserInfo userInfo) {
		this.userInfo = userInfo;
	}
	public UserInfoModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public UserInfoModel(String email, String username) {
		super();
		this.email = email;
		this.username = username;
	}
	//登录信息模型
	public UserInfoModel(String userid) {
		super();
		this.userid = userid;
	}
	public UserInfoModel(String userid, Set<String> userRole) {
		super();
		this.userid = userid;
		this.userRole = userRole;
	}
	
	
}
