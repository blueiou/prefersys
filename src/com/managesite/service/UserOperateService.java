package com.managesite.service;

import java.util.List;

import com.managesite.dao.impl.UserOperateDaoImpl;
import com.managesite.model.NewsModel;
import com.managesite.model.UserInfoModel;
import com.managesite.tools.CacheClass;
import com.managesite.tools.PulginsException;
import com.managesite.tools.ReceiveData;

public class UserOperateService {
private UserOperateDaoImpl userOperateDaoImpl;

public UserOperateDaoImpl getUserOperateDaoImpl() {
	return userOperateDaoImpl;
}

public void setUserOperateDaoImpl(UserOperateDaoImpl userOperateDaoImpl) {
	this.userOperateDaoImpl = userOperateDaoImpl;
}

public void saveNews(String uid,String title,String des,String t_id,String[] imgs)
{
	if (CacheClass.isEmpty(uid)||CacheClass.isEmpty(title)||CacheClass.isEmpty(des)||CacheClass.isEmpty(t_id)
			||(imgs.length<=0)) 
	{
		return;
	}
	else {
		userOperateDaoImpl.addNews(uid, title, des, t_id, imgs);
	}
}

public List<NewsModel> findUnverifyOrVeriNews(ReceiveData r)
{
	List<NewsModel> newsModelList=null;
	if (CacheClass.isEmpty(r.user_id)||userOperateDaoImpl.getNewsPageByUser(r).size()==0)
	{
		return null;
	}
	else {
		newsModelList=userOperateDaoImpl.getNewsPageByUser(r);
	}
	return newsModelList;
}

}
