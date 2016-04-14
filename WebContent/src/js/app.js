/*global require */

// app.js
//
// main function for app test fullstack
//
// 2016, Camilo Quimbayo

(function(){
    "use strict";

    // Dependencies
    var ld = require("lodash"),
        l10n = require("l10n"),
        angular = require("angular"),
        ngRoute = require("angular-route"),
        ngAnimate = require("angular-animate"),
        ngResource = require("angular-resource"),
        ngMessages = require("angular-messages"),
        ngSanitize = require("angular-sanitize"),
        appMain = require("./modules/main"),
        $$ = angular.element;

    // Init App
    appMain.initApp({
        modules: ["ngRoute", "ngResource", "ngMessages", "ngAnimate",
                  "ngLocale", "ngSanitize"]
    });

    // Bootstrap App!!
    document.webL10n.ready(function(){
        if(document.webL10n.getReadyState() === "interactive"){
            bootstrap();
        }
    });


    // Functions

    /**
     * @name bootstrap
     * @description run app when localization is loaded
     * @return {promise}
     */
    function bootstrap(){
        var initInjector = angular.injector(["ng"]),
            $q = initInjector.get("$q"),
            deferred = $q.defer();
        $$(document).ready(function(){
            onBootReady();
            deferred.resolve(false);
        });
        return deferred.promise;
    }


    /**
     * @name onBootReady
     * @description angular bootstrap
     */
    function onBootReady(){
        angular.bootstrap(document.body, ["appMain"],{
            strictDi: false //Strict DI Mode
        });
    }

    // Exports
    module.exports = {
        ld: ld,
        l10n: l10n,
        angular: angular,
        ngRoute: ngRoute,
        ngAnimate: ngAnimate,
        ngResource: ngResource,
        ngMessages: ngMessages,
        ngSanitize: ngSanitize,
        appMain: appMain,
        $$: $$
    };
})();
