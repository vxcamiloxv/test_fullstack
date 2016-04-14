(function() {
    "use strict";

    // Functions
    function jshintGrunt(grunt, data) {
        var jshint = {
            options: {
                jshintrc: true
            },
            all: ["Gruntfile.js", "libs.src/**/*.js", "test/**/*.js"]
        };
        return jshint;
    }

    // Exports
    module.exports = jshintGrunt;
})();
