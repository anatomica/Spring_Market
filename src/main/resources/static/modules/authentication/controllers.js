var contextPath = 'https://marketcook.herokuapp.com/market'

angular.module('Authentication')
    .controller('LoginController', function ($scope, $rootScope, $location, $http, $localStorage) {
        $scope.tryToAuth = function () {
            $scope.dataLoading = true;
            $http.post(contextPath + '/auth', $scope.user)
                .then(successCallback, errorCallback);
            function successCallback(response){
                if (response.data.token) {
                    $http.defaults.headers.common.Authorization = 'Bearer ' + response.data.token;
                    $localStorage.currentUser = { username: $scope.user.username, token: response.data.token };
                    $location.path('/');
                }
            }
            function errorCallback(response) {
                $scope.error = response.message;
                $scope.dataLoading = false;
                alert(JSON.stringify(response.data.message));
            }
        };

        $scope.tryToLogout = function () {
            delete $localStorage.currentUser;
            $http.defaults.headers.common.Authorization = '';
            $location.path('/logout');
        };
    });

// .controller('LoginController',
//     ['$scope', '$rootScope', '$location', 'AuthenticationService',
//     function ($scope, $rootScope, $location, AuthenticationService) {
//         // reset login status
//         AuthenticationService.ClearCredentials();
//
//         $scope.login = function () {
//             $scope.dataLoading = true;
//             AuthenticationService.Login($scope.username, $scope.password, function (response) {
//                 if (response.success) {
//                     AuthenticationService.SetCredentials($scope.username, $scope.password);
//                     $location.path('/');
//                 } else {
//                     $scope.error = response.message;
//                     $scope.dataLoading = false;
//                 }
//             });
//         };
//     }]);