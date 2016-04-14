(function(){
    "use strict";

    function cssminGrunt(grunt, data) {
        var cssmin = {
            options: {
                banner: "/*! <%= package.name %> v<%= package.version %> - <%= package.author %> - " +
                    "<%= grunt.template.today('yyyy-mm-dd') %> */",
                sourceMap: "<%= debug %>"
            },
            all: {
                files: {
                    "<%= static.dist %>/css/bundle.min.css": [
                        "<%= static.dist %>/css/app.min.css"
                    ]
                }
            },
            dist: "<%= cssmin.all %>"
        };

        return cssmin;
    }
    // Module export
    module.exports = cssminGrunt;
})();
