// declare modules
angular.module('Authentication', []);
// angular.module('Products', []);
angular.module('Home', []);

angular.module('BasicHttpAuthExample', [
    'Authentication',
    // 'Products',
    'Home',
    'ngRoute',
    'ngCookies'
])

.config(['$routeProvider', function ($routeProvider) {

    $routeProvider
        .when('/', {
            controller: 'HomeController',
            templateUrl: 'home'
        })

        .when('/login', {
            controller: 'LoginController',
            templateUrl: 'login'
        })

        .when('/logout', {
            controller: 'LoginController',
            templateUrl: 'logout'
        })

        .when('/products', {
            controller: 'HomeController',
            templateUrl: 'products'
        })

        .when('/cart', {
            controller: 'HomeController',
            templateUrl: 'cart'
        })

        .when('/profile', {
            controller: 'HomeController',
            templateUrl: 'profile'
        })

        .when('/admin', {
            controller: 'HomeController',
            templateUrl: 'admin'
        })

        .otherwise({ redirectTo: '/login' });
}])

.run(['$rootScope', '$location', '$cookieStore', '$http',
    function ($rootScope, $location, $cookieStore, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookieStore.get('globals') || {};
        if ($rootScope.globals.currentUser) {
            $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata; // jshint ignore:line
        }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in
            if ($location.path() !== '/login' && !$rootScope.globals.currentUser) {
                $location.path('/login');
            }
        });
    }]);
