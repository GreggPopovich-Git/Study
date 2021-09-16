package treeexam;

public class Score {
	int kor,eng,mat,com,tot;
	
	Score(){}
	Score(int kor, int eng, int mat, int com) {
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		this.com = com;
		tot = kor + eng + mat + com;
	}
	@Override
	public String toString() {
		return kor + "\t" + eng + "\t" + mat + "\t" + com;
	}
}
