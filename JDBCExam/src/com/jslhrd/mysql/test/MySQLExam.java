package com.jslhrd.mysql.test;

public class MySQLExam {

	public static void main(String[] args) throws Exception {
		MySQLTest mysql = new MySQLTest();
		// 드라이버 및 DB 연결
		mysql.makeConn();
		// 메소드 호출
/*		int row = mysql.insertDept(60, "인사", "대전");
		if(row == 1) {
			System.out.println("Insert Success");
		}
*/
		int row = mysql.deleteDept(60);
		if(row == 1) {
			System.out.println("Delete Success");
		}
		mysql.takeDown();
	}

}