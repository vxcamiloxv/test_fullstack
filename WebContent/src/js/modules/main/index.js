/*global require */

// modules/main/index.js
//
// index function for main module
//
// 2016, Camilo Quimbayo

(function(){
    "use strict";

    var mainController = require("./mainController"),
        mainService = require("./mainService"),
        mainDirective = require("./mainDirective"),
        mainConfig = require("./mainConfig"),
        mainRun = require("./mainRun");

    function initApp(appData) {
        // Create core module and add dependencies
        window.angular.module("appMain", appData.modules);
        var appMain = window.angular.module("appMain");

        // Main Controller
        appMain.controller("MainController", mainController);

        // Main Services
        appMain.factory("$Main", mainService);

        // Directive
        appMain.directive("appLoginForm", mainDirective.loginForm);

        // Set config core module
        appMain.config(mainConfig);

        // When Run App!
        appMain.run(mainRun);

        appMain.constant("USER_ROLES", {
            guest: 0,
            admin: 1,
            user: 2,
            editor: 3
        });

        return appMain;
    }

    module.exports = {
        initApp: initApp
    };

})();
