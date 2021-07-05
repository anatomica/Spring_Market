// declare modules
angular.module('Authentication', []);
angular.module('addOrEditProduct', []);
angular.module('Products', []);
angular.module('Order', []);
angular.module('getOrder', []);
angular.module('Cart', []);
angular.module('Home', []);

angular.module('BasicHttpAuthExample', [
    'Authentication',
    'addOrEditProduct',
    'Products',
    'Order',
    'getOrder',
    'Cart',
    'Home',
    'ngRoute',
    'ngCookies',
    'ngStorage'
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
            templateUrl: 'logouts'
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
            controller: 'CartController',
            templateUrl: 'cart'
        })

        .when('/order_info', {
            controller: 'OrderController',
            templateUrl: 'order_info'
        })

        .when('/order_result', {
            controller: 'CreatedOrder',
            templateUrl: 'order_result'
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
            redirectTo: 'home' }
        );
}])

.run(['$rootScope', '$location', '$cookies', '$http', '$localStorage',
    function ($rootScope, $location, $cookies, $http, $localStorage) {
        // keep user logged in after page refresh
        if ($localStorage.currentUser) {
            $http.defaults.headers.common.Authorization = 'Bearer ' + $localStorage.currentUser.token;
        }
        // $rootScope.globals = $cookies.get('globals') || {};
        // if ($rootScope.globals.currentUser) {
        //     $http.defaults.headers.common['Authorization'] = 'Basic ' + $rootScope.globals.currentUser.authdata;
        // }

        $rootScope.$on('$locationChangeStart', function (event, next, current) {
            // redirect to login page if not logged in
            if ($location.path() === '/logout' && !$localStorage.currentUser) {
                $location.path('/logout');
            }
            else if ($location.path() !== '/login' && !$localStorage.currentUser) {
                $location.path('/login');
            }
        });
    }]);
