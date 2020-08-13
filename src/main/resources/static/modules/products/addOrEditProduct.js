var contextPath = 'http://localhost:8189/market'
angular.module('addOrEditProduct', [])
    .controller('addOrEditProductCtrl', function ($scope, $http, $routeParams) {
        const advertsPath = contextPath + '/api/v1/products';

        if ($routeParams.id != null) {
            $http.get(advertsPath + '/' + $routeParams.id).then(function (response) {
                $scope.productFromForm = response.data;
                console.log($scope.productFromForm);
            });
        }

        $scope.createOrUpdateProduct = function() {
            // window.btoa("admin@gmail.com:100")

            if($scope.productFromForm.id == null) {
                $http.post(contextPath + '/api/v1/products', $scope.productFromForm).then(function (response) {
                    console.log(response);
                    window.location.href = contextPath + '/#/products';
                    window.location.reload(true);
                });
            } else {
                $http.put(contextPath + '/api/v1/products', $scope.productFromForm).then(function (response) {
                    console.log(response);
                    window.location.href = contextPath + '/#/products';
                    window.location.reload(true);
                });
            }
        };
    });