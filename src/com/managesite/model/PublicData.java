package com.managesite.model;

import java.util.ArrayList;
import java.util.List;

import com.managesite.tools.CacheClass;



public class PublicData {

    public String name;//呢称
    public String sex;//性别，0为女性
	public String avatar;//头像
 
	private List<OrdersInfo> ordersInfo;
	
	private List<NewsModel> newsModels;
	
	public List<NewsModel> getNewsModels() {
		return newsModels;
	}


	public void setNewsModels(List<NewsModel> newsModels) {
		this.newsModels = newsModels;
	}


	public List<OrdersInfo> getOrdersInfo() {
		return ordersInfo;
	}


	public void setOrdersInfo(List<OrdersInfo> ordersInfo) {
		this.ordersInfo = ordersInfo;
	}


	public PublicData()
	{
	}


}
