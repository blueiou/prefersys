package com.managesite.entity;

import java.io.Serializable;

public class NewsStatus implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -1709195022696323474L;
	private String n_id;
	private int status;//审核状态
	private String person;//审核人员
	private String question;//原因
	private String veritime;
	//与新闻一对一
	private News news;
	
	public String getVeritime() {
		return veritime;
	}
	public void setVeritime(String veritime) {
		this.veritime = veritime;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public News getNews() {
		return news;
	}
	public void setNews(News news) {
		this.news = news;
	}
	public String getN_id() {
		return n_id;
	}
	public void setN_id(String n_id) {
		this.n_id = n_id;
	}
	public String getPerson() {
		return person;
	}
	public void setPerson(String person) {
		this.person = person;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public NewsStatus() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
