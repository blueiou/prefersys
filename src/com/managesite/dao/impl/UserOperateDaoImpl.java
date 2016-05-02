package com.managesite.dao.impl;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.managesite.entity.News;
import com.managesite.entity.NewsImg;
import com.managesite.entity.NewsLabel;
import com.managesite.entity.NewsStatus;
import com.managesite.entity.NewsType;
import com.managesite.entity.Page;
import com.managesite.entity.User;
import com.managesite.model.NewsModel;
import com.managesite.model.PublicData;
import com.managesite.tools.MyDate;
import com.managesite.tools.ReceiveData;
/**
 * 
 * @author Administrator
 *
 */
public class UserOperateDaoImpl extends BaseDaoImpl<User>{
//添加新爆料,必须含有图片 ,也添加
public void addNews(String uid,String title,String des,int t_id,String[] imgs){
    String dateString=new MyDate().getYMDHMS();
    News news1=new News(title,des,dateString);
	User user=(User)super.getEntity(User.class,uid);
    NewsType type=super.getTypeEntity(NewsType.class, t_id);
    /*NewsType type=new NewsType();
	type.setType("美式");*/
    //添加默认标签
    NewsLabel label=super.getLabelEntity(NewsLabel.class,"ff80808153b6b9d20153b6b9d5b60001");
   /* NewsLabel label=new NewsLabel();
    label.setLabel("实时");*/
   
    
    
    news1.setUser(user);
    news1.setLabels(label);
 /*   type.getNews().add(news1);*/
    
    news1.setType(type);
    //添加多张图片
    Set<NewsImg> imgs1=new HashSet<>();
    for (int i = 0; i < imgs.length; i++) {
    	NewsImg img=new NewsImg(imgs[i]);
    	news1.getImgs().add(img);//先在一的一方添加
    	img.setNews(news1);//再在多的一方添加一的一方
    	System.out.println(news1.getNew_id());
	}
    NewsStatus newsStatus=new NewsStatus();
    newsStatus.setStatus(0);
    newsStatus.setNews(news1);
    news1.setNewsstatu(newsStatus);
    this.getHibernateTemplate().save(news1);
    System.out.println("ok");
	}
//查看提交的爆料信息
/*public Page getNewsPageByUser(int pageno,int pagesize,String uid,String temp){
	
}*/
/**
 * ps:传入新闻状态，用户id
 * @param r 接收数据
 * @return
 */
public List<NewsModel> getNewsPageByUser(ReceiveData r){
	String hqlString="select new com.managesite.model.NewsModel(n.title,n.creatTime,n.newsstatu.status) from News n where n.newsstatu.status=? and n.user.userid=?";
	List<NewsModel> newslist=getHibernateTemplate().find(hqlString,r.statu,r.user_id);
    return newslist;
}
public void test(){
		System.out.println("test");
	}	
}
