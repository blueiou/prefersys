package com.managesite.dao;

import com.managesite.entity.Page;


public interface BaseDao<T> {

	public void saveEntity(T t);
	public void saveOrUpdateEntity(T t);
	public void updateEntity(T t);
	public void deleteEntity(T t);
	public T getEntity(T t);
	public T loadEntity(T t);
	public Page listPage(String hql1,String hql2,int pageno,int pagesize);
	Page listPage();
	
}
