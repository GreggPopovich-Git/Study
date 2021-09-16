package com.jslhrd.artist.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBManager {
	private DBManager() {}
	private static DBManager instance = new DBManager();
	public static DBManager getInstance() {
		return instance;
	}
	// DB Connection method
	public static Connection getConnection() {
		String myDriver = "com.mysql.jdbc.Driver";
		String myURL = "jdbc:mysql://localhost:3306/jsl49";
		String myID = "jsl49";
		String myPass = "ehfkdl12";
		
		Connection myConn = null;
		try {
			Class.forName(myDriver);
			System.out.println("Driver Loading...");
		}catch (Exception e) {
			e.printStackTrace();
		}
		try {
			myConn = DriverManager.getConnection(myURL, myID, myPass);
			System.out.println("DB Connection Success");
		}catch (Exception e) {
			e.printStackTrace();
		}
		return myConn;
	}
}
