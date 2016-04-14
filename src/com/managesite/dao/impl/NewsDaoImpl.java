package com.managesite.dao.impl;

import java.util.List;

import com.managesite.entity.News;
import com.managesite.entity.Page;

public class NewsDaoImpl extends BaseDaoImpl<News>{
	//获取前台优惠信息
	public Page getPageList(int pageno ,int pagesize,int temp){
		Page p = null;
		System.out.println("使用Query分页");
		String hql1="select new com.managesite.model.NewsModel(n.new_id,n.title,n.user.username,n.descript,n.creatTime) from News n where n.newsstatu.status='"+temp+"'";
		String hql2="select count(*) from NewsStatus where status="+temp;
	p=super.listPage(hql1, hql2, pageno, pagesize);
	return p;
	}
	//前台获取详情
	public News getEntity(String n_id){
		return super.getEntity(News.class,n_id);
	}
	public List getUserComment(String n_id){
		return super.getHibernateTemplate().find("from UserComment uc where uc.news.new_id=?",n_id);
	}
	
}
