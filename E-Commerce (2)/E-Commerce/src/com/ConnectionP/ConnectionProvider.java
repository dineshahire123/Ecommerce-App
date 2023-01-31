package com.ConnectionP;

import java.sql.Connection;
import java.sql.DriverManager;


//Connection pooling

public class ConnectionProvider {

	// constructor
	
	private ConnectionProvider() {

	}
	
	// method which return object of connection

	public static Connection getConnection() {
		Connection con = null;

		try {
			
			//Loading Driver Class
			Class.forName(DatabaseDetails.Db_Driver);
			con = DriverManager.getConnection(DatabaseDetails.Database_URL, DatabaseDetails.Database_USER,
					DatabaseDetails.Database_PASS);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}

}
