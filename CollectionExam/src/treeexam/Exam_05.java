package treeexam;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Exam_05 {

	public static void main(String[] args) {
		TreeMap<Student, Score> sMap = new TreeMap<Student, Score>();
		sMap.put(new Student(7,"김학생"), new Score(70,90,60,85));
		sMap.put(new Student(3,"이학생"), new Score(95,88,75,80));
		sMap.put(new Student(1,"이학생"), new Score(90,77,73,84));
		sMap.put(new Student(5,"이학생"), new Score(69,99,94,81));
		
		Iterator<Student> iter = sMap.keySet().iterator();
/*		Map.Entry<Student, Score> entry = null;
		System.out.println("번호\t이름\t국어\t영어\t수학\t전산\t총점\t평균"); 
		while(!sMap.isEmpty()) {
			entry = sMap.pollFirstEntry();
			int tot = entry.getValue().tot;
			System.out.println(entry.getKey() + "\t" + entry.getValue() + "\t" + tot + "\t" + tot/4);
		}*/
		System.out.println("번호\t이름\t국어\t영어\t수학\t전산\t총점\t평균"); 
		while(iter.hasNext()) {
			Student stu = iter.next();
			Score score = sMap.get(stu);
			System.out.print(stu + "\t" + score);
			System.out.println("\t" + score.tot + "\t" + score.tot/4);
		}
	}
}