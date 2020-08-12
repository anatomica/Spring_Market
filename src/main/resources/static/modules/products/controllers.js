angular.module('Products', [])

.controller('ProductsController', function($scope, $http) {
    fillTable = function() {
        // window.btoa("admin@gmail.com:100")
        $http.get("http://localhost:8189/market/api/v1/products")
            .then(function(response) {
                $scope.AllProducts = response.data;
            });
    };
    fillTable();
});