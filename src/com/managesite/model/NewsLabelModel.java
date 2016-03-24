/**
 * 
 */
package com.managesite.model;

import java.io.Serializable;

/**
 * @author Administrator
 *
 */
public class NewsLabelModel implements Serializable{
	private String key;
	private String name;
	public String getKey() {
		return key;
	}
	public void setKey(String key) {
		this.key = key;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public NewsLabelModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public NewsLabelModel(String key, String name) {
		super();
		this.key = key;
		this.name = name;
	}
	
}
