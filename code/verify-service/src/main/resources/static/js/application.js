// Angular Route
var app = angular.module("myApp", ['ngRoute']);

//App configuration
app.config(function ($routeProvider) {

  // Route
  $routeProvider
  .when("/", {
    templateUrl: "home.html"
  })
  .otherwise({
    redirectTo: '/'
  });

});