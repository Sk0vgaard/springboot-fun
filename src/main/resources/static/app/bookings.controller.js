(function () {
  'use strict';

  angular
      .module('myApp', [])
      .controller('BookingsController', BookingsController);

  BookingsController.$inject = ['$http'];

  function BookingsController($http) {
    var vm = this;

    vm.bookings = [];
    vm.getAll = getAll;
    vm.getAffordable = getAffordable;
    vm.deleteBooking = deleteBooking;

    init();

    console.log('TESTING');

    function init(){
      getAll();
    }

    function getAll(){
      var url = "/bookings/all";
      var bookingsPromise = $http.get(url);
      bookingsPromise.then(function(response){
        vm.bookings = response.data;
      });
    }

    function getAffordable(){
      var url = "/bookings/affordable/" + 300;
      var bookingsPromise = $http.get(url);
      bookingsPromise.then(function(response){
        vm.bookings = response.data;
      });
    }

    function deleteBooking(id){
      var url = "/bookings/delete/" + id;
      $http.post(url).then(function(response){
        vm.bookings = response.data;
      });
    }
  }
})();
