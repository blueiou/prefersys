package com.managesite.action;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.http.HttpSession;
import com.managesite.entity.User;
import com.managesite.model.PublicData;
import com.managesite.service.SysUsersService;
import com.managesite.tools.CacheClass;
import com.managesite.tools.Functions;
public class UserAction extends AjaxActionSupport{
	private SysUsersService loginUser;
	 private Object reply=null;
	   private Map<String, Object> map;
	   private  PublicData publicData;
	   private String uname;
	   private String upass;
	public String getUname() {
		return uname;
	}
	public void setUname(String uname) {
		this.uname = uname;
	}
	public String getUpass() {
		return upass;
	}
	public void setUpass(String upass) {
		this.upass = upass;
	}
	public Map<String, Object> getMap() {
		return map;
	}
	public void setMap(Map<String, Object> map) {
		this.map = map;
	}
	
	public SysUsersService getLoginUser() {
		return loginUser;
	}
	public void setLoginUser(SysUsersService loginUser) {
		this.loginUser = loginUser;
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
		switch (m) {
		case Functions.USERINFO_OPERATION_LOGIN: //150 用户登录
			return getUser();

		default:
			break;
		}
		return ERROR;
	}
	public String regUser(){
		System.out.println("用户注册");
		return SUCCESS;
		
	}
	public String getUser(){
		System.out.println("进入登录");
		 HttpSession session=request.getSession();
			map=new HashMap<String, Object>();
			User user=loginUser.findUserUnit(uname, upass);
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
					session.setAttribute("uname", uname);
					session.setAttribute("urole", user.getRoles());
					//session.setAttribute("urole", value);
					map.put("user", user);
					map.put("success", true);
					return SUCCESS;
				}
			}
		map.put("user","error");
			return SUCCESS;
	}
	
}
