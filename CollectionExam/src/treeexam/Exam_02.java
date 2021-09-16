package treeexam;

import java.util.TreeSet;

public class Exam_02 {

	public static void main(String[] args) {
		TreeSet<Integer> scores = new TreeSet<Integer>();
		scores.add(87);
		scores.add(98);
		scores.add(75);
		scores.add(95);
		scores.add(80);
		scores.add(70);
		
		Integer score = null;
		score = scores.first();
		System.out.println("가장 낮은 점수 : " + score);
		
		score = scores.last();
		System.out.println("가장 낮은 점수 : " + score);
		
		score = scores.lower(new Integer(95));
		System.out.println("95점 아래 점수 : " + score);
		
		score = scores.higher(new Integer(95));
		System.out.println("95점 위 점수 : " + score);
		
		score = scores.floor(new Integer(95));
		System.out.println("95점 이거나 바로 아래 점수 : " + score);
		
		score = scores.ceiling(new Integer(85));
		System.out.println("85점 이거나 바로 위 점수 : " + score);
		
		while(!scores.isEmpty()) {
			score = scores.pollFirst(); // 가장 낮은 객체를 반환하고 삭제
			System.out.println(score + "남은 객체 수 : " + scores);
		}
	}
}