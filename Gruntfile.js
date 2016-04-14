(function(){
    "use strict";

    var ld = require("lodash"),
        loadGrunt = require("load-grunt-config"),
        timeGrunt = require("time-grunt");

    function gruntConfig(grunt){
        //Get time for optimizing build times
        timeGrunt(grunt);

        // run grunt config
        loadGrunt(grunt, {
            init: true,
            data: {
                appName: "<%= package.name %>-<%= ld.snakeCase(package.version) %>",
                libs: {
                    src: "WebContent/src/js",
                    dist: "WebContent/app/js"
                },
                static: {
                    src: "WebContent/src",
                    dist: "WebContent/app"
                },
                ld: ld,
                debug: false
            }
        });
    }

    // Exports
    module.exports = gruntConfig;
})();
