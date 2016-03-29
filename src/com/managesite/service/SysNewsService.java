package com.managesite.service;

import java.util.List;

import com.managesite.dao.impl.SysNewsDaoImpl;
import com.managesite.entity.IndexGoods;
import com.managesite.entity.News;
import com.managesite.entity.NewsLabel;
import com.managesite.entity.Page;
import com.managesite.model.NewsModel;
import com.managesite.model.PublicData;
import com.managesite.tools.CacheClass;
import com.managesite.tools.PulginsException;

public class SysNewsService {

	private SysNewsDaoImpl sysNewsDaoImpl;
	private Page p;
	public SysNewsDaoImpl getSysNewsDaoImpl() {
		return sysNewsDaoImpl;
	}

	public void setSysNewsDaoImpl(SysNewsDaoImpl sysNewsDaoImpl) {
		this.sysNewsDaoImpl = sysNewsDaoImpl;
	}
	
	public List findNewsLabel(){
		List<NewsLabel> newsLabels=sysNewsDaoImpl.getNewsLabel();
		if (newsLabels.size()==0) {
			new PulginsException("没有这类的新闻");
		}
		return newsLabels;
	}
	/**
	 * @author Administrator
	 * @param temp
	 */
	public Page findNewsListByLabel(int pageno,int pagesize,final int temp,final String label_id){
		if (p==null)  p=new Page();
		p=sysNewsDaoImpl.getPageList(pageno, pagesize,temp);
		int pagecount=p.getPagecount();
		if(pageno<=2||pageno>=pagecount) p.setPagelast(2);
		else p.setPagelast(pageno);
		if(pageno>=pagecount||pageno<0) p.setPageNext(pagecount-1);
		else p.setPageNext(pageno);
		if (pageno>pagecount) p.setPageno(pagecount);
		return p;
	}
/*	public NewsModel findNewsById(String id){
		NewsModel newsModel=sysNewsDaoImpl.getNewsById(id);
		if (CacheClass.isEmpty(id)||list.size()==0) {
			new PulginsException("该ID不存在");
		}
		else{
			NewsModel newsModel=list.get(0);
			return newsModel;
		}
		return null;
	}*/
	
	public void test(){
		System.out.println("SysNewsService");
	}
	
	/*public Page findNewsList(int pageno,int pagesize,final int temp){
	if (p==null)  p=new Page();
			p=sysNewsDaoImpl.getPageList(pageno, pagesize,temp);
			int pagecount=p.getPagecount();
			if(pageno<=2||pageno>=pagecount) p.setPagelast(2);
			else p.setPagelast(pageno);
			if(pageno>=pagecount||pageno<0) p.setPageNext(pagecount-1);
			else p.setPageNext(pageno);
			if (pageno>pagecount) p.setPageno(pagecount);
			return p;

		}*/
}
