(function(){
    "use strict";

    // Functions
    function uglifyGrunt(grunt, data) {
        var isDebug = data.debug,
            uglify = {
                options: {
                    banner: "/*! <%= package.name %> v<%= package.version %> - <%= package.author %> - " +
                        "<%= grunt.template.today('yyyy-mm-dd') %> */"
                },
                all: {
                    files: [{
                        expand: true,
                        cwd:  "<%= libs.dist %>/build/",
                        src:  [ "**/*.js", "!**/*.min.js"],
                        dest: "<%= libs.dist %>",
                        ext:  ".min.js"
                    }]
                },
                dist: {
                    options: {
                        compress: {
                            join_vars: !isDebug,
                            drop_console: !isDebug
                        },
                        sourceMap: isDebug,
                        sourceMapIncludeSources: isDebug
                    },
                    files: "<%= uglify.all.files %>"
                }
            };
        return uglify;
    }


    module.exports = uglifyGrunt;
})();
