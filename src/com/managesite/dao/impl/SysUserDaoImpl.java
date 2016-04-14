package com.managesite.dao.impl;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.managesite.db.DbConnect;
import com.managesite.entity.Page;
import com.managesite.entity.Role;
import com.managesite.entity.User;
import com.managesite.model.OrdersInfo;
import com.managesite.model.UserInfoModel;
import com.managesite.tools.CacheClass;

import freemarker.cache.StringTemplateLoader;

public class SysUserDaoImpl extends BaseDaoImpl<User>{
private DbConnect dbConnect;
	private HibernateTemplate hibernateTemplate;
/*	public HibernateTemplate getHibernateTemplate() {
		return hibernateTemplate;
	}
	public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}*/
/*	public List uLogin(String na, String pa){
		  String f_name= "from User u where u.username=? and u.password=?";  
			List<User> userlist=getHibernateTemplate().find(f_name, new String[]{na,pa});
			if (userlist.size()==0) {System.out.println("没有查到到该用户");	return null;}
			else {User user=userlist.get(0);}
			return userlist;
	}*/
//判断用户登录	
public List<String> uLogin2(String na,String pa){
		String f_nameString="select u.userid from User u where u.username=? and u.password=?";
		List<String> userid=getHibernateTemplate().find(f_nameString,new String[]{na,pa});
		return userid;
	}
//查找用户角色
public UserInfoModel uLogin3(String u_id){
	String f_nameString="select rolename from roles r where roleid in (select roleid from user_role where userid=?)";
	Connection con=DbConnect.getConnection();
	PreparedStatement ps = null;
	ResultSet rs = null;
	UserInfoModel userInfoModel=null;
	Set<String> rolesString=new HashSet<>();
	try {
		ps=con.prepareStatement(f_nameString);
	    ps.setString(1,u_id);
	    rs=ps.executeQuery();
	    con.commit();
	    System.out.println(rs.next());
	    while (rs.next()) {
			System.out.println(rs.getString(1));
			rolesString.add(rs.getString(1));
		}
	  userInfoModel=new UserInfoModel(u_id,rolesString);
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally{
    DbConnect.closeConnection(rs, ps, con);
	}
	return userInfoModel;
}
	public Page getUsers(int pageno,int pagesize,String stemp){
		Page p=null;
		String hql1="select new com.managesite.model.UserInfoModel(n.email,n.username) from User n";
		String hql2="select count(*) from User";
		p=super.listPage(hql1,hql2,pageno,pagesize);
		return p;
	}
	public List<OrdersInfo> searchOrder(String uid){
		String hqlString="select new com.model.OrdersInfo(t.ticket_id,t.play.goods.sysname,t.play.play_time,t.statue) from Ticket t where t.user.userid=?";
		List<OrdersInfo> orderlList=getHibernateTemplate().find(hqlString,uid);
		return orderlList;
	}
	/*public Ticket tickets(String uid,String oid){
		
		String hqlString="select t.u_seat,t.currPrice";
	}*/
	/******************************UPDATE*/
	public void del(String uid,String oid){
	/*	String hqlString="delete from Ticket t where t.user.userid=? and t.ticket_id=?";
	 this.hibernateTemplate.bulkUpdate(hqlString,new String[]{uid,oid});*/
	}
	public void del(String uid){
		User user=(User)getSess().load(User.class, uid);
		getSess().delete(user);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	//查找用户对某影片的评论
/*	public List getContentById(String mid){
		//UserInfo userInfo=new UserInfo();
		List<SysGoodsData> list1=new ArrayList<>();
		 dbConnect=new DbConnect();
		  PreparedStatement psPreparedStatement=null;
		try {
			//psPreparedStatement = dbConnect.getPreparedStatemen("select distinct  content from uservgood where good_id=?");
			psPreparedStatement = dbConnect.getPreparedStatemen("select distinct  u.username,ug.content from uservgood ug,users u where ug.userid=u.userid and  good_id=?");
			psPreparedStatement.setString(1, mid);
			   ResultSet rsResultSet=psPreparedStatement.executeQuery();
			   while (rsResultSet.next()) {
				    SysGoodsData sysGoodsData=new SysGoodsData();
				    sysGoodsData.setName(rsResultSet.getString(1));
				    sysGoodsData.setMsg(rsResultSet.getString(2));
				    list1.add(sysGoodsData);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
			 dbConnect.closeconn();
		return list1;
	}*/
	
	
}
