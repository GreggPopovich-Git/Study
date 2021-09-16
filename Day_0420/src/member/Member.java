package member;
public class Member {
	String name;
	int age;
	String phone;
	int sex;
	String sex1;
	Member(){}
	Member(String name, int age, String phone, int sex) {
		this.name = name;
		this.age = age;
		this.phone = phone;
		this.sex = sex;

		if (sex == 1 || sex == 3)
			sex1 = "남성";
		else if (sex == 2 || sex == 4)
			sex1 = "여성";
		else if (sex == 5 || sex == 7)
			sex1 = "외국인 남성";
		else
			sex1 = "외국인 여성";
		
		if (age < 22)
			this.age = 22 - age;
		else
			this.age = 122 - age;
	}
	public void mPrint() {
		System.out.println(name + "\t" + phone + "\t" + sex1 + "\t" + age);
	}
}