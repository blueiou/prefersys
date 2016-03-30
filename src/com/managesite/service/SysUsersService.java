package com.managesite.service;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import com.managesite.dao.impl.SysUserDaoImpl;
import com.managesite.entity.Page;
import com.managesite.entity.Role;
import com.managesite.entity.User;
import com.managesite.model.OrdersInfo;
import com.managesite.model.PublicData;
import com.managesite.model.UserInfoModel;
import com.managesite.tools.CacheClass;
import com.managesite.tools.PulginsException;
public class SysUsersService {
	private SysUserDaoImpl sysUserDaoImpl;
	public SysUserDaoImpl getSysUserDaoImpl() {
		return sysUserDaoImpl;
	}
	public void setSysUserDaoImpl(SysUserDaoImpl sysUserDaoImpl) {
		this.sysUserDaoImpl = sysUserDaoImpl;
	}
	public List findByMid(String mid){
		if (CacheClass.isEmpty(mid)) return null;
		return sysUserDaoImpl.getContentById(mid);
		
	}
	public Page findUsers(int pageno,int pagesize){
		Page p=new Page();
	    p=sysUserDaoImpl.getUsers(pageno, pagesize,"");
		int pagecount=p.getPagecount();
		if(pageno<=2||pageno>=pagecount) p.setPagelast(2);
		else p.setPagelast(pageno);
		if(pageno>=pagecount||pageno<0) p.setPageNext(pagecount-1);
		else p.setPageNext(pageno);
		if (pageno>pagecount) p.setPageno(pagecount);
		return p;
	}
	public User findUserUnit(String na,String pa){
		if (CacheClass.isEmpty(na)||CacheClass.isEmpty(pa)) {
			new PulginsException("非法参数");
		}
		List<User> userlist=sysUserDaoImpl.uLogin(na, pa);//传入到数据处理层
		if (userlist.size()==0) {new PulginsException("没有该用户"); return null;}
		else {
			User user=userlist.get(0);
		/*Set<Role>	role=new HashSet<>();
		role=user.getRoles();
		Iterator iterator=role.iterator();// 获得一个迭代子
		Set<String> roleNameSet=new HashSet<>();//存放遍历出来名字
		while (iterator.hasNext()) {
			Role role2=(Role) iterator.next();
			//System.out.println(" "+role2.getRolename());
			roleNameSet.add(role2.getRolename());
		}
		if (roleNameSet.contains("generalUser")&&roleNameSet.contains("")) {
			return "user";
		}
		else if (roleNameSet.contains("")){}*/
			return user;
	}
		
}
	public PublicData findOrderInfo(String uid){
		PublicData publicData=null;
		
		if (!CacheClass.isEmpty(uid)) {
			publicData=new PublicData();
			List<OrdersInfo> list=sysUserDaoImpl.searchOrder(uid);
			if (list.size()>0) {
				publicData.setOrdersInfo(list);
				return publicData;
			}
		}
		else {
			new PulginsException("非法参数");return null;
		}
		return null;
	}
	public void delOrder(String uid,String oid){
		if (!CacheClass.isEmpty(uid)&&!CacheClass.isEmpty(oid)) {
			sysUserDaoImpl.del(uid, oid);
		}
		else {
			return;
		}
	}
	public void delUser(String uid){
		if (!CacheClass.isEmpty(uid)) {
			sysUserDaoImpl.del(uid);
		}
		else {
			return;
		}
	}
}
