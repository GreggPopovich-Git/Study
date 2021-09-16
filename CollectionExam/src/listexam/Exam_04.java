package listexam;

import java.util.ArrayList;
import java.util.List;

class Member {
	private int idx;
	private String name;
	private int age;
	Member(){}
	Member(int idx, String name, int age) {
		this.idx = idx;
		this.name = name;
		this.age = age;
	}
	@Override
	public String toString() {
		return idx + "\t" + name + "\t" + age;
	}
	@Override
	public boolean equals(Object obj) {
		boolean bool = false;
		if (obj != null && obj instanceof Member) {
			if (idx == ((Member)obj).idx && name.equalsIgnoreCase(((Member)obj).name) && age == ((Member)obj).age)
				bool = true;
		}
		return bool;
	}
}
public class Exam_04 {

	public static void main(String[] args) {
		List<Member> mList = new ArrayList<Member>();
		Member m = new Member(1,"AAA",30);
		mList.add(m);
		m = new Member(2,"BBB",28);
		mList.add(m);
		mList.add(new Member(3,"CCC",25));
		mList.add(new Member(4,"DDD",29));
		m = new Member(3,"CCC",25);
		boolean bool = true;
		for(int x = 0; x < mList.size(); x++) {
			if (m.equals(mList.get(x)))
				bool = false;
		}
		if (bool)
			mList.add(m);
		
		System.out.println(mList.get(2).hashCode() == mList.get(3).hashCode());
		System.out.println("번호\t이름\t나이");
		for(Member mem : mList) {
			System.out.println(mem);
		}
		
	}
	
}
