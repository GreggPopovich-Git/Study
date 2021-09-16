package exam01.user;

import exam01.util.DataAccess;
import exam01.util.MysqlDB;
import exam01.util.OracleDB;

public class DaoExam {
	public static void dbWork(DataAccess da) {
		da.select();
		da.insert();
		da.update();
		da.delete();
	}
	public static void main(String[] args) {
		dbWork(new OracleDB());
		dbWork(new MysqlDB());
	}
	/* 실행결과
	 * Oracle DB에서 검색
	 * Oracle DB에서 삽입
	 * Oracle DB에서 수정
	 * Oracle DB에서 삭제
	 * Mysql DB에서 검색
	 * Mysql DB에서 삽입
	 * Mysql DB에서 수정
	 * Mysql DB에서 삭제
	 */

}
