package com.managesite.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

public  class Goods implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 2607137354064922704L;
	private String sysname;//影片名称
	private String  good_id;//影片ID
	private String descript;//影片详情
	private String type;//影片类型
	private int stamp;//正在上映或预备上映
	private String showtime;//上映时间
	private String uploadtime;
	private BaseInfo baseInfo;//影片基本信息
	
	private String playbillurl;//图片地址
	
	//与场次多对一   播放多场同一部电影
	private Set<Play> play;
	
	//private Set<UserInfo> userInfo;

	public String getPlaybillurl() {
		return playbillurl;
	}
	public void setPlaybillurl(String playbillurl) {
		this.playbillurl = playbillurl;
	}
	
	public Set<Play> getPlay() {
		return play;
	}
	public void setPlay(Set<Play> play) {
		this.play = play;
	}
	public BaseInfo getBaseInfo() {
		return baseInfo;
	}
	public void setBaseInfo(BaseInfo baseInfo) {
		this.baseInfo = baseInfo;
	}

	public String getGood_id() {
		return good_id;
	}
	public void setGood_id(String good_id) {
		this.good_id = good_id;
	}
	public String getUploadtime() {
		return uploadtime;
	}
	public void setUploadtime(String uploadtime) {
		this.uploadtime = uploadtime;
	}
	
	public String getShowtime() {
		return showtime;
	}
	public void setShowtime(String showtime) {
		this.showtime = showtime;
	}
	public int getStamp() {
		return stamp;
	}
	public void setStamp(int stamp) {
		this.stamp = stamp;
	}
	public String getSysname() {
		return sysname;
	}
	public void setSysname(String sysname) {
		this.sysname = sysname;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Goods() {
		super();
	}
	public Goods(String sysname, String good_id, String descript) {
		super();
		this.sysname = sysname;
		this.good_id = good_id;
		this.descript = descript;
	}
	
	
}
