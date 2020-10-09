angular.module('Products', [])
    .controller('ProductsController', function($scope, $http, $location, $routeParams) {
        const advertsPath = contextPath + '/api/v1/products';

        if ($routeParams.p != null) {
            fillTable = function() {
                $http.get(advertsPath + '?p=' + $routeParams.p)
                    .then(function(response) {
                        $scope.AllProducts = response.data;
                    });
            };
            fillTable();
        }

        else {
            fillTable = function() {
                // window.btoa("admin@gmail.com:100")
                $http.get(advertsPath)
                    .then(function(response) {
                        $scope.AllProducts = response.data;
                    });
            };
            fillTable();
        }

        $scope.filterTable = function() {
            if ($scope.min_price == null) $scope.min_price = "";
            if ($scope.max_price == null) $scope.max_price = "";
            $http.get(advertsPath + '?min_price=' + $scope.min_price + '&max_price=' + $scope.max_price)
                .then(function(response) {
                    $scope.AllProducts = response.data;
                });
        };

        $scope.addToCartFunction = function(product) {
            $http({
                url: contextPath + '/api/v1/cart/add/' + product.id,
                method: "GET"
            }).then(function (response) {
                $location.path('/cart');
                console.log('added');
            });
        }

    });