package com.managesite.interceptor;

import com.managesite.action.AjaxActionSupport;
import com.managesite.action.NewsAction;
import com.managesite.action.SysNewsManageAction;
import com.managesite.action.UserAction;
import com.managesite.dao.impl.SysNewsDaoImpl;
import com.opensymphony.xwork2.ActionInvocation;
import com.opensymphony.xwork2.interceptor.Interceptor;

public class LoginInterceptor implements Interceptor{
	@Override
	public void destroy() {
		// TODO Auto-generated method stub
	}
	@Override
	public void init() {
		// TODO Auto-generated method stub
	}
	@Override
	public String intercept(ActionInvocation invocation) throws Exception {
		// TODO Auto-generated method stub
		
AjaxActionSupport basetionActionSupport=(AjaxActionSupport) invocation.getAction();
if (basetionActionSupport instanceof UserAction 
	||basetionActionSupport instanceof NewsAction) {
		System.out.println("放行拦截");
		return invocation.invoke();
	}
		return  invocation.invoke();//放行 不拦截
	}

}
