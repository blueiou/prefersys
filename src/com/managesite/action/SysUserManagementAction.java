package com.managesite.action;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpSession;

import com.managesite.entity.Role;
import com.managesite.entity.User;
import com.managesite.model.PublicData;
import com.managesite.service.SysGoodsService;
import com.managesite.service.SysUsersService;
import com.managesite.tools.CacheClass;
import com.managesite.tools.Functions;
public class SysUserManagementAction extends AjaxActionSupport{
	private SysUsersService sUser;
   private Object reply=null;
   private Map<String, Object> map;
   private  PublicData publicData;
   private final static int pageSize=5;
	public SysUsersService getsUser() {
	return sUser;
}
public void setsUser(SysUsersService sUser) {
	this.sUser = sUser;
}
public Map<String, Object> getMap() {
	return map;
}
public void setMap(Map<String, Object> map) {
	this.map = map;
}
	@Override
	public String execute() throws Exception {
		// TODO Auto-generated method stub
		String mS=request.getParameter("m");
		System.out.println(request.getParameter("m"));
		int m=-1;
		
		if (CacheClass.isEmpty(mS)||!CacheClass.checkId(mS)) {
			m=1510;
		} else {
			 m=Integer.parseInt(mS);
		}
		System.out.println("sys管理m的值："+m);
		switch (m) {
		case Functions.USERINFO_OPERATION_ISSUE: //用户评价
			return userIssue();
		case Functions.USERINFO_OPERATION_QUERY_ORDER://200查询订单
			return getOrders();
		case Functions.USERINFO_OPERATION_INDEX: //-1返回首页
			return getIndex();
		case Functions.USERINFO_OPERATION_DEL_ORDER: //250删除订单
			System.out.println("m");
			delOrder();
			break;
		case Functions.Admin_UserListInfo: //5001 管理员在后台获取用户列表
			return getUsers();
		case Functions.Admin_UserDisabled1: //禁止用户
			break;
		case Functions.Admin_UserDisabled0: //启用用户
		}
		return ERROR;
	}
	//查找用户
	private String getUsers() {
		System.out.println("进入查询用户信息");
		// TODO Auto-generated method stub
		map=new HashMap<String, Object>();
		int pageno=1;
		if (request.getParameter("pageno")!=null) {
			String pagenoString=request.getParameter("pageno");
			if(CacheClass.checkPage(pagenoString))  pageno=Integer.parseInt(pagenoString);
		}
		reply=sUser.findUsers(pageno, pageSize);
		map.put("users", reply);
		return SUCCESS;
	}
	//删除用户
	public void delUser(){
		String uid=request.getParameter("uid");
       sUser.delUser(uid);
	}
	
	public String  userIssue() {
		map=new HashMap<String, Object>();
		reply=sUser.findByMid(request.getParameter("mid"));
		map.put("reply", reply);
		return SUCCESS;
	}
	//查看用户个人订单
	public String getOrders(){
		map=new HashMap<String, Object>();
		HttpSession session=request.getSession();
		String uidString=(String) session.getAttribute("uid");
		if (!CacheClass.isEmpty(uidString)) {
			publicData=sUser.findOrderInfo(uidString);
			map.put("data", publicData);
			map.put("success", true);
			return SUCCESS;
		}
		else {
			map.put("data", null);
			map.put("success", false);
		}
		return SUCCESS;
	}
	/*//用户登录
	public String getUser(){
		System.out.println("进入登录");
		 HttpSession session=request.getSession();
			map=new HashMap<String, Object>();
			User user=sUser.findUserUnit(request.getParameter("uname"), request.getParameter("upass"));
			String code=request.getParameter("code");
			String sescode=(String)session.getAttribute("rand");
			if (code==null||sescode==null||!code.equals(sescode)) {
				System.out.println("验证码不正确");
				map.put("er_msg", "验证码不正确");
				map.put("success", false);
				return SUCCESS;
			}
			else {
				System.out.println("else");
				if (user==null) {
				map.put("user", null);
				map.put("er_msg", "用户不存在");
				map.put("success", false);
				return SUCCESS;
			}
				else if (user!=null) {
					System.out.println("user not null ");
					session.setAttribute("uid", user.getUserid());
					session.setAttribute("uname", user.getUsername());
					session.setAttribute("urole", user.getRoles());
					//session.setAttribute("urole", value);
					map.put("user", user);
					map.put("success", true);
					return SUCCESS;
				}
			}
		map.put("user","error");
			return SUCCESS;
	}*/
	public void delOrder(){
		HttpSession session=request.getSession();
		String uidString=(String) session.getAttribute("uid");
		String oidString=request.getParameter("oid");
		if (!CacheClass.isEmpty(uidString)&&!CacheClass.isEmpty(oidString)) {
			System.out.println("进入删除");
			sUser.delOrder(uidString, oidString);
		}
		
		else {
			return;
		}
	}
	public String getIndex(){
		return "uindex";
	}

	public String  testU(){
		/*  HttpSession session=request.getSession();
		map=new HashMap<String, Object>();
		User user=sUser.findUserUnit(request.getParameter("uname"), request.getParameter("upass"));
		
		if (user==null) {
			map.put("user", null);
			map.put("success", false);
			return SUCCESS;
		}
		else if (user!=null) {
			session.setAttribute("uid", user.getUserid());
			session.setAttribute("uname", user.getUsername());
			session.setAttribute("urole", user.getRoles());
			//session.setAttribute("urole", value);
			map.put("user", user);
			map.put("success", true);
			return SUCCESS;
		}*/
		return SUCCESS;
		/*Set<Role>	role=new HashSet<>();
		Set<String> roleNameSet=new HashSet<>();//存放遍历出来名字
		role=user.getRoles();
		Iterator iterator=role.iterator();// 获得一个迭代子
		while (iterator.hasNext()) {
			Role role2=(Role) iterator.next();
			System.out.println(" role2.getRolename()"+role2.getRolename());
			roleNameSet.add(role2.getRolename());
		}
		if (roleNameSet.contains("generalUser")&&!roleNameSet.contains("manager")&&!roleNameSet.contains("administrator")) {
			System.out.println("user");
			return "user";
		}
		else if (roleNameSet.contains("manager")&&!roleNameSet.contains("administrator")){
			System.out.println("manager");
			return "manager";
		}
        else if (roleNameSet.contains("manager")&&roleNameSet.contains("administrator")){
			
			return "choose";
		}
        else if (roleNameSet.contains("administrator")){
        	System.out.println("administrator");
			return "administrator";
		}*/
		//return ERROR;
	/*	switch (key) {
		case value:
			
			break;

		default:
			break;
		}*/
	//	return SUCCESS;
	}
}
