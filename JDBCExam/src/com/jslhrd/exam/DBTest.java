package com.jslhrd.exam;

import java.sql.Connection;

import com.jslhrd.util.DBManager;

public class DBTest {

	public static void main(String[] args) {
		Connection conn = DBManager.getConnection();
		System.out.println("커넥션 정보 : " + conn);
	}

}