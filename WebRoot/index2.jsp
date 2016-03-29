
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@include file="menu.jsp" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html ng-app="IndexApp">
  <head>
    <base href="<%=basePath%>">
    <title>线下优惠网</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="./css/bootstrap.css" />
<link rel="stylesheet" href="./css/ct-paper.css" />
  </head>
  <body>
   <!-- Navigation -->
   <div ng-controller="CollapseDemoCtrl">
    <nav class="navbar navbar-inverse" role="navigation">
        <div class="container" >
            <div class="collapse navbar-collapse" id="">
                <ul class="nav navbar-nav">
                <li><a href="#">首页</a></li>
                    <li>
                        <a href="#">优惠精选</a>
                    </li>
                    <li>
                        <a href="#">发现</a>
                    </li>
                    <li>
                        <a href="#">联系我们</a>
                    </li>
                    <li>
                    <div >
	<button type="button" class="btn btn-default" ng-click="isCollapsed = !isCollapsed">现场爆料</button>
</div>
                    </li>
                </ul>
            </div>
            <!-- /.navbar-collapse -->
        
        </div>
        <!-- /.container -->
    </nav>
    <!-- 添加爆料 -->
        <div uib-collapse="isCollapsed">
		<div class="well well-lg">
		   <div class="row">
                        <div class="col-md-4 col-md-offset-4 col-sm-6 col-sm-offset-3 col-xs-10 col-xs-offset-1 ">
                            <div class="register-card">
                                <h3 class="title">Welcome</h3>
                                <form class="register-form" >
                                
                                    <label>店名</label>
                                    <input id="shopname" name="shopname"  type="text" class="form-control" placeholder="用户名">
                                   
                                     <label>类别</label>
                                    <input id="msgtype" name="msgtype"  type="password" class="form-control" placeholder="密码">
                                      <label>上传图片</label>
                                    <input id="shopimg" name="shopimg"  type="password" class="form-control" placeholder="密码">
                                    <label for="">优惠简介</label>
                                    <textarea rows="" cols="" class="form-control"></textarea>
                                    
                                </form>
                            </div>
                        </div>
                    </div>
		
		</div>
	</div> 
	<div class="container">
	<div class="row">
		<div class="col-lg-12">
			<h1 class="page-header">
			Page Text
			<small>Secondaty Text</small>
			</h1>
		</div>
	</div>
	<!-- 列举优惠信息 -->
	<div class="container">
	
	<div class="row">
		<div class="col-md-4">
		<a href="">
		<img src="http://placehold.it/700x300"" alt="" class="img-responsive" /></a>
		</div>
		<div class="col-md-5">
			<h3>新闻标题</h3>
			<p>标签：</p>
			<p>内容详情简介:</p>
			<a href="" class="btn btn-primary" style="float:right">查看详细<span class="glyphicon glyphicon-chevron-right"></span></a>
		</div>
		<div class="col-md-3" >
		<!-- 标签 -->
		<div class="well">
		<h6>最新发现</h6></div>
		<div class="well">
		<h6>标签分类</h6>
		</div>
		<div class="well">
		<h6>热门推荐</h6>
		</div>
		</div>
		
	</div>
	</div>
	</div> 
  </body>
   <!-- Angular -->
  <script src="./script/angularjs/angular.js"></script>
  <script src="./script/angularjs/angular-resource.js"></script>
  <script src="./script/angularjs/angular-animate.js"></script>
   <script src="./script/ui-bootstrap-tpls-1.1.1.js"></script>
  <!-- UI-Router -->
  <script src="./script/angularjs/angular-ui-router.js"></script>
  <!-- App Script -->
    <script src="./script/app/app.js"></script>
    <script src="./script/app/service.js"></script>
    <script src="./script/app/directive.js"></script>
    <script src="./script/app/filter.js"></script>
    <script src="./script/app/controller.js"></script>
    <!-- 其他 -->
<script src="./script/jquery1.8.js"></script>
<script src="./script/bootstrap.js"></script>
</html>
