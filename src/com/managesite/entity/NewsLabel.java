package com.managesite.entity;

import java.io.Serializable;
import java.util.Set;

public class NewsLabel implements Serializable{
/**
	 * 
	 */
	private static final long serialVersionUID = 3742158361978959498L;
private String label_id;
private String label;

private Set<News> news;

public Set<News> getNews() {
	return news;
}
public void setNews(Set<News> news) {
	this.news = news;
}
public String getLabel_id() {
	return label_id;
}
public void setLabel_id(String label_id) {
	this.label_id = label_id;
}
public String getLabel() {
	return label;
}
public void setLabel(String label) {
	this.label = label;
}
public NewsLabel() {
	super();
	// TODO Auto-generated constructor stub
}
public NewsLabel(String label) {
	super();
	this.label = label;
}
public NewsLabel(String label_id, String label) {
	super();
	this.label_id = label_id;
	this.label = label;
}

}
