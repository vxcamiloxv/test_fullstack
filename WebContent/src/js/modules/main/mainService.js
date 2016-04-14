(function(){
    "use strict";

    mainService.$inject = [
        '$q',
        '$window',
        '$http'
    ];
    function mainService($q, $window, $http) {
        // Memebres
        var Main = {
            isRole: isRole,
            getTypes: getTypes,
            getInventorys: getInventorys,
            createInventory: createInventory,
            deleteInventory: deleteInventory
        };
        return Main;

        // Functions
        function isRole() {
            return $window.sessionStorage.role || 0;
        }

        /**
         * @name getType
         * @description get list of types
         * @return {promise}
         */
        function getTypes() {
            var deferred = $q.defer();
            $http({
                url: "/test_fullstack/api/types",
                method: "GET"
            }).then(function(res){
                deferred.resolve(res.data);
            }).catch(function(err){
                deferred.reject(err);
            });
            return deferred.promise;
        }

        /**
         * @name getInventorys
         * @description get list of all inventorys
         * @return {promise}
         */
        function getInventorys() {
            var deferred = $q.defer();
            $http({
                url: "/test_fullstack/api/inventorys",
                method: "GET"
            }).then(function(res){
                deferred.resolve(res.data);
            }).catch(function(err){
                deferred.reject(err);
            });
            return deferred.promise;
        }

        /**
         * @name createInventory
         * @description create new inventorys in db
         * @return {promise}
         */
        function createInventory(dataObj) {
            var deferred = $q.defer();
            $http({
                url: "/test_fullstack/api/inventorys",
                method: "POST",
                params: dataObj
            }).then(function(res){
                deferred.resolve(res.data);
            }).catch(function(err){
                deferred.reject(err);
            });
            return deferred.promise;
        }
        /**
         * @name deleteInventory
         * @description delete inventorys from db
         * @return {promise}
         */
        function deleteInventory(id) {
            var deferred = $q.defer();
            $http({
                url: "/test_fullstack/api/inventorys/" + id,
                method: "DELETE"
            }).then(function(res){
                deferred.resolve(res.data);
            }).catch(function(err){
                deferred.reject(err);
            });
            return deferred.promise;
        }
    }
    // Exports
    module.exports = mainService;

})();
