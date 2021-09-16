package com.jslhrd.util;

public class PersonData extends Person implements PersonScore {
	int tot;
	int score[];
	int age;
	public PersonData(String name, String birth, int[] score) {
		super(name, birth);
		this.score = score;
	}

	@Override
	public int scoreTotal() {
		for (int x = 0; x < score.length; x++) 
			tot += score[x];
		return tot;
	}

	@Override
	public void dataPrint() {
		scoreTotal();
		getAge();
		System.out.print("이름\t나이\t");
		for (int x = 1; x <= score.length; x++)
			System.out.print("점수" + x + "\t");
		System.out.println("총점");
		System.out.print(name + "\t" + age + "\t");
		for (int x = 0; x < score.length; x++)
			System.out.print(score[x] + "\t");
		System.out.println(tot);
	}

	@Override
	public int getAge() {
		if(Integer.parseInt(birth.substring(0, 2)) > 21)
			age = 122-Integer.parseInt(birth.substring(0, 2));
		else
			age = 22-Integer.parseInt(birth.substring(0, 2));
		return age;
	}

}
