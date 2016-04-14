package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import dto.Inventory;

public class InventoryBusiness {
    public ArrayList<Inventory> getInventorys(Connection con) throws SQLException {
        ArrayList<Inventory> inventoryList = new ArrayList<Inventory>();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM inventory");
        ResultSet rs = stmt.executeQuery();
        try {
            while(rs.next()) {
                Inventory inventoryObj = new Inventory();
                inventoryObj.setId(rs.getInt("id"));
                inventoryObj.setName(rs.getString("name"));
                inventoryObj.setDescription(rs.getString("description"));
                inventoryObj.setTypeId(rs.getInt("type_id"));
                inventoryObj.setUnitPrice(rs.getDouble("unit_price"));
                inventoryList.add(inventoryObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return inventoryList;
    }

    public Object getInventory(Connection con, int id) throws SQLException {
       	Inventory inventoryObj = new Inventory();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM inventory WHERE id = ?");
        stmt.setInt(1, id);
        ResultSet rs = stmt.executeQuery();
        try {
        	while (rs.next()) {
                inventoryObj.setId(rs.getInt("id"));
                inventoryObj.setName(rs.getString("name"));
                inventoryObj.setDescription(rs.getString("description"));
                inventoryObj.setTypeId(rs.getInt("type_id"));
                inventoryObj.setUnitPrice(rs.getDouble("unit_price"));        
        	}        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(inventoryObj.getName() != null) {
        	return inventoryObj;
        } else {
        	return null;
        }
    }
    
    public Object putInventory(Connection con, int id, String name, 
    		String description, int type_id, Double unit_price) throws SQLException {
       	Inventory inventoryObj = new Inventory();
        PreparedStatement stmt = con.prepareStatement(
        		"UPDATE inventory SET name=?, description=?, type_id=?, unit_price=?  WHERE id = ?");
        stmt.setString(1, name);
        stmt.setString(2, description);
        stmt.setInt(3, type_id);
        stmt.setDouble(4, unit_price);;
        stmt.setInt(5, id);
        int resInt = stmt.executeUpdate();
        if(resInt > 0) {
        	inventoryObj.setId(id);
            inventoryObj.setName(name);
            inventoryObj.setDescription(description);
            inventoryObj.setTypeId(type_id);
            inventoryObj.setUnitPrice(unit_price);        
        }      
        if(inventoryObj.getName() != null) {
        	return inventoryObj;
        } else {
        	return null;
        }
    }
    
    public Object createInventory(Connection con, String name, 
    		String description, int type_id, Double unit_price) throws SQLException {
       	Inventory inventoryObj = new Inventory();
        PreparedStatement stmt = con.prepareStatement(
        		"INSERT INTO inventory (name, description, type_id, unit_price) VALUES (?,?,?,?)",
        		Statement.RETURN_GENERATED_KEYS);
        stmt.setString(1, name);
        stmt.setString(2, description);
        stmt.setInt(3, type_id);
        stmt.setDouble(4, unit_price);;
        stmt.executeUpdate();
        ResultSet rs = stmt.getGeneratedKeys();
        try {
        	while (rs.next()) {
                inventoryObj.setId(rs.getInt(1));
                inventoryObj.setName(name);
                inventoryObj.setDescription(description);
                inventoryObj.setTypeId(type_id);
                inventoryObj.setUnitPrice(unit_price);        
        	}        
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if(inventoryObj.getName() != null) {
        	return inventoryObj;
        } else {
        	return null;
        }
    }
    
    public Object deleteInventory(Connection con, int id) throws SQLException {
       	Inventory inventoryObj = new Inventory();
        PreparedStatement stmt = con.prepareStatement(
        		"DELETE FROM inventory WHERE id = ?");
        stmt.setInt(1, id);
        int resInt = stmt.executeUpdate();
        if(resInt > 0) {
        	inventoryObj.setId(id);        
        }      
        if(inventoryObj.getId() != 0) {
        	return inventoryObj;
        } else {
        	return null;
        }
    }
}
