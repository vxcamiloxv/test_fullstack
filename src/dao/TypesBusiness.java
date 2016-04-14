package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dto.Types;

public class TypesBusiness {
    
    public ArrayList<Types> getTypes(Connection con) throws SQLException {
        ArrayList<Types> typesList = new ArrayList<Types>();
        PreparedStatement stmt = con.prepareStatement("SELECT * FROM types");
        ResultSet rs = stmt.executeQuery();
        try {
            while(rs.next()) {
                Types typesObj = new Types();
                typesObj.setId(rs.getInt("id"));
                typesObj.setName(rs.getString("name"));
                typesList.add(typesObj);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return typesList;
    }
}
