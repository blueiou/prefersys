package com.managesite.model;

import java.util.HashSet;
import java.util.Set;

import com.managesite.entity.NewsImg;

public class NewsModel {

	private String new_id;
	private String title; //新闻标题
	private String auth;
	
	
	private String descript; //新闻描述
	private String imagesurl; //新闻图片路径
	 private String creatTime;
	 private Set<NewsImg> imgs=new HashSet<>();
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
	public NewsModel(String title, String auth, String creatTime,String descript, Set<NewsImg> imgs) {
		super();
		this.title = title;
		this.auth = auth;
		this.creatTime = creatTime;
		this.descript = descript;
		this.imgs = imgs;
	}
	public NewsModel(String title, String auth, String creatTime,String descript) {
		super();
		this.title = title;
		this.auth = auth;
		this.creatTime = creatTime;
		this.descript = descript;
	}
	public NewsModel(String title, Set<NewsImg> imgs) {
		super();
		this.title = title;
		this.imgs = imgs;
	}
	public NewsModel(String new_id, String title, String auth) {
		super();
		this.new_id = new_id;
		this.title = title;
		this.auth = auth;
	}
	public NewsModel(String new_id, String title, String auth, Set<NewsImg> imgs) {
		super();
		this.new_id = new_id;
		this.title = title;
		this.auth = auth;
		this.imgs = imgs;
	}
	 
	
}
