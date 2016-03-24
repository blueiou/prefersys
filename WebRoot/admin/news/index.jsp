<%@ page language="java" import="java.util.* ,com.managesite.tools.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<%@ taglib uri="/struts-tags"  prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title>管理首页</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<!-- <link rel="stylesheet" href="css/bootstrap.css" />
<link rel="stylesheet" type="text/css" href="./css/bootstrap.min.css"> -->
 <link rel="stylesheet" href="./css/font-awesome.min.css" />
   <link href="./css/bootstrap.min.css" rel="stylesheet"> 
  <link rel="stylesheet" href="./css/ct-paper.css" /> 
   <link rel="stylesheet" href="./treeview/example/style.css" />
    
  </head>
  <style type="text/css">
  form.tab-form-demo .tab-pane {
    margin: 10px 10px;
  }
</style>
  <body ng-app="IndexApp" >
   <div class="main">
   <div class="section">
   <div class="container tim-container">
  <div class="container" style="margin-top: 50px;">
        <div class="row">
         <div class="col-md-12">
          <input type="text" value="" id="clock" />
         </div>
        </div>         
                        <!-- 左侧 -->
                        <div class="row" style="margin-top: 40px;" ng-controller="MyController">
        <div class="col-md-2" >
        <div class="well">
        <h4>菜单管理</h4>
                    <div class="row" >
<div class="col-lg-12">
                            <ul class="list-unstyled" >
                              <tree-view tree-service="myService" node-label="name" item-class="pull-left" item-ng-include=""></tree-view>
                            </ul>
                        </div>
                    </div>
        </div>
        </div>
                        <div class="col-md-10" >
   <div class="well">
   <!-- 采用ui-router -->
       <!--  <h4>新闻标题</h4>
                    <div class="row" ui-view="">
                    </div> -->
                    <div ui-view=""></div>
                    <uib-tabset justified="true" >
                           <uib-tab heading="查看新闻" class="uib-tab ng-isolate-scope" >
                           <div style="margin-top:30px;" ng-controller="newslist">
                           <table class="table table-hover" >
                      <tr>
                      <th>标题</th>
                      <th>作者</th>
                      <th>内容</th>
                      <th>操作</th>
                      </tr>
                      <tr ng-repeat="o in list.goodlist">
                      <td>{{o.title}}</td>
                      <td>{{o.auth}}</td>
                      <td>{{o.descript}}</td>
                      <td><a ng-click="delnew(o)" href="">删除</a></td>
                      </tr>
                      </table>
                      {{list.rowcount}}
<uib-pagination ng-click="setPage(bigCurrentPage)" total-items="list.pagecount*10" ng-model="bigCurrentPage" max-size="maxSize" class="pagination-sm" boundary-link-numbers="true" rotate="false" num-pages="numPages"></uib-pagination>
    <pre>Page: {{bigCurrentPage}} / {{numPages}}</pre>
                           </div>
                           </uib-tab>
                           <uib-tab heading="增加新闻" class="">新闻</uib-tab>
</uib-tabset>
        </div>                     
</div>
        </div>
        </div>
         </div>
   </div>
   </div><!-- EDN container -->
 <div  ng-controller="MyController">
        <hr />
        <h1>树形结构菜单</h1>
<hr />

<p>
    Use buttons to interact with treeview<br />
    <a class="btn btn-default" ng-click="select()">Select First</a>
    <a class="btn btn-default" ng-click="unselect()">Unselect Selected</a>
</p>
<br />
<p>Selected node<br />
    {{myService.selectedNode.template}}</p><br />

<tree-view tree-service="myService" node-label="name" item-class="pull-left" item-ng-include=""></tree-view>
 </div>    
<hr />

    <script>
   function clock() {
	   document.getElementById("clock").value = new Date().toLocaleString();
   }
   setInterval("clock()",1000);
   var int=self.setInterval("clock()",1000);
    </script>
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
    
    <!-- other -->
<%--     <script type="text/javascript" src="./script/jquery.js"></script> --%>
    
    <script type="text/javascript" >
    
    </script>
</html>