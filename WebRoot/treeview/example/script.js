var app = angular.module('app', ['ui.bootstrap', 'ui.bootstrap.treeview']);

app.controller('MyController', ['$scope', 'TreeViewService', function($scope, TreeViewService) {

    var service = new TreeViewService;

    $scope.myService = service;
    $scope.myService.nodes = [
        {
            id: 1,
            name: 'first',
            uiserf:'dayday',
            children: []
        },
        {
            id: 2,
            name: 'second',
            template:"<div  style='position:absolute;top:65px;left:5px;right:5px;bottom:5px; '><ul class='nav nav-tabs' style='margin-left: -5px; margin-right: -5px;'>  <li ><a ui-sref='usermanage.student'> 学生用户</a> </li> </ul></div>",
            children: [
                {
                    id: 10,
                    name: 'child of second',
                    children: [
                        {
                            id: 20,
                            name: 'grand child',
                            children: []
                        }
                    ]
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
}]);