(function(){
    "use strict";

    // Functions
    function browserifyGrunt(grunt, data) {
        var browserify = {
            options: { // Global options
                watch: false,
                keepAlive: false
            },
            all: {
                files: ["<%= libs.src %>/app.js"]
            },
            debug: {
                files: {
                    "<%= libs.dist %>/app.min.js": "<%= browserify.all.files %>"
                }
            },
            dist: {
                files: {
                    "<%= libs.dist %>/build/<%= appName %>.js":
                    "<%= browserify.all.files %>"
                }
            }
        };

        return browserify;
    }

    // Exports
    module.exports = browserifyGrunt;
})();
