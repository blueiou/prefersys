package com.managesite.dao;

import com.managesite.entity.Page;

public interface PagingDao {

	public Page getPageList();
/*
 *  @prama stamp 正在热映和预备上映 1：热映 0：预备上映
 */
	Page getPageList(int pageno, int pagesize,Class arg1,int stamp);

	
}
