(function() {
    "use strict";

    // Members
    var mainDirective = {
        loginForm: loginForm
    };

    function loginForm(){
        var loginDirective = {
            restrict: "E",
            templateUrl: "templates/view/loginForm.html"
        };
        return loginDirective;
    }

    // Exports
    module.exports = mainDirective;

})();
