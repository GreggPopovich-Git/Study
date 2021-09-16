package com.jslhrd.mysql.test;

import java.sql.Connection;
import java.sql.DriverManager;

public abstract class MySQLConn {
	String myDriver = "com.mysql.jdbc.Driver";
	String myURL = "jdbc:mysql://localhost:3306/jsl49";
	String myID = "jsl49";
	String myPass = "ehfkdl12";
	
	protected Connection myConn;
	
	public MySQLConn() {}
	// JDBC 드라이버로딩 및 DB연결 메소드
	public void makeConn() throws Exception {
		Class.forName(myDriver);
		myConn = DriverManager.getConnection(myURL, myID, myPass);
		System.out.println("Connection Success");
	}
	// SQL 명령 객체 close()
	public abstract void cleanup() throws Exception;
	
	public void takeDown() throws Exception {
		cleanup();
		myConn.close();
	}
}