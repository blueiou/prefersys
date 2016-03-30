package com.managesite.dao;

import java.util.List;

import com.managesite.entity.Page;
import com.managesite.entity.User;


public interface BaseDao<T> {

	public void saveEntity(T t);
	public void saveOrUpdateEntity(T t);
	public void updateEntity(T t);
	public void deleteEntity(T t);
	public T getEntity(T t);
	public T loadEntity(T t);
	public Page listPage(String hql1,String hql2,int pageno,int pagesize);
	Page listPage();
	public List<T> getlist();
	
}
