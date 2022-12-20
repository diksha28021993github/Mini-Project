package com.jpmorgan;

import java.sql.Connection;
import java.sql.DriverManager;

public class ConnectionTest {
	Connection con = null;
	public Connection getConnectionDetails() {
				try {
			//STEP 1 - LOAD THE DRIVER CLASS
			Class.forName("com.mysql.jdbc.Driver");
			//STEP 2 - ESTABLISH THE CONNECTION
			con= DriverManager.getConnection("jdbc:mysql://localhost:3306/mini project","root","Root");
			} catch (Exception e) {
			e.printStackTrace();
		}
		return con;
	}
}
