package exam;

import java.util.ArrayList;
import java.util.List;

import dao.ShopDAO;
import vo.ShopVO;

// 회원정보 테이블 모든 데이터 출력
// 회원번호	성명	연락처	성별	가입일자	고객등급	도시코드
public class ShopExam_05 {

	public static void main(String[] args) {
		List<ShopVO> mList = new ArrayList<ShopVO>();
		ShopDAO dao = ShopDAO.getInstance();
		mList = dao.memberPrint();
		
		System.out.println("회원번호\t성명\t연락처\t\t성별\t가입일자\t\t고객등급\t도시코드");
		for(int x = 0; x < mList.size(); x++) {
			System.out.print(mList.get(x).getCustno() + "\t");
			System.out.print(mList.get(x).getCustname() + "\t");
			System.out.print(mList.get(x).getPhone() + "\t");
			System.out.print(mList.get(x).getGender() + "\t");
			System.out.print(mList.get(x).getJoindate() + "\t");
			System.out.print(mList.get(x).getGrade() + "\t");
			System.out.print(mList.get(x).getCity() + "\n");
			
		}
		
	}

}
