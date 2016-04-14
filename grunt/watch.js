(function(){
    "use strict";

    // Functions
    function watchGrunt(grunt, data) {
        var watch = {
            options: {
                atBegin: true,
                spawn: false
            },
            less: {
                files: ["<%= static.src %>/less/**/*.less"],
                tasks: ["less:dist"]
            },
            browserify: {
                files: ["<%= libs.src %>/**/*.js"],
                tasks: ["browserify:debug"]
            }
        };

        return watch;
    }

    // Exports
    module.exports = watchGrunt;

})();
