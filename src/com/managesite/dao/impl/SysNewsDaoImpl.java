package com.managesite.dao.impl;

import java.sql.SQLException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.HibernateTemplate;

import com.managesite.entity.Goods;
import com.managesite.entity.News;
import com.managesite.entity.NewsImg;
import com.managesite.entity.NewsLabel;
import com.managesite.entity.Page;
import com.managesite.model.NewsModel;

public class SysNewsDaoImpl<T> extends BaseDaoImpl<T>{
private HibernateTemplate hibernateTemplate;
public HibernateTemplate getHibernateTemplate() {
	return hibernateTemplate;
}
public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
	this.hibernateTemplate = hibernateTemplate;
}
//获取新闻类型
public List<NewsLabel> getNewsLabel(){
	List<NewsLabel> newsLabels=this.hibernateTemplate.find("select new com.managesite.model.NewsLabelModel(n.label_id,n.label) from NewsLabel n");
	return newsLabels;
}
/* 获取新闻类型下的某列新闻
 * @param stemp:新闻归类 0:未审核 1:审核不通过 2:审核成功
 */
public Page getPageList(int pageno ,int pagesize,int temp){
	Page p = null;
	System.out.println("使用Query分页");
	String hql1="select new com.managesite.model.NewsModel(n.new_id,n.title,n.user.username,n.descript,n.creatTime) from News n where n.newsstatu.status='"+"'";
	String hql2="select count(*) from NewsStatus where status="+temp;
p=super.listPage(hql1, hql2, pageno, pagesize);
	/*Query query=(Query) this.getHibernateTemplate().execute(new HibernateCallback<Object>(){
		@Override
		public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
			Query q=(Query) session.createQuery("select new com.managesite.model.NewsModel(n.new_id,n.title,n.user.username) from News n where n.labels.label_id='"+label_id+"' and n.symbol="+temp);
			return q;
		}
	}
	);
	query.setFirstResult((pageno - 1) * pagesize);
	query.setMaxResults(pagesize);
	int rowcount=getCount(temp,label_id);
	int pagecount = 0;
	if(rowcount%pagesize==0){
		pagecount=rowcount/pagesize;
	}
	else if(rowcount%pagesize!=0)
	{
		pagecount=rowcount/pagesize+1;
	}
	List slist=query.list();
	 if (p==null) 
		 {
		 p=new Page(pagecount,pageno, pagesize, slist,rowcount);
		 }*/
	return p;
}
//获取总行数
public  int getCount(int temp,String label_id){
	String hql = "select count(*) from News where symbol=? and label_id=?";
	  Long count = (Long)this.getHibernateTemplate().find(hql,temp,label_id).listIterator().next();
	  int ii = Integer.parseInt(String.valueOf(count)); 
	  return ii;
}
//根据新闻ID查询其详细信息
public NewsModel getNewsById(String id) {
	News news=(News) getForeignkey(News.class, id);
	NewsModel model=getNewsModel(news);
	return model;
}
public NewsModel getNewsModel(News news){
	NewsModel newsModel=new NewsModel();
	newsModel.setNew_id(news.getNew_id());
	newsModel.setTitle(news.getTitle());
	newsModel.setAuth(news.getUser().getUsername());
	//只取imgs的URL就好
	Set<NewsImg> imgs=news.getImgs();
	Set newsimg=new HashSet<>();
	for (NewsImg newsImg : imgs) {
		System.out.println(newsImg.getImgurl());
		newsimg.add(newsImg.getImgurl());
	}
	newsModel.setImgs(newsimg);
	return newsModel;
}


//获取缓存中的实体类信息
public Object getForeignkey(final Class arg,final String id){
	return this.getHibernateTemplate().execute(new HibernateCallback<Object>() {
		@Override
		public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
			// TODO Auto-generated method stub
			return session.get(arg,id);
		}
	});
}
public Session getSess(){
	Session session=this.getHibernateTemplate().getSessionFactory().getCurrentSession();
	return session;
}
public void delNews(String uid,String nid){
	/*String hqlString="delete from News ns where ns.user.userid=? and ns.ticket_id=?";
	 this.hibernateTemplate.bulkUpdate(hqlString,new String[]{uid,nid});*/
	
}
public List test(){
	Session session=this.getHibernateTemplate().getSessionFactory().getCurrentSession();
	
	List<News> news=this.hibernateTemplate.find("select n.title,nu.username,n.creatTime,n.descript,n.imgs from News n inner join n.user nu   where symbol=0");
	return news;
}
/*
 * @param stemp:新闻归类 0:普通用户 1:图片新闻 2:视频新闻
 
public Page getPageList(int pageno ,int pagesize,final int temp) {
	Page p = null;
	System.out.println("使用Query分页");
	Query query=this.getHibernateTemplate().execute(new HibernateCallback(){
		@Override
		public Object doInHibernate(Session session)
				throws HibernateException, SQLException {
			//Query q=(Query) session.createQuery("select new com.managesite.model.NewsModel(n.title,nu.username,n.creatTime,n.descript,n.getImgs().imgurl,n.getImgs().videourl) from News n inner join n.user nu where symbol="+temp);
			Query q=(Query) session.createQuery("select n.title,nu.username,n.creatTime,n.descript,n.imgs.imgurl from News n inner join n.user nu   where symbol="+temp);
			return q;
		}
	}
	);
	query.setFirstResult((pageno - 1) * pagesize);
	query.setMaxResults(pagesize);
	int rowcount=(Integer) criteria.setProjection(Projections.rowCount()).uniqueResult();
	criteria.setProjection(null);
	criteria.setFirstResult((pageno-1)*pagesize);
	criteria.setMaxResults(pagesize);
	
	criteria.add(Restrictions.eq("stamp", stamp));
	
	int rowcount=getCount(temp);
	System.out.println("总记录数"+rowcount);
	int pagecount = 0;
	if(rowcount%pagesize==0){
		pagecount=rowcount/pagesize;
	}
	else if(rowcount%pagesize!=0)
	{
		pagecount=rowcount/pagesize+1;
	}
	List slist=query.list();
	 if (p==null) 
		 {
		 p=new Page(pagecount,pageno, pagesize, slist,rowcount);
		 }
	return p;
}*/
}
