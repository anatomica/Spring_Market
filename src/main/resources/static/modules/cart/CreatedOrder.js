angular.module('getOrder', [])
    .controller('CreatedOrder', function ($scope, $http) {
        fillTable = function () {
            $http.get(contextPath + '/api/v1/orders')
                .then(function (response) {
                    console.log(response.data);
                    $scope.OrderList = response.data;
                });
        };

        fillTable();

    });