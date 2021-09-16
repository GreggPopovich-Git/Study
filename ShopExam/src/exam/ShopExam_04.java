package exam;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

import dao.ShopDAO;
import vo.ShopVO;

// 문제 4번
public class ShopExam_04 {
	public static void main(String[] args) {
		List<ShopVO> mList = new ArrayList<ShopVO>();
		ShopDAO dao = ShopDAO.getInstance();
		mList = dao.pricePrint();
		String grade;
		DecimalFormat mdf = new DecimalFormat("￦#,###");
		System.out.println("회원번호\t성명\t연락처\t\t고객등급\t매출");
		for (int x = 0; x < mList.size(); x++) {
			if (mList.get(x).getGrade().equalsIgnoreCase("A"))
				grade = "VIP";
			else if (mList.get(x).getGrade().equalsIgnoreCase("B"))
				grade = "일반";
			else
				grade = "직원";
			System.out.print(mList.get(x).getCustno() + "\t");
			System.out.print(mList.get(x).getCustname() + "\t");
			System.out.print(mList.get(x).getPhone() + "\t");
			System.out.print(grade + "\t");
			System.out.print(mdf.format(mList.get(x).getPrice()) + "\n");
		}
	}
}