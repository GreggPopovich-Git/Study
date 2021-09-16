package student;

import java.io.Serializable;

public class Student implements Serializable {
	int bun;
	String name;
	int kor, eng, mat, tot;
	double ave;
	String score;
	Student(){}
	Student(int bun, String name, int kor, int eng, int mat) {
		this.bun = bun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		ave = (int)(tot / 3. * 100 + 0.5) / 100.;
		if (ave >= 90)
			score = "A";
		else if (ave >= 80)
			score = "B";
		else if (ave >= 70)
			score = "C";
		else if (ave >= 60)
			score = "D";
		else
			score = "F";
	}
	@Override
	public boolean equals(Object obj) { 
		if (obj != null && obj instanceof Student)
			return bun == ((Student)obj).bun || name.equalsIgnoreCase(((Student)obj).name);
		else return false;
	}
	@Override
	public String toString() {
		return bun + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + ave + "\t" + score;
	}
	
}
