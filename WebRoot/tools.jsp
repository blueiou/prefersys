<%@page import="com.managesite.tools.OperateTools"%>
<%@page import="org.json.JSONObject"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  <%!public String getIpAddr(HttpServletRequest request) { 
    String ip = request.getHeader("x-forwarded-for");    
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
        ip = request.getHeader("Proxy-Client-IP");    
    }    
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
        ip = request.getHeader("WL-Proxy-Client-IP");    
    }    
    if(ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {    
        ip = request.getRemoteAddr();    
    }    
    return ip;    
}%>
    <%
    OperateTools load=new OperateTools();
    String ip=getIpAddr(request);
    String url="http://api.map.baidu.com/location/ip?ak=F454f8a5efe5e577997931cc01de3974&ip=182.91.172.83";
    String json=OperateTools.loadJson(url);
    out.print(json);
    %>

  </head>
  
  <body>
  </body>
</html>
