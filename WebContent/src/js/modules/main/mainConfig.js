/*global module */

// modules/main/mainConfig.js
//
// main config to set providers and defined
// base routes
//
// 2016, Camilo QS

(function(){
    "use strict";


    mainConfig.$inject = [
        '$routeProvider',
        'USER_ROLES'
    ];
    function mainConfig($routeProvider, USER_ROLES) {
        // Routes defualt config
        $routeProvider.otherwise("/");

        $routeProvider.when("/", {
            templateUrl: "app/template/main.html",
            data: {
                title: "index",
                roles: [USER_ROLES.guest]
            }
        }).when("/login", {
            templateUrl: "app/template/login.html",
            data: {
                title: "login",
                roles: [USER_ROLES.guest]
            }
        });
    }


    // Exports
    module.exports = mainConfig;

})();
