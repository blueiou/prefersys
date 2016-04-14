   var indexapp = angular.module('IndexApp', ["ui.router",'ngAnimate', 'ui.bootstrap','mv.service','mv.filter','mv.controller','mv.directive']);
   indexapp.config(function($stateProvider, $urlRouterProvider) {
      // For any unmatched url, send to /route1
	   $urlRouterProvider.when("", "");
      $urlRouterProvider.otherwise("");
      $stateProvider
        //usermanage url
    //前台显示商品
    .state('index', {
	    url: '/ShowNewsIndex',
	    //templateUrl: './mtpls/newlist.html',
	    template:"<div  style='position:absolute;top:65px;left:5px;right:5px;bottom:5px; '><ul class='nav nav-tabs' style='margin-left: -5px; margin-right: -5px;'>  <li ><a ui-sref='usermanage.student'> 学生用户</a> </li> </ul></div>",
	    controller: ''
	})
	
	.state('detail',{
		url: '/{contactId:[0-9]{1,4}}',
	   /* templateUrl: './mtpls/newlist.html',*/
		template:"<div  style='position:absolute;top:65px;left:5px;right:5px;bottom:5px; '><ul class='nav nav-tabs' style='margin-left: -5px; margin-right: -5px;'>  <li ><a ui-sref='usermanage.student'> 学生用户</a> </li> </ul></div>",
		 //templateUrl: '/dayday/mtpls/newlist.html',
		 //controller: 'newslist'
		//controller:"chooseSeat",
	  /*  resolve:{
	    	msggg:function(){
	    		return "shenm";
	    	}
	    }*/
	})
	//显示在线选择座位
   });
var userapp=angular.module('UserApp',["ui.router",'ngAnimate', 'ui.bootstrap','mv.service','mv.filter','mv.controller']);
userapp.config(function($stateProvider, $urlRouterProvider){
	$urlRouterProvider.otherwise("/OrderIndex");
/*	$stateProvider.state('userorder', {
	    url: '/OrderIndex',
	    templateUrl: './mtpls/user/newlist.html',
	    controller: 'searchOrder'
	})*/
})

   
   