
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link rel="stylesheet" href="./css/fileinput.css" media="all" type="text/css" />	
<style type="text/css">
.fileinput-button {
  position: relative;
  overflow: hidden;
  display: inline-block;
}
.fileinput-button input {
  position: absolute;
  top: 0;
  right: 0;
  margin: 0;
  opacity: 0;
  -ms-filter: 'alpha(opacity=0)';
  font-size: 200px !important;
  direction: ltr;
  cursor: pointer;
}
</style>
  </head>
  <body ng-controller="newsctrl">
   <!-- Navigation -->
   <div >
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
                         <form method="post" enctype="multipart/form-data"  action="api/userop/addNews" >         
                                    <label>店名:</label>
                                    <input id="shopname" name="shopname"  type="text" class="form-control" placeholder="标题">
                                    <label>类型:</label>
                                     <select name="n_type" id="n_type">
                                      
                                     <option value="1">家电数码</option>
                                     <option value="2">生活用品</option>
                                     </select><br />
                                      <label for="">优惠简介：</label>
                                    <textarea rows="" cols="" class="form-control" name="content"></textarea>
                                      <label class="">上传图片:</label>
                                      <span class="form-group">
                   <input id="vailimages" type="file" name="upload" multiple="multiple" multiple class="file" data-overwrite-initial="false" data-min-file-count="1"> 
                  <!-- <input id="file-1" type="file" multiple class="file" name="upload" data-overwrite-initial="false" data-min-file-count="2" > -->
             
       <!--  <input type="file" id="upload" name="upload" multiple="multiple"/> -->
        </span>
                <input type="submit" value="提交" />                   
                                </form>
                            </div>
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
	<div class="row">
	<div class="col-md-3"  >
		<!-- 标签 -->
		<div class="well">
		<h6>最新发现</h6>
		<p>sdfhsdf skdjksdhashdf kjshf</p>
		</div>
		<div class="well">
		<h6>标签分类</h6>
		<p>sdfhsdf skdjksdhashdf kjshf</p>
		</div>
		<div class="well">
		<h6>热门推荐</h6>
		<p>sdfhsdf skdjksdhashdf kjshf</p>
		</div>
		<div class="well">
		</div>
		<div class="well">
		<p> ，第88届奥斯卡颁奖典礼在美国洛杉矶杜比剧院结束。在《荒野猎人》中上演搏命演出的莱昂纳多·迪卡普里奥终于获得了学院的青睐，成为新科影帝。从1994年获得最佳男配角提名开始，历经22年的“陪跑”，小李子终于圆了“小金人”之梦。</p>
		</div>
		<div class="well">
		</div>
		</div>
	<div   ng-repeat="o in list.newslist">
		<div class="col-md-4" >
		<a href="">
		<img src="api/" alt="" class="img-responsive" /></a>
		</div>
		<div class="col-md-5">
			<h3>{{o.title}}</h3>
			<p>标签：</p>
			<p>内容详情简介:{{o.descript}}</p>
			<a href="" class="btn btn-primary" style="float:right">查看详细<span class="glyphicon glyphicon-chevron-right"></span></a>
		</div>
	</div>
	<center>
	<uib-pagination ng-click="setPage(bigCurrentPage)" total-items="list.pagecount*10" ng-model="bigCurrentPage" max-size="maxSize" class="pagination-sm" boundary-link-numbers="true" rotate="false" num-pages="numPages"></uib-pagination>
	</center>
	</div></div>
		
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
<script src="./script/fileinput.js"></script>
<script src="./script/fileinput_locale_zh.js"></script>
  <script type="text/javascript">
  $("#vailimages").fileinput({
      //uploadUrl: '#', // you must set a valid URL here else you will get an error
      allowedFileExtensions : ['jpg', 'png','gif','bmp'],
      overwriteInitial: false,
      maxFileSize: 3072,
      maxFilesNum: 10,
      allowedFileTypes: ['image'],
      slugCallback: function(filename) {
          return filename.replace('(', '_').replace(']', '_');
      }
	});

  </script>
</html>
