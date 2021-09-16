package com.jslhrd.mysql.test;

public class MySQLSelect {

	public static void main(String[] args) throws Exception {
		MySQLTest mysql = new MySQLTest();
		// 드라이버 및 DB 연결
		mysql.makeConn();
		// 메소드 호출
		mysql.listDept();
		mysql.takeDown();
	}

}