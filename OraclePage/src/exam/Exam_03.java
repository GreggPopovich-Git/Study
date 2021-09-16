package exam;

import java.util.List;

import dao.BoardDAO;
import dao.ZipVO;

public class Exam_03 {

	public static void main(String[] args) {
		String dong = "";
		BoardDAO dao = BoardDAO.getInstance();
		
		List<ZipVO> zList = dao.zipList(dong);
		System.out.println("우편번호\t시도\t구군\t동\t번지");
		
		for(int x = 0; x < zList.size(); x++) {
			System.out.print(zList.get(x).getZipcode() + "\t");
			System.out.print(zList.get(x).getSido() + "\t");
			System.out.print(zList.get(x).getGugun() + "\t");
			System.out.print(zList.get(x).getDong() + "\t");
			System.out.print(zList.get(x).getBunji() + "\n");
		}
		
	}

}
