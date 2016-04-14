package model;

import java.sql.Connection;
import java.util.ArrayList;

import dao.Database;
import dao.TypesBusiness;
import dto.Types;

public class TypesManager{
	
	 /**
     * Method to get list of types
     * 
     * @return {Array} types
     * @throws Exception
     */
    public ArrayList<Types> getTypes() throws Exception {
        ArrayList<Types> typesList = new ArrayList<Types>();
        Database db = new Database();
        Connection con = db.getConnection();
        TypesBusiness access = new TypesBusiness();
        typesList = access.getTypes(con);
        return typesList;
    }
}
