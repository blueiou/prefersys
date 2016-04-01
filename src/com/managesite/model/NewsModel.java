package com.managesite.model;

import java.util.HashSet;
import java.util.Set;

import com.managesite.entity.NewsImg;

public class NewsModel {

	public String new_id;
	public String title; //新闻标题
	public String auth;  //爆料者
	public String writer;
	
	
	public String descript; //新闻描述
	public String imagesurl; //新闻图片路径
	 public String creatTime;
	 public Set<NewsImg> imgs=new HashSet<>();
	 
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
	 
	
}
