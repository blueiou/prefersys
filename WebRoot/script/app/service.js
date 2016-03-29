var services = angular.module('mv.service', ['ngResource']);

services.factory('goodsList', ['$resource', function ($resource) {
    return $resource('allist.action', {}, {
        query: {
            method: 'GET',
            /*params:{pageno:"",m:"",id:"",playTime:""},*/
            isArray: false,
            url:'allist.action',
        },
        update:{
        	method:'POST',
        	params:{g_id:"",p_id:"",u_id:""},
        	isArray:false,
        }
    });
}]);
services.factory('newsList', ['$resource', function ($resource) {
    return $resource('api/news', {}, {
        query: {
            method: 'GET',
            isArray: false,
            url:'api/news/newList',
        },
        update:{
        	method:'POST',
        	//params:{g_id:"",p_id:"",u_id:""},
        	isArray:false,
        }
    });
}]);
services.factory('usersListG',['$resource',function($resource){
	return $resource('sysuserm.action/:uid/order/:oid',{uid:'402881845277b20f015277b210430001',oid:'2016022017160065'},{
		query:{
			method:'get',
			/*Params:{m:"",mid:"",uname:"",pass:""},*/
	        isArray:false,
	        url:'sysuserm.action',
		},
	  update:{
      	method:'POST',
      	isArray:false,
      	url:'sysuserm.action',
      }
	});
	
}]);

services.factory('TreeViewService', function () {
    function TreeViewService() {
        var that = this;
        this.nodes = [];
        this.selectedNode = undefined;
        this.collapsed = [];
        // will search all nodes for this node, and expand each parent node
        this.collapseTo = function(node) {
            function iterate(list) {
                for (var i = 0; i < list.length; i++) {
                    var found = false;
                    if (list[i] == node) {
                        found = true;
                    } else if (angular.isDefined(list[i].children)) {
                        found = iterate(list[i].children);
                    }

                    if (found == true) {
                        that.collapsed.push(list[i]);
                        return true;
                    }
                }

                return false;
            }

            iterate(that.nodes);
        };
    }

    return TreeViewService;
});

//票务管理
services.factory('tmList',['$resource',function($resource){
	return $resource('tm.action',{},{
		query:{
			method:'get',
			Params:{m:"",playTime:"",room:"",play_id:""},
	        isArray:false,
		}
	
	})
	
}]);
services.factory('smv',function($resource)
		
		{
			 var resource = $resource("smvlist.action?pageno=:pageno",
				      {
				        
				      },
				      {
				        // A custom method to update the picture of the person
				        updatePicture: {
				          method: "PUT",
				          isArray: false
				        }
				      }
				    );
			 resource.retrievePerson = function (pageno) {
			      return this.get(
			        {
			          pageno: pageno
			        });
			    };
			    return resource;
		}

		);
