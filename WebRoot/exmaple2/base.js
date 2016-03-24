'use strict';
var app=angular.module('indexapp',[]);
app.controller('ctrl.tree.basic', function ($scope) {
  var vm = $scope.vm = {};
 // vm.countries = CityData;
  vm.select = function(country, province, city) {
    vm.country = country;
    vm.province = province;
    vm.city = city;
  };
});