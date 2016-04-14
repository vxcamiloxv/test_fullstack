package dao;

import java.sql.Connection;
import java.sql.DriverManager;

import utils.Constants;

public class Database {
	 /**
     * Method to get DB Connection
     * 
     * @return connection
     * @throws Exception
     */
    public Connection getConnection() throws Exception {
        try {
            String connectionURL = Constants.dbUrl;
            Connection connection = null;
            Class.forName(Constants.dbClass).newInstance();
            connection = DriverManager.getConnection(connectionURL, Constants.dbUser, Constants.dbPass);
            return connection;
        } catch (Exception e) {
            throw e;
        }

    }

}
