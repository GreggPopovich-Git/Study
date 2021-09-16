package exam01.util;

public class OracleDB implements DataAccess{

	@Override
	public void select() {
		System.out.println("OracleDB에서 검색");
	}

	@Override
	public void insert() {
		System.out.println("OracleDB에서 삽입");
	}

	@Override
	public void update() {
		System.out.println("OracleDB에서 수정");
	}

	@Override
	public void delete() {
		System.out.println("OracleDB에서 삭제");
	}
	
}
