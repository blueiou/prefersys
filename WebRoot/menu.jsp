<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!-- Bootstrap Core CSS -->
    <link href="<%=path %>/css/bootstrap.css" rel="stylesheet" /> 
   <link href="<%=path %>/css/bootstrap.min.css" rel="stylesheet"> 
    <!-- Custom CSS -->
     <!-- jQuery -->
<link rel="stylesheet" href="<%=path %>/css/ct-paper.css" />
    <!-- Bootstrap Core JavaScript -->
  
  <nav class="navbar-default navbar-static-top" role="navigation">
        <div class="container">
            <!-- Brand and toggle get grouped for better mobile display -->
          <!--   <div class="navbar-header" > -->
                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
            <div class=""></div>
            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav" style="float: right;     ">
                                     
      <% 
      String uname=(String)session.getAttribute("uname");
            		//out.print(uname);
            		session.setMaxInactiveInterval(900);
      if(session.getAttribute("uname")==null)
      {
      %>
                    <li >
                        <a href="user/login.jsp"  target="_blank">登陆</a>
                    </li >
                    <li>
                 <a href="#" target="">|</a>
                    </li>
                    <li>
                       <a href="register.jsp" target="_blank">注册</a>
                    </li>
                    <li >
                        <a href="login.jsp" target="_blank" onclick="alert('请登录')" class="glyphicon glyphicon-shopping-cart">个人中心</a>
                    </li>
                    
     <%} 
      else{ %>   
              <li>
                       <a><%=uname %>，欢迎您</a>
                    </li>
                    <li >
                        <a href="user/userinfo.jsp" target="" onclick="" class="glyphicon glyphicon-shopping-cart">个人中心</a>
                    </li> 
                    <li>
                       <a href="api/user/loginOut">退出</a>
                    </li> 
                    
                      <%} %>                                                         
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container -->
    </nav>

