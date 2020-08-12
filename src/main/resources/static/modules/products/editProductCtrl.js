angular.module('editProduct', [])
.controller('editProductCtrl', function($scope, $http) {
    $scope.submitEdit = function() {
        // window.btoa("admin@gmail.com:100")
        $http.put('http://localhost:8189/market/api/v1/products', $scope.product)
            .then(function(response) {
                console.log();
                $scope.Product.push(response.data);
            });
    };
});