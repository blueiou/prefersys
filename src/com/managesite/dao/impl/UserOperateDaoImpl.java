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
public class UserOperateDaoImpl extends BaseDaoImpl<User>{
//添加新爆料,必须含有图片 ,也添加
public void addNews(String uid,String title,String des,String t_id,String[] imgs){
    String dateString=new MyDate().getYMDHMS();
    News news1=new News(title,des,dateString);
	User user=(User)super.getEntity(User.class,uid);
    NewsType type=super.getTypeEntity(NewsType.class,t_id);
    //添加默认标签
    NewsLabel label=super.getLabelEntity(NewsLabel.class,"5e4ba3e053b6e7a20153b6e7a6150001");
    news1.setType(type);	
    news1.setUser(user);
    news1.setLabels(label);
    //添加多张图片
    Set<NewsImg> imgs1=new HashSet<>();
    for (int i = 0; i < imgs.length; i++) {
    	NewsImg img=new NewsImg(imgs[i]);
    	news1.getImgs().add(img);//先在一的一方添加
    	img.setNews(news1);//再在多的一方添加一的一方
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
//传入新闻状态，用户id
public List<NewsModel> getNewsPageByUser(ReceiveData r){
	String hqlString="select new com.managesite.model.NewsModel(n.title,n.creatTime,n.newsstatu.status) from News n where n.newsstatu.status=? and n.user.userid=?";
	List<NewsModel> newslist=getHibernateTemplate().find(hqlString,r.statu,r.user_id);
    return newslist;
}
public void test(){
		System.out.println("test");
	}	
}
