package student;

import java.io.Serializable;

public class StudentSet implements Serializable, Comparable<StudentSet> {
	int bun;
	String name;
	int kor, eng, mat, tot;
	double ave;
	String score;

	StudentSet() {
	}

	StudentSet(int bun, String name, int kor, int eng, int mat) {
		this.bun = bun;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.mat = mat;
		tot = kor + eng + mat;
		ave = (int) (tot / 3. * 100 + 0.5) / 100.;
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
		if (obj != null && obj instanceof StudentSet)
			return bun == ((Student) obj).bun || name.equalsIgnoreCase(((Student) obj).name);
		else
			return false;
	}

	@Override
	public String toString() {
		return bun + "\t" + name + "\t" + kor + "\t" + eng + "\t" + mat + "\t" + tot + "\t" + ave + "\t" + score;
	}
	@Override
	public int compareTo(StudentSet stu) {
		if(bun < stu.bun)
			return -1;
		else if(bun == stu.bun)
			return 0;
		else
			return 1;
	}
}
