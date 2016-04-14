package model;

import java.sql.Connection;
import java.util.ArrayList;

import dao.InventoryBusiness;
import dao.Database;
import dto.Inventory;

public class InventoryManager{
	
	 /**
     * Method to get list of inventory
     * 
     * @return {Array} inventorys
     * @throws Exception
     */
    public ArrayList<Inventory> getInventorys() throws Exception {
        ArrayList<Inventory> inventoryList = new ArrayList<Inventory>();
        Database db = new Database();
        Connection con = db.getConnection();
        InventoryBusiness access = new InventoryBusiness();
        inventoryList = access.getInventorys(con);
        return inventoryList;
    }
    
    /**
     * Method get single inventory
     * 
     * @param {int} id of inventory
     * @return {Object} inventory
     * @throws Exception
     */
    public Object getInventory(int id) throws Exception {
        Object inventory = new ArrayList<Inventory>();
        Database db = new Database();
        Connection con = db.getConnection();
        InventoryBusiness access = new InventoryBusiness();
        inventory = access.getInventory(con, id);
        return inventory;
    }
    
    /**
     * Method update single inventory
     * 
     * @param {int} id of inventory
     * @return {Object} new data inventory
     * @throws Exception
     */
    public Object putInventory(int id, String name, 
    		String description, int type_id, Double unit_price) throws Exception {
        Object inventory = new ArrayList<Inventory>();
        Database db = new Database();
        Connection con = db.getConnection();
        InventoryBusiness access = new InventoryBusiness();
        inventory = access.putInventory(con, id, name, description, type_id, unit_price);
        return inventory;
    }
    
    /**
     * Method create inventory
     * 
     * @param {string} name of inventory
     * @return {Object} new data inventory
     * @throws Exception
     */
    public Object createInventory(String name, 
    		String description, int type_id, Double unit_price) throws Exception {
        Object inventory = new ArrayList<Inventory>();
        Database db = new Database();
        Connection con = db.getConnection();
        InventoryBusiness access = new InventoryBusiness();
        inventory = access.createInventory(con, name, description, type_id, unit_price);
        return inventory;
    }
    
    /**
     * Method remove inventory
     * 
     * @param {int} id of inventory
     * @return {Object} remove inventory
     * @throws Exception
     */
    public Object deleteInventory(int id) throws Exception {
        Object inventory = new ArrayList<Inventory>();
        Database db = new Database();
        Connection con = db.getConnection();
        InventoryBusiness access = new InventoryBusiness();
        inventory = access.deleteInventory(con, id);
        return inventory;
    }
}
