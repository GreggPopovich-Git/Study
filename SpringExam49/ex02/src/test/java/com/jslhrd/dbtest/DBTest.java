package com.jslhrd.dbtest;

import java.sql.Connection;
import java.sql.DriverManager;

import org.junit.Test;

import lombok.extern.log4j.Log4j;

@Log4j
public class DBTest {
	//private static final Logger log = LoggerFactory.getLogger(DBTest.class);
	
	@Test
	public void testConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			Connection con = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","jsl49","ehfkdl12");
			log.info("커넥션 : " + con);
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
}
