package com.managesite.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;

import com.opensymphony.xwork2.ActionSupport;

public class AjaxActionSupport extends ActionSupport implements ServletRequestAware,ServletResponseAware,SessionAware{
protected HttpServletRequest request;
protected Map session;

	@Override
	public void setServletRequest(HttpServletRequest request) {
		
		this.request=request;
		
	}
protected HttpServletResponse response;
	@Override
	public void setServletResponse(HttpServletResponse response) {
		this.response=response;
		// TODO Auto-generated method stub
		
	}
	   public void setSession(Map session) {
	       this.session = session;
	    }

}
