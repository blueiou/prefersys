package com.test;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.managesite.action.SysNewsManageAction;
import com.managesite.dao.SysTicketManageDao;
import com.managesite.dao.impl.SysGoodsDaoImpl;
import com.managesite.dao.impl.SysNewsDaoImpl;
import com.managesite.dao.impl.SysTicketDaoImpl;
import com.managesite.dao.impl.SysUserDaoImpl;
import com.managesite.entity.News;
import com.managesite.entity.NewsImg;
import com.managesite.entity.NewsLabel;
import com.managesite.entity.Page;
import com.managesite.entity.Play;
import com.managesite.entity.Role;
import com.managesite.entity.User;
import com.managesite.entity.UserInfo;
import com.managesite.model.NewsModel;
import com.managesite.model.OrdersInfo;
import com.managesite.model.PlayByMid;
import com.managesite.service.SysNewsService;
import com.managesite.service.SysTicketService;
//类中测试方法 已经注入到spring中的
public class TestApplication {
	public static void main(String args[]){
	ApplicationContext act=new ClassPathXmlApplicationContext("applicationContext.xml");
	/*SysGoodsDaoImpl sysGoodsDaoImpl=(SysGoodsDaoImpl) act.getBean("SysGoodsDaoImpl");
	SysTicketDaoImpl sysTicketDaoImpl=(SysTicketDaoImpl) act.getBean("SysTicketDaoImpl");
	SysTicketService sysTicketService=(SysTicketService) act.getBean("SysTicketBo");*/
	SysUserDaoImpl sysUserDaoImpl=(SysUserDaoImpl) act.getBean("SysUserDaoImpl");
	
	SysNewsDaoImpl sysNewsDaoImpl=(SysNewsDaoImpl) act.getBean("SysNewsDaoImpl");
	SysNewsService servic=(SysNewsService) act.getBean("SysNewsBo");
	SysNewsManageAction sysNewsManageAction=(SysNewsManageAction) act.getBean("SysNewsManageAction");
	Page page=sysUserDaoImpl.getUsers(1,2,"0");
	System.out.println("查找的总记录数为"+page.getRowcount());
	
	
	/*News news=sysNewsDaoImpl.getNewsById("402881835331481d015331481e870001");
	Set<NewsImg> imgs=news.getImgs();
	Set newsimg=new HashSet<>();
	for (NewsImg newsImg : imgs) {
		System.out.println(newsImg.getImgurl());
		newsimg.add(newsImg.getImgurl());
	}
	System.out.println(newsimg);*/
/*List<NewsModel> news =sysNewsDaoImpl.getNewsById("402881835331481d015331481e870001");
List list=new ArrayList<>();
NewsModel newsModel;
for (NewsModel news2 : news) {
	System.out.print(news2.getNew_id());
System.out.println(news2.getImgs());
	
}*/
/*NewsImg newsImg1=new NewsImg();
newsImg1.setImgurl("askdjlksjkd");
NewsImg newsImg2=new NewsImg();
newsImg2.setImgurl("222222222");
    Set<NewsImg> imgs=new HashSet<>();
	NewsModel model=new NewsModel("",null);
	System.out.println(model.getImgs());*/
	/*
	System.out.println(test1.contains("re"));
	}*/
	/*遍历显示hibernate返回的object[]*/
	 /*for (int i = 0; i < list.size(); i++) {
		 System.out.println(list[i]);
	}*/
	/*for (Object[] o : list) {
		System.out.println((String)o[0]);
		System.out.println(o[1]);
	}*/
/*List<OrdersInfo> list=sysUserDaoImpl.searchOrder();
	for (OrdersInfo info : list) {
		System.out.println(info.getStatue());
	}
	System.out.println();*/
/*sysNewsDaoImpl.test();
servic.test();*/
	}
	
	
	
}
