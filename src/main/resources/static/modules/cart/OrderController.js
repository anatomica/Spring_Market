var contextPath = 'http://localhost:8189/market'
angular.module('Order', [])
    .controller('OrderController', function ($scope, $http, $location) {
        fillTable = function () {
            $http.get(contextPath + '/api/v1/cart')
                .then(function (response) {
                    $scope.CartList = response.data;
                });
        };

        fillTable();

        $scope.confirmOrder = function () {
            console.log($scope.userinfo.address);
            $http({
                url: contextPath + '/api/v1/orders/confirm',
                method: "POST",
                params: {address: $scope.userinfo.address, phone: $scope.userinfo.phone},
            }).then(function () {
                $location.path('/order_result');
            });
        }

    });