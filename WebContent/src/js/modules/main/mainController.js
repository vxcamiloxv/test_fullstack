/*global module */

// modules/main/mainDirective.js
//
// main directives function
//
// 2016, Camilo Quimbayo

(function() {
    "use strict";

    var ld = require("lodash");

    MainController.$inject = [
        '$Main'
    ];
    function MainController($Main){
        var main = this;

        // Members
        main.getTypes = getTypes;
        main.getInventorys = getInventorys;
        main.createInventory = createInventory;
        main.deleteInventory = deleteInventory;
        main.userRole = $Main.isRole();

        // Model
        main.types = [];
        main.inventory = {
            name: null,
            description: null,
            type_id: 1,
            unit_price: null
        };
        main.inventorys = [];

        // Run
        getInventorys();
        getTypes();

        // Functions
        function getTypes() {
            $Main.getTypes().then(function(types){
                main.types = types;
            });
        }

        function getInventorys() {
            $Main.getInventorys(main.dataFeedback).then(function(inventorys){
                main.inventorys = inventorys;
            });
        }

        function createInventory() {
            $Main.createInventory(main.inventory).then(function(inventory){
                main.inventorys.push(inventory);
                main.inventory = {
                    name: null,
                    description: null,
                    type_id: 1,
                    unit_price: null
                };
            });
        }

        function deleteInventory(id) {
            var index;
            $Main.deleteInventory(id).then(function(res){
                index = ld.findIndex(main.inventorys, { id: id });
                if(index > -1) {
                    ld.pullAt(main.inventorys, index);
                }
            });
        }

    }

    module.exports = MainController;

})();
