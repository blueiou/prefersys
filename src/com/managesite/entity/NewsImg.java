package com.managesite.entity;

import java.io.Serializable;

public class NewsImg implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5643228106738211030L;
    
	private String img_id;
	private String imgurl;
	private String videourl;
	//一张图片只能对应一条新闻，一条新闻对应多张图片
	private News news;
	
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public String getImg_id() {
		return img_id;
	}
	public void setImg_id(String img_id) {
		this.img_id = img_id;
	}
	public String getImgurl() {
		return imgurl;
	}
	public void setImgurl(String imgurl) {
		this.imgurl = imgurl;
	}

	
	public String getVideourl() {
		return videourl;
	}
	public void setVideourl(String videourl) {
		this.videourl = videourl;
	}
	public NewsImg() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewsImg(String imgurl, String videourl) {
		super();
		this.imgurl = imgurl;
		this.videourl = videourl;
	}
	
}
