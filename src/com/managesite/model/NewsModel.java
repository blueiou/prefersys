package com.managesite.model;

import java.util.HashSet;
import java.util.Set;

import com.managesite.entity.NewsImg;
import com.managesite.entity.UserComment;

public class NewsModel {
	private String new_id;
	private String title; //新闻标题
	private String auth;  //爆料者
	private String writer;
	private String descript; //新闻描述
	private String imagesurl; //新闻图片路径
	 private String creatTime; 
	 private Set<UserComment> userComments;
	 private int status; //新闻审核状态

	 public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public Set<NewsImg> imgs=new HashSet<>();
	 
	public Set<UserComment> getUserComments() {
		return userComments;
	}
	public void setUserComments(Set<UserComment> userComments) {
		this.userComments = userComments;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
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
	public String getAuth() {
		return auth;
	}
	public void setAuth(String auth) {
		this.auth = auth;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getImagesurl() {
		return imagesurl;
	}
	public void setImagesurl(String imagesurl) {
		this.imagesurl = imagesurl;
	}
	public String getCreatTime() {
		return creatTime;
	}
	public void setCreatTime(String creatTime) {
		this.creatTime = creatTime;
	}
	
	public Set<NewsImg> getImgs() {
		return imgs;
	}
	public void setImgs(Set<NewsImg> imgs) {
		this.imgs = imgs;
	}
	public NewsModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	//查看信息
	public NewsModel(String new_id, String title, String writer,
			String descript, String creatTime) {
		super();
		this.new_id = new_id;
		this.title = title;
		this.writer = writer;
		this.descript = descript;
		this.creatTime = creatTime;
	}
	 //用户查看审核状态
	public NewsModel(String title, String creatTime,
			int status) {
		super();
		this.title = title;
		this.creatTime = creatTime;
		this.status = status;
	}
	
	
}
