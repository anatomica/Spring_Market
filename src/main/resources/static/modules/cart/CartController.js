angular.module('Cart', [])
    .controller('CartController', function ($scope, $http, $location, $routeParams) {
        fillTable = function () {
            $http.get(contextPath + '/api/v1/cart')
                .then(function (response) {
                    $scope.CartList = response.data;
                });
        };

        fillTable();

        $scope.decrementProduct = function (productCart) {
            $http({
                url: contextPath + '/api/v1/cart/decrement/' + productCart.id,
                method: "GET"
            }).then(function (response) {
                $scope.CartList = response.data;
                $location.path('/cart');
                console.log('decrement');
            });
        }

        $scope.incrementProduct = function (productCart) {
            $http({
                url: contextPath + '/api/v1/cart/add/' + productCart.id,
                method: "GET"
            }).then(function (response) {
                $scope.CartList = response.data;
                $location.path('/cart');
                console.log('added');
            });
        }

        $scope.removeProduct = function (productCart) {
            $http({
                url: contextPath + '/api/v1/cart/remove/' + productCart.id,
                method: "GET"
            }).then(function (response) {
                $scope.CartList = response.data;
                $location.path('/cart');
                console.log('remove');
            });
        }

        $scope.createOrder = function () {
            $location.path('/order_info');
        }

    });