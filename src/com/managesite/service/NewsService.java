package com.managesite.service;

import com.managesite.dao.impl.NewsDaoImpl;
import com.managesite.entity.Page;

public class NewsService {
   private NewsDaoImpl newsDaoImpl;
   private Page p;
	public NewsDaoImpl getNewsDaoImpl() {
	return newsDaoImpl;
}
public void setNewsDaoImpl(NewsDaoImpl newsDaoImpl) {
	this.newsDaoImpl = newsDaoImpl;
}
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
	
}
