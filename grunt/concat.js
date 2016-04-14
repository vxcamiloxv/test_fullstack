(function(){
    "use strict";

    // Functions
    function concatGrunt(grunt, data) {
        var srcFiles = ["<%= libs.dist %>/build/<%= appName %>.js"],
            concat = {
                all: {
                    files: {
                        "<%= libs.dist %>/build/app.js": srcFiles
                    }
                },
                dist: {
                    files: "<%= concat.all.files %>"
                }
            };

        return concat;
    }

    // Exports
    module.exports = concatGrunt;
})();
