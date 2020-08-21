// declare modules
angular.module('Authentication', []);
angular.module('addOrEditProduct', []);
angular.module('Products', []);
angular.module('Home', []);

angular.module('BasicHttpAuthExample', [
    'Authentication',
    'addOrEditProduct',
    'Products',
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
            controller: 'ProductsController',
            templateUrl: 'products'
        })

        .when('/products/add_or_edit_product', {
            controller: 'addOrEditProductCtrl',
            templateUrl: 'products/add_or_edit_product'
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

        .when('/about', {
            controller: 'HomeController',
            templateUrl: 'about'
        })

        .otherwise({
            redirectTo: '/login' }
        )
    ;
}])

.run(['$rootScope', '$location', '$cookies', '$http',
    function ($rootScope, $location, $cookies, $http) {
        // keep user logged in after page refresh
        $rootScope.globals = $cookies.get('globals') || {};
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
