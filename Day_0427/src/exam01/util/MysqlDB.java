package exam01.util;

public class MysqlDB implements DataAccess {

	@Override
	public void select() {
		System.out.println("MysqlDB에서 검색");
	}

	@Override
	public void insert() {
		System.out.println("MysqlDB에서 삽입");
	}

	@Override
	public void update() {
		System.out.println("MysqlDB에서 수정");
	}

	@Override
	public void delete() {
		System.out.println("MysqlDB에서 삭제");
	}
	
}
