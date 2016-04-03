package com.managesite.service;


import com.managesite.dao.impl.NewsDaoImpl;
import com.managesite.entity.News;
import com.managesite.entity.Page;
import com.managesite.model.NewsModel;
import com.managesite.model.PublicData;
import com.managesite.tools.CacheClass;

public class NewsService {
   private NewsDaoImpl newsDaoImpl;
   private Page p;
	public NewsDaoImpl getNewsDaoImpl() {
	return newsDaoImpl;
}
public void setNewsDaoImpl(NewsDaoImpl newsDaoImpl) {
	this.newsDaoImpl = newsDaoImpl;
}
//分页
	public Page findPageList(int pageno,int pagesize,int temp){
		if (p==null)  p=new Page();
	    p=newsDaoImpl.getPageList(pageno, pagesize,temp);
		int pagecount=p.getPagecount();
		if(pageno<=2||pageno>=pagecount) p.setPagelast(2);
		else p.setPagelast(pageno);
		if(pageno>=pagecount||pageno<0) p.setPageNext(pagecount-1);
		else p.setPageNext(pageno);
		if (pageno>pagecount) p.setPageno(pagecount);
		return p;
	}
public NewsModel findUnique(String idString){
	PublicData publicData;
	NewsModel newsModel = new NewsModel();
	if (CacheClass.isEmpty(idString)) {
		return null;
	}
	else {
		News news=newsDaoImpl.getEntity(idString);
	if(news!=null){
		newsModel.setTitle(news.getTitle());
		newsModel.setAuth(news.getUser().getUsername());
		newsModel.setCreatTime(news.getCreatTime());
		System.out.println("用户评价"+news.getU_comment().size());
		System.out.println("图片"+news.getImgs().size());
		
		if (!news.getU_comment().isEmpty()) {
			newsModel.setUserComments(news.getU_comment());
		}
		
		return	newsModel;
	}	
	return null;
	}
}
}
