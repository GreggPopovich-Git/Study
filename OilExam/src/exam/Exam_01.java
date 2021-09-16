package exam;

import java.text.DecimalFormat;
import java.util.List;

import dao.DAO;
import vo.VO;

public class Exam_01 {

	public static void main(String[] args) {
		DAO dao = DAO.getInstance();
		List<VO> list = dao.exam_1();
		System.out.println("매출번호\t주유일자\t\t유종\t주유량\t결제방법\t회원성명\t회원번호\t전화번호\t\t카드번호\t\t\t금액");
		DecimalFormat df = new DecimalFormat("￦#,###");
		for(int x = 0; x < list.size(); x++) {
			System.out.print(list.get(x).getSaleno() + "\t");
			System.out.print(list.get(x).getOildate() + "\t");
			System.out.print(list.get(x).getOilname() + "\t");
			System.out.print(list.get(x).getAmount() + "\t");
			System.out.print(list.get(x).getPaytype() + "\t");
			System.out.print(list.get(x).getCustname() + "\t");
			System.out.print(list.get(x).getCustno() + "\t");
			System.out.print(list.get(x).getCusttel1() + "\t");
			System.out.print(list.get(x).getCreditcard() + "\t");
			if(list.get(x).getCreditcard().length() < 10)
				System.out.print("\t\t");
			System.out.print(df.format(list.get(x).getOilcost()) + "\n");
		}
		
	}

}