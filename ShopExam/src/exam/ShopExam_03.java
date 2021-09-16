package exam;

import java.util.ArrayList;
import java.util.List;

import dao.ShopDAO;
import vo.ShopVO;

// 문제 3번
public class ShopExam_03 {

	public static void main(String[] args) {
		List<ShopVO> mList = new ArrayList<ShopVO>();
		ShopDAO dao = ShopDAO.getInstance();
		mList = dao.custPrint();
		String grade;
		System.out.println("회원번호\t성명\t연락처\t\t성별\t가입일자\t\t고객등급\t거주지역");
		for (int x = 0; x < mList.size(); x++) {
			if (mList.get(x).getGrade().equalsIgnoreCase("A"))
				grade = "VIP";
			else if (mList.get(x).getGrade().equalsIgnoreCase("B"))
				grade = "일반";
			else
				grade = "직원";
			String year = mList.get(x).getJoindate().substring(0,4);
			String month = mList.get(x).getJoindate().substring(4,6);
			String day = mList.get(x).getJoindate().substring(6);
			System.out.print(mList.get(x).getCustno() + "\t");
			System.out.print(mList.get(x).getCustname() + "\t");
			System.out.print(mList.get(x).getPhone() + "\t");
			System.out.print(mList.get(x).getGender() + "\t");
			System.out.print(year + "년" + month + "월" + day + "일" + "\t");
			System.out.print(grade + "\t");
			System.out.print(mList.get(x).getCityname() + "\n");
		}
	}

}
