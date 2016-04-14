(function(){
    "use strict";


    // Functions
    function lessGrunt(grunt, data) {
        var less = {
            dist: {
                files: {
                    "<%= static.dist %>/css/app.min.css": "<%= static.src %>/less/main.less"
                },
                options: {
                    cleancss: true,
                    compress: true
                }
            }
        };
        return less;
    }

    // Exports
    module.exports = lessGrunt;
})();
