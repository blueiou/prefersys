package com.managesite.action;

import java.util.HashMap;
import java.util.Map;

import com.managesite.entity.Page;
import com.managesite.model.NewsModel;
import com.managesite.service.SysNewsService;
import com.managesite.tools.CacheClass;
import com.managesite.tools.Functions;

public class SysNewsManageAction extends AjaxActionSupport{
    private String new_id;//新闻ID
	private SysNewsService sNewsManage;
	private Map<String, Object> dataMap;
	private Page page;
 private static  int pagesize=5;
 
	public String getNew_id() {
	return new_id;
}

public void setNew_id(String new_id) {
	this.new_id = new_id;
}

	public Map<String, Object> getDataMap() {
		return dataMap;
	}

	public void setDataMap(Map<String, Object> dataMap) {
		this.dataMap = dataMap;
	}

	public SysNewsService getsNewsManage() {
		return sNewsManage;
	}

	public void setsNewsManage(SysNewsService sNewsManage) {
		this.sNewsManage = sNewsManage;
	}

	public String execute(){
		/*String mString=request.getParameter("m");
		int m=-1;
		if (CacheClass.isEmpty(mString)||!CacheClass.isNumValue(mString)) m=1510;
		else {
			m=Integer.parseInt(mString);
		}
		System.out.print("snews m的值为："+mString);
		switch (m) {
		case Functions.Admin_NEWSListInfo: //5041
			return newList();
		default:
			break;
		}*/
		return SUCCESS;
	}
	//获取普通新闻类型
	public String normal_label(){
		int  pageno=1;
		if (dataMap==null)  dataMap=new HashMap<String, Object>();
		String label_id=request.getParameter("key");
		if (label_id==null) {
			dataMap.put("data",sNewsManage.findNewsLabel());
			return SUCCESS;
		}
		else if (label_id!=null) {
			if (request.getParameter("pageno")!=null) {
				String pagenoString=request.getParameter("pageno");
				if(CacheClass.checkPage(pagenoString))  pageno=Integer.parseInt(pagenoString);
			}
			System.out.println(pageno);
			dataMap.put("data",sNewsManage.findNewsListByLabel(pageno, pagesize, 0, label_id));
			return SUCCESS;
		}
		return SUCCESS;
	}
	//获取普通新闻详细信息
	public String normal_new(){
		if (dataMap==null)  dataMap=new HashMap<String, Object>();
		if (CacheClass.isEmpty(new_id)) {
			return null;
		}
		else{
		NewsModel newsModel=sNewsManage.findNewsById(new_id);
			dataMap.put("data", newsModel);
			return SUCCESS;
		}
	}
	
/*	public String newList(){
		if (dataMap==null)  dataMap=new HashMap<String, Object>();
		int  pageno=1;
		int symbol=0;
		if (request.getParameter("pageno")!=null) {
			String pagenoString=request.getParameter("pageno");
			if(CacheClass.checkPage(pagenoString))  pageno=Integer.parseInt(pagenoString);
		}
		if (request.getParameter("symbol")!=null) {
			String symbol1=request.getParameter("pageno");
			if(CacheClass.checkPage(symbol1))  symbol=Integer.parseInt(symbol1);
		}
		page=sNewsManage.findNewsList(pageno, pagesize,symbol);
		System.out.println(symbol);
		dataMap.put("smvlist", page);
		dataMap.put("success", true);
		return SUCCESS;
	}*/
	
	
	public void test(){
		
	}
	
}
