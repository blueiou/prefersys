package com.managesite.action;
import java.util.HashMap;
import java.util.Map;

import com.managesite.entity.News;
import com.managesite.entity.Page;
import com.managesite.model.NewsModel;
import com.managesite.service.NewsService;
import com.managesite.service.SysNewsService;
import com.managesite.tools.CacheClass;
import com.managesite.tools.Functions;
public class NewsAction extends AjaxActionSupport{
	 private String new_id;//新闻ID
		private NewsService sNews;
		private NewsModel news;
		private Map<String, Object> dataMap;
		private Page page;
		private String m;
	 private static  int pagesize=4;
	 
		public NewsModel getNews() {
		return news;
	}
	public void setNews(NewsModel news) {
		this.news = news;
	}
		public String getM() {
		return m;
	}
	public void setM(String m) {
		this.m = m;
	}
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
		
		public NewsService getsNews() {
			return sNews;
		}
		public void setsNews(NewsService sNews) {
			this.sNews = sNews;
		}
		public String execute(){
			String mString=request.getParameter("m");
			int m=-1;
			if (CacheClass.isEmpty(mString)||!CacheClass.isNumValue(mString)) m=1510;
			else {
				m=Integer.parseInt(mString);
			}
			System.out.print("snews m的值为："+mString);
			switch (m) {
			case Functions.GET_GOODS_OPERATION_LIST0: //1510
				return newList();
			default:
				break;
			}
			return SUCCESS;
		}
		//获取普通新闻类型
		//获取已经审核新闻详细信息
	public String newList(){
			if (dataMap==null)  dataMap=new HashMap<String, Object>();
			int  pageno=1;
			int symbol=2;
			if (request.getParameter("pageno")!=null) {
				String pagenoString=request.getParameter("pageno");
				if(CacheClass.checkPage(pagenoString))  pageno=Integer.parseInt(pagenoString);
			}
			if (request.getParameter("symbol")!=null) {
				String symbol1=request.getParameter("pageno");
				if(CacheClass.checkPage(symbol1))  symbol=Integer.parseInt(symbol1);
			}
			page=sNews.findPageList(pageno,pagesize,symbol);
			System.out.println(pageno);
			dataMap.put("msglist", page);
			dataMap.put("success", true);
			return SUCCESS;
		}
	public String detail(){
		dataMap=new HashMap<>();
		String id=request.getParameter("p");
		news=sNews.findUnique(id);
		//dataMap.put("data", news);
		return "detail";
		
	}
	
	
		public void test(){
			
		}
		
}
