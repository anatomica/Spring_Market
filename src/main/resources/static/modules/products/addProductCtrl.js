angular.module('addProduct', [])
.controller('addProductCtrl', function($scope, $http) {
    $scope.submitAdd = function() {
        // window.btoa("admin@gmail.com:100")
        $http.post('http://localhost:8189/market/api/v1/products', $scope.product)
            .then(function(response) {
                console.log();
                $scope.Product.push(response.data);
            });
    };
});