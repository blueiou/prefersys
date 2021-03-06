var app=angular.module('mv.controller',['ui.bootstrap', 'ui.router']);
//导航
app.controller('newsctrl', function ($scope,newsList) {
  $scope.isCollapsed = true;
  $scope.currentPage=1;
  $scope.msglist=function(){
newsList.query({pageno:$scope.currentPage},function(res){
				 $scope.list=res.msglist;
				 console.log($scope.list);
			});
  };
  $scope.setPage = function (pageNo) {
	    $scope.currentPage = pageNo;		     
	   $scope.msglist();			   
		   };
  $scope.msglist();
});
//用户登录操作
app.controller('userop',function($scope,useroper){
	$scope.code='';
	$scope.uname='';
	$scope.upass='';
	//登录
	$scope.login=function(){
		useroper.login({uname:$scope.uname,upass:$scope.upass,code:$scope.code},function(res){
			if(!res.success) alert(res.er_msg);
			if(res.success) window.location.href='index.jsp';
		})
		
	}
	
})
//********************影片管理
/*app.controller('showing',function ($scope,$interval,$http,$log,$uibModal,goodsList){
		//传入当前的页码到后台
	$scope.currentPage=1;
		   //在还没触发setPage()函数时候pageno=1
		  $http.get("smvlist.action").success( function(response) {
				  console.log(response);			                         		
				  $scope.smvlist = response.smvlist;				                       				                       
			                        //因为其是按照每页十条记录显示的，所以先取出总页数 再*10得到bigTotalItems
			  });
	     // var pageNo=$scope.currentPage;
		   $scope.search = function (){
			   goodsList.query({pageno:$scope.currentPage,m:"1510"},function(res){
			   $scope.smvlist=res.smvlist;
			   $scope.goodsDecri=$scope.smvlist.stulist;
			   
			   console.log(res);
		   });
		   };
		   $scope.setPage = function (pageNo) {
			    $scope.currentPage = pageNo;		     
			   $scope.search();			   
				   };
		   $scope.search();
//详情
		   $scope.animationsEnabled = true;
			  $scope.open = function(exmaple) {
			    var modalInstance = $uibModal.open({
			      animation: $scope.animationsEnabled,
			      templateUrl: './movies/baseInfo/goodsdescri.html',
			      controller: 'GoodsInstance',
			      size: 'lg',
			      resolve: {
			      exmaple: function() {
			          return exmaple;
			        }
			      }
			    });
			    modalInstance.result.then(function() {
			    }, function() {
			    	//$scope.search();
			      console.log("打印：");
			      //console.log(d);
			    });
			  };
			  $scope.toggleAnimation = function() {
			    $scope.animationsEnabled = !$scope.animationsEnabled;
			  };
});
app.controller('prepara',function ($scope,$interval,$http,goodsList){	
		$scope.search = function (){
			goodsList.query({pageno:$scope.currentPage,m:"1511"},function(res){
				   $scope.pmvlist=res.pmvlist;
			   });
			   };
			   //分页
		$scope.setPage = function (pageNo) {
				    $scope.currentPage = pageNo;		     
				   $scope.search();			   
					   };
			   $scope.search();
	   });*/
//商品详情页
app.controller('GoodsInstance', function($scope, $uibModalInstance,exmaple) {
var time=new Date();
	$scope.time=time;
	console.log("输出的时间"+time);
	  $scope.exmaple = exmaple;
	  console.log("商品ID:"+exmaple);	  
	  $scope.showtime='asd';
/*	 goodsList.query({m:"1520",id:exmaple},function(res){
		 // goodsList.query({m:"1520"},function(res){
		  console.log(res);
		  $scope.goodDescri=res.goodDescri;
	  });*/	 
	 //获取用户评价
/*	 usersListG.query({m:"10186",mid:exmaple},function(res){
 $scope.userissue=res.reply;
 console.log(res);
	 });*/
	  $scope.ok = function () {
		    $uibModalInstance.close($scope.selected.item);
		  };
		  $scope.cancel = function () {
		    $uibModalInstance.dismiss('cancel');
		  };
	});

//*****************用户管理
app.controller('ulogin',function($scope,$interval,$http,usersListG){
	$scope.login=function(){
		usersListG.query({uname:"",pass:""},function(res)
		{
			console.log("登录返回的结果");
			console.log(res);
		}
		
		);
	};
});
/*******************订单管理*/
//座位选择                                                                                              $interval
/*app.controller('chooseSeat', function ($scope,$http,$stateParams,tmList) {
	$scope.room="hao";
	$scope.time;
	$scope.playid=$stateParams.id;
	var room=$stateParams.room;
	var time=$stateParams.time.substring(0,19);
	$scope.price=$stateParams.price;
	console.log(room);
	console.log(time);
	 $scope.search = function (){
	tmList.query({m:"1710",room:room,playTime:time},function(res){
		$scope.rows = ['A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'];
	    $scope.cols = [1, 2, 3, 4, 5, 6, 7, 8];
	    // Set reserved and selected
	    var reserved = res.seat;//已出售，不可选
	    var selected = [];//
	    // seat onClick
	    $scope.seatClicked = function(seatPos) {
	        console.log("Selected Seat: " + seatPos);
	        var index = selected.indexOf(seatPos);
	        var removere=reserved.indexOf(seatPos);//若返回1 则说明选择到了该不可选的位置，那么selected则不可添加
	        console.log(removere);
	        if(index != -1) {
	            // seat already selected, remove
	            selected.splice(index, 1);
	        } else if(removere==-1){   //设置无法选择的座位
	            // new seat, push
	            selected.push(seatPos);
	        }
	    }
	    // get seat status
	    $scope.getStatus = function(seatPos) {
	        if(reserved.indexOf(seatPos) > -1) {
	            return 'reserved';
	        }
	        else if(selected.indexOf(seatPos) > -1) {
	            return 'selected';
	        }
	    };
	    // clear selected
	    $scope.clearSelected = function() {
	        selected = [];
	    }
	    // show selected
	    $scope.showSelected = function() {
	        if(selected.length > 0) {
	            alert("所选的座位为: \n" + selected);
	        } else {
	            alert("没有选择座位");
	        }
	    }
	    $scope.selected=selected;	
	});
	
	 }
	 $scope.search();
});*/
/******************管理员管理*/
app.controller('newslist',function($scope,$q,$interval,$http,$log,$uibModal,newsList){
	$scope.currentPage=1;
	$scope.newslist=function(){
		newsList.query({m:"5041",pageno:$scope.currentPage},function(res){
			
			 $scope.list=res.smvlist;
			 console.log($scope.list);
			 //删除某行记录
			 $scope.delnew=function(index){
				 var index=$scope.list.goodlist.indexOf(index);
				 $scope.list.goodlist.splice((index),1);
				 
				}
		})
	}
	 $scope.setPage = function (pageNo) {
		    $scope.currentPage = pageNo;		     
		   $scope.newslist();			   
			   };
	
	$scope.newslist();
});
//左侧、右侧查看新闻
app.controller('adminctr',  function($scope,$interval,$http,$log,$uibModal,TreeViewService,newsList) {
    var service = new TreeViewService;
    $scope.myService = service;

    //左侧列表
    $scope.myService.nodes = [
        {
            id:1,
            name: '用户管理',
            topname:'用户管理',
            nodename:'查看用户',
            children: [
                {
                    id: 1,
                    name: '查看用户',
                    nodename:'查看用户',
                    children: [],
                },{
                	id: 2,
                    name: '新增用户',
                    nodename:'新增用户',
                    children: []
                }
            ]
            
        },
        {
            id:22,
            name: '新闻管理',
           
            children: [{
            	id:11,
            	name:"全部新闻",
            	children:[]
            },{
            	id:22,
            	name:"未审核新闻",
            		children:[]
            }
           ,{
        	   id:3,
        	   name:"添加栏目",
        	   children:[]
           }
           ,{
        	   id:4,
        	   name:"添加标签",
        	   children:[]
           }
            
            ]
        }
    ];

    $scope.select = function() {
        service.selectedNode = service.nodes[0];
    };

    $scope.unselect = function() {
        service.selectedNode = undefined;
    }
    //右侧内容 
    $scope.newslist=function(){
		newsList.query({symbol:"0",pageno:$scope.currentPage},function(res){			
			 $scope.list=res.msglist;
			 console.log('没有记录？？');
			 console.log($scope.list);
			 //删除某行记录   因为是集合 所以传入一个对象 在所查询出来的数据中进行检索
			 $scope.delnew=function(index){
				 var index=$scope.list.newslist.indexOf(index);
				 $scope.list.newslist.splice((index),1);				 
				}
		})
	}
    $scope.setPage = function (pageNo) {
	    $scope.currentPage = pageNo;		     
	   $scope.newslist();			   
		   };
    $scope.newslist();
  //详情
	   $scope.animationsEnabled = true;
		  $scope.open = function(exmaple) {
			  console.log("输出值为：");
			  console.log(exmaple);
		    var modalInstance = $uibModal.open({
		      animation: $scope.animationsEnabled,
		      templateUrl: './mtpls/admin/updateNews.html',
		      controller: 'GoodsInstance',
		      size: 'lg',
		      resolve: {
		      exmaple: function() {
		          return exmaple;
		        }
		      }
		    });
		    modalInstance.result.then(function() {
		    }, function() {
		    	//$scope.search();
		      console.log("打印：");
		      //console.log(d);
		    });
		  };
		  $scope.toggleAnimation = function() {
		    $scope.animationsEnabled = !$scope.animationsEnabled;
		  };
});


