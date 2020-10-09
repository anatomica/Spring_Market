angular.module('addOrEditProduct', [])
    .controller('addOrEditProductCtrl', function ($scope, $http, $routeParams) {
        const advertsPath = contextPath + '/api/v1/products';

        if ($routeParams.id != null) {
            $http.get(advertsPath + '/' + $routeParams.id)
                .then(successCallback, errorCallback);
            function successCallback(response){
                console.log("Success--> " + JSON.stringify(response));
                $scope.productFromForm = response.data;
            } // if http code == 200
            function errorCallback(response){
                console.log("Error--> " + JSON.stringify(response));
                alert(JSON.stringify(response.data));
            } // if http code == 404
        }

        $scope.createOrUpdateProduct = function() {
            // window.btoa("admin@gmail.com:100")

            if($scope.productFromForm.id == null) {
                $http.post(contextPath + '/api/v1/products', $scope.productFromForm)
                    .then(function (response) {
                    console.log(response);
                    window.location.href = '/products';
                    window.location.reload(true);
                });
            } else {
                $http.put(contextPath + '/api/v1/products', $scope.productFromForm)
                    .then(function (response) {
                    console.log(response);
                    window.location.href = '/products';
                    window.location.reload(true);
                });
            }
        };
    });